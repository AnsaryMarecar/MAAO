package secure.retirement.home.service.common;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.secure.retirement.home.common.Sensor;
import org.secure.retirement.home.common.exception.DAOConfigurationException;
import org.secure.retirement.home.service.DAOSensor;
import org.secure.retirement.home.service.cache.GuavaCache;
import org.secure.retirement.home.service.simulation.SimulateFailure;

public class ConnectionPool {

   //Initializ default value
   private int 						att_port 		 ;
   private String 					att_host 		 ;
   
   private static final String FILE_PROPERTIES	 = "connection.properties";
   private static final String PROPERTY_PORT	 = "port";
   private static final String PROPERTY_HOST	 = "host";
   
   private ServerSocket 			att_server 		 = null			;
   private boolean 					att_isRunning 	 = true			;
   private static ArrayList<Sensor> att_sensors 	 = null			;
   private static GuavaCache 		[]att_cache						;
   
   public ConnectionPool(){
	   this.setAtt_server();
	   setAtt_sensors();
	   att_cache = GuavaCache.createAllCach(getAtt_sensors());
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
		Properties 	var_properties 	= new Properties()									;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader()		;
        InputStream fileProperties = classLoader.getResourceAsStream(FILE_PROPERTIES )	;        
        if ( fileProperties == null ) {
            throw new DAOConfigurationException( "the file:  " + FILE_PROPERTIES + " does not exist." );
        }
        else {
	        //attribute value
	        try {
	            var_properties.load( fileProperties )										;
	            att_port 	= Integer.parseInt(var_properties.getProperty( PROPERTY_PORT))	;
	            att_host 	= (String) var_properties.getProperty( PROPERTY_HOST )			;
	            System.out.println("att_port:"+att_port+" att_host:"+att_host);
	         } 
	        catch ( Exception exp ) {
	            throw new DAOConfigurationException( " we have difficulty to charge the file : " + FILE_PROPERTIES, exp );
	        }
        }
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
	    	//att_cache = GuavaCache.createAllCach(getAtt_sensors());
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
	  SimulateFailure t = new SimulateFailure("Simulate Failure"
			   ,JDBCConnectionPool.getConnection()
			   );
	  t.start();
   }
   public void close(){
	   att_isRunning = false;
   }
}