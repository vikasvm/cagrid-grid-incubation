/**
*============================================================================
*  The Ohio State University Research Foundation, Emory University,
*  the University of Minnesota Supercomputing Institute
*
*  Distributed under the OSI-approved BSD 3-Clause License.
*  See http://ncip.github.com/cagrid-grid-incubation/LICENSE.txt for details.
*============================================================================
**/
/**
*============================================================================
*============================================================================
**/
package edu.umn.msi.cagrid.introduce.interfaces;


import edu.umn.msi.cagrid.introduce.interfaces.codegen.DocletUtils;
import edu.umn.msi.cagrid.introduce.interfaces.configuration.ConfigurationFactory;
import edu.umn.msi.cagrid.introduce.interfaces.configuration.MethodConfiguration;
import edu.umn.msi.cagrid.introduce.interfaces.configuration.ServiceConfiguration;
import edu.umn.msi.cagrid.introduce.interfaces.services.Service;
import edu.umn.msi.cagrid.introduce.interfaces.services.ServiceProcessor;
import edu.umn.msi.cagrid.introduce.interfaces.types.mapping.TypeMapping;
import gov.nih.nci.cagrid.introduce.beans.method.MethodType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Iterator;

import com.thoughtworks.qdox.model.JavaMethod;

import static com.google.common.collect.Iterables.filter;

public class PreCodegenServiceProcessor implements ServiceProcessor {
  private TypeMapping typeMap;

  public PreCodegenServiceProcessor(TypeMapping typeMap) {
    this.typeMap = typeMap; 
  }

  public void execute(Service service) throws IOException  {
    System.out.println("InterfaceExtension: Prepreprocessing service " + service.getName());
    ServiceConfiguration serviceConfiguration = new ConfigurationFactory().getServiceConfiguration(service);
    serviceConfiguration.addDefaultValues(typeMap);
    
    
    Collection<MethodType> oldMethods;
    if(service.getMethods() == null || service.getMethods().getMethod() == null) {
      oldMethods = new ArrayList<MethodType>();
    } else {     
      oldMethods = Arrays.asList(service.getMethods().getMethod());
    }
    Collection<MethodType> newMethods = new LinkedList<MethodType>();
    
    // Initialize new methods with all the old methods
    newMethods.addAll(oldMethods);
    
    // Remote all methods previously generated by this extension
    removeOldMethods(newMethods, service);
    
    // Add all methods required to implement all annotated interfaces
    addNewMethods(newMethods, serviceConfiguration);
    
    // We might have removed and added back a method, and the user
    // may have set security settings for that method, if this is the
    // case restore it.
    restoreSecurity(newMethods, oldMethods);
    
    // Reset the introduce ServiceInformation data structure with this
    // new collection of methods
    service.getMethods().setMethod(newMethods.toArray(new MethodType[]{}));

    // Remove old implemented method tags
    StringBuffer sourceContents = new StringBuffer(service.getServiceImplContents());
    PreCodegenServiceProcessor.removeInterfacesAnnotationTags(sourceContents);
    service.setServiceImplContents(sourceContents.toString());
  }

  private void restoreSecurity(Collection<MethodType> newMethods, Collection<MethodType> oldMethods) {
    for(MethodType oldMethod : oldMethods) {
      for(MethodType newMethod : newMethods) {
        if(newMethod.getName().equals(oldMethod.getName())) {
          newMethod.setMethodSecurity(oldMethod.getMethodSecurity());
        }
      }
    }
  }
  
  private void addNewMethods(Collection<MethodType> methods, ServiceConfiguration serviceConfiguration) {
    //Iterator<Method> methodsToImplement = MethodUtils.enumerateMethodsToImplement(map.keySet());
    Collection<MethodConfiguration> allMethods = serviceConfiguration.getMethods();
    Iterable<MethodConfiguration> methodsToImplement = filter(allMethods, MethodConfiguration.getIncludedPredicate());
    for(MethodConfiguration methodConfiguration : methodsToImplement) {
      methods.add(methodConfiguration.getIntroduceMethodType());
    }
  }

  private void removeOldMethods(Collection<MethodType> methods, Service service) throws IOException {
    String sourceContents = service.getServiceImplContents();
    Iterable<JavaMethod> javaMethods = DocletUtils.enumerateMethods(sourceContents);
    javaMethods = filter(javaMethods, new DocletUtils.HasDoclet(Constants.INTERFACES_ANNOTATION_TAG));
    for(JavaMethod javaMethod : javaMethods) {
      boolean methodRemoved = false;
      for(MethodType method : methods) {
        if(javaMethod.getName().equals(method.getName())) {
          methods.remove(method);
          methodRemoved = true;
          break;
        }
      }
      if(!methodRemoved) {
        System.out.println("Failed to remove method " + javaMethod.getDeclarationSignature(true));
      }
    }
  }

  /**
   * Removes all Doclet tags indicating that a method
   * was created for this extension from the given source
   * file.
   * 
   * @param buffer Contents of the source file.
   */
  public static void removeInterfacesAnnotationTags(StringBuffer buffer) {
    // TODO: Maybe this should be the  first step in postcodegen, not last step in precodegen 
    // in case something goes wrong.
    DocletUtils.eliminateCommentsWithTag(Constants.INTERFACES_ANNOTATION_TAG, buffer);
  }


}
