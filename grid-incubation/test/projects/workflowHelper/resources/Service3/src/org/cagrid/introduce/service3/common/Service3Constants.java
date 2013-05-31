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
package org.cagrid.introduce.service3.common;

import javax.xml.namespace.QName;


public interface Service3Constants {
	public static final String SERVICE_NS = "http://service3.introduce.cagrid.org/Service3";
	public static final QName RESOURCE_KEY = new QName(SERVICE_NS, "Service3Key");
	public static final QName RESOURCE_PROPERTY_SET = new QName(SERVICE_NS, "Service3ResourceProperties");

	//Service level metadata (exposed as resouce properties)
	
}
