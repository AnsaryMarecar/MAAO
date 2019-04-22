package org.secure.retirement.home.client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

import org.secure.retirement.home.common.Decode;
import org.secure.retirement.home.common.Type_sensor;
import org.secure.retirement.home.frame.Frame;

public class ClientConnection implements Runnable{

   private Socket 				att_connexion 	= null		;
   private PrintWriter 			att_writer 		= null		;
   private BufferedInputStream 	att_reader 		= null		;
   private String 				att_action 		= null		;
   private String 				att_data		= null		;
   private Frame 				att_frame					;
   
   public ClientConnection(String param_host, int param_port, 
		   String param_action, String param_data, Frame param_frame){
      
      try {
         att_connexion 		= new Socket(param_host, param_port);   
         this.att_action 	= param_action						;
         this.att_data 		= param_data						;
         this.att_frame 	= param_frame						;
      } catch (UnknownHostException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public void run(){
	   Thread.currentThread();
	   String response = null;
       try {
    	   att_writer = new PrintWriter(att_connexion.getOutputStream(), true)	 ;
    	   att_reader = new BufferedInputStream(att_connexion.getInputStream())  ;
    	   
    	   String commande = this.att_action+";"+this.att_data					 ;
    	   att_writer.write(commande)											 ;
           att_writer.flush()													 ;
            
           System.out.println(" " + commande + " send to the server")			 ;
            
           //Wait the answer
           try {
        	  try {
        	   response = read()												 ;
        	   System.out.println(" answer received: " + response)				 ;
        	  }catch(Exception ex1) {
        		  System.out.println("ex1: "+ex1.getMessage());
        	  }
        	  
        	  Type_sensor[] type_sensor_tab1 =  Decode.decodeType_sensor(response);
        	  if( type_sensor_tab1[0].getType_sensor_id() ==-1 ){
            		att_frame.getOptionpane()									  ;
					// same value is existing
            		att_frame.getOptionpane().showMessageDialog(att_frame, 
            				"You can't have more than one value at a time",
           		         " SECURE RETIREMENT HOMME WARNING ",
           		         JOptionPane.WARNING_MESSAGE)							  ;
            	}
            	else if( type_sensor_tab1[0].getType_sensor_id() ==-2){
            		att_frame.getOptionpane();
					// data does no exist
            		att_frame.getOptionpane().showMessageDialog(att_frame, 
            				"Sorry, but the data chosen does not exist anymore",
              		         " SECURE RETIREMENT HOMME WARNING ",
              		         JOptionPane.WARNING_MESSAGE)						;
            	}
            	else if( type_sensor_tab1[0].getType_sensor_id() ==-3){
            		att_frame.getOptionpane();
					// number of connected is limited, please try later
           
            		att_frame.getOptionpane().showMessageDialog(att_frame, 
            				"The number connection is limited, please try later",
              		         " SECURE RETIREMENT HOMME WARNING ",
              		         JOptionPane.WARNING_MESSAGE)						;
            	}
            	else if( type_sensor_tab1[0].getType_sensor_id() ==-4){
            		// your request was realized succesfully
            		System.out.println("your request was realised successfully");
            		att_frame.getOptionpane().showMessageDialog(att_frame, 
           		      "The traitment was realized succesfully",
           		      " SECURE RETIREMENT HOMME INFORMATION MESSAGE ",
           		      JOptionPane.INFORMATION_MESSAGE)							;
            	}
            	else{
            		// init table
            		System.out.println("initialise table")						;
            		att_frame.initialise_table(Decode.decodeType_sensor(response)); 
            	}
            
            	
            }catch(Exception e) {
            	System.out.println("\t * " + "error" + " : problem with answer "+e.getMessage());
            } 
       } catch (IOException e) {
            e.printStackTrace();
       }
       
       att_writer.write("CLOSE");
       att_writer.flush()		;
       att_writer.close()		;
   }
   
   /**
    * <p>Read answer</p>
    * @return String
    * @throws IOException
    */
   private String read() throws IOException{      
      String response = ""								;
      int stream										;
      byte[] b = new byte[4096]							;
      stream = att_reader.read(b)						;
      response = new String(b, 0, stream)				;  
      return response									;
      
   }   
}