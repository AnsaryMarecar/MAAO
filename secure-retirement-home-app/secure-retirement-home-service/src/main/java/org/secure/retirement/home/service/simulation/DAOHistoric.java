/**
 * 
 */
package org.secure.retirement.home.service.simulation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.secure.retirement.home.common.DAOException;
import org.secure.retirement.home.common.Type_sensor;
import org.secure.retirement.home.service.DAO;
import org.secure.retirement.home.service.DAOFactory;
import org.secure.retirement.home.service.DAOUtility;
import org.secure.retirement.home.service.simulation.*;

/**
 * @author Ansary MARECAR
 *
 */
public class DAOHistoric implements DAO<Historic> {
	private DAOFactory daofactory;
	
	public DAOHistoric(DAOFactory param_daofactory) throws Exception {
		this.setDaofactory(param_daofactory);
	}
	
	public int create(Historic param_historic) throws SQLException {
		// TODO Auto-generated method stub
		int to_return = -5	;
		System.out.println("create");
		try {
			String SQL_INSERT = "INSERT INTO historic (historic_datetime, historic_value, sensor_id) VALUES (  NOW(), ?, ?  )";
			Connection connexion = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			int status = 0;
			try {
				/* Get connection from the Factory */
				connexion = daofactory.getConnection();
				System.out.println(" execute  ");
				System.out.println("param_historic.getSensor().getSensor_id()"+param_historic.getSensor().getSensor_id());
				preparedStatement = DAOUtility.initPreparedRequest(
					connexion
					,	SQL_INSERT
					,	true
					,	param_historic.getHistoric_value()
					,	param_historic.getSensor().getSensor_id()
				);
				System.out.println(" status  ");
				status = preparedStatement.executeUpdate();
				//System.out.println("status "+status);
				System.out.println("end status ");
				if( status == 0 ) {
					System.out.println("error execute  ");
					throw new DAOException( "Sorry we have problem, we cannot insert" );
				}
				else {
					System.out.println("else");
					/* take the generated id */
					try{
						System.out.println("generate key");
						resultSet = preparedStatement.getGeneratedKeys();
					}
					catch(Exception e) {
						System.out.println("error");
					}
					if ( resultSet.next() ) {
						System.out.println(" to_return = -4  ");
						param_historic.setHistoric_id(resultSet.getInt( 1 ));
						to_return = -4;
					} 
					else {
						System.out.println(" insertion id is not return to us  ");
						throw new DAOException( "insertion id is not return to us" );
					}
				}
				} catch ( SQLException e ) {
					throw new DAOException( e );
				} finally {
					DAOUtility.closeAll(preparedStatement, connexion,   resultSet );
				}
		}catch(Exception e) {
		}
		return to_return;
	}
	
	

	public int delete(Historic obj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Historic obj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean ifFind(Historic obj) throws SQLException {
		return false;
	}

	public Historic find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Historic> presentData() throws SQLException {
		// TODO Auto-generated method stub
		
		return null;
	}

	/**
	 * @return the daofactory
	 */
	public DAOFactory getDaofactory() {
		return daofactory;
	}

	/**
	 * @param daofactory the daofactory to set
	 */
	public void setDaofactory(DAOFactory daofactory) {
		this.daofactory = daofactory;
	}

}
