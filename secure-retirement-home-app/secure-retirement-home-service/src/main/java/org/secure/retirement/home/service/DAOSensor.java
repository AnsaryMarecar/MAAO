package org.secure.retirement.home.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import secure.retirement.home.service.common.DAO;
import secure.retirement.home.service.common.DAOFactory;
import secure.retirement.home.service.common.DAOUtility;

import org.secure.retirement.home.common.Sensor;
import org.secure.retirement.home.common.Type_sensor;
import org.secure.retirement.home.common.exception.DAOException;
import org.secure.retirement.home.common.transmission.information.Return_information;

public class DAOSensor implements DAO<Sensor>{

	private DAOFactory daofactory;
	
	public DAOSensor(DAOFactory param_daofactory)  {
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
				String SQL_INSERT = "INSERT INTO sensor (type_sensor,sensor_min,sensor_max,sensor_mac,sensor_ip,,sensor_positionX,sensor_positionY) VALUES ( ?,?,?,?,?,?,?)";
				
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
							,   param_sensor.getSensor_min()
							,   param_sensor.getSensor_max()
							,   param_sensor.getSensor_mac()
							,   param_sensor.getSensor_ip()
							,   param_sensor.getSensor_positionX()
							,   param_sensor.getSensor_positionY()

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
		String SQL_DELETE = " DELETE FROM sensor WHERE sensor_id =" +	param_sensor.getSensor_id();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		int status = 0;
		try {
			/* Get connection from the Factory */
			connexion = daofactory.getConnection();
			preparedStatement = DAOUtility.initPreparedRequest( 
			        			connexion
			        		,	SQL_DELETE, true
			        		,param_sensor.getType_sensor()
			   
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
			throw new RuntimeException(e);
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
			connexion = daofactory.getConnection();
			preparedStatement = DAOUtility.initPreparedRequest( 
			        		connexion
			        	,	SQL_UPDATE
						,	true
						,	param_sensor.getSensor_id()
						,   param_sensor.getType_sensor()
						,   param_sensor.getSensor_min()
						,   param_sensor.getSensor_max()
						,   param_sensor.getSensor_ip()
						,   param_sensor.getSensor_mac()
						,   param_sensor.getSensor_positionX()
						,   param_sensor.getSensor_positionY()
						
						
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

	private static Sensor map( ResultSet resultSet ) throws SQLException {
	    Sensor var_sensor = new Sensor();
	    
	    var_sensor.setSensor_id( resultSet.getInt( "id" ) );
	    var_sensor.setType_sensor( resultSet.getString( "nom" ) );
	    var_sensor.setSensor_positionX( resultSet.getInt( "x" ) );
	    var_sensor.setSensor_positionY( resultSet.getInt( "y" ) );
	    var_sensor.setSensor_min( resultSet.getInt( "sensor_min" ) );
	    var_sensor.setSensor_max( resultSet.getInt( "sensor_max" ) );
	    var_sensor.setSensor_ip( resultSet.getString( "sensor_ip" ) );
	    var_sensor.setSensor_mac( resultSet.getString( "sensor_mac" ) );
	 
	    return var_sensor;
	    
	}
	
	public ArrayList<Sensor> presentData() throws SQLException {
		ArrayList<Sensor> var_table						 ;
		var_table = new ArrayList<Sensor>()	 			 ;
		String SQL_SELECT = "SELECT * from sensor ";
			//	+ "		sensor.sensor_id"
			//	+ ",	sensor.sensor_ip"
			//	+ ",	sensor.sensor_mac"
			//	+ ",	sensor.sensor_min"
			//	+ ",	sensor.sensor_max"
			//	+ ",	sensor.sensor_positionX"
			//	+ ",	sensor.sensor_positionY"
			//	+ ",	type_sensor.type_sensor_interval"
			//	+ ",	type_sensor.type_sensor_name"
			//	+ ",	type_sensor.type_sensor_id "
			//	+ "		from sensor join type_sensor "
			//	+ "		where sensor.type_sensor_id=type_sensor.type_sensor_id";
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    try {
	    	try {
	        /* Get connection from the Factory */
	        connexion = daofactory.getConnection();
	    	}catch(Exception e0) {
	    		System.out.println("E0: "+e0.getLocalizedMessage());
	    	}
	    	try{
	        preparedStatement = DAOUtility.initPreparedRequest(
	        			connexion
	        		,	SQL_SELECT
	        		,	true
	        		);
	    }catch(Exception e0B) {
    		System.out.println("E0B: "+e0B.getLocalizedMessage());
    	}
	        try {
	        resultSet = preparedStatement.executeQuery();
	        System.out.println("status "+resultSet);
	        
	        while(resultSet.next()) {
				try {
	        	var_table.add(
						
						new Sensor(
							resultSet.getInt("sensor_id")
						, 	resultSet.getString("type_sensor")
						,	resultSet.getString("sensor_mac")
						,	resultSet.getString("sensor_ip")
						,	resultSet.getDouble("sensor_min")
						,	resultSet.getDouble("sensor_max")
						,	resultSet.getDouble("sensor_positionX")
						,	resultSet.getDouble("sensor_positionY")
						));
				}
				catch(Exception e1) {
					System.out.println("E1: "+e1.getLocalizedMessage());
				}
			} 
		    }
			catch(Exception e2) {
				System.out.println("E2: "+e2.getLocalizedMessage());
			}
	    }
	    catch(Exception e){
	    	System.out.println("E: "+e.getLocalizedMessage());
	    }
		return var_table										 ;
	}
	
	public void close() throws SQLException {
		// TODO Auto-generated method stub		
	}

	public Return_information select(Sensor obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	


}
