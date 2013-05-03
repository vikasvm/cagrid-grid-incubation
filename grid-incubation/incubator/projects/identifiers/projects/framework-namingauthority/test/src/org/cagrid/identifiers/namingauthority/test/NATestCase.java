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
package org.cagrid.identifiers.namingauthority.test;

/*
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
*/

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import junit.framework.TestCase;

public class NATestCase extends TestCase {
    private static Log log = LogFactory.getLog(NATestCase.class);

   public static void main(String[] args) {
      junit.textui.TestRunner.run(NATestCase.class);
   }
}

