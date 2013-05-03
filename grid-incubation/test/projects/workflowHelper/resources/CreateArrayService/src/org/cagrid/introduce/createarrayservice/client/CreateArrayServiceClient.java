/**
*============================================================================
*  Copyright The Ohio State University Research Foundation, The University of Chicago - 
*	Argonne National Laboratory, Emory University, SemanticBits LLC, and 
*	Ekagra Software Technologies Ltd.
*
*  Distributed under the OSI-approved BSD 3-Clause License.
*  See http://ncip.github.com/cagrid-core/LICENSE.txt for details.
*============================================================================
**/
package org.cagrid.introduce.createarrayservice.client;

import java.io.InputStream;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.AxisClient;
import org.apache.axis.client.Stub;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;

import org.oasis.wsrf.properties.GetResourcePropertyResponse;

import org.globus.gsi.GlobusCredential;

import org.cagrid.introduce.createarrayservice.stubs.CreateArrayServicePortType;
import org.cagrid.introduce.createarrayservice.stubs.service.CreateArrayServiceAddressingLocator;
import org.cagrid.introduce.createarrayservice.common.CreateArrayServiceI;
import org.cagrid.workflow.systemtests.types.ComplexType;

import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;

/**
 * This class is autogenerated, DO NOT EDIT GENERATED GRID SERVICE ACCESS METHODS.
 *
 * This client is generated automatically by Introduce to provide a clean unwrapped API to the
 * service.
 *
 * On construction the class instance will contact the remote service and retrieve it's security
 * metadata description which it will use to configure the Stub specifically for each method call.
 * 
 * @created by Introduce Toolkit version 1.1
 */
public class CreateArrayServiceClient extends ServiceSecurityClient implements CreateArrayServiceI {	
	protected CreateArrayServicePortType portType;
	private Object portTypeMutex;

	public CreateArrayServiceClient(String url) throws MalformedURIException, RemoteException {
		this(url,null);	
	}

	public CreateArrayServiceClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(url,proxy);
	   	initialize();
	}
	
	public CreateArrayServiceClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
	   	this(epr,null);
	}
	
	public CreateArrayServiceClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(epr,proxy);
		initialize();
	}
	
	private void initialize() throws RemoteException {
	    this.portTypeMutex = new Object();
		this.portType = createPortType();
	}

	private CreateArrayServicePortType createPortType() throws RemoteException {

		CreateArrayServiceAddressingLocator locator = new CreateArrayServiceAddressingLocator();
		// attempt to load our context sensitive wsdd file
		InputStream resourceAsStream = getClass().getResourceAsStream("client-config.wsdd");
		if (resourceAsStream != null) {
			// we found it, so tell axis to configure an engine to use it
			EngineConfiguration engineConfig = new FileProvider(resourceAsStream);
			// set the engine of the locator
			locator.setEngine(new AxisClient(engineConfig));
		}
		CreateArrayServicePortType port = null;
		try {
			port = locator.getCreateArrayServicePortTypePort(getEndpointReference());
		} catch (Exception e) {
			throw new RemoteException("Unable to locate portType:" + e.getMessage(), e);
		}

		return port;
	}
	

	public static void usage(){
		System.out.println(CreateArrayServiceClient.class.getName() + " -url <service url>");
	}
	
	public static void main(String [] args){
	    System.out.println("Running the Grid Service Client");
		try{
		if(!(args.length < 2)){
			if(args[0].equals("-url")){
			  CreateArrayServiceClient client = new CreateArrayServiceClient(args[1]);
			  // place client calls here if you want to use this main as a
			  // test....
			  
			  String[] output = client.getArray();
			  System.out.println("Contents of received array");
			  for(int i=0; i < output.length; i++){
				  System.out.println("output["+ i +"] = "+output[i]);
			  }
			  System.out.println("Done");
			  
			  ComplexType[] complex_output = client.getComplexArray();
			  System.out.println("Contents of received complex array");
			  for(int i=0; i < output.length; i++){
				  System.out.println("complex_output["+ i +"] = "+complex_output[i].getId()+'#'+complex_output[i].getMessage());
			  }
			  System.out.println("Done");
			  
			  
			  
			} else {
				usage();
				System.exit(1);
			}
		} else {
			usage();
			System.exit(1);
		}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

  public java.lang.String[] secureGetArray() throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"secureGetArray");
    org.cagrid.introduce.createarrayservice.stubs.SecureGetArrayRequest params = new org.cagrid.introduce.createarrayservice.stubs.SecureGetArrayRequest();
    org.cagrid.introduce.createarrayservice.stubs.SecureGetArrayResponse boxedResult = portType.secureGetArray(params);
    return boxedResult.getResponse();
    }
  }

  public org.cagrid.workflow.systemtests.types.ComplexType[] secureGetComplexArray() throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"secureGetComplexArray");
    org.cagrid.introduce.createarrayservice.stubs.SecureGetComplexArrayRequest params = new org.cagrid.introduce.createarrayservice.stubs.SecureGetComplexArrayRequest();
    org.cagrid.introduce.createarrayservice.stubs.SecureGetComplexArrayResponse boxedResult = portType.secureGetComplexArray(params);
    return boxedResult.getComplexType();
    }
  }

  public java.lang.String[] getArray() throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getArray");
    org.cagrid.introduce.createarrayservice.stubs.GetArrayRequest params = new org.cagrid.introduce.createarrayservice.stubs.GetArrayRequest();
    org.cagrid.introduce.createarrayservice.stubs.GetArrayResponse boxedResult = portType.getArray(params);
    return boxedResult.getResponse();
    }
  }

  public org.cagrid.workflow.systemtests.types.ComplexType[] getComplexArray() throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getComplexArray");
    org.cagrid.introduce.createarrayservice.stubs.GetComplexArrayRequest params = new org.cagrid.introduce.createarrayservice.stubs.GetComplexArrayRequest();
    org.cagrid.introduce.createarrayservice.stubs.GetComplexArrayResponse boxedResult = portType.getComplexArray(params);
    return boxedResult.getComplexType();
    }
  }

}
