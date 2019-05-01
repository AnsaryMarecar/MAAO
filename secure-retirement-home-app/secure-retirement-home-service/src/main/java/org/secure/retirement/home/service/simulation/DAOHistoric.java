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
import org.secure.retirement.home.common.Historic;
import org.secure.retirement.home.common.Return_information;
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
	
	public Return_information create(Historic param_historic) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("create");
		Return_information val_return_information = Return_information.att_notfoud;
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
				status = preparedStatement.executeUpdate();
				if( status == 0 ) {
					System.out.println("error execute  ");
					val_return_information = Return_information.att_db_cannot_insert;
					throw new DAOException( "Insertion error" );
				}
				else {
					System.out.println("else");
					/* take the generated id */
					try{
						System.out.println("generate key");
						resultSet = preparedStatement.getGeneratedKeys();
					}
					catch(Exception e) {
						val_return_information = Return_information.att_notfoud;
						System.out.println("error");
					}
					if ( resultSet.next() ) {
						System.out.println(" to_return = -4  ");
						param_historic.setHistoric_id(resultSet.getInt( 1 ));
						//to_return = -4;
					} 
					else {
						val_return_information = Return_information.att_db_not_return;
						System.out.println(" insertion id is not return to us  ");
						throw new DAOException( "insertion id is not return to us" );
					}
				}
				} catch ( SQLException e ) {
					val_return_information = Return_information.att_db_error;
					throw new DAOException( e );
				} finally {
					DAOUtility.closeAll(preparedStatement, connexion,   resultSet );
				}
		}catch(Exception e) {
			val_return_information = Return_information.att_db_cannot_insert;
		}
		return val_return_information;
	}
	
	

	public Return_information delete(Historic obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Return_information update(Historic obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
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

	public Return_information select(Historic obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
