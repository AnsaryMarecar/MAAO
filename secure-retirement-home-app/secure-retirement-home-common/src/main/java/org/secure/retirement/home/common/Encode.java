/**
 * 
 */
package org.secure.retirement.home.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Ansary MARECAR
 *
 */
public class Encode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Type_sensor> element = new ArrayList<Type_sensor>();
		element.add(new Type_sensor(10,"ee"));
		element.add(new Type_sensor(11,"ee"));
		encoder(element);
	}
	
	public static String encoder(ArrayList<?> data) {
		File file = null;
		String json = null;
		ObjectMapper objectMapper = new ObjectMapper ();
		try {
			//objectMapper.writeValue (
			//new FileOutputStream ("output.json"), data);
		

			json = objectMapper.writeValueAsString(data);
			
			
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

}
