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
package org.cagrid.tide.replica.context.service.globus.resource;


/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class is used by the resource to get configuration information about the 
 * resource.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class TideReplicaManagerContextResourceConfiguration {
	private String registrationTemplateFile;
	private boolean performRegistration;




	public boolean shouldPerformRegistration() {
		return performRegistration;
	}


	public void setPerformRegistration(boolean performRegistration) {
		this.performRegistration = performRegistration;
	}


	public String getRegistrationTemplateFile() {
		return registrationTemplateFile;
	}
	


	public void setRegistrationTemplateFile(String registrationTemplateFile) {
		this.registrationTemplateFile = registrationTemplateFile;
	}
		
}
