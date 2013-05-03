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
package org.cagrid.gaards.csm.filters.service.globus;

import org.cagrid.gaards.csm.filters.service.FilterCreatorImpl;

import java.rmi.RemoteException;

/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class implements each method in the portType of the service.  Each method call represented
 * in the port type will be then mapped into the unwrapped implementation which the user provides
 * in the CSMImpl class.  This class handles the boxing and unboxing of each method call
 * so that it can be correclty mapped in the unboxed interface that the developer has designed and 
 * has implemented.  Authorization callbacks are automatically made for each method based
 * on each methods authorization requirements.
 * 
 * @created by Introduce Toolkit version 1.3
 * 
 */
public class FilterCreatorProviderImpl{
	
	FilterCreatorImpl impl;
	
	public FilterCreatorProviderImpl() throws RemoteException {
		impl = new FilterCreatorImpl();
	}
	

    public org.cagrid.gaards.csm.filters.stubs.GetClassNamesResponse getClassNames(org.cagrid.gaards.csm.filters.stubs.GetClassNamesRequest params) throws RemoteException, org.cagrid.gaards.csm.stubs.types.CSMInternalFault {
    org.cagrid.gaards.csm.filters.stubs.GetClassNamesResponse boxedResult = new org.cagrid.gaards.csm.filters.stubs.GetClassNamesResponse();
    boxedResult.setResponse(impl.getClassNames());
    return boxedResult;
  }

    public org.cagrid.gaards.csm.filters.stubs.GetAssociatedClassNamesResponse getAssociatedClassNames(org.cagrid.gaards.csm.filters.stubs.GetAssociatedClassNamesRequest params) throws RemoteException {
    org.cagrid.gaards.csm.filters.stubs.GetAssociatedClassNamesResponse boxedResult = new org.cagrid.gaards.csm.filters.stubs.GetAssociatedClassNamesResponse();
    boxedResult.setResponse(impl.getAssociatedClassNames(params.getClassName()));
    return boxedResult;
  }

    public org.cagrid.gaards.csm.filters.stubs.GetAssociatedAttributesResponse getAssociatedAttributes(org.cagrid.gaards.csm.filters.stubs.GetAssociatedAttributesRequest params) throws RemoteException {
    org.cagrid.gaards.csm.filters.stubs.GetAssociatedAttributesResponse boxedResult = new org.cagrid.gaards.csm.filters.stubs.GetAssociatedAttributesResponse();
    boxedResult.setResponse(impl.getAssociatedAttributes(params.getClassName()));
    return boxedResult;
  }

    public org.cagrid.gaards.csm.filters.stubs.GetFilterClauseBeanResponse getFilterClauseBean(org.cagrid.gaards.csm.filters.stubs.GetFilterClauseBeanRequest params) throws RemoteException {
    org.cagrid.gaards.csm.filters.stubs.GetFilterClauseBeanResponse boxedResult = new org.cagrid.gaards.csm.filters.stubs.GetFilterClauseBeanResponse();
    boxedResult.setFilterClause(impl.getFilterClauseBean(params.getStartingClass(),params.getFilters(),params.getTargetClassAttribute(),params.getTargetClassAlias(),params.getTargetClassAttributeAlias()));
    return boxedResult;
  }

}
