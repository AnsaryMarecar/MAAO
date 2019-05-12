package org.secure.retirement.home.common.transmission.json;

import java.io.IOException;

import org.secure.retirement.home.common.Historic;
import org.secure.retirement.home.common.Room;
import org.secure.retirement.home.common.Sensor;
import org.secure.retirement.home.common.Type_sensor;
import org.secure.retirement.home.common.transmission.information.Return_information;
import org.secure.retirement.home.common.transmission.information.Send_information;

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
				  val_object = objectMapper.readValue(param_todecode, Sensor[].class);
			    break;
			  case "Room":
				  val_object = objectMapper.readValue(param_todecode, Room[].class);
				    break;
			  case "Historic":
				    val_object = to_decodeHistoric(param_todecode);
				  break;
			  case "Failure":
				    // code block
				    break;
			  default:
			    // code block
			}
		}
		return val_object;
	}
	
	public static Object[] to_decodeHistoric(String param_todecode)throws IOException {
	    param_todecode = param_todecode.replace("[","");
	    param_todecode = param_todecode.replace("]","");
	    param_todecode = param_todecode.replaceAll("\"","");
	    String[] parts = param_todecode.split("/");
	    int val_iter = 0;
	    int val_length = parts.length/2;
	    Historic []historic_tab = new Historic [val_length];
	    for(int i = 0; i<parts.length; i=i+2) {
	    	Historic historic = new Historic(
	    			new Sensor(Integer.parseInt(parts[i]))
	    			,Double.parseDouble(parts[i+1])
	    			);
	    	historic_tab[val_iter]= historic;
	    }
	    return historic_tab;
	}
}