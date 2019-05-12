/**
 * 
 */
package org.secure.retirement.home.service.simulation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.secure.retirement.home.common.Historic;
import org.secure.retirement.home.common.exception.DAOException;
import org.secure.retirement.home.common.transmission.information.Return_information;

import secure.retirement.home.service.common.DAO;
import secure.retirement.home.service.common.DAOFactory;
import secure.retirement.home.service.common.DAOUtility;

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
	
	public String add(Historic param_historic) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("create");
		String val_return_information = Return_information.att_notfoud.toString();
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
					val_return_information = Return_information.att_db_cannot_insert.toString();
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
						val_return_information = Return_information.att_notfoud.toString();
						System.out.println("error");
					}
					if ( resultSet.next() ) {
						System.out.println(" to_return = -4  ");
						 param_historic.setHistoric_id(resultSet.getInt( 1 ));
						 val_return_information = String.valueOf(param_historic.getHistoric_id());
						//to_return = -4;
					} 
					else {
						val_return_information = Return_information.att_db_not_return.toString();
						System.out.println(" insertion id is not return to us  ");
						throw new DAOException( "insertion id is not return to us" );
					}
				}
				} catch ( SQLException e ) {
					val_return_information = Return_information.att_db_error.toString();
					throw new DAOException( e );
				} finally {
					DAOUtility.closeAll(preparedStatement, connexion,   resultSet );
				}
		}catch(Exception e) {
			val_return_information = Return_information.att_db_cannot_insert.toString();
		}
		return val_return_information.toString();
	}

	public Return_information delete(Historic obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Return_information update(Historic obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean ifFind(Historic param_historic) throws SQLException {
		// verification of the presence of the same value in the data base
				boolean to_return = false;
				String SQL_SELECTALL = "SELECT IF(count(*) as number from hisoric "
						+ " where sensor_id = ? "
						+ " and historic_datetime>=(NOW()-5)";
				Connection connexion = null;
			    PreparedStatement preparedStatement = null;
			    ResultSet resultSet = null;
			    
			    try {
			        /* Get connection from the Factory */
			        connexion = daofactory.getConnection();
			        preparedStatement = DAOUtility.initPreparedRequest(
			        			connexion
			        		,	SQL_SELECTALL
			        		,	true
			        		, 	param_historic.getSensor().getSensor_id()
			        		);
			        resultSet = preparedStatement.executeQuery();
			        System.out.println("status "+resultSet);
			        resultSet.next();
			        if(resultSet.getInt("number") == 0 ) {
			        	to_return = true;
			        }
			    }
			    catch(Exception e){
			    	System.out.println("Exception DAOHistoric/ifFind : "+e.getMessage());
			    }
				return to_return;
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
