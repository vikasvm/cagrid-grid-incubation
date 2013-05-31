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
package org.cagrid.iso21090.service.globus;


import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import javax.security.auth.Subject;
import javax.xml.namespace.QName;
import javax.xml.rpc.handler.MessageContext;

import gov.nih.nci.cagrid.introduce.servicetools.security.AuthorizationExtension;
import org.globus.wsrf.impl.security.authorization.exceptions.AuthorizationException;
import org.globus.wsrf.impl.security.authorization.exceptions.CloseException;
import org.globus.wsrf.impl.security.authorization.exceptions.InitializeException;
import org.globus.wsrf.impl.security.authorization.exceptions.InvalidPolicyException;
import org.globus.wsrf.security.authorization.PDP;
import org.globus.wsrf.security.authorization.PDPConfig;
import org.globus.wsrf.config.ContainerConfig;
import org.w3c.dom.Node;


/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This is a PDP for use with the globus authorization callout.
 * This class will have a authorize method for each method on this grid service.
 * The method is responsibe for making any authorization callouts required to satisfy the 
 * authorization requirements placed on each method call.  Each method will either return
 * apon a successful authorization or will throw an exception apon a failed authorization.
 * 
 * @created by Introduce Toolkit version 1.3
 * 
 */
public class ISO21090AnalyticalServiceAuthorization implements PDP {

	public static final String SERVICE_NAMESPACE = "http://iso21090.cagrid.org/ISO21090AnalyticalService";
	
	Map authorizationClassMap = new HashMap();
	
	
	public ISO21090AnalyticalServiceAuthorization() {
	}
	
	protected String getServiceNamespace(){
		return SERVICE_NAMESPACE;
	}
	
	public static String getCallerIdentity() {
		String caller = org.globus.wsrf.security.SecurityManager.getManager().getCaller();
		if ((caller == null) || (caller.equals("<anonymous>"))) {
			return null;
		} else {
			return caller;
		}
	}
					
	public void authorizeGetMultipleResourceProperties(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetResourceProperty(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeQueryResourceProperties(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetServiceSecurityMetadata(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendBlNonNull(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendEdText(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendAd(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendBl(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendCd(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendEd(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendEn(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendEnOn(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendEnPn(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendIi(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendIvlInt(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendIvlPq(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendIvlReal(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendIvlTs(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendPq(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendReal(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendSc(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendSt(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendStNt(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendTel(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendTelEmail(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendTelPerson(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendTelPhone(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendTelUrl(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendTs(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendDSetAd(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendDSetCd(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendDSetII(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendDSetTel(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSendInt(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   
	
	public boolean isPermitted(Subject peerSubject, MessageContext context, QName operation)
		throws AuthorizationException {
		
		if(!operation.getNamespaceURI().equals(getServiceNamespace())){
		  return false;
		}
		if(operation.getLocalPart().equals("getMultipleResourceProperties")){
			authorizeGetMultipleResourceProperties(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getResourceProperty")){
			authorizeGetResourceProperty(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("queryResourceProperties")){
			authorizeQueryResourceProperties(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getServiceSecurityMetadata")){
			authorizeGetServiceSecurityMetadata(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendBlNonNull")){
			authorizeSendBlNonNull(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendEdText")){
			authorizeSendEdText(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendAd")){
			authorizeSendAd(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendBl")){
			authorizeSendBl(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendCd")){
			authorizeSendCd(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendEd")){
			authorizeSendEd(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendEn")){
			authorizeSendEn(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendEnOn")){
			authorizeSendEnOn(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendEnPn")){
			authorizeSendEnPn(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendIi")){
			authorizeSendIi(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendIvlInt")){
			authorizeSendIvlInt(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendIvlPq")){
			authorizeSendIvlPq(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendIvlReal")){
			authorizeSendIvlReal(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendIvlTs")){
			authorizeSendIvlTs(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendPq")){
			authorizeSendPq(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendReal")){
			authorizeSendReal(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendSc")){
			authorizeSendSc(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendSt")){
			authorizeSendSt(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendStNt")){
			authorizeSendStNt(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendTel")){
			authorizeSendTel(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendTelEmail")){
			authorizeSendTelEmail(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendTelPerson")){
			authorizeSendTelPerson(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendTelPhone")){
			authorizeSendTelPhone(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendTelUrl")){
			authorizeSendTelUrl(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendTs")){
			authorizeSendTs(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendDSetAd")){
			authorizeSendDSetAd(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendDSetCd")){
			authorizeSendDSetCd(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendDSetII")){
			authorizeSendDSetII(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendDSetTel")){
			authorizeSendDSetTel(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("sendInt")){
			authorizeSendInt(peerSubject, context, operation);
			return true;
		} 		
		return false;
	}
	

	public Node getPolicy(Node query) throws InvalidPolicyException {
		return null;
	}


	public String[] getPolicyNames() {
		return null;
	}


	public Node setPolicy(Node policy) throws InvalidPolicyException {
		return null;
	}


	public void close() throws CloseException {


	}


	public void initialize(PDPConfig config, String name, String id) throws InitializeException {
    	try{
    		String serviceName = (String)config.getProperty(name, "serviceName");
    	    String etcPath = ContainerConfig.getBaseDirectory() + File.separator + (String)config.getProperty(name, "etcDirectoryPath");

    	
    	} catch (Exception e){
        	throw new InitializeException(e.getMessage(),e);
		}
	}
	
	
}
