package org.secure.retirement.home.service;


import java.sql.SQLException;

import org.secure.retirement.home.common.Type_sensor;
//import org.secure.retirement.home.frame.FrameType_sensor;
import org.secure.retirement.home.service.DAOFactory;
import org.secure.retirement.home.service.DAOType_sensor;
import org.secure.retirement.home.service.JDBCConnectionPool;

/**
*/
public class AppServer 
{
	public static void main(String[] args) {
		System.out.println(JDBCConnectionPool.displayConnex());
		JDBCConnectionPool.initializList();
		System.out.println(JDBCConnectionPool.displayConnex());
		
		String host = "127.0.0.1";
	    int port = 2345;
	      
	    TimeServer ts = new TimeServer(host, port);
	    ts.open();
	    System.out.println("Initializ server");
		
		/**DAOFactory daof;
		JDBCConnectionPool.initializList();		
		daof = JDBCConnectionPool.getConnection();
		System.out.println(JDBCConnectionPool.displayConnex());
		DAOType_sensor dts;
		try {
			dts = new DAOType_sensor(daof);
			Type_sensor ts = new Type_sensor(19,"OBELIX SENSOR");
			try {
				System.out.println("test: "+dts.update(ts));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} **/
		//JDBCConnectionPool.AddConnection(daof);
		//System.out.println(JDBCConnectionPool.displayConnex());
	}
}
