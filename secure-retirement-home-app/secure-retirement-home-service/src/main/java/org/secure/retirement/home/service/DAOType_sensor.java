package org.secure.retirement.home.service;


/**
 * 
 * */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.secure.retirement.home.common.*;
import org.secure.retirement.home.common.exception.DAOException;
import org.secure.retirement.home.common.transmission.information.Return_information;

import secure.retirement.home.service.common.DAO;
import secure.retirement.home.service.common.DAOFactory;
import secure.retirement.home.service.common.DAOUtility;


/**
 * @author ansary.marecar
 *
 */
public class DAOType_sensor implements DAO<Type_sensor> {

	private DAOFactory daofactory;
	/**
	 * @throws Exception 
	 * 
	 */
	public DAOType_sensor(DAOFactory param_daofactory) throws Exception {
		// TODO Auto-generated constructor stub
		this.daofactory = param_daofactory;
	}

	/**
	 * <p>this method create in the database a type_sensor</p>
	 * 
	 * @author ansary.marecar
	 */
	public Return_information create( Type_sensor param_type_sensor )  throws IllegalArgumentException,  DAOException {
		Return_information val_return_information = Return_information.att_notfoud;
		try {
			if(ifFind(param_type_sensor)) {
				String SQL_INSERT = "INSERT INTO type_sensor (type_sensor_name ) VALUES ( ? )";
				
				Connection val_connection = null;
				PreparedStatement val_preparedStatement = null;
				ResultSet val_resultSet = null;
				int val_status = 0;
				
				try {
					/* Get connection from the Factory */
					val_connection = daofactory.getConnection();
					val_preparedStatement = DAOUtility.initPreparedRequest(
							val_connection
							,	SQL_INSERT
							,	true
							,	param_type_sensor.getType_sensor_name()
							);
					val_status = val_preparedStatement.executeUpdate();
					System.out.println("val_status "+val_status);
					if( val_status == 0 ) {
						val_return_information = Return_information.att_db_cannot_insert;
						throw new DAOException( "cannot insert" );
					}
					else {
						try{
							val_resultSet = val_preparedStatement.getGeneratedKeys();
						}
						catch(Exception e) {
							val_return_information = Return_information.att_db_not_return;
							throw new DAOException( "insertion id is not return to us" );
						}
						if ( val_resultSet.next() ) {
							param_type_sensor.setType_sensor_id( val_resultSet.getInt( 1 ));
							 val_return_information = Return_information.att_success;
						} else {
							val_return_information = Return_information.att_db_not_return;
							throw new DAOException( "insertion id is not return to us" );
						}
					}
				} catch ( SQLException e ) {
					val_return_information = Return_information.att_db_error;
					throw new DAOException( e );
				} finally {
				DAOUtility.closeAll(val_preparedStatement, val_connection, val_resultSet );
				}
			}else {
				System.out.println("error");
				val_return_information = Return_information.att_intern_transmission;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return val_return_information;
	}

	
	/**
	 * <p>delete in the database</p>
	 * @author ansary.marecar
	 */
	public Return_information delete( Type_sensor param_type_sensor ) throws SQLException {
		//Remove
		Return_information val_return_information = Return_information.att_notfoud;
		String SQL_DELETE = " DELETE FROM type_sensor WHERE type_sensor_id = ? ; 	";
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		int status = 0;
		try {
			/* Get connection from the Factory */
			connexion = daofactory.getConnection();
			preparedStatement = DAOUtility.initPreparedRequest( 
			        			connexion
			        		,	SQL_DELETE
			        		,	true
			        		,	param_type_sensor.getType_sensor_id()
			        		);
			status = preparedStatement.executeUpdate();
			System.out.println("status "+status);
			if( status == 0 ) {
				val_return_information = Return_information.att_db_cannot_delete;
				throw new DAOException( "cannot delete" );
			}
			else {
				val_return_information = Return_information.att_success;
			}
		}
		catch ( SQLException e ) {
			val_return_information = Return_information.att_db_error;
			throw new DAOException( e );
		} 
		finally {
			DAOUtility.closeStatementConnection(preparedStatement, connexion);
		}
		return val_return_information;
	}

	public Return_information update( Type_sensor param_type_sensor ) throws SQLException {
		Return_information val_return_information = Return_information.att_notfoud;
		String SQL_UPDATE = "UPDATE type_sensor set type_sensor_name = ? WHERE type_sensor.type_sensor_id = ?";
		Connection connexion = null;
		PreparedStatement preparedStatement = null;	  
		int status = 0;
		try {
			/* Get connection from the Factory */
			connexion = daofactory.getConnection();
			preparedStatement = DAOUtility.initPreparedRequest( 
			        		connexion
			        	,	SQL_UPDATE
			        	,	true
			       		,	param_type_sensor.getType_sensor_name()
			       		,	param_type_sensor.getType_sensor_id()
			       		);
			status = preparedStatement.executeUpdate();
			System.out.println("status "+status);        
			if( status == 0 ) {
				val_return_information= Return_information.att_db_cannot_update;
				throw new DAOException( "cannot update" );
			}
			else {
				val_return_information= Return_information.att_success;
			}
		} catch ( SQLException e ) {
			val_return_information = Return_information.att_db_error;
			throw new DAOException( e );
		} finally {
			DAOUtility.closeStatementConnection(preparedStatement, connexion);
		}
		return val_return_information;
	}

	public boolean ifFind(Type_sensor param_type_sensor) throws SQLException {
		// verification of the presence of the same value in the data base
		boolean to_return = false;
		String SQL_SELECTALL = "SELECT count(*) as number from type_sensor where type_sensor_name = ? ";
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
	        		, 	param_type_sensor.getType_sensor_name()
	        		);
	        resultSet = preparedStatement.executeQuery();
	        System.out.println("status "+resultSet);
	        resultSet.next();
	        if(resultSet.getInt("number") == 0 ) {
	        	to_return = true;
	        }
	    }
	    catch(Exception e)
	    {
	    }
		return to_return;
	}

	public Type_sensor find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<Type_sensor> presentData() throws SQLException {
		ArrayList<Type_sensor> var_table						 ;
		var_table = new ArrayList<Type_sensor>()	 			 ;
		String SQL_SELECTALL = "SELECT * from type_sensor ";
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
	        		);
	        resultSet = preparedStatement.executeQuery();
	        System.out.println("status "+resultSet);
	        while(resultSet.next()) {
				var_table.add(
						new Type_sensor(
							resultSet.getInt("type_sensor_id")
						,	resultSet.getString("type_sensor_name")
						))											 ;
			} 
	    }
	    catch(Exception e)
	    {
	    }
		return var_table										 ;
	}
/**
	private static Type_sensor map( ResultSet resultSet ) throws SQLException {
	    Type_sensor var_type_sensor = new Type_sensor();
	    
	    var_type_sensor.setType_sensor_id( resultSet.getInt( "id" ) );
	    var_type_sensor.setType_sensor_name( resultSet.getString( "nom" ) );
	    return var_type_sensor;
	}
**/	
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public Return_information select(Type_sensor obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	


}


