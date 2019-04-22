package org.secure.retirement.home.common;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Ansary MARECAR
 *
 */
public class Decode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			decodeType_sensor("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Type_sensor[] decodeType_sensor(String param_todecode) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Type_sensor[] type_sensor = null;
		try {
			String text = param_todecode;
		    if(text!=null) {
		    	type_sensor = objectMapper.readValue(text, Type_sensor [] .class );
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return type_sensor;
	}
}