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
		String SQL_SELECT = "SELECT " + "		s.sensor_mac" + ",	s.sensor_ip" + ",	ts.type_sensor_name"
				+ ",	r.room_name" + ",	h.historic_datetime" + ",	h.historic_value" + "		from sensor s, "
				+ "		type_sensor ts," + "		room r," + "		historic h	"
				+ "		where s.sensor_positionX BETWEEN " + "r.x_min and r.x_max "
				+ "and s.sensor_positionY BETWEEN r.y_min and r.y_max " + "and s.type_sensor_id=ts.type_sensor_id "
				+ "and s.sensor_id=h.sensor_id";
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
										resultSet.getString("sensor_mac"),
										resultSet.getString("sensor_ip"),
										resultSet.getString("type_sensor_name"),
										resultSet.getString("room_name"),
										resultSet.getString("Historic_datetime"),
										resultSet.getDouble("historic_value")));
					} catch (Exception e1) {
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