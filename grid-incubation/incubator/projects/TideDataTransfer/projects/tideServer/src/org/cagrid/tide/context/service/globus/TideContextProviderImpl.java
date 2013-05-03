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
package org.cagrid.tide.context.service.globus;

import org.cagrid.tide.context.service.TideContextImpl;

import java.rmi.RemoteException;

/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class implements each method in the portType of the service.  Each method call represented
 * in the port type will be then mapped into the unwrapped implementation which the user provides
 * in the TideImpl class.  This class handles the boxing and unboxing of each method call
 * so that it can be correclty mapped in the unboxed interface that the developer has designed and 
 * has implemented.  Authorization callbacks are automatically made for each method based
 * on each methods authorization requirements.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class TideContextProviderImpl{
	
	TideContextImpl impl;
	
	public TideContextProviderImpl() throws RemoteException {
		impl = new TideContextImpl();
	}
	

    public org.cagrid.tide.context.stubs.GetWaveResponse getWave(org.cagrid.tide.context.stubs.GetWaveRequest params) throws RemoteException {
    org.cagrid.tide.context.stubs.GetWaveResponse boxedResult = new org.cagrid.tide.context.stubs.GetWaveResponse();
    boxedResult.setWaveDescriptor(impl.getWave(params.getWaveRequest().getWaveRequest()));
    return boxedResult;
  }

}
