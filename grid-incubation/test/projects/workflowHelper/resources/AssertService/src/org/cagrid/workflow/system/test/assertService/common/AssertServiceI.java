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

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

  public boolean assertEquals(java.lang.String string1,java.lang.String string2) throws RemoteException ;

  public boolean assertNumbersEqual(long number1,long number2) throws RemoteException ;

  public boolean secureAssertEquals(java.lang.String string1,java.lang.String string2) throws RemoteException ;

  public boolean secureAssertNumberEquals(long number1,long number2) throws RemoteException ;

}

