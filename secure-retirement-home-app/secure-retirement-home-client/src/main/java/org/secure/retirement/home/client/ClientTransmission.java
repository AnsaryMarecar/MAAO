package org.secure.retirement.home.client;

import org.secure.retirement.home.frame.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.secure.retirement.home.common.DAOConfigurationException;
import org.secure.retirement.home.common.Encode;
import org.secure.retirement.home.common.Send_information;

public class ClientTransmission {
	
	public static String FILE_PROPERTIES 	="properties"												;
	public static String PROPERTY_HOST 		="host"														;
	public static String PROPERTY_PORT		="port"														;
	
	public static void  transmission ( 		String 			param_element
										, 	String 			param_action_type
										,	ArrayList<?> 	param_data
										,	Frame 			param_frame
									) {
		
		Properties 	val_properties 	= new Properties()													;
		String 	val_host = null																			;
	    int 	val_port = 0																			;
	    Send_information val_send_information = new Send_information(param_element,param_action_type);
	    ArrayList<Send_information>val_send_info_tab = new ArrayList<Send_information>();
	    val_send_info_tab.add(val_send_information);
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
	            val_host 		= (String) val_properties.getProperty(PROPERTY_HOST)					;
	            val_port 		= Integer.parseInt(val_properties.getProperty(PROPERTY_PORT))			;
	            System.out.println("val_host: "+val_host+" val_port: "+val_port)						;
	        } 
	        catch (Exception exp) {
	            throw new DAOConfigurationException("Problem to charge : " + FILE_PROPERTIES,exp)		;
	        }
	    }
		String val_send_information_text =  Encode.to_encode(val_send_info_tab)								;
	   System.out.println("val_send_information_text: "+val_send_information_text);
		String val_data = Encode.to_encode(param_data)													;
		ArrayList<String> val_action_array = new ArrayList<String>()									;
		val_action_array.add(param_element)																;
		val_action_array.add(param_action_type)															;
		String val_action = Encode.to_encode(val_action_array)											;
		ClientConnection cc = new ClientConnection(
					val_host
				, 	val_port
				, 	val_send_information_text
				, 	val_data,param_frame
				);
		Thread t = new Thread(cc)																		;
		t.start()																						;
	}
	
	public static void main (String []args) {
		
	}
}
