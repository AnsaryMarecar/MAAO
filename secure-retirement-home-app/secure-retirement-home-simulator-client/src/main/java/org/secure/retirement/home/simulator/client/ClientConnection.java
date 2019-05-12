/**
 * 
 */
package org.secure.retirement.home.simulator.client;

/**
 * @author Ansary MARECAR
 *
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.secure.retirement.home.simulator.frame.*;

public class ClientConnection implements Runnable{

   private Socket 				att_connexion 	= null		;
   private PrintWriter 			att_writer 		= null		;
   private String 				att_action 		= null		;
   private String 				att_data		= null		;
   
   public ClientConnection(String param_host, int param_port, 
		   String param_action, String param_data, FrameSimulator param_frame){
      
      try {
         att_connexion 		= new Socket(param_host, param_port);   
         this.att_action 	= param_action						;
         this.att_data 		= param_data						;
      } catch (UnknownHostException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public void run(){
	   
	   Thread.currentThread();
       String commande = this.att_action+";"+this.att_data;
	   System.out.println("commande: "+commande);
	   try {
		   System.out.println("clientco>run>try ");
    	   att_writer = new PrintWriter(att_connexion.getOutputStream(), true)	 ;
    	   att_writer.write(commande)											 ;
           att_writer.flush()													 ;
           System.out.println(" " + commande + " send to the server")			 ;
       } catch (IOException e) {
            e.printStackTrace();
       }
   }
   
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
