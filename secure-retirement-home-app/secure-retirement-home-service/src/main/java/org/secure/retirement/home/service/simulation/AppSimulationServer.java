/**
 * 
 */
package org.secure.retirement.home.service.simulation;

import org.secure.retirement.home.common.Historic;
import org.secure.retirement.home.common.Sensor;
import org.secure.retirement.home.common.Type_sensor;
import org.secure.retirement.home.service.DAOFactory;
import org.secure.retirement.home.service.JDBCConnectionPool;

/**
 * @author Ansary MARECAR
 *
 */
public class AppSimulationServer {
 
	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Type_sensor ts = new Type_sensor(10,"Humidité");
		Sensor sensor = new Sensor(1,ts);
		Historic historic = new Historic(sensor,1200);
		JDBCConnectionPool.initializList();		
		DAOFactory daof;
		daof = JDBCConnectionPool.getConnection();
		System.out.println(JDBCConnectionPool.displayConnex());
		try {
			System.out.println("---deb try -----");
			DAOHistoric daohistoric = new DAOHistoric(daof);
			daohistoric.create(historic);
			System.out.println("---end try -----");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error nose");
		}
		System.out.println(JDBCConnectionPool.displayConnex());
	}

}
