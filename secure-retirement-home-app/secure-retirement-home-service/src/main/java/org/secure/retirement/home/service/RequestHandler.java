package org.secure.retirement.home.service;

/**
 * @author Ansary MARECAR
 *
 */
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import org.secure.retirement.home.common.Decode;
import org.secure.retirement.home.common.Encode;
import org.secure.retirement.home.common.Historic;
import org.secure.retirement.home.common.Return_information;
import org.secure.retirement.home.common.Send_information;
import org.secure.retirement.home.common.Type_sensor;
import org.secure.retirement.home.service.simulation.DAOHistoric;

public class RequestHandler implements Runnable{

   private Socket sock;
   private PrintWriter writer = null;
   private BufferedInputStream reader = null;
   
   public RequestHandler(Socket pSock){
      sock = pSock;
   }
   
   //traitment is launched in a separate thread
   public void run(){
      String to_return = ""; 
      boolean closeConnection = false;
      ArrayList<?> elements = new ArrayList<Object>();
      System.out.println("requesthandler>before jdbc is empty");
      while(!sock.isClosed()){
    	  if (!(JDBCConnectionPool.displayConnex().isEmpty())) {
    		  System.out.println("requesthandler>connection isnotempty");
    		  
    		  System.out.println("requesthandler>before try");
	    	  try {
	    		  DAOFactory daof = JDBCConnectionPool.getConnection(); //getconnection
	    		  System.out.println("requesthandler>on try");
	    		  
	    		  writer = new PrintWriter(sock.getOutputStream());
	    		  reader = new BufferedInputStream(sock.getInputStream());
	    		  String response = "";
	    		  response = read();
	    		  InetSocketAddress remote = (InetSocketAddress)sock.getRemoteSocketAddress();
	    		  String debug = "";
	              debug = "Thread id : " + Thread.currentThread().getName() + ". ";
	              debug += "ASK IP @dress : " + remote.getAddress().getHostAddress() +".";
	              debug += " port : " + remote.getPort() + ".\n";
	              debug += "\t -> Received on server : " + response + "\n";
	    		  System.out.println(debug);
	              //TODO REVOIR ENTIEREMENT CETTE PARTIE 
	    		  ArrayList<?> val_jsontext = new ArrayList<String>(Arrays.asList(response.split(";")));
	    		  System.out.println("val_jsontext: "+val_jsontext.toString());
	    		  Send_information[] val_send_information = (Send_information[]) Decode.to_decode(val_jsontext.get(0).toString(), "Send_information");

	    		  elements = ActionDecision.Actions( elements,daof, val_send_information,val_jsontext );
	    		  
	    		  to_return = Encode.to_encode(elements);
	    		  closeConnection = true;
	              String toSend = "";
	              toSend = to_return; 
	              JDBCConnectionPool.AddConnection(daof);
	              //answer to client
	              writer.write(toSend);
	              writer.flush();
	               
	              if(closeConnection){
	            	  System.out.println(val_send_information[0].getSend_information_crud_action().toString()+" : RequesHandler>CLOSE  ");
	                  writer = null;
	                  reader = null;
	                  sock.close();
	                  break;
	              }
	    	  }
	    	  catch(Exception e) {
	    		  System.out.println("RequestHandler>Catch>e: "+e.getMessage());
	    	  }
	    	  
	      }
    	  else {
	    	  System.out.println("RequestHandler>else");
	      }
      }
   }
   
   /**
    * 
    * @return
    * @throws IOException
    */
   private String read() throws IOException{      
      String response = "";
      int stream;
      byte[] b = new byte[4096];
      stream = reader.read(b);
      response = new String(b, 0, stream);
      return response;
   }
   
}