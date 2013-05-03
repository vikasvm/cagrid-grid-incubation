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
package org.cagrid.tide.replica.context.service.globus;

import org.cagrid.tide.replica.context.service.TideReplicaManagerContextImpl;

import java.rmi.RemoteException;

/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class implements each method in the portType of the service.  Each method call represented
 * in the port type will be then mapped into the unwrapped implementation which the user provides
 * in the TideReplicaManagerImpl class.  This class handles the boxing and unboxing of each method call
 * so that it can be correclty mapped in the unboxed interface that the developer has designed and 
 * has implemented.  Authorization callbacks are automatically made for each method based
 * on each methods authorization requirements.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class TideReplicaManagerContextProviderImpl{
	
	TideReplicaManagerContextImpl impl;
	
	public TideReplicaManagerContextProviderImpl() throws RemoteException {
		impl = new TideReplicaManagerContextImpl();
	}
	

    public org.cagrid.tide.replica.context.stubs.AddReplicaHostResponse addReplicaHost(org.cagrid.tide.replica.context.stubs.AddReplicaHostRequest params) throws RemoteException {
    org.cagrid.tide.replica.context.stubs.AddReplicaHostResponse boxedResult = new org.cagrid.tide.replica.context.stubs.AddReplicaHostResponse();
    impl.addReplicaHost(params.getTideContextReference().getEndpointReference());
    return boxedResult;
  }

    public org.cagrid.tide.replica.context.stubs.GetReplicasResponse getReplicas(org.cagrid.tide.replica.context.stubs.GetReplicasRequest params) throws RemoteException {
    org.cagrid.tide.replica.context.stubs.GetReplicasResponse boxedResult = new org.cagrid.tide.replica.context.stubs.GetReplicasResponse();
    boxedResult.setTideReplicasDescriptor(impl.getReplicas());
    return boxedResult;
  }

    public org.cagrid.tide.replica.context.stubs.ReportUnreachableReplicaHostResponse reportUnreachableReplicaHost(org.cagrid.tide.replica.context.stubs.ReportUnreachableReplicaHostRequest params) throws RemoteException {
    org.cagrid.tide.replica.context.stubs.ReportUnreachableReplicaHostResponse boxedResult = new org.cagrid.tide.replica.context.stubs.ReportUnreachableReplicaHostResponse();
    impl.reportUnreachableReplicaHost(params.getTideContextReference().getEndpointReference());
    return boxedResult;
  }

}
