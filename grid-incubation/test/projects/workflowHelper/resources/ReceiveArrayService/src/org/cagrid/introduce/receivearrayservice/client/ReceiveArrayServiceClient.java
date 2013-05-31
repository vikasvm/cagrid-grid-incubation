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
package org.cagrid.introduce.receivearrayservice.client;

import java.io.InputStream;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.AxisClient;
import org.apache.axis.client.Stub;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;

import org.oasis.wsrf.properties.GetResourcePropertyResponse;

import org.globus.gsi.GlobusCredential;

import org.cagrid.introduce.receivearrayservice.stubs.ReceiveArrayServicePortType;
import org.cagrid.introduce.receivearrayservice.stubs.service.ReceiveArrayServiceAddressingLocator;
import org.cagrid.introduce.receivearrayservice.common.ReceiveArrayServiceI;
import org.cagrid.workflow.systemtests.types.ComplexType;

import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;

/**
 * This class is autogenerated, DO NOT EDIT GENERATED GRID SERVICE ACCESS METHODS.
 *
 * This client is generated automatically by Introduce to provide a clean unwrapped API to the
 * service.
 *
 * On construction the class instance will contact the remote service and retrieve it's security
 * metadata description which it will use to configure the Stub specifically for each method call.
 * 
 * @created by Introduce Toolkit version 1.1
 */
public class ReceiveArrayServiceClient extends ServiceSecurityClient implements ReceiveArrayServiceI {	
	protected ReceiveArrayServicePortType portType;
	private Object portTypeMutex;

	public ReceiveArrayServiceClient(String url) throws MalformedURIException, RemoteException {
		this(url,null);	
	}

