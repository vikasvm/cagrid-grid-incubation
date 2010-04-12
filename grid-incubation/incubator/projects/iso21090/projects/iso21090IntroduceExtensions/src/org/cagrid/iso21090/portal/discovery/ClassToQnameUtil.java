package org.cagrid.iso21090.portal.discovery;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.xml.bind.annotation.XmlRootElement;

public class ClassToQnameUtil {

    private List<File> libFiles = null;

    public ClassToQnameUtil(List<File> libFiles) {
        this.libFiles = libFiles;
    }
    
    
    public String getJavaClassName(String packageName, String xmlElementName) throws IOException, ClassNotFoundException {
        Set<Class<?>> classesInPackage = getClassesInPackage(packageName);
        for (Class<?> clazz : classesInPackage) {
            XmlRootElement rootElement = clazz.getAnnotation(XmlRootElement.class);
            if (rootElement != null) {
                String boundElemName = rootElement.name();
                if (xmlElementName.equals(boundElemName)) {
                    // found the class we want
                    return clazz.getName();
                }
            }
        }
        return null;
    }
    
    
    private Set<Class<?>> getClassesInPackage(String packageName) throws IOException, ClassNotFoundException {
        String slashifiedPackage = packageName.replace('.', File.separatorChar);
        ClassLoader libClassLoader = getLibClassLoader();
        Set<Class<?>> classes = new HashSet<Class<?>>();
        for (File f : libFiles) {
            JarFile jar = new JarFile(f);
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (!entry.isDirectory() && entry.getName().endsWith(".class") 
                    && entry.getName().startsWith(slashifiedPackage)) {
                    String dotifiedClassname = entry.getName().replace(File.separatorChar, '.');
                    String cleanClassname = dotifiedClassname.substring(0, dotifiedClassname.length() - 6);
                    Class<?> clazz = libClassLoader.loadClass(cleanClassname);
                    classes.add(clazz);
                }
            }
            jar.close();
        }
        return classes;
    }
    
    
    private ClassLoader getLibClassLoader() throws MalformedURLException {
        URL[] urls = new URL[libFiles.size()];
        for (int i = 0; i < libFiles.size(); i++) {
            urls[i] = libFiles.get(i).toURI().toURL();
        }
        ClassLoader loader = new URLClassLoader(urls, getClass().getClassLoader());
        return loader;
    }
}
