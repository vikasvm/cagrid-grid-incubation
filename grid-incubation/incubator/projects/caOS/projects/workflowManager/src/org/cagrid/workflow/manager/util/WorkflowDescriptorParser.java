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
package org.cagrid.workflow.manager.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.xml.namespace.QName;

import org.apache.axis.message.addressing.Address;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.cagrid.workflow.helper.descriptor.AnonymousAuthenticationMethod;
import org.cagrid.workflow.helper.descriptor.CDSAuthenticationMethod;
import org.cagrid.workflow.helper.descriptor.ChannelProtection;
import org.cagrid.workflow.helper.descriptor.DeliveryPolicy;
import org.cagrid.workflow.helper.descriptor.InputParameter;
import org.cagrid.workflow.helper.descriptor.InputParameterDescriptor;
import org.cagrid.workflow.helper.descriptor.NativeDelegationAuthenticationMethod;
import org.cagrid.workflow.helper.descriptor.OperationInputMessageDescriptor;
import org.cagrid.workflow.helper.descriptor.OperationOutputParameterTransportDescriptor;
import org.cagrid.workflow.helper.descriptor.OperationOutputTransportDescriptor;
import org.cagrid.workflow.helper.descriptor.SecureConversationInvocationSecurityDescriptor;
import org.cagrid.workflow.helper.descriptor.SecureMessageInvocationSecurityDescriptor;
import org.cagrid.workflow.helper.descriptor.ServiceAuthenticationMethod;
import org.cagrid.workflow.helper.descriptor.TLSInvocationSecurityDescriptor;
import org.cagrid.workflow.helper.descriptor.WorkflowInstanceHelperDescriptor;
import org.cagrid.workflow.helper.descriptor.WorkflowInvocationHelperDescriptor;
import org.cagrid.workflow.helper.descriptor.WorkflowInvocationSecurityDescriptor;
import org.cagrid.workflow.manager.descriptor.WorkflowInputParameter;
import org.cagrid.workflow.manager.descriptor.WorkflowInputParameters;
import org.cagrid.workflow.manager.descriptor.WorkflowManagerInstanceDescriptor;
import org.cagrid.workflow.manager.descriptor.WorkflowOutputParameterTransportDescriptor;
import org.cagrid.workflow.manager.descriptor.WorkflowOutputTransportDescriptor;
import org.cagrid.workflow.manager.descriptor.WorkflowPortionDescriptor;
import org.cagrid.workflow.manager.descriptor.WorkflowStageDescriptor;
import org.cagrid.workflow.workflowhelperservice.workflowHelperService.DeliveryPolicy.Enum;
import org.cagrid.workflow.workflowmanagerservice.workflowManagerService.WorkflowPortionsDescriptor;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xmlsoap.schemas.ws.x2004.x03.addressing.AttributedURI;

public class WorkflowDescriptorParser implements WorkflowManagerInstanceParser {


	private static Log logger = LogFactory.getLog(WorkflowDescriptorParser.class);


