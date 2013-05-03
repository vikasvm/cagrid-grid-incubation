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
package org.cagrid.workflow.system.test.assertService.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public interface AssertServiceI {

  public boolean assertComplexArrayEquals(systemtests.ComplexType[] complexArray1,systemtests.ComplexType[] complexArray2) throws RemoteException ;

  public boolean assertSimpleArrayEquals(java.lang.String[] stringArray1,java.lang.String[] stringArray2) throws RemoteException ;

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

  public boolean assertEquals(java.lang.String string1,java.lang.String string2) throws RemoteException ;

  public boolean assertNumbersEqual(long number1,long number2) throws RemoteException ;

  public boolean secureAssertEquals(java.lang.String string1,java.lang.String string2) throws RemoteException ;

  public boolean secureAssertNumberEquals(long number1,long number2) throws RemoteException ;

}

