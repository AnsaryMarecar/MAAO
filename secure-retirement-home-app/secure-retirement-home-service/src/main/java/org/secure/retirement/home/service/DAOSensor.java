package org.secure.retirement.home.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.secure.retirement.home.common.DAOException;
import org.secure.retirement.home.common.Return_information;
import org.secure.retirement.home.common.Room;
import org.secure.retirement.home.service.*;
import org.secure.retirement.home.common.Sensor;

public class DAOSensor implements DAO<Sensor>{

	private DAOFactory daofactory;
	
	public DAOSensor(DAOFactory param_daofactory) throws Exception {
		// TODO Auto-generated constructor stub
		//super(param_daofactory);
		this.daofactory = param_daofactory;
	}


	/**
	 * 
	 * 
	 */
	public Return_information create(Sensor param_sensor )  throws IllegalArgumentException,  DAOException {
		Return_information val_return_information = Return_information.att_notfoud;
		try {
			if(ifFind(param_sensor)) {
				String SQL_INSERT = "INSERT INTO sensor (type_sensor,position_x,position_y,sensor_min,sensor_max,sensor_ip,sensor_mac) VALUES ( ?,?,?,?,?,?,?)";
				
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
							
							,   param_sensor.getType_sensor()
							,   param_sensor.getPosition_x()
							,   param_sensor.getPosition_y()
							,   param_sensor.getSensor_min()
							,   param_sensor.getSensor_max()
							,   param_sensor.getAddress_ip()
							,   param_sensor.getAddress_mac()
						//	,   param_sensor.getRisq_id()

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
							param_sensor.setSensor_id( val_resultSet.getInt( 1 ));
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
	public Return_information delete( Sensor param_sensor) throws SQLException {
		//Remove
		Return_information val_return_information = Return_information.att_notfoud;
		String SQL_DELETE = " DELETE FROM sensor WHERE sensor_id = ? ; 	";
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

	public Return_information update( Sensor param_sensor ) throws SQLException {
		Return_information val_return_information = Return_information.att_notfoud;
		String SQL_UPDATE = "UPDATE sensor set sensor_status = ? WHERE sensor_id = ?";
		Connection connexion = null;
		PreparedStatement preparedStatement = null;	    
		Sensor var_sensor = null;
		int status = 0;
		try {
			/* Get connection from the Factory */
			connexion = daofactory.getConnection();
			preparedStatement = DAOUtility.initPreparedRequest( 
			        		connexion
			        	,	SQL_UPDATE
						,	true
						,	param_sensor.getSensor_id()
						,   param_sensor.getType_sensor()
						,   param_sensor.getPosition_x()
						,   param_sensor.getPosition_y()
						,   param_sensor.getSensor_min()
						,   param_sensor.getSensor_max()
						,   param_sensor.getAddress_ip()
						,   param_sensor.getAddress_mac()
					//	,   param_sensor.getRisq_id()
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

	public boolean ifFind(Sensor param_sensor) throws SQLException {
		// verification of the presence of the same value in the data base
		boolean to_return = false;
		String SQL_SELECTALL = "SELECT count(*) as number from sensor where type_sensor = ? ";
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
				
					,   param_sensor.getType_sensor()
		
	        		
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

	public Sensor find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<Sensor> presentData() throws SQLException {
		ArrayList<Sensor> var_table						 ;
		var_table = new ArrayList<Sensor>()	 			 ;
		String SQL_SELECTALL = "SELECT * from sensor ";
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
						new Sensor(
								resultSet.getInt("sensor_id"),
								resultSet.getString("type_sensor"),
								resultSet.getInt("position_x"),
							     resultSet.getInt("position_y"),
							   resultSet.getInt("sensor_min"),
							  resultSet.getInt("sensor_max"),
							   resultSet.getString("sensor_ip"),
							  resultSet.getString("sensor_mac")
						))											 ;
			} 
	    }
	    catch(Exception e)
	    {
	    }
		return var_table										 ;
	}
	private static Sensor map( ResultSet resultSet ) throws SQLException {
	    Sensor var_sensor = new Sensor();
	    
	    var_sensor.setSensor_id( resultSet.getInt( "id" ) );
	    var_sensor.setType_sensor( resultSet.getString( "nom" ) );
	    var_sensor.setPosition_x( resultSet.getInt( "x" ) );
	    var_sensor.setPosition_y( resultSet.getInt( "y" ) );
	    var_sensor.setSensor_min( resultSet.getInt( "sensor_min" ) );
	    var_sensor.setSensor_max( resultSet.getInt( "sensor_max" ) );
	    var_sensor.setAddress_ip( resultSet.getString( "sensor_ip" ) );
	    var_sensor.setAddress_mac( resultSet.getString( "sensor_mac" ) );
	    return var_sensor;
	    
	}
	
	
	public void close() throws SQLException {
		// TODO Auto-generated method stub		
	}

	public Return_information select(Sensor obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	


}
