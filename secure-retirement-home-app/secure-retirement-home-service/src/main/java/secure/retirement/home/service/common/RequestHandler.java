package secure.retirement.home.service.common;

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

import org.secure.retirement.home.common.transmission.information.Send_information;
import org.secure.retirement.home.common.transmission.json.Decode;
import org.secure.retirement.home.common.transmission.json.Encode;

public class RequestHandler implements Runnable{

   private Socket 				sock		 ;
   private PrintWriter 			writer = null;
   private BufferedInputStream 	reader = null;
   
   public RequestHandler(Socket param_sock){
      sock = param_sock;
   }
   
   //traitment is launched in a separate thread
   public void run(){
      String to_return = ""; 
      boolean closeConnection = false;
      ArrayList<?> elements = new ArrayList<Object>();
      while(!sock.isClosed()){
    	  if (!(JDBCConnectionPool.displayConnex().isEmpty())) {
	    	  try {
	    		  DAOFactory daof = JDBCConnectionPool.getConnection(); //getconnection
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
	    		  //System.out.println(debug);
	    		  ArrayList<?> val_jsontext = new ArrayList<String>(Arrays.asList(response.split(";")));
	    		  Send_information[] val_send_information = (Send_information[]) Decode.to_decode(val_jsontext.get(0).toString(), "Send_information");
	    		  
	    		  elements = ActionDecision.Actions( elements,daof, val_send_information,val_jsontext);
	    		  
	    		  to_return = Encode.to_encode(elements);
	    		  closeConnection = true;
	              String toSend = "";
	              toSend = to_return; 
	              JDBCConnectionPool.AddConnection(daof);
	              //answer to client
	              writer.write(toSend);
	              writer.flush();
	               
	              if(closeConnection){
	            	  //System.out.println(val_send_information[0].getSend_information_crud_action().toString()+" : RequesHandler>CLOSE  ");
	                  writer = null;
	                  reader = null;
	                  sock.close();
	                  break;
	              }
	    	  }
	    	  catch(Exception e) {
	    		  //System.out.println("RequestHandler>Catch>e: "+e.getMessage());
	    	  }
	    	  
	      }
    	  else {
	    	  //System.out.println("RequestHandler>else");
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