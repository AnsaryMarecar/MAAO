package org.secure.retirement.home.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.secure.retirement.home.common.Sensor;
import org.secure.retirement.home.service.cache.GuavaCache;
import org.secure.retirement.home.service.*;

public class ConnectionPool {

   //Initializ default value
   private int 				att_port 		 = 2345			;
   private String 			att_host 		 = "127.0.0.1"	;
   //private String 		att_host		 = "10.10.5.1"	;
   private ServerSocket 	att_server 		 = null			;
   private boolean 			att_isRunning 	 = true			;
   private ArrayList<Sensor> att_sensors 	 = null			;
   private GuavaCache 		[]att_cache;
   
   public ConnectionPool(){
	   this.setAtt_server();
	   this.setAtt_sensors(); 
   }

   /**
    * @return the att_server
    */
   public ServerSocket getAtt_server() {
	   return att_server;
   }

	/**
	 */
	public void setAtt_server() {
		try {
			this.att_server = new ServerSocket(att_port, 100, InetAddress.getByName(att_host));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @return the att_sensors
	 */
	public ArrayList<Sensor> getAtt_sensors() {
		return att_sensors;
	}

	/**
	 * @param att_sensors the att_sensors to set
	 */
	public void setAtt_sensors() {
		DAOFactory daof = JDBCConnectionPool.getConnection(); //getconnection
	    DAOSensor daosensor = new DAOSensor(daof);
	    try {
	    	this.att_sensors = daosensor.presentDataA();
	    	att_cache = GuavaCache.createAllCach(this.getAtt_sensors());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    JDBCConnectionPool.AddConnection(daof);
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
						Thread t = new Thread(new RequestHandler(client,att_sensors,att_cache));
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
   public void testFailure() {
	   
   }
   public void close(){
	   att_isRunning = false;
   }
}