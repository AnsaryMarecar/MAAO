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
										resultSet.getString("countAll"),
										null,
										null,null));
										
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
	
	public ArrayList<Analysis> presentCountType() throws SQLException {
		ArrayList<Analysis> var_table;
		var_table = new ArrayList<Analysis>();
		String SQL_SELECT = "select ts.type_sensor_name, count(*) as countType from historic h, sensor s, type_sensor ts where h.sensor_id=s.sensor_id and h.historic_value not between s.sensor_min and s.sensor_max and s.type_sensor_id=ts.type_sensor_id group by type_sensor_name";

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
										resultSet.getString("type_sensor_name"),
										null,
										null,
										null,
										null,
										null,
										resultSet.getString("countType"),
										null,null));
										
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
	
	public ArrayList<Analysis> presentCountRoom() throws SQLException {
		ArrayList<Analysis> var_table;
		var_table = new ArrayList<Analysis>();
		String SQL_SELECT = "select ts.type_sensor_name, count(*) as countType from historic h, sensor s, type_sensor ts where h.sensor_id=s.sensor_id and h.historic_value not between s.sensor_min and s.sensor_max and s.type_sensor_id=ts.type_sensor_id group by type_sensor_name";

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
										resultSet.getString("room_name"),
										null,
										null,
										null,
										null,
										null,
										resultSet.getString("countRoom"),null));
										
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
										null,
										null,
										null,null));
										
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
	
	public ArrayList<Analysis> presentDate(Analysis anal1, Analysis anal2) throws SQLException {
		ArrayList<Analysis> var_table=new ArrayList<Analysis>();
		System.out.println(anal1.getHistoric_datetime());
		System.out.println(anal2.getHistoric_datetime());
		String SQL_SELECT = "select count(*)as countDate from historic h, sensor s where s.sensor_id=h.sensor_id and historic_datetime between ? and ? and h.historic_value not between s.sensor_min and s.sensor_max";
		 
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
				preparedStatement = DAOUtility.initPreparedRequest( 
        			connexion
        		,	SQL_SELECT
        		,	true
        		,	anal1.getHistoric_datetime(),
        		anal2.getHistoric_datetime()
        		);
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
										null,
										null,
										null,
										null,
										null,
										null,
										null,
										null,
										null,
										null, 
										resultSet.getString("countDate")));
										
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