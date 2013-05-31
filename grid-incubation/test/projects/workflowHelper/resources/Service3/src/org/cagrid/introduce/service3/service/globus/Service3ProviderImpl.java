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
package org.cagrid.introduce.service3.service.globus;

import org.cagrid.introduce.service3.service.Service3Impl;

import java.rmi.RemoteException;

/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class implements each method in the portType of the service.  Each method call represented
 * in the port type will be then mapped into the unwrapped implementation which the user provides
 * in the Service3Impl class.  This class handles the boxing and unboxing of each method call
 * so that it can be correclty mapped in the unboxed interface that the developer has designed and 
 * has implemented.  Authorization callbacks are automatically made for each method based
 * on each methods authorization requirements.
 * 
 * @created by Introduce Toolkit version 1.1
 * 
 */
public class Service3ProviderImpl{
	
	Service3Impl impl;
	
	public Service3ProviderImpl() throws RemoteException {
		impl = new Service3Impl();
	}
	

    public org.cagrid.introduce.service3.stubs.GenerateXResponse generateX(org.cagrid.introduce.service3.stubs.GenerateXRequest params) throws RemoteException {
    org.cagrid.introduce.service3.stubs.GenerateXResponse boxedResult = new org.cagrid.introduce.service3.stubs.GenerateXResponse();
    boxedResult.setResponse(impl.generateX(params.getStr_length()));
    return boxedResult;
  }

    public org.cagrid.introduce.service3.stubs.SecureGenerateXResponse secureGenerateX(org.cagrid.introduce.service3.stubs.SecureGenerateXRequest params) throws RemoteException {
    org.cagrid.introduce.service3.stubs.SecureGenerateXResponse boxedResult = new org.cagrid.introduce.service3.stubs.SecureGenerateXResponse();
    boxedResult.setResponse(impl.secureGenerateX(params.getStr_length()));
    return boxedResult;
  }

}
