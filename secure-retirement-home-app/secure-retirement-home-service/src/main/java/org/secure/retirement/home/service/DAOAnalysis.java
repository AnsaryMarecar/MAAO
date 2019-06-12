package org.secure.retirement.home.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.secure.retirement.home.common.Analysis;
import org.secure.retirement.home.common.Sensor;
import org.secure.retirement.home.common.Type_sensor;
import org.secure.retirement.home.common.transmission.information.Return_information;

import secure.retirement.home.service.common.DAOFactory;
import secure.retirement.home.service.common.DAOUtility;

public class DAOAnalysis {

	private DAOFactory daofactory;

	public DAOAnalysis(DAOFactory param_daofactory) {
		this.daofactory = param_daofactory;
	}

	public ArrayList<Analysis> presentData() throws SQLException {
		ArrayList<Analysis> var_table;
		var_table = new ArrayList<Analysis>();
		String SQL_SELECT = "select count(*) as countAll from historic h, sensor s where h.sensor_id=s.sensor_id and h.historic_value not between s.sensor_min and s.sensor_max";

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			try {
				/* Get connection from the Factory */
				connexion = daofactory.getConnection();
			} catch (Exception e0) {
				System.out.println("E0: " + e0.getLocalizedMessage());
			}
			try {
				preparedStatement = DAOUtility.initPreparedRequest(connexion, SQL_SELECT, true);
			} catch (Exception e0B) {
				System.out.println("E0B: " + e0B.getLocalizedMessage());
			}
			try {
				resultSet = preparedStatement.executeQuery();
				System.out.println("status " + resultSet);
				while (resultSet.next()) {
					try {
						var_table.add(

								new Analysis(
										null,
										null,
										null,
										null,
										null,
										null,
										null,
										resultSet.getString("countAll")));
										
					}  catch (Exception e1) {
						System.out.println("E1: " + e1.getLocalizedMessage());
					} 
				}
			} catch (Exception e2) {
				System.out.println("E2: " + e2.getLocalizedMessage());
			}
		} catch (Exception e) {
			System.out.println("E: " + e.getLocalizedMessage());
		}
		return var_table;
	}
	
	public ArrayList<Analysis> presentCount() throws SQLException {
		ArrayList<Analysis> var_table;
		var_table = new ArrayList<Analysis>();
		String SQL_SELECT = "select s.sensor_mac ,count(*) as countAnal "
				+ "from historic h,sensor s "
				+ "where s.sensor_id=h.sensor_id "
				+ "and h.historic_value not between s.sensor_min and s.sensor_max  "
				+ "group by s.sensor_id";
		 
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			try {
				/* Get connection from the Factory */
				connexion = daofactory.getConnection();
			} catch (Exception e0) {
				System.out.println("E0: " + e0.getLocalizedMessage());
			}
			try {
				preparedStatement = DAOUtility.initPreparedRequest(connexion, SQL_SELECT, true);
			} catch (Exception e0B) {
				System.out.println("E0B: " + e0B.getLocalizedMessage());
			}
			try {

				System.out.println("DAOAnalysis>SELECTCOUNT>TRY EXECUTE QUERY");
				resultSet = preparedStatement.executeQuery();
				System.out.println("status " + resultSet);
			
				while (resultSet.next()) {
					try {

						System.out.println("DAOAnalysis>SELECTCOUNT>TRY EXECUTE QUERY");
						var_table.add(

								new Analysis(
										resultSet.getString("sensor_mac"),
										null,
										null,
										null,
										null,
										null,
										resultSet.getString("countAnal"),
										null));
										
					} 
					
					catch (Exception e1) {
						System.out.println("E1: " + e1.getLocalizedMessage());
					} 
				}
			} catch (Exception e2) {
				System.out.println("E2: " + e2.getLocalizedMessage());
			}
		} catch (Exception e) {
			System.out.println("E: " + e.getLocalizedMessage());
		}
		return var_table;
	}
	

	public void close() throws SQLException {
		// TODO Auto-generated method stub
	}

	public Return_information select(Sensor obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}