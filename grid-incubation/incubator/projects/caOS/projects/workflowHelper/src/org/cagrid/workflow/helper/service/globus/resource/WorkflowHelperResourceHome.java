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
package org.cagrid.workflow.helper.service.globus.resource;

import gov.nih.nci.cagrid.introduce.servicetools.SingletonResourceHomeImpl;

import org.apache.axis.components.uuid.UUIDGen;
import org.apache.axis.components.uuid.UUIDGenFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cagrid.workflow.helper.common.WorkflowHelperConstants;
import org.cagrid.workflow.helper.stubs.WorkflowHelperResourceProperties;
import org.globus.wsrf.InvalidResourceKeyException;
import org.globus.wsrf.PersistenceCallback;
import org.globus.wsrf.Resource;
import org.globus.wsrf.ResourceContext;
import org.globus.wsrf.ResourceException;
import org.globus.wsrf.ResourceKey;
import org.globus.wsrf.jndi.Initializable;


/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class implements the resource home for the resource type represented
 * by this service.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class WorkflowHelperResourceHome extends SingletonResourceHomeImpl implements Initializable {

	static final Log logger = LogFactory.getLog(WorkflowHelperResourceHome.class);
    private static final UUIDGen UUIDGEN = UUIDGenFactory.getUUIDGen();

	public Resource createSingleton() {
		logger.info("Creating a single resource.");
		try {
		    WorkflowHelperResourceProperties props = new WorkflowHelperResourceProperties();
			WorkflowHelperResource resource = new WorkflowHelperResource();
			if (resource instanceof PersistenceCallback) {
			      //try to load the resource if it was persisted
                  try{
                    ((PersistenceCallback) resource).load(null);
			      } catch (InvalidResourceKeyException ex){
			      	  //persisted singleton resource was not found so we will just create a new one
			          resource.initialize(props, WorkflowHelperConstants.RESOURCE_PROPERTY_SET, UUIDGEN.nextUUID());
			      }
            } else {
                    resource.initialize(props, WorkflowHelperConstants.RESOURCE_PROPERTY_SET, UUIDGEN.nextUUID());
            }
			
			return resource;
		} catch (Exception e) {
			logger.error("Exception when creating the resource",e);
			return null;
		}
	}


	public Resource find(ResourceKey key) throws ResourceException {
		WorkflowHelperResource resource = (WorkflowHelperResource) super.find(key);
		return resource;
	}


	/**
	 * Initialze the singleton resource, when the home is initialized.
	 */
	public void initialize() throws Exception {
		logger.info("Attempting to initialize resource.");
		Resource resource = find(null);
		if (resource == null) {
			logger.error("Unable to initialize resource!");
		} else {
			logger.info("Successfully initialized resource.");
		}
	}
	
    /**
     * Get the resouce that is being addressed in this current context
     */
    public WorkflowHelperResource getAddressedResource() throws Exception {
        WorkflowHelperResource thisResource;
        thisResource = (WorkflowHelperResource) ResourceContext.getResourceContext().getResource();
        return thisResource;
    }
}
