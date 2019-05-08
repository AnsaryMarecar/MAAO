/**
 * 
 */
package org.secure.retirement.home.service;

import java.util.ArrayList;

import org.secure.retirement.home.common.Decode;
import org.secure.retirement.home.common.Historic;
import org.secure.retirement.home.common.Return_information;
import org.secure.retirement.home.common.Room;
import org.secure.retirement.home.common.Send_information;
import org.secure.retirement.home.common.Type_sensor;
import org.secure.retirement.home.service.simulation.DAOHistoric;

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
	
	public static ArrayList<?> Actions( ArrayList<?> elements,DAOFactory daof, Send_information[] val_send_information, ArrayList<?> val_jsontext ) {
		
		
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
			  			Return_information val_message = element_dao.create(history[0]);
			  			ArrayList<Return_information> test = new ArrayList<Return_information>();
			  			test.add(val_message);
			  			elements = test;
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
		
		return elements;
	}
}