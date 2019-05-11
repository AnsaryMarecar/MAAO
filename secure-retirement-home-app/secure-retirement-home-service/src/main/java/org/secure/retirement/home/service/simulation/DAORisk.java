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
import org.secure.retirement.home.common.Risk;
import org.secure.retirement.home.service.DAO;
import org.secure.retirement.home.service.DAOFactory;
import org.secure.retirement.home.service.DAOUtility;

/**
 * @author Ansary MARECAR
 *
 */
public class DAORisk implements DAO<Risk> {
	private DAOFactory daofactory;
	/**
	 * 
	 */
	public DAORisk(DAOFactory param_daofactory) {
		// TODO Auto-generated constructor stub
		this.daofactory = param_daofactory;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Return_information create(Risk param_risk) throws SQLException {
		System.out.println("create");
		Return_information val_return_information = Return_information.att_notfoud;
		try {
			String SQL_INSERT = "INSERT INTO risk (sensor_id, historic_id) VALUES ( ?, ? )";
			Connection connexion = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			int status = 0;
			try {
				/* Get connection from the Factory */
				connexion = daofactory.getConnection();
				System.out.println(" execute  ");
				System.out.println("param_risk.getSensor().getSensor_id()"+param_risk.getSensor().getSensor_id());
				preparedStatement = DAOUtility.initPreparedRequest(
					connexion
					,	SQL_INSERT
					,	true
					,	param_risk.getSensor().getSensor_id()
					,	param_risk.getHistoric().getHistoric_id()
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
						param_risk.setRisk_id(resultSet.getInt( 1 ));
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
	
	public Return_information delete(Risk obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Return_information update(Risk obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Return_information select(Risk obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean ifFind(Risk obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public Risk find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Risk> presentData() throws SQLException {
			return null;
	}

}
