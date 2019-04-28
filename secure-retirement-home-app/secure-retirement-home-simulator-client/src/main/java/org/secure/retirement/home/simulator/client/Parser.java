/**
 * 
 */
package org.secure.retirement.home.simulator.client;

import java.io.InputStream;
import java.util.Properties;

import org.secure.retirement.home.common.DAOConfigurationException;

/**
 * @author Ansary MARECAR
 *
 */
public class Parser {
	
	public static void to_parse() {
		String FILE_PROPERTIES = ""; 
		Properties 	val_properties 	= new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    InputStream fileProperties = classLoader.getResourceAsStream(FILE_PROPERTIES)					; 
	    
	    if (fileProperties == null) {
        	System.out.println(FILE_PROPERTIES + " is not found.")										;
            throw new DAOConfigurationException("the file:  " + FILE_PROPERTIES + " does not exist.")	;
        }
	    else {
	        //attribute value
	        try {
	            val_properties.load(fileProperties)														;
	        } 
	        catch (Exception exp) {
	            throw new DAOConfigurationException("Problem to charge : " + FILE_PROPERTIES,exp)		;
	        }
	    }
	}
}