	/**
	 * Parse an XML description of a workflow into the WorkflowManagerInstance descriptor
	 * @throws Exception 
	 * */
	public org.cagrid.workflow.manager.descriptor.WorkflowManagerInstanceDescriptor parseWorkflowDescriptor(
			String xmlWorkflowDescription) throws Exception {


		// Use parser generated by XMLBeans to parse the descriptor
		StringReader stringReader = new StringReader(xmlWorkflowDescription);
		org.cagrid.workflow.workflowmanagerservice.workflowManagerService.WorkflowManagerInstanceDescriptorDocument managerInstanceDescriptor = null;
		try {
			Collection errors = new ArrayList();
			XmlOptions options = new XmlOptions();
			options.setErrorListener(errors);
			managerInstanceDescriptor = 
				org.cagrid.workflow.workflowmanagerservice.workflowManagerService.WorkflowManagerInstanceDescriptorDocument.Factory.parse(stringReader);

			// Validate the file just read
			boolean isValidDescriptor = managerInstanceDescriptor.validate(options);

			if( !isValidDescriptor ){

				// Print errors
				Iterator errors_iter = errors.iterator();
				StringBuffer errorsbuf = new StringBuffer();
				while( errors_iter.hasNext() ){

					String curr_error = errors_iter.next().toString();
					errorsbuf.append("\n"+curr_error);
				}
				throw new Exception("File descriptor is not valid"+ errorsbuf.toString());
			}

		} catch (XmlException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 


		// Convert the retrieved descriptor into the type generated by Introduce
		org.cagrid.workflow.manager.descriptor.WorkflowManagerInstanceDescriptor convertedDescriptor = 
			convertFromXMLBeans(managerInstanceDescriptor.getWorkflowManagerInstanceDescriptor());

		return convertedDescriptor;
	}



	/** METHODS THAT TRAVERSE THE DESCRIPTOR AND CONVERT IT INTO THE INTRODUCE-GENERATED TYPE  **/

	/**
	 * Each one of the following methods follows a common pattern. They instantiate the return object and delegate the task of converting 
	 * its attributes. If the return object has any attribute of a simple type (Java native type or Enumeration), the method convert it to
	 * the corresponding Introduce-generated type.
	 * @throws MalformedURIException 
	 * **/



	private static WorkflowManagerInstanceDescriptor convertFromXMLBeans(
			org.cagrid.workflow.workflowmanagerservice.workflowManagerService.WorkflowManagerInstanceDescriptor managerInstanceDescriptor) throws MalformedURIException {

		WorkflowManagerInstanceDescriptor converted = null;

		if( managerInstanceDescriptor != null ){
			
			// Retrieve all namespaces in this document
			Node node = managerInstanceDescriptor.getDomNode();
			NamedNodeMap attrs = node.getAttributes();
			ArrayList<QName> namespaces = new ArrayList<QName>();
			String tns = node.getNamespaceURI();
			QName targetNamespace = new QName(tns, "tns");
			namespaces.add(targetNamespace);
			
			for(int i=0; i < attrs.getLength(); i++){
				
				Node curr_attr = attrs.item(i);
				String name = curr_attr.getNodeName();
				String value = curr_attr.getNodeValue();
				
				// If current attribute is a namespace declaration, store namespace prefix
				if( name.contains("xmlns") ){

					String prefix;
					int colonIndex = name.indexOf(':');
					prefix = name.substring(colonIndex + 1);
					
					QName namespacePrefix = new QName(value, prefix);
					namespaces.add(namespacePrefix);
				}
			}
			QName[] namespacesArray = namespaces.toArray(new QName[0]);
			
			
			
			// Proceed to the conversion from the XMLBeans-generated type to the Introduce-generated one
			converted = new WorkflowManagerInstanceDescriptor();
			converted.setInputs(extractInputs(managerInstanceDescriptor.getInputs()));
			converted.setOutputDesc(extractOutputDesc(managerInstanceDescriptor.getOutputDesc(), namespacesArray));
			converted.setLocalWorkflows(extractLocalWorkflows(managerInstanceDescriptor.getLocalWorkflows(), namespacesArray));
		}

		return converted;
	}


	private static org.cagrid.workflow.manager.descriptor.WorkflowPortionsDescriptor extractLocalWorkflows(
			WorkflowPortionsDescriptor localWorkflows, QName[] namespaces) throws MalformedURIException {

		org.cagrid.workflow.manager.descriptor.WorkflowPortionsDescriptor converted = null;


		if( localWorkflows != null ){

			converted = new org.cagrid.workflow.manager.descriptor.WorkflowPortionsDescriptor();
			converted.setLocalWorkflowDesc(extractWorkflowParts(localWorkflows.getLocalWorkflowDescArray(), namespaces));
		}

		return converted;
	}



	private static WorkflowPortionDescriptor[] extractWorkflowParts(
			org.cagrid.workflow.workflowmanagerservice.workflowManagerService.WorkflowPortionDescriptor[] workflowPartsArray, QName[] namespaces) throws MalformedURIException {

		WorkflowPortionDescriptor[] converted = null;

		if( workflowPartsArray != null ){

			converted = new WorkflowPortionDescriptor[workflowPartsArray.length];
			for( int i=0; i < workflowPartsArray.length; i++ ){

				org.cagrid.workflow.workflowmanagerservice.workflowManagerService.WorkflowPortionDescriptor currPart = workflowPartsArray[i];
				converted[i] = new WorkflowPortionDescriptor();
				converted[i].setInstanceHelperDesc(extractInstanceHelperDesc(currPart.getInstanceHelperDesc()));
				converted[i].setInvocationHelperDescs(extractInvocationHelperDescs(currPart.getInvocationHelperDescsArray(), namespaces));
				converted[i].setWorkflowHelperServiceLocation(currPart.getWorkflowHelperServiceLocation());
			}
		}

		return converted;
	}


	private static WorkflowStageDescriptor[] extractInvocationHelperDescs(
			org.cagrid.workflow.workflowmanagerservice.workflowManagerService.WorkflowStageDescriptor[] invocationHelperDescsArray, QName[] namespaces) throws MalformedURIException {

		WorkflowStageDescriptor[] converted = null;

		if( invocationHelperDescsArray != null ){

			converted = new WorkflowStageDescriptor[invocationHelperDescsArray.length];

			for(int i=0; i < invocationHelperDescsArray.length; i++){

				org.cagrid.workflow.workflowmanagerservice.workflowManagerService.WorkflowStageDescriptor currStageDesc = invocationHelperDescsArray[i];
				converted[i] = new WorkflowStageDescriptor();
				converted[i].setBasicDescription(extractBasicDescription(currStageDesc.getBasicDescription()));
				converted[i].setGlobalUniqueIdentifier(currStageDesc.getGlobalUniqueIdentifier());
				converted[i].setInputsDescription(extractInputsDescription(currStageDesc.getInputsDescription()));
				converted[i].setOutputTransportDescriptor(extractOutputTransportDescriptor(currStageDesc.getOutputTransportDescriptor(), namespaces));

			}
		}

		return converted;
	}



	private static OperationInputMessageDescriptor extractInputsDescription(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.OperationInputMessageDescriptor inputsDescription) {

		OperationInputMessageDescriptor converted = null;

		if( inputsDescription != null ){

			converted = new OperationInputMessageDescriptor();
			converted.setInputParam(extractInputParam(inputsDescription.getInputParamArray()));
		}

		return converted;
	}



	private static InputParameterDescriptor[] extractInputParam(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.InputParameterDescriptor[] inputParamArray) {

		InputParameterDescriptor[] converted = null;

		if( inputParamArray != null ){

			converted = new InputParameterDescriptor[inputParamArray.length];

			for(int i=0; i < inputParamArray.length; i++){

				org.cagrid.workflow.workflowhelperservice.workflowHelperService.InputParameterDescriptor currInputParam = inputParamArray[i];
				converted[i] = new InputParameterDescriptor();
				converted[i].setParamQName(currInputParam.getParamQName());
				converted[i].setParamType(currInputParam.getParamType());
				converted[i].setParameterIsArray(currInputParam.getParameterIsArray1());
			}
		}

		return converted ;
	}



	private static OperationOutputTransportDescriptor extractOutputTransportDescriptor(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.OperationOutputTransportDescriptor outputTransportDescriptor, QName[] namespaces) {

		OperationOutputTransportDescriptor converted = null;

		if( outputTransportDescriptor != null ){

			converted = new OperationOutputTransportDescriptor();
			converted.setParamDescriptor(extractParamDescriptor(outputTransportDescriptor.getParamDescriptorArray(), namespaces));
		}

		return converted;
	}



	private static OperationOutputParameterTransportDescriptor[] extractParamDescriptor(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.OperationOutputParameterTransportDescriptor[] paramDescriptorArray, QName[] namespaces) {

		OperationOutputParameterTransportDescriptor[] converted = null;

		if( paramDescriptorArray != null ){

			converted = new OperationOutputParameterTransportDescriptor[paramDescriptorArray.length];

			for(int i=0; i < paramDescriptorArray.length; i++){

				org.cagrid.workflow.workflowhelperservice.workflowHelperService.OperationOutputParameterTransportDescriptor currParamDesc = paramDescriptorArray[i];
				converted[i] = new OperationOutputParameterTransportDescriptor();
				converted[i].setDeliveryPolicy(extractDeliveryPolicy(currParamDesc.getDeliveryPolicy()));
				converted[i].setDestinationGlobalUniqueIdentifier(currParamDesc.getDestinationGlobalUniqueIdentifier());
				converted[i].setLocationQuery(currParamDesc.getLocationQuery());
				converted[i].setParamIndex(currParamDesc.getParamIndex());
				converted[i].setQueryNamespaces(namespaces);  //(currParamDesc.getQueryNamespacesArray());
				converted[i].setType(currParamDesc.getType());
				converted[i].setExpectedTypeIsArray(currParamDesc.getExpectedTypeIsArray1());
			}
		}


		return converted;
	}



	private static DeliveryPolicy extractDeliveryPolicy(Enum deliveryPolicy) {

		DeliveryPolicy converted = null;

		if( deliveryPolicy != null){

			int deliveryPolicyIntID = deliveryPolicy.intValue();

			switch(deliveryPolicyIntID){

			case org.cagrid.workflow.workflowhelperservice.workflowHelperService.DeliveryPolicy.INT_BROADCAST:
				converted = DeliveryPolicy.BROADCAST;
				break;

			case org.cagrid.workflow.workflowhelperservice.workflowHelperService.DeliveryPolicy.INT_DEMANDDRIVEN:
				converted = DeliveryPolicy.DEMANDDRIVEN;
				break;

			case org.cagrid.workflow.workflowhelperservice.workflowHelperService.DeliveryPolicy.INT_ROUNDROBIN:
				converted = DeliveryPolicy.ROUNDROBIN;
				break;

			default:
				logger .error("Unexpected DeliveryPolicy value: "+ deliveryPolicy.toString());
			}
		}

		return converted ;
	}



	private static WorkflowInvocationHelperDescriptor extractBasicDescription(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.WorkflowInvocationHelperDescriptor basicDescription) throws MalformedURIException {

		WorkflowInvocationHelperDescriptor converted = null;


		if( basicDescription != null ){

			converted = new WorkflowInvocationHelperDescriptor();
			converted.setOperationQName(basicDescription.getOperationQName());
			converted.setOutputType(basicDescription.getOutputType());
			converted.setOutputIsArray(basicDescription.getOutputIsArray1());
			converted.setServiceURL(basicDescription.getServiceURL());
			converted.setWorkflowID(basicDescription.getWorkflowID());
			converted.setWorkflowInvocationSecurityDescriptor(extractWorkflowInvocationSecurityDescriptor(basicDescription.getWorkflowInvocationSecurityDescriptor()));
		}


		return converted;
	}



	private static WorkflowInvocationSecurityDescriptor extractWorkflowInvocationSecurityDescriptor(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.WorkflowInvocationSecurityDescriptor wfInvSecDesc) throws MalformedURIException {

		WorkflowInvocationSecurityDescriptor converted = null;

		if(wfInvSecDesc != null){

			converted = new WorkflowInvocationSecurityDescriptor();
			converted.setSecureConversationInvocationSecurityDescriptor(extractSecureConversationInvocationSecurityDescriptor(wfInvSecDesc.getSecureConversationInvocationSecurityDescriptor()));
			converted.setSecureMessageInvocationSecurityDescriptor(extractSecureMessageInvocationSecurityDescriptor(wfInvSecDesc.getSecureMessageInvocationSecurityDescriptor()));
			converted.setTLSInvocationSecurityDescriptor(extractTLSInvocationSecurityDescriptor(wfInvSecDesc.getTLSInvocationSecurityDescriptor()));

		}

		return converted;
	}



	private static TLSInvocationSecurityDescriptor extractTLSInvocationSecurityDescriptor(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.TLSInvocationSecurityDescriptor invocationSecurityDescriptor) throws MalformedURIException {

		TLSInvocationSecurityDescriptor converted = null;

		if(invocationSecurityDescriptor != null){

			converted = new TLSInvocationSecurityDescriptor();
			converted.setAnonymousAuthenticationMethod(extractAnonymousAuthenticationMethod(invocationSecurityDescriptor.getAnonymousAuthenticationMethod()));
			converted.setCDSAuthenticationMethod(extractCDSAuthenticationMethod(invocationSecurityDescriptor.getCDSAuthenticationMethod()));
			converted.setChannelProtection(extractChannelProtection(invocationSecurityDescriptor.getChannelProtection()));
			converted.setServiceAuthenticationMethod(extractServiceAuthenticationMethod(invocationSecurityDescriptor.getServiceAuthenticationMethod()));
		}

		return converted;
	}



	private static ServiceAuthenticationMethod extractServiceAuthenticationMethod(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.ServiceAuthenticationMethod serviceAuthenticationMethod) {

		ServiceAuthenticationMethod converted = null;

		if( serviceAuthenticationMethod != null ){

			converted = new ServiceAuthenticationMethod();
		}

		return converted;
	}



	private static ChannelProtection extractChannelProtection(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.ChannelProtection.Enum channelProtection) {

		ChannelProtection converted = null;

		if( channelProtection != null ){

			switch(channelProtection.intValue()){


			case org.cagrid.workflow.workflowhelperservice.workflowHelperService.ChannelProtection.INT_INTEGRITY:
				converted = ChannelProtection.Integrity;
				break;

			case org.cagrid.workflow.workflowhelperservice.workflowHelperService.ChannelProtection.INT_PRIVACY:
				converted = ChannelProtection.Privacy;
				break;

			default:
				logger.error("Unexpected channel protection value: "+ channelProtection.toString());

			}
		}

		return converted;
	}



	private static CDSAuthenticationMethod extractCDSAuthenticationMethod(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.CDSAuthenticationMethod authenticationMethod) throws MalformedURIException {

		CDSAuthenticationMethod converted = null;

		if( authenticationMethod != null ){

			converted = new CDSAuthenticationMethod();
			converted.setProxyEPR(extractEPR(authenticationMethod.getProxyEPR()));

		}

		return converted ;
	}



	private static EndpointReferenceType extractEPR(
			org.xmlsoap.schemas.ws.x2004.x03.addressing.EndpointReferenceType proxyEPR) throws MalformedURIException {

		EndpointReferenceType converted = null;

		if( (proxyEPR != null) && (proxyEPR.getAddress() != null) ){

			AttributedURI address = proxyEPR.getAddress();
			converted = new EndpointReferenceType(new Address(address.getStringValue()));

		}

		return converted;
	}



	private static AnonymousAuthenticationMethod extractAnonymousAuthenticationMethod(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.AnonymousAuthenticationMethod anonymousAuthenticationMethod) {

		AnonymousAuthenticationMethod converted = null;

		if( anonymousAuthenticationMethod != null ){

			converted = new AnonymousAuthenticationMethod();
		}

		return converted;
	}



	private static SecureMessageInvocationSecurityDescriptor extractSecureMessageInvocationSecurityDescriptor(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.SecureMessageInvocationSecurityDescriptor secureMessageInvocationSecurityDescriptor) throws MalformedURIException {

		SecureMessageInvocationSecurityDescriptor converted = null;

		if( secureMessageInvocationSecurityDescriptor != null ){

			converted = new SecureMessageInvocationSecurityDescriptor();
			converted.setCDSAuthenticationMethod(extractCDSAuthenticationMethod(secureMessageInvocationSecurityDescriptor.getCDSAuthenticationMethod()));
			converted.setChannelProtection(extractChannelProtection(secureMessageInvocationSecurityDescriptor.getChannelProtection()));
			converted.setServiceAuthenticationMethod(extractServiceAuthenticationMethod(secureMessageInvocationSecurityDescriptor.getServiceAuthenticationMethod()));
		}

		return converted;
	}



	private static SecureConversationInvocationSecurityDescriptor extractSecureConversationInvocationSecurityDescriptor(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.SecureConversationInvocationSecurityDescriptor secureConversationInvocationSecurityDescriptor) throws MalformedURIException {

		SecureConversationInvocationSecurityDescriptor converted = null;

		if( secureConversationInvocationSecurityDescriptor != null ){

			converted = new SecureConversationInvocationSecurityDescriptor();
			converted.setAnonymousAuthenticationMethod(extractAnonymousAuthenticationMethod(secureConversationInvocationSecurityDescriptor.getAnonymousAuthenticationMethod()));
			converted.setCDSAuthenticationMethod(extractCDSAuthenticationMethod(secureConversationInvocationSecurityDescriptor.getCDSAuthenticationMethod()));
			converted.setChannelProtection(extractChannelProtection(secureConversationInvocationSecurityDescriptor.getChannelProtection()));
			converted.setNativeDelegationAuthenticationMethod(extractNativeDelegationAuthenticationMethod(secureConversationInvocationSecurityDescriptor.getNativeDelegationAuthenticationMethod()));
			converted.setServiceAuthenticationMethod(extractServiceAuthenticationMethod(secureConversationInvocationSecurityDescriptor.getServiceAuthenticationMethod()));
		}

		return converted;
	}



	private static NativeDelegationAuthenticationMethod extractNativeDelegationAuthenticationMethod(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.NativeDelegationAuthenticationMethod nativeDelegationAuthenticationMethod) {

		NativeDelegationAuthenticationMethod converted = null;

		if( nativeDelegationAuthenticationMethod != null ){

			converted = new NativeDelegationAuthenticationMethod();
		}

		return converted;
	}



	private static WorkflowInstanceHelperDescriptor extractInstanceHelperDesc(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.WorkflowInstanceHelperDescriptor instanceHelperDesc) throws MalformedURIException {

		WorkflowInstanceHelperDescriptor converted = null;

		if( instanceHelperDesc != null ){

			converted = new WorkflowInstanceHelperDescriptor();
			converted.setWorkflowID(instanceHelperDesc.getWorkflowID());
			converted.setWorkflowManagerEPR(extractEPR(instanceHelperDesc.getWorkflowManagerEPR()));
		}

		return converted;
	}



	private static WorkflowOutputTransportDescriptor extractOutputDesc(
			org.cagrid.workflow.workflowmanagerservice.workflowManagerService.WorkflowOutputTransportDescriptor outputDesc, QName[] namespaces) {

		WorkflowOutputTransportDescriptor converted = null;

		if( outputDesc != null ){

			converted = new WorkflowOutputTransportDescriptor();
			converted.setParamDescriptor(extractParamDescriptor(outputDesc.getParamDescriptorArray(), namespaces));

		}

		return converted;
	}


	private static WorkflowOutputParameterTransportDescriptor[] extractParamDescriptor(
			org.cagrid.workflow.workflowmanagerservice.workflowManagerService.WorkflowOutputParameterTransportDescriptor[] paramDescriptorArray, QName[] namespaces) {

		WorkflowOutputParameterTransportDescriptor[] converted = null;

		if( paramDescriptorArray != null ){

			converted = new WorkflowOutputParameterTransportDescriptor[paramDescriptorArray.length];

			for(int i=0; i < paramDescriptorArray.length; i++){

				org.cagrid.workflow.workflowmanagerservice.workflowManagerService.WorkflowOutputParameterTransportDescriptor currParamDesc = paramDescriptorArray[i];
				converted[i] = new WorkflowOutputParameterTransportDescriptor();
				converted[i].setParamDescription(extractParamDescription(currParamDesc.getParamDescription(), namespaces));
				converted[i].setSourceGUID(currParamDesc.getSourceGUID());


			}
		}

		return converted;
	}



	private static OperationOutputParameterTransportDescriptor extractParamDescription(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.OperationOutputParameterTransportDescriptor paramDescription, QName[] namespaces) {

		OperationOutputParameterTransportDescriptor converted = null;

		if( paramDescription != null ){

			converted = new OperationOutputParameterTransportDescriptor();
			converted.setDeliveryPolicy(extractDeliveryPolicy(paramDescription.getDeliveryPolicy()));
			converted.setDestinationGlobalUniqueIdentifier(paramDescription.getDestinationGlobalUniqueIdentifier());
			converted.setLocationQuery(paramDescription.getLocationQuery());
			converted.setParamIndex(paramDescription.getParamIndex());
			converted.setQueryNamespaces(namespaces);
			converted.setType(paramDescription.getType());
			converted.setExpectedTypeIsArray(paramDescription.getExpectedTypeIsArray1()); 
		}

		return converted;
	}



	private static WorkflowInputParameters extractInputs(
			org.cagrid.workflow.workflowmanagerservice.workflowManagerService.WorkflowInputParameters inputs) {

		WorkflowInputParameters converted = null;

		if( inputs != null ){

			converted = new WorkflowInputParameters();
			converted.setParameter(extractParameters(inputs.getParameterArray()));
		}

		return converted;
	}



	private static WorkflowInputParameter[] extractParameters(
			org.cagrid.workflow.workflowmanagerservice.workflowManagerService.WorkflowInputParameter[] parametersArray) {

		WorkflowInputParameter[] converted = null;

		if( parametersArray != null ){

			converted = new WorkflowInputParameter[parametersArray.length];

			for(int i=0; i < parametersArray.length; i++){

				org.cagrid.workflow.workflowmanagerservice.workflowManagerService.WorkflowInputParameter currInputParam = parametersArray[i];
				converted[i] = new WorkflowInputParameter();
				converted[i].setParamDescription(extractParamDescription(currInputParam.getParamDescription()));
				converted[i].setParamDestinationGUID(currInputParam.getParamDestinationGUID());

			}

		}

		return converted;
	}



	private static InputParameter extractParamDescription(
			org.cagrid.workflow.workflowhelperservice.workflowHelperService.InputParameter paramDescription) {

		InputParameter converted = null;

		if( paramDescription != null ){

			converted = new InputParameter();
			converted.setData(paramDescription.getData());
			converted.setParamIndex(paramDescription.getParamIndex());
		}

		return converted;
	}


	public static void main(String args[]){


		File testFile = new File(args[0]);
		int numBytes = (int) testFile.length();

		char[] fileBytes = null;
		try {
			FileReader testFileReader = new FileReader(testFile);
			fileBytes = new char[numBytes];
			testFileReader.read(fileBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}


		String xmlWorkflowDescription = new String(fileBytes);
		WorkflowManagerInstanceDescriptor wfDesc = null;
		try {
			wfDesc = new WorkflowDescriptorParser().parseWorkflowDescriptor(xmlWorkflowDescription);
		} catch (Exception e) {
			e.printStackTrace();
		}

		wfDesc.getInputs();
		return;
	}

}
