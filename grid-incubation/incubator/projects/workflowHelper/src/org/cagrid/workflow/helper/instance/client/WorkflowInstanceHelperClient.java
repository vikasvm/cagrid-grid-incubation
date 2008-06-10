package org.cagrid.workflow.helper.instance.client;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axis.client.Stub;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;
import org.cagrid.workflow.helper.instance.common.WorkflowInstanceHelperI;
import org.globus.gsi.GlobusCredential;
import org.globus.wsrf.NotifyCallback;
import org.globus.wsrf.container.ContainerException;

/**
 * This class is autogenerated, DO NOT EDIT GENERATED GRID SERVICE ACCESS METHODS.
 *
 * This client is generated automatically by Introduce to provide a clean unwrapped API to the
 * service.
 *
 * On construction the class instance will contact the remote service and retrieve it's security
 * metadata description which it will use to configure the Stub specifically for each method call.
 * 
 * @created by Introduce Toolkit version 1.2
 */
public class WorkflowInstanceHelperClient extends WorkflowInstanceHelperClientBase implements WorkflowInstanceHelperI {	

	private Map<QName, NotifyCallback> callbacks = new HashMap<QName, NotifyCallback>();

	public WorkflowInstanceHelperClient(String url) throws MalformedURIException, RemoteException {
		this(url,null);	
	}

	public WorkflowInstanceHelperClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
		super(url,proxy);
	}

	public WorkflowInstanceHelperClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
		this(epr,null);
	}

	public WorkflowInstanceHelperClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
		super(epr,proxy);
	}

	public static void usage(){
		System.out.println(WorkflowInstanceHelperClient.class.getName() + " -url <service url>");
	}

	public static void main(String [] args){
		System.out.println("Running the Grid Service Client");
		try{
			if(!(args.length < 2)){
				if(args[0].equals("-url")){
					WorkflowInstanceHelperClient client = new WorkflowInstanceHelperClient(args[1]);
					// place client calls here if you want to use this main as a
					// test....
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

	public org.oasis.wsn.SubscribeResponse subscribeWithCallback(QName qname, NotifyCallback callback) throws RemoteException, ContainerException, MalformedURIException {

		//System.out.print("[InstanceHelper::subscribeWithCallback] Putting "+ qname +" on internal list"); //DEBUG

		callbacks.put(qname, callback);

		//System.out.println("...OK"); // DEBUG

		return subscribe(qname, callback);
	} 

  
  
  public org.oasis.wsn.SubscribeResponse subscribe(QName qname, NotifyCallback callback) throws RemoteException, ContainerException, MalformedURIException {
      synchronized (portTypeMutex) {
          configureStubSecurity((Stub) portType, "subscribe");

          if (consumer == null) {
              // Create client side notification consumer
              consumer = org.globus.wsrf.NotificationConsumerManager.getInstance();
              consumer.startListening();
              consumerEPR = consumer.createNotificationConsumer(callback);
          }

          org.oasis.wsn.Subscribe params = new org.oasis.wsn.Subscribe();
          params.setUseNotify(Boolean.TRUE);
          params.setConsumerReference(consumerEPR);
          org.oasis.wsn.TopicExpressionType topicExpression = new org.oasis.wsn.TopicExpressionType();
          topicExpression.setDialect(org.globus.wsrf.WSNConstants.SIMPLE_TOPIC_DIALECT);
          topicExpression.setValue(qname);
          params.setTopicExpression(topicExpression);
          return portType.subscribe(params);
     }
  }

  public org.oasis.wsrf.lifetime.DestroyResponse destroy(org.oasis.wsrf.lifetime.Destroy params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"destroy");
    return portType.destroy(params);
    }
  }

  public org.oasis.wsrf.lifetime.SetTerminationTimeResponse setTerminationTime(org.oasis.wsrf.lifetime.SetTerminationTime params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"setTerminationTime");
    return portType.setTerminationTime(params);
    }
  }

  public org.cagrid.workflow.helper.invocation.client.WorkflowInvocationHelperClient createWorkflowInvocationHelper(org.cagrid.workflow.helper.descriptor.WorkflowInvocationHelperDescriptor workflowInvocationHelperDescriptor) throws RemoteException, org.apache.axis.types.URI.MalformedURIException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"createWorkflowInvocationHelper");
    org.cagrid.workflow.helper.instance.stubs.CreateWorkflowInvocationHelperRequest params = new org.cagrid.workflow.helper.instance.stubs.CreateWorkflowInvocationHelperRequest();
    org.cagrid.workflow.helper.instance.stubs.CreateWorkflowInvocationHelperRequestWorkflowInvocationHelperDescriptor workflowInvocationHelperDescriptorContainer = new org.cagrid.workflow.helper.instance.stubs.CreateWorkflowInvocationHelperRequestWorkflowInvocationHelperDescriptor();
    workflowInvocationHelperDescriptorContainer.setWorkflowInvocationHelperDescriptor(workflowInvocationHelperDescriptor);
    params.setWorkflowInvocationHelperDescriptor(workflowInvocationHelperDescriptorContainer);
    org.cagrid.workflow.helper.instance.stubs.CreateWorkflowInvocationHelperResponse boxedResult = portType.createWorkflowInvocationHelper(params);
    EndpointReferenceType ref = boxedResult.getWorkflowInvocationHelperReference().getEndpointReference();
    return new org.cagrid.workflow.helper.invocation.client.WorkflowInvocationHelperClient(ref);
    }
  }

  public void addCredential(org.apache.axis.message.addressing.EndpointReferenceType serviceOperationEPR,org.apache.axis.message.addressing.EndpointReferenceType proxyEPR) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"addCredential");
    org.cagrid.workflow.helper.instance.stubs.AddCredentialRequest params = new org.cagrid.workflow.helper.instance.stubs.AddCredentialRequest();
    org.cagrid.workflow.helper.instance.stubs.AddCredentialRequestServiceOperationEPR serviceOperationEPRContainer = new org.cagrid.workflow.helper.instance.stubs.AddCredentialRequestServiceOperationEPR();
    serviceOperationEPRContainer.setEndpointReference(serviceOperationEPR);
    params.setServiceOperationEPR(serviceOperationEPRContainer);
    org.cagrid.workflow.helper.instance.stubs.AddCredentialRequestProxyEPR proxyEPRContainer = new org.cagrid.workflow.helper.instance.stubs.AddCredentialRequestProxyEPR();
    proxyEPRContainer.setEndpointReference(proxyEPR);
    params.setProxyEPR(proxyEPRContainer);
    org.cagrid.workflow.helper.instance.stubs.AddCredentialResponse boxedResult = portType.addCredential(params);
    }
  }

  public void removeCredential(org.apache.axis.message.addressing.EndpointReferenceType proxyEPR) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"removeCredential");
    org.cagrid.workflow.helper.instance.stubs.RemoveCredentialRequest params = new org.cagrid.workflow.helper.instance.stubs.RemoveCredentialRequest();
    org.cagrid.workflow.helper.instance.stubs.RemoveCredentialRequestProxyEPR proxyEPRContainer = new org.cagrid.workflow.helper.instance.stubs.RemoveCredentialRequestProxyEPR();
    proxyEPRContainer.setEndpointReference(proxyEPR);
    params.setProxyEPR(proxyEPRContainer);
    org.cagrid.workflow.helper.instance.stubs.RemoveCredentialResponse boxedResult = portType.removeCredential(params);
    }
  }

  public void replaceCredential(org.apache.axis.message.addressing.EndpointReferenceType serviceOperationEPR,org.apache.axis.message.addressing.EndpointReferenceType proxyEPR) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"replaceCredential");
    org.cagrid.workflow.helper.instance.stubs.ReplaceCredentialRequest params = new org.cagrid.workflow.helper.instance.stubs.ReplaceCredentialRequest();
    org.cagrid.workflow.helper.instance.stubs.ReplaceCredentialRequestServiceOperationEPR serviceOperationEPRContainer = new org.cagrid.workflow.helper.instance.stubs.ReplaceCredentialRequestServiceOperationEPR();
    serviceOperationEPRContainer.setEndpointReference(serviceOperationEPR);
    params.setServiceOperationEPR(serviceOperationEPRContainer);
    org.cagrid.workflow.helper.instance.stubs.ReplaceCredentialRequestProxyEPR proxyEPRContainer = new org.cagrid.workflow.helper.instance.stubs.ReplaceCredentialRequestProxyEPR();
    proxyEPRContainer.setEndpointReference(proxyEPR);
    params.setProxyEPR(proxyEPRContainer);
    org.cagrid.workflow.helper.instance.stubs.ReplaceCredentialResponse boxedResult = portType.replaceCredential(params);
    }
  }

  public void setIsInvocationHelperSecure(org.apache.axis.message.addressing.EndpointReferenceType serviceOperationEPR,boolean isSecure) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"setIsInvocationHelperSecure");
    org.cagrid.workflow.helper.instance.stubs.SetIsInvocationHelperSecureRequest params = new org.cagrid.workflow.helper.instance.stubs.SetIsInvocationHelperSecureRequest();
    org.cagrid.workflow.helper.instance.stubs.SetIsInvocationHelperSecureRequestServiceOperationEPR serviceOperationEPRContainer = new org.cagrid.workflow.helper.instance.stubs.SetIsInvocationHelperSecureRequestServiceOperationEPR();
    serviceOperationEPRContainer.setEndpointReference(serviceOperationEPR);
    params.setServiceOperationEPR(serviceOperationEPRContainer);
    params.setIsSecure(isSecure);
    org.cagrid.workflow.helper.instance.stubs.SetIsInvocationHelperSecureResponse boxedResult = portType.setIsInvocationHelperSecure(params);
    }
  }

  public org.oasis.wsn.SubscribeResponse subscribe(org.oasis.wsn.Subscribe params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"subscribe");
    return portType.subscribe(params);
    }
  }

  public java.lang.String getEPRString() throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getEPRString");
    org.cagrid.workflow.helper.instance.stubs.GetEPRStringRequest params = new org.cagrid.workflow.helper.instance.stubs.GetEPRStringRequest();
    org.cagrid.workflow.helper.instance.stubs.GetEPRStringResponse boxedResult = portType.getEPRString(params);
    return boxedResult.getResponse();
    }
  }

}
