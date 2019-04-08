package org.secure.retirement.home.client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

import javax.swing.JFrame;

import org.secure.retirement.home.common.Decode;
import org.secure.retirement.home.frame.Frame;
import org.secure.retirement.home.frame.FrameType_sensor;

public class ClientConnexion implements Runnable{

   private Socket 				att_connexion 	= null		;
   private PrintWriter 			att_writer 		= null		;
   private BufferedInputStream 	reader 			= null		;
   private String 				att_action 		= null		;
   private String 				att_data		= null		;
   private Frame 				att_frame					;
   private static int 			att_count 		= 0			;
   private String 				att_name 		= "Client-"	;   
   
   public ClientConnexion(String param_host, int param_port, 
		   String param_action, String param_data, Frame param_frame){
      
	  att_name += ++att_count;
      System.out.println("name : "+att_name);
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
            att_writer = new PrintWriter(att_connexion.getOutputStream(), true)	;
            reader = new BufferedInputStream(att_connexion.getInputStream())	;
            
            String commande = this.att_action+";"+this.att_data	;
            att_writer.write(commande)							;
            att_writer.flush()									;  
            
            System.out.println(" " + commande + " send to the server");
            
            //Wait the answer
            try {
            	response = read()															;
            	System.out.println("\t * " + att_name + " : answer received " + response)	;
            	/**
            	if(response == 1){
            		// same value is existing
            	}
            	else if (response == "2"){
            		// data does no exist
            	}
            	else if (response == "3"){
            		// number of connected is limited, please try later
            	}
            	else if(response == "4"){
            		// your request was realized succesfully
            	}
            	else{
            		// init table
            	}
            	**/
            	att_frame.initialise_table(Decode.decodeType_sensor(response))				; 
            }catch(Exception e) {
            	System.out.println("\t * " + "error" + " : problem with answer " )			;
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
      stream = reader.read(b)							;
      response = new String(b, 0, stream)				;      
      System.out.println("client connect : "+response)	;
      return response									;
      
   }   
}