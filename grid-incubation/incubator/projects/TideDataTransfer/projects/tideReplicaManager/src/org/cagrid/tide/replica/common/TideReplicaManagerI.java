package org.cagrid.tide.replica.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public interface TideReplicaManagerI {

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

  public org.cagrid.tide.replica.context.client.TideReplicaManagerContextClient createTideReplicaManagerContext(org.cagrid.tide.descriptor.TideDescriptor tideDescriptor) throws RemoteException, org.apache.axis.types.URI.MalformedURIException ;

  public org.cagrid.tide.replica.context.client.TideReplicaManagerContextClient getTideReplicaManagerContext(java.lang.String tideID) throws RemoteException, org.apache.axis.types.URI.MalformedURIException ;

  public org.cagrid.tide.descriptor.TideInformation[] listTides() throws RemoteException ;

  public org.cagrid.tide.descriptor.TideInformation[] queryTides(java.lang.String string) throws RemoteException ;

}
