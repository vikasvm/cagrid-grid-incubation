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
package org.cagrid.workflow.helper.service;

import gov.nih.nci.cagrid.introduce.servicetools.ServiceConfiguration;

import org.globus.wsrf.config.ContainerConfig;
import java.io.File;
import javax.naming.InitialContext;

import org.apache.axis.MessageContext;
import org.globus.wsrf.Constants;


/** 
 * DO NOT EDIT:  This class is autogenerated!
 * 
 * This class holds all service properties which were defined for the service to have
 * access to.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class WorkflowHelperConfiguration implements ServiceConfiguration {

	public static WorkflowHelperConfiguration  configuration = null;

	public static WorkflowHelperConfiguration getConfiguration() throws Exception {
		if (WorkflowHelperConfiguration.configuration != null) {
			return WorkflowHelperConfiguration.configuration;
		}
		MessageContext ctx = MessageContext.getCurrentContext();

		String servicePath = ctx.getTargetService();

		String jndiName = Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/serviceconfiguration";
		try {
			javax.naming.Context initialContext = new InitialContext();
			WorkflowHelperConfiguration.configuration = (WorkflowHelperConfiguration) initialContext.lookup(jndiName);
		} catch (Exception e) {
			throw new Exception("Unable to instantiate service configuration.", e);
		}

		return WorkflowHelperConfiguration.configuration;
	}
	
	private String etcDirectoryPath;
	
	
	private String helperIdentity;
	
	private String helperCredential;
	
	private String globusLocation;
	
	
	public String getEtcDirectoryPath() {
		return ContainerConfig.getBaseDirectory() + File.separator + etcDirectoryPath;
	}
	
	public void setEtcDirectoryPath(String etcDirectoryPath) {
		this.etcDirectoryPath = etcDirectoryPath;
	}

	
	public String getHelperIdentity() {
		return helperIdentity;
	}
	
	
	public void setHelperIdentity(String helperIdentity) {
		this.helperIdentity = helperIdentity;
	}

	
	public String getHelperCredential() {
		return ContainerConfig.getBaseDirectory() + File.separator + helperCredential;
	}
	
	
	public void setHelperCredential(String helperCredential) {
		this.helperCredential = helperCredential;
	}

	
	public String getGlobusLocation() {
		return globusLocation;
	}
	
	
	public void setGlobusLocation(String globusLocation) {
		this.globusLocation = globusLocation;
	}

	
}
