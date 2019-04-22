package org.secure.retirement.home.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectionPool {

   //Initializ default value
   private int 			att_port 		= 2345;
   private String 		att_host 		= "127.0.0.1";
   private ServerSocket att_server 		= null;
   private boolean 		att_isRunning 	= true;
   
   public ConnectionPool(){
      try {
    	  att_server = new ServerSocket(att_port, 100, InetAddress.getByName(att_host));
      } catch (UnknownHostException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public ConnectionPool(String param_host, int param_port){
	   att_host = param_host;
	   att_port = param_port;
      try {
    	  att_server = new ServerSocket(att_port, 100, InetAddress.getByName(att_host));
      } catch (UnknownHostException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   
   //Launch server
   public void open(){
      Thread t = new Thread(new Runnable(){
         public void run(){
           while(att_isRunning == true){
               
               try {
                  //wait a connection
                  Socket client = att_server.accept();
                  //treatment of it in a separated thread
                  System.out.println("Client conection received");                  
                  Thread t = new Thread(new RequestHandler(client));
                  t.start();
                  
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }
            
            try {
            	att_server.close();
            } catch (IOException e) {
               e.printStackTrace();
               att_server = null;
            }
         }
      });
      
      t.start();
   }
   
   public void close(){
	   att_isRunning = false;
   }   
}