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
package org.cagrid.gaards.cds.service.globus;


import java.rmi.RemoteException;
import javax.security.auth.Subject;
import javax.xml.namespace.QName;
import javax.xml.rpc.handler.MessageContext;

import org.globus.wsrf.impl.security.authorization.exceptions.AuthorizationException;
import org.globus.wsrf.impl.security.authorization.exceptions.CloseException;
import org.globus.wsrf.impl.security.authorization.exceptions.InitializeException;
import org.globus.wsrf.impl.security.authorization.exceptions.InvalidPolicyException;
import org.globus.wsrf.security.authorization.PDP;
import org.globus.wsrf.security.authorization.PDPConfig;
import org.w3c.dom.Node;


/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This is a PDP for use with the globus authorization callout.
 * This class will have a authorize<methodName> method for each method on this grid service.
 * The method is responsibe for making any authorization callouts required to satisfy the 
 * authorization requirements placed on each method call.  Each method will either return
 * apon a successful authorization or will throw an exception apon a failed authorization.
 * 
 * @created by Introduce Toolkit version 1.1
 * 
 */
public class CredentialDelegationServiceAuthorization implements PDP {

	public static final String SERVICE_NAMESPACE = "http://cds.gaards.cagrid.org/CredentialDelegationService";
	
	
	public CredentialDelegationServiceAuthorization() {
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
					
	public static void authorizeGetServiceSecurityMetadata() throws RemoteException {
		
		
	}
					
	public static void authorizeInitiateDelegation() throws RemoteException {
		
		
	}
					
	public static void authorizeApproveDelegation() throws RemoteException {
		
		
	}
					
	public static void authorizeFindDelegatedCredentials() throws RemoteException {
		
		
	}
					
	public static void authorizeUpdateDelegatedCredentialStatus() throws RemoteException {
		
		
	}
					
	public static void authorizeFindCredentialsDelegatedToClient() throws RemoteException {
		
		
	}
					
	public static void authorizeSearchDelegatedCredentialAuditLog() throws RemoteException {
		
		
	}
					
	public static void authorizeDeleteDelegatedCredential() throws RemoteException {
		
		
	}
					
	public static void authorizeAddAdmin() throws RemoteException {
		
		
	}
					
	public static void authorizeRemoveAdmin() throws RemoteException {
		
		
	}
					
	public static void authorizeGetAdmins() throws RemoteException {
		
		
	}
	
	
	public boolean isPermitted(Subject peerSubject, MessageContext context, QName operation)
		throws AuthorizationException {
		
		if(!operation.getNamespaceURI().equals(getServiceNamespace())){
		  return false;
		}
		if(operation.getLocalPart().equals("getServiceSecurityMetadata")){
			try{
				authorizeGetServiceSecurityMetadata();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("initiateDelegation")){
			try{
				authorizeInitiateDelegation();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("approveDelegation")){
			try{
				authorizeApproveDelegation();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("findDelegatedCredentials")){
			try{
				authorizeFindDelegatedCredentials();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("updateDelegatedCredentialStatus")){
			try{
				authorizeUpdateDelegatedCredentialStatus();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("findCredentialsDelegatedToClient")){
			try{
				authorizeFindCredentialsDelegatedToClient();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("searchDelegatedCredentialAuditLog")){
			try{
				authorizeSearchDelegatedCredentialAuditLog();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("deleteDelegatedCredential")){
			try{
				authorizeDeleteDelegatedCredential();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("addAdmin")){
			try{
				authorizeAddAdmin();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("removeAdmin")){
			try{
				authorizeRemoveAdmin();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("getAdmins")){
			try{
				authorizeGetAdmins();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
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

	}
	
	
}