	public ReceiveArrayServiceClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(url,proxy);
	   	initialize();
	}
	
	public ReceiveArrayServiceClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
	   	this(epr,null);
	}
	
	public ReceiveArrayServiceClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(epr,proxy);
		initialize();
	}
	
	private void initialize() throws RemoteException {
	    this.portTypeMutex = new Object();
		this.portType = createPortType();
	}

	private ReceiveArrayServicePortType createPortType() throws RemoteException {

		ReceiveArrayServiceAddressingLocator locator = new ReceiveArrayServiceAddressingLocator();
		// attempt to load our context sensitive wsdd file
		InputStream resourceAsStream = getClass().getResourceAsStream("client-config.wsdd");
		if (resourceAsStream != null) {
			// we found it, so tell axis to configure an engine to use it
			EngineConfiguration engineConfig = new FileProvider(resourceAsStream);
			// set the engine of the locator
			locator.setEngine(new AxisClient(engineConfig));
		}
		ReceiveArrayServicePortType port = null;
		try {
			port = locator.getReceiveArrayServicePortTypePort(getEndpointReference());
		} catch (Exception e) {
			throw new RemoteException("Unable to locate portType:" + e.getMessage(), e);
		}

		return port;
	}
	

	public static void usage(){
		System.out.println(ReceiveArrayServiceClient.class.getName() + " -url <service url>");
	}
	
	public static void main(String [] args){
	    System.out.println("Running the Grid Service Client");
		try{
		if(!(args.length < 2)){
			if(args[0].equals("-url")){
			  ReceiveArrayServiceClient client = new ReceiveArrayServiceClient(args[1]);
			  // place client calls here if you want to use this main as a
			  // test....
			  
			  String[] array_str = new String[]{ "Element1", "Element 2", "Element 3" };
			  
			  client.receiveArray(array_str);
			  
			  client.receiveArrayAndMore(999, array_str, true);
			  
			  ComplexType[] complex_type = new ComplexType[5];
			  for(int i=0; i < complex_type.length; i++){
				  complex_type[i] = new ComplexType(i, "Element "+i);
			  }
			  client.receiveComplexArray(999, complex_type, true);
			  
			} else {
				usage();
				System.exit(1);
			}
		} else {
			usage();
			System.exit(1);
		}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

  public void receiveArray(java.lang.String[] arrayStr) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"receiveArray");
    org.cagrid.introduce.receivearrayservice.stubs.ReceiveArrayRequest params = new org.cagrid.introduce.receivearrayservice.stubs.ReceiveArrayRequest();
    params.setArrayStr(arrayStr);
    org.cagrid.introduce.receivearrayservice.stubs.ReceiveArrayResponse boxedResult = portType.receiveArray(params);
    }
  }

  public void receiveArrayAndMore(int number,java.lang.String[] strArray,boolean booleanValue) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"receiveArrayAndMore");
    org.cagrid.introduce.receivearrayservice.stubs.ReceiveArrayAndMoreRequest params = new org.cagrid.introduce.receivearrayservice.stubs.ReceiveArrayAndMoreRequest();
    params.setNumber(number);
    params.setStrArray(strArray);
    params.setBooleanValue(booleanValue);
    org.cagrid.introduce.receivearrayservice.stubs.ReceiveArrayAndMoreResponse boxedResult = portType.receiveArrayAndMore(params);
    }
  }

  public void receiveComplexArray(int number,org.cagrid.workflow.systemtests.types.ComplexType[] complexArray,boolean booleanValue) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"receiveComplexArray");
    org.cagrid.introduce.receivearrayservice.stubs.ReceiveComplexArrayRequest params = new org.cagrid.introduce.receivearrayservice.stubs.ReceiveComplexArrayRequest();
    params.setNumber(number);
    org.cagrid.introduce.receivearrayservice.stubs.ReceiveComplexArrayRequestComplexArray complexArrayContainer = new org.cagrid.introduce.receivearrayservice.stubs.ReceiveComplexArrayRequestComplexArray();
    complexArrayContainer.setComplexType(complexArray);
    params.setComplexArray(complexArrayContainer);
    params.setBooleanValue(booleanValue);
    org.cagrid.introduce.receivearrayservice.stubs.ReceiveComplexArrayResponse boxedResult = portType.receiveComplexArray(params);
    }
  }

  public void secureReceiveArray(java.lang.String[] arrayStr) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"secureReceiveArray");
    org.cagrid.introduce.receivearrayservice.stubs.SecureReceiveArrayRequest params = new org.cagrid.introduce.receivearrayservice.stubs.SecureReceiveArrayRequest();
    params.setArrayStr(arrayStr);
    org.cagrid.introduce.receivearrayservice.stubs.SecureReceiveArrayResponse boxedResult = portType.secureReceiveArray(params);
    }
  }

  public void secureReceiveArrayAndMore(int number,java.lang.String[] strArray,boolean booleanValue) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"secureReceiveArrayAndMore");
    org.cagrid.introduce.receivearrayservice.stubs.SecureReceiveArrayAndMoreRequest params = new org.cagrid.introduce.receivearrayservice.stubs.SecureReceiveArrayAndMoreRequest();
    params.setNumber(number);
    params.setStrArray(strArray);
    params.setBooleanValue(booleanValue);
    org.cagrid.introduce.receivearrayservice.stubs.SecureReceiveArrayAndMoreResponse boxedResult = portType.secureReceiveArrayAndMore(params);
    }
  }

  public void secureReceiveComplexArray(int number,org.cagrid.workflow.systemtests.types.ComplexType[] complexArray,boolean booleanValue) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"secureReceiveComplexArray");
    org.cagrid.introduce.receivearrayservice.stubs.SecureReceiveComplexArrayRequest params = new org.cagrid.introduce.receivearrayservice.stubs.SecureReceiveComplexArrayRequest();
    params.setNumber(number);
    org.cagrid.introduce.receivearrayservice.stubs.SecureReceiveComplexArrayRequestComplexArray complexArrayContainer = new org.cagrid.introduce.receivearrayservice.stubs.SecureReceiveComplexArrayRequestComplexArray();
    complexArrayContainer.setComplexType(complexArray);
    params.setComplexArray(complexArrayContainer);
    params.setBooleanValue(booleanValue);
    org.cagrid.introduce.receivearrayservice.stubs.SecureReceiveComplexArrayResponse boxedResult = portType.secureReceiveComplexArray(params);
    }
  }

}
