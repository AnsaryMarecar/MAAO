/**
 * 
 */
package org.secure.retirement.home.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharStreams;

/**
 * @author Ansary MARECAR
 *
 */
public class Decode {

	/**
	 * @param args
	 */
	
	
	
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		///try {
			//decode();
		//} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	//}
	
	public static Type_sensor[] decodeType_sensor(String param_todecode) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Type_sensor[] type_sensor = null;
		//InputStream input;
		
		try {
		//	input = new FileInputStream("output.json");
			String text = null;
		    //try (final Reader reader = new InputStreamReader(input)) {
		        text = param_todecode;
		    //}
			//try {
		        
		    if(text!=null) {
		    	type_sensor = objectMapper.readValue(text, Type_sensor [] .class );
		    }
		        
			    //for(int i=0; i<type_sensor.length;i++) {
			    //System.out.println("decode id = " + type_sensor[i].getType_sensor_id());
			    //System.out.println("decode name = " + type_sensor[i].getType_sensor_name());
			    //}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		//}
	    
		
		return type_sensor;
	}
	
	

}
