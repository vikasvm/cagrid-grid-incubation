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
package org.cagrid.gaards.csm.service;

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
 * @created by Introduce Toolkit version 1.3
 * 
 */
public class CSMConfiguration implements ServiceConfiguration {

	public static CSMConfiguration  configuration = null;
    public String etcDirectoryPath;
    	
	public static CSMConfiguration getConfiguration() throws Exception {
		if (CSMConfiguration.configuration != null) {
			return CSMConfiguration.configuration;
		}
		MessageContext ctx = MessageContext.getCurrentContext();

		String servicePath = ctx.getTargetService();

		String jndiName = Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/serviceconfiguration";
		try {
			javax.naming.Context initialContext = new InitialContext();
			CSMConfiguration.configuration = (CSMConfiguration) initialContext.lookup(jndiName);
		} catch (Exception e) {
			throw new Exception("Unable to instantiate service configuration.", e);
		}

		return CSMConfiguration.configuration;
	}
	

	
	private String csmProperties;
	
	private String csmConfiguration;
	
	
    public String getEtcDirectoryPath() {
		return ContainerConfig.getBaseDirectory() + File.separator + etcDirectoryPath;
	}
	
	public void setEtcDirectoryPath(String etcDirectoryPath) {
		this.etcDirectoryPath = etcDirectoryPath;
	}


	
	public String getCsmProperties() {
		return ContainerConfig.getBaseDirectory() + File.separator + csmProperties;
	}
	
	
	public void setCsmProperties(String csmProperties) {
		this.csmProperties = csmProperties;
	}

	
	public String getCsmConfiguration() {
		return ContainerConfig.getBaseDirectory() + File.separator + csmConfiguration;
	}
	
	
	public void setCsmConfiguration(String csmConfiguration) {
		this.csmConfiguration = csmConfiguration;
	}

	
}
