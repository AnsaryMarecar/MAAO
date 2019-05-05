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
		String string = "[10/12.0]";
		string.replace("[","").replace("]","");
		
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
			  case "Room":
				  val_object = objectMapper.readValue(param_todecode, Room[].class);
				    break;
			  case "Historic":
				    val_object = to_decodeHistoric(param_todecode);
				  break;
			  case "Failure":
				    // code block
				    break;
			  case "Level_risq":
				  	val_object = objectMapper.readValue(param_todecode, Level_risq[].class);
				    break;
			  default:
			    // code block
			}
		}
		return val_object;
	}
	
	public static Object[] to_decodeHistoric(String param_todecode)throws IOException {
		System.out.println("param_todecode: "+param_todecode+" Historic 1");
	    param_todecode = param_todecode.replace("[","");
	    
	    System.out.println("param_todecode: "+param_todecode+" Historic 2");
	    param_todecode = param_todecode.replace("]","");
	    System.out.println("param_todecode: "+param_todecode+" Historic 3");
	    param_todecode = param_todecode.replaceAll("\"","");
	    System.out.println("param_todecode: "+param_todecode+" Historic 4");
	    String[] parts = param_todecode.split("/");
	    System.out.println("parts: "+parts+" Historic 5");
	    int val_iter = 0;
	    System.out.println("parts.length: "+parts.length+" Historic 5");
	    int val_length = parts.length/2;
	    Historic []historic_tab = new Historic [val_length];
	    for(int i = 0; i<parts.length; i=i+2) {
	    	System.out.println("parts: "+parts[i+1]+" Historic while:"+i);
	    	
	    	Historic historic = new Historic(
	    			new Sensor(Integer.parseInt(parts[i]))
	    			,Double.parseDouble(parts[i+1])
	    			);
	    	historic_tab[val_iter]= historic;
	    }
	    return historic_tab;
	}
}