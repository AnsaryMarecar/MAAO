package org.secure.retirement.home.common;

import java.io.IOException;
import java.util.ArrayList;

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
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Type_sensor> element = new ArrayList<Type_sensor>();
		element.add(new Type_sensor(10,"ee"));
		element.add(new Type_sensor(11,"ee"));
		to_encode(element);
	}
	*/
	public static String to_encode(ArrayList<?> param_data) {
		String json = null;
		ObjectMapper objectMapper = new ObjectMapper ();
		try {
			json = objectMapper.writeValueAsString(param_data);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

}
