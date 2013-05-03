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
package org.cagrid.tide.service;

import org.cagrid.tide.service.globus.resource.TideResource;
import  org.cagrid.tide.service.TideConfiguration;

import java.rmi.RemoteException;

import javax.naming.InitialContext;
import javax.xml.namespace.QName;

import org.apache.axis.MessageContext;
import org.globus.wsrf.Constants;
import org.globus.wsrf.ResourceContext;
import org.globus.wsrf.ResourceContextException;
import org.globus.wsrf.ResourceException;
import org.globus.wsrf.ResourceHome;
import org.globus.wsrf.ResourceProperty;
import org.globus.wsrf.ResourcePropertySet;


/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * Provides some simple accessors for the Impl.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public abstract class TideImplBase {
	
	public TideImplBase() throws RemoteException {
	
	}
	
	public TideConfiguration getConfiguration() throws Exception {
		return TideConfiguration.getConfiguration();
	}
	
	
	public org.cagrid.tide.service.globus.resource.TideResourceHome getResourceHome() throws Exception {
		ResourceHome resource = getResourceHome("home");
		return (org.cagrid.tide.service.globus.resource.TideResourceHome)resource;
	}

	
	
	
	public org.cagrid.tide.context.service.globus.resource.TideContextResourceHome getTideContextResourceHome() throws Exception {
		ResourceHome resource = getResourceHome("tideContextHome");
		return (org.cagrid.tide.context.service.globus.resource.TideContextResourceHome)resource;
	}
	
	
	protected ResourceHome getResourceHome(String resourceKey) throws Exception {
		MessageContext ctx = MessageContext.getCurrentContext();

		ResourceHome resourceHome = null;
		
		String servicePath = ctx.getTargetService();

		String jndiName = Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/" + resourceKey;
		try {
			javax.naming.Context initialContext = new InitialContext();
			resourceHome = (ResourceHome) initialContext.lookup(jndiName);
		} catch (Exception e) {
			throw new Exception("Unable to instantiate resource home. : " + resourceKey, e);
		}

		return resourceHome;
	}


}

