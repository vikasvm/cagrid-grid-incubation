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
package org.cagrid.monitor.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.3
 * 
 */
public interface MonitoringServiceI {

  /**
   * Service Metadata
   *
   * @param serviceMetadata
   */
  public void addServiceMetadata(gov.nih.nci.cagrid.metadata.ServiceMetadata serviceMetadata) throws RemoteException ;

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

  /**
   * Starts the monitoring service
   *
   */
  public void startMonitoring() throws RemoteException ;

  /**
   * Stops the monitoring service.
   *
   */
  public void stopMonitoring() throws RemoteException ;

  /**
   * Adds a service for monitoring
   *
   * @param service
   * @throws MonitorFault
   *	
   */
  public long addService(org.cagrid.monitor.db.Service service) throws RemoteException, org.cagrid.monitor.stubs.types.MonitorFault ;

  /**
   * Adds a task
   *
   * @param task
   * @throws MonitorFault
   *	
   */
  public long addTask(org.cagrid.monitor.db.Task task) throws RemoteException, org.cagrid.monitor.stubs.types.MonitorFault ;

  /**
   * Adds an event
   *
   * @param event
   * @throws MonitorFault
   *	
   */
  public long addEvent(org.cagrid.monitor.db.Event event) throws RemoteException, org.cagrid.monitor.stubs.types.MonitorFault ;

  /**
   * Get history
   *
   * @param event
   * @throws MonitorFault
   *	
   */
  public org.cagrid.monitor.db.Job[] getEventHistory(org.cagrid.monitor.db.Event event) throws RemoteException, org.cagrid.monitor.stubs.types.MonitorFault ;

}

