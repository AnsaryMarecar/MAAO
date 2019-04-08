/**
 * 
 */
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
import java.net.SocketException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.secure.retirement.home.common.Decode;
import org.secure.retirement.home.common.Encode;
import org.secure.retirement.home.common.Type_sensor;

public class ClientProcessor implements Runnable{

   private Socket sock;
   private PrintWriter writer = null;
   private BufferedInputStream reader = null;
   
   public ClientProcessor(Socket pSock){
      sock = pSock;
   }
   
   //traitment is launched in a separate thread
public void run(){
      System.out.println("Launch client connection");
      String to_return = ""; 
      boolean closeConnection = false;
      while(!sock.isClosed()){
      try {
        	writer = new PrintWriter(sock.getOutputStream());
            reader = new BufferedInputStream(sock.getInputStream());
            
            //take the client proposition            
            String response = "";
            response = read();
            ArrayList<?> val = new ArrayList<String>(Arrays.asList(response.split(";")));
            System.out.println("val: "+val);
            ArrayList<String> vals = new ArrayList<String> (Arrays.asList(val.get(0).toString().split(",")));
            System.out.println("vals : "+vals);
            String vals1 = (String)(vals.get(0).toString().replaceAll("[^\\w]",""));
            String vals2 ="";
            try {
            	vals2 = (String)(vals.get(1).toString().replaceAll("[^\\w]",""));
            }catch(Exception e) {
            }
            if(vals1.equals("Type_sensor")) {
            	if(vals2.equals("SELECTALL")) {
            		if (!(JDBCConnectionPool.displayConnex().isEmpty())) {
            			try {
            				Thread.sleep(800);
            				System.out.println("select all");
            				DAOFactory daof = JDBCConnectionPool.getConnection();
            				DAOType_sensor element_dao = new DAOType_sensor(daof);
							ArrayList<?> elements = element_dao.presentData();
							to_return = Encode.encoder(elements);
							System.out.println("to_return client pro: "+to_return);
							closeConnection = true;
							JDBCConnectionPool.AddConnection(daof);
							
            			} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
            		}
            	}
            	else if(vals2.equals("ADD")) {
            		String type_sensors_text = (String)val.get(1).toString();
            		Type_sensor[] type_sensors = null;
            		type_sensors = Decode.decodeType_sensor(type_sensors_text);
            		if (!(JDBCConnectionPool.displayConnex().isEmpty())) {
            			try {
            				System.out.println("add");
            				DAOFactory daof = JDBCConnectionPool.getConnection();
            				DAOType_sensor element_dao = new DAOType_sensor(daof);
							if(element_dao.create(type_sensors[0])) {
								closeConnection = true;
								to_return = "true";
							}
							JDBCConnectionPool.AddConnection(daof);
            			} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
            			
            		}
            	}
            	else if(vals2.equals("UPDATE")) {
            		String type_sensors_text = (String)val.get(1).toString();
            		Type_sensor[] type_sensors = null;
            		type_sensors = Decode.decodeType_sensor(type_sensors_text);
            		if (!(JDBCConnectionPool.displayConnex().isEmpty())) {
            			try {
            				System.out.println("update");
            				DAOFactory daof = JDBCConnectionPool.getConnection();
            				DAOType_sensor element_dao = new DAOType_sensor(daof);
							if(element_dao.update(type_sensors[0])) {
								closeConnection = true;
								to_return = "true";
							}
							JDBCConnectionPool.AddConnection(daof);
            			} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
            			
            		}
            	}
            	else if(vals2.equals("DELETE")) {
            		String type_sensors_text = (String)val.get(1).toString();
            		Type_sensor[] type_sensors = null;
            		type_sensors = Decode.decodeType_sensor(type_sensors_text);
            		System.out.println("type_sensors: "+type_sensors);
            		if (!(JDBCConnectionPool.displayConnex().isEmpty())) {
            			try {
            				System.out.println("delete");
            				DAOFactory daof = JDBCConnectionPool.getConnection();
            				DAOType_sensor element_dao = new DAOType_sensor(daof);
							if(element_dao.delete(type_sensors[0].getType_sensor_id())) {
								closeConnection = true;
								to_return = "true";
							}
							JDBCConnectionPool.AddConnection(daof);
            			} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
            		}
            	}
            }
            InetSocketAddress remote = (InetSocketAddress)sock.getRemoteSocketAddress();
            
            String debug = "";
            debug = "Thread id : " + Thread.currentThread().getName() + ". ";
            debug += "ASK IP @dress : " + remote.getAddress().getHostAddress() +".";
            debug += " port : " + remote.getPort() + ".\n";
            debug += "\t -> Received on server : " + response + "\n";
            System.err.println("\n" + debug);
            
            String toSend = "";
            toSend = to_return; 
            //answer to client
            writer.write(toSend);
            writer.flush();
            
            if(closeConnection){
               System.out.println("CLOSE  ");
               writer = null;
               reader = null;
               sock.close();
               break;
            }
         }catch(SocketException e){
            System.err.println("INTERRUPTED  ");
            break;
         } catch (IOException e) {
            e.printStackTrace();
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