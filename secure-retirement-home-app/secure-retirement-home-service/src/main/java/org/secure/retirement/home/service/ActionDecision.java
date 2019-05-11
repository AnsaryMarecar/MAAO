/**
 * 
 */
package org.secure.retirement.home.service;

import java.util.ArrayList;

import org.secure.retirement.home.common.Decode;
import org.secure.retirement.home.common.Historic;
import org.secure.retirement.home.common.Return_information;
import org.secure.retirement.home.common.Risk;
import org.secure.retirement.home.common.Room;
import org.secure.retirement.home.common.Send_information;
import org.secure.retirement.home.common.Sensor;
import org.secure.retirement.home.common.Type_sensor;
import org.secure.retirement.home.service.cache.GuavaCache;
import org.secure.retirement.home.service.simulation.DAOHistoric;
import org.secure.retirement.home.service.simulation.DAORisk;

/**
 * @author Ansary MARECAR
 *
 */
public class ActionDecision {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ArrayList<?> Actions( ArrayList<?> elements,DAOFactory daof, Send_information[] val_send_information, ArrayList<?> val_jsontext,  ArrayList<Sensor> param_sensors, GuavaCache []param_cache) {
		
		
		if(val_send_information[0].getSend_information_table().toString().equals("Type_sensor")) {
			DAOType_sensor element_dao;   
			try {
				element_dao = new DAOType_sensor(daof);
				Type_sensor[] type_sensors = null;
				  try {
			  		type_sensors = (Type_sensor[]) Decode.to_decode(val_jsontext.get(1).toString(), "Type_sensor");
				  }catch(Exception e) {
					  System.out.println(val_send_information[0].getSend_information_crud_action().toString()+" e: "+e.getLocalizedMessage());
				  }
			      if(val_send_information[0].getSend_information_crud_action().toString().equals("SELECT ALL")) {	
			  			//Select All
			  			try {
			  				Thread.sleep(500);
			  				elements = element_dao.presentData();
			  			}catch (Exception e) {
			  				e.printStackTrace();
			  			}
			  	   }
			  	   else if(val_send_information[0].getSend_information_crud_action().toString().equals("ADD")) {
			  		   	//Add
			  		   	Return_information val_message = element_dao.create(type_sensors[0]);
			  		   	ArrayList<Return_information> val_return_info = new ArrayList<Return_information>();
			  			val_return_info.add(val_message);
			  			elements = val_return_info;
			  	   }
			  } catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			  }
		  }
		else if(val_send_information[0].getSend_information_table().toString().equals("Historic")) {
			  DAOHistoric element_dao;   
			  try {
				  element_dao = new DAOHistoric(daof);
				  Historic[] history = null;
				  try {
			  		history = (Historic[]) Decode.to_decode(val_jsontext.get(1).toString(), "Historic");
				  }catch(Exception e) {
					  System.out.println(val_send_information[0].getSend_information_crud_action().toString()+" e: "+e.getLocalizedMessage());
				  }
			      if(val_send_information[0].getSend_information_crud_action().toString().equals("SELECT ALL")) {	
			  			System.out.println("RequestHandler>select all");
			  			try {
			  				Thread.sleep(500);
			  				elements = element_dao.presentData();
			  			}catch (Exception e) {
			  				e.printStackTrace();
			  			}
			  	   }
			  	   else if(val_send_information[0].getSend_information_crud_action().toString().equals("ADD")) {
			  			System.out.println("RequestHandler>add");
			  			String val_message_add = element_dao.add(history[0]);
			  			System.out.println("val_message_add: "+val_message_add);
			  			history[0].setHistoric_id(Integer.parseInt(val_message_add));
			  			ArrayList<Return_information> return_info_array = new ArrayList<Return_information>();
			  			
			  			//return_info_array.add(val_message_add);
			  			elements = return_info_array;
			  			
			  			boolean val_bool = false;
			  			int i = -1;
			  			System.out.println("actiondecision>historic>add>1");
			  			for(i = 0 ; i < param_sensors.size() && !val_bool; i++) {
			  				System.out.println("actiondecision>historic>add>for>i:"+i);
			  				if(history[0].getSensor().getSensor_id() == param_sensors.get(i).getSensor_id()) {
			  					val_bool = true;
			  				}
			  			}
			  			System.out.println("actiondecision>historic>add>2");
			  			if(val_bool) {
			  				System.out.println("actiondecision>historic>add>3");
			  				if(param_cache[i].edition(history[0])) {
			  					Risk val_risk = new Risk(history[0].getSensor(),history[0]);
				  				DAORisk daorisk = new DAORisk(daof);
				  				daorisk.create(val_risk);
			  				}
			  			}
			  			System.out.println("actiondecision>historic>add>4");
			  	   }
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  }
		  else if(val_send_information[0].getSend_information_table().toString().equals("Room")) {
			DAORoom element_dao;   
			try {
				element_dao = new DAORoom(daof);
				Room[] rooms= null;
				  try {
			  		rooms = (Room[]) Decode.to_decode(val_jsontext.get(1).toString(), "Room");
				  }catch(Exception e) {
					  System.out.println(val_send_information[0].getSend_information_crud_action().toString()+" e: "+e.getLocalizedMessage());
				  }
			      if(val_send_information[0].getSend_information_crud_action().toString().equals("SELECT ALL")) {	
			  			//Select All
			  			try {
			  				Thread.sleep(500);
			  				elements = element_dao.presentData();
			  			}catch (Exception e) {
			  				e.printStackTrace();
			  			}
			  	   }
			  	   else if(val_send_information[0].getSend_information_crud_action().toString().equals("ADD")) {
			  		   	//Add
			  		   	Return_information val_message = element_dao.create(rooms[0]);
			  		   	ArrayList<Return_information> val_return_info = new ArrayList<Return_information>();
			  			val_return_info.add(val_message);
			  			elements = val_return_info;
			  	   }
			  } catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			  }
		  }
		  else if(val_send_information[0].getSend_information_table().toString().equals("Sensor")) {
			  DAOSensor element_dao;   
			  try {
				  element_dao = new DAOSensor(daof);
				  Sensor[] sensors = null;
				  try {
			  		sensors = (Sensor[]) Decode.to_decode(val_jsontext.get(1).toString(), "Sensor");
				  }catch(Exception e) {
					  System.out.println(val_send_information[0].getSend_information_crud_action().toString()+" e: "+e.getLocalizedMessage());
				  }
			      if(val_send_information[0].getSend_information_crud_action().toString().equals("SELECT ALL")) {	
			  			System.out.println("RequestHandler>select all");
			  			try {
			  				Thread.sleep(500);
			  				elements = element_dao.presentData();
			  			}catch (Exception e) {
			  				e.printStackTrace();
			  			}
			  	   }
			  	   else if(val_send_information[0].getSend_information_crud_action().toString().equals("ADD")) {
			  			System.out.println("RequestHandler>add");
			  			Return_information val_message = element_dao.create(sensors[0]);
			  			ArrayList<Return_information> test = new ArrayList<Return_information>();
			  			test.add(val_message);
			  			elements = test;
			  	   }
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  }
		
		return elements;
	}
}