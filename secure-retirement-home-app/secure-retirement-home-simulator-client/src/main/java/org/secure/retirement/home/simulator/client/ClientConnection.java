/**
 * 
 */
package org.secure.retirement.home.simulator.client;

/**
 * @author Ansary MARECAR
 *
 */

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

import org.secure.retirement.home.common.Decode;
import org.secure.retirement.home.simulator.frame.*;

public class ClientConnection implements Runnable{

   private Socket 				att_connexion 	= null		;
   private PrintWriter 			att_writer 		= null		;
   private BufferedInputStream 	att_reader 		= null		;
   private String 				att_action 		= null		;
   private String 				att_data		= null		;
   private FrameSimulator 		att_frame					;
   
   public ClientConnection(String param_host, int param_port, 
		   String param_action, String param_data, FrameSimulator param_frame){
      
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
       String val_message = null;
       String val_title = null;
       String commande = this.att_action+";"+this.att_data					 ;
	   System.out.println("commande: "+commande);
	   try {
		   System.out.println("clientco>run>try ");
    	   att_writer = new PrintWriter(att_connexion.getOutputStream(), true)	 ;
    	   att_reader = new BufferedInputStream(att_connexion.getInputStream())  ;
    	   
    	  
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
        	  
        	  
        	  Object[] val_object =  Decode.to_decode(response, "Type_sensor");
        	  //att_frame.getOptionpane().showMessageDialog(att_frame, 
        	  //val_message,
     		  //       " SECURE RETIREMENT HOMME "+val_title,
     		  //       JOptionPane.WARNING_MESSAGE)							  ;
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
      String 	response = ""								;
      int 		stream										;
      byte[] 	b = new byte[4096]							;
      stream 	= att_reader.read(b)						;
      response 	= new String(b, 0, stream)					;  
      return response										;
      
   }  
   
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
