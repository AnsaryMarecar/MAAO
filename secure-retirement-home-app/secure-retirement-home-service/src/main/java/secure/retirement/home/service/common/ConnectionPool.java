package secure.retirement.home.service.common;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.secure.retirement.home.common.Sensor;
import org.secure.retirement.home.service.DAOSensor;
import org.secure.retirement.home.service.cache.GuavaCache;
import org.secure.retirement.home.service.simulation.SimulateFailure;

public class ConnectionPool {

   //Initializ default value
   private int 				att_port 		 = 2345			;
   private String 			att_host 		 = "127.0.0.1"	;
   //private String 		att_host		 = "10.10.5.1"	;
   private ServerSocket 	att_server 		 = null			;
   private boolean 			att_isRunning 	 = true			;
   private static ArrayList<Sensor> att_sensors 	 = null			;
   private static GuavaCache 		[]att_cache;
   
   public ConnectionPool(){
	   this.setAtt_server();
	   setAtt_sensors();
	   this.testFailure();
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
	public static ArrayList<Sensor> getAtt_sensors() {
		return att_sensors;
	}


	
	/**
	 * @return the att_cache
	 */
	public static final GuavaCache[] getAtt_cache() {
		return att_cache;
	}

	/**
	 * @param param_cache the att_cache to set
	 */
	public static final void setAtt_cache(GuavaCache[] param_cache) {
		ConnectionPool.att_cache = param_cache;
	}

	/**
	 * @param att_sensors the att_sensors to set
	 */
	public static void setAtt_sensors() {
		DAOFactory daof = JDBCConnectionPool.getConnection(); //getconnection
	    DAOSensor daosensor = new DAOSensor(daof);
	    try {
	    	att_sensors = daosensor.presentData();
	    	att_cache = GuavaCache.createAllCach(getAtt_sensors());
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
   public void testFailure() {
	   SimulateFailure t = new SimulateFailure("Simulate Failure");
	    //TestThread t2 = new TestThread("  B");
	    t.start();
	    //t2.start();
   }
   public void close(){
	   att_isRunning = false;
   }
}