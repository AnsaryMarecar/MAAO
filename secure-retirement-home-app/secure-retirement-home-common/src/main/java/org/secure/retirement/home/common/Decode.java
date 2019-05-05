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
		/**try {
			to_decode("","Send_information");
		} catch (IOException e) {
			e.printStackTrace();
		}**/
	}
	
	public static Object[] to_decode(String param_todecode, String param_class)throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Object[] val_object = null;
		if(param_todecode!=null) {
			switch(param_class) {
			  case "Return_information":
				  val_object = objectMapper.readValue(param_todecode, Return_information[].class);
				 break;
			  case "Send_information":
				  val_object = objectMapper.readValue(param_todecode, Send_information[].class);
				 break;
			  case "Type_sensor":
				  val_object = objectMapper.readValue(param_todecode, Type_sensor[].class);
			    break;
			  case "Sensor":
			    // code block
			    break;
			  case "Historic":
				  	val_object = objectMapper.readValue(param_todecode, Historic[].class);
				    break;
			  case "Failure":
				    // code block
				    break;
			  case "Level_risq":
				  val_object = objectMapper.readValue(param_todecode, Level_risq[].class);
				    break;
			  case "Room":
				  val_object = objectMapper.readValue(param_todecode, Room[].class);
				    break;
				    
			  default:
			    // code block
			}
		}
		return val_object;
	}
}