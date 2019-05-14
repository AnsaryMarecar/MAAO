/**
 * 
 */
package org.secure.retirement.home.service.simulation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.secure.retirement.home.common.Failure;
import org.secure.retirement.home.common.exception.DAOException;
import org.secure.retirement.home.common.transmission.information.Return_information;

import secure.retirement.home.service.common.DAO;
import secure.retirement.home.service.common.DAOFactory;
import secure.retirement.home.service.common.DAOUtility;

/**
 * @author Ansary MARECAR
 *
 */
public class DAOFailure implements DAO<Failure> {
	private DAOFactory att_daofactory;
	/**
	 * 
	 */
	public DAOFailure(DAOFactory param_daofactory) {
		// TODO Auto-generated constructor stub
		this.setAtt_daofactory(param_daofactory);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Return_information create(Failure param_failure) throws SQLException {
		// TODO Auto-generated method stub
		Return_information val_return_information = Return_information.att_notfoud;
		try {
			String SQL_INSERT = "INSERT INTO failure (sensor_id, failure_datetime) VALUES ( ?, now() )";
			
			Connection val_connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			int status = 0;
			try {
				/* Get connection from the Factory */
				val_connection = att_daofactory.getConnection();
				preparedStatement = DAOUtility.initPreparedRequest(
							val_connection
						,	SQL_INSERT
						,	true
						,	param_failure.getSensor().getSensor_id()	
					);
				
				status = preparedStatement.executeUpdate();
				if( status == 0 ) {
					val_return_information = Return_information.att_db_cannot_insert;
					throw new DAOException( "Insertion error" );
				}
				else {
					/* take the generated id */
					try{
						resultSet = preparedStatement.getGeneratedKeys();
					}
					catch(Exception e) {
						val_return_information = Return_information.att_notfoud;
						System.out.println("error");
					}
					if ( resultSet.next() ) {
						param_failure.setFailure_id(resultSet.getInt( 1 ));
					} 
					else {
						val_return_information = Return_information.att_db_not_return;
						throw new DAOException( "insertion id is not return to us" );
					}
				}
			} catch ( SQLException e ) {
				val_return_information = Return_information.att_db_error;
				throw new DAOException( e );
			} finally {
					
				DAOUtility.closeAll(preparedStatement, val_connection,   resultSet );
			}
		}catch(Exception e) {
			val_return_information = Return_information.att_db_cannot_insert;
		}
		return val_return_information;
	}

	public Return_information delete(Failure obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Return_information update(Failure obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Return_information select(Failure obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean ifFind(Failure obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public Failure find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Failure> presentData() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the att_daofactory
	 */
	public DAOFactory getAtt_daofactory() {
		return att_daofactory;
	}

	/**
	 * @param att_daofactory the att_daofactory to set
	 */
	public void setAtt_daofactory(DAOFactory att_daofactory) {
		this.att_daofactory = att_daofactory;
	}

}
