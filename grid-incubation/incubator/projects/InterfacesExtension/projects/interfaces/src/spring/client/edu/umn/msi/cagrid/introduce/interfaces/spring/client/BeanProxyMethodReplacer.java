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
package edu.umn.msi.cagrid.introduce.interfaces.spring.client;

import org.springframework.beans.factory.support.MethodReplacer;

public interface BeanProxyMethodReplacer extends MethodReplacer {
  public void setBeanProxyInfo(BeanProxyInfo beanProxyInfo);
}
