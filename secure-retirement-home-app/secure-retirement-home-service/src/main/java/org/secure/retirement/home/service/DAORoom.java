package org.secure.retirement.home.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.secure.retirement.home.common.*;
import org.secure.retirement.home.common.exception.DAOException;
import org.secure.retirement.home.common.transmission.information.Return_information;
import org.secure.retirement.home.service.*;

import secure.retirement.home.service.common.DAO;
import secure.retirement.home.service.common.DAOFactory;
import secure.retirement.home.service.common.DAOUtility;


/**
 
 *
 */
public class DAORoom implements DAO<Room> {

	private DAOFactory daofactory;
	/**
	 * @throws Exception 
	 * 
	 */
	public DAORoom(DAOFactory param_daofactory) throws Exception {
		// TODO Auto-generated constructor stub
		//super(param_daofactory);
		this.daofactory = param_daofactory;
	}

	/**
	 * <p>this method create in the database a room</p>
	 * 
	 * 
	 */
	public Return_information create(Room param_room )  throws IllegalArgumentException,  DAOException {
		Return_information val_return_information = Return_information.att_notfoud;
		try {
			if(ifFind(param_room)) {
				String SQL_INSERT = "INSERT INTO room (room_name,x_min,x_max,y_min,y_max  ) VALUES ( ?,?,?,?,? )";
				
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
							,	param_room.getRoom_name(),
							param_room.getX_min(),
							param_room.getX_max(),
							param_room.getY_min(),
							param_room.getY_max()
							
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
							param_room.setRoom_id( val_resultSet.getInt( 1 ));
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
	public Return_information delete( Room param_room) throws SQLException {
		//Remove
		Return_information val_return_information = Return_information.att_notfoud;
		String SQL_DELETE = " DELETE FROM room WHERE room_id = ? ; 	";
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
			        		,	param_room.getRoom_id()
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

	public Return_information update( Room param_room ) throws SQLException {
		Return_information val_return_information = Return_information.att_notfoud;
		String SQL_UPDATE = "UPDATE room set room_name = ? WHERE room.room_id = ?";
		Connection connexion = null;
		PreparedStatement preparedStatement = null;	    
		Room var_room = null;
		int status = 0;
		try {
			/* Get connection from the Factory */
			connexion = daofactory.getConnection();
			preparedStatement = DAOUtility.initPreparedRequest( 
			        		connexion
			        	,	SQL_UPDATE
			        	,	true
			       		,	param_room.getRoom_name()
			       		,	param_room.getRoom_id(),
			       		param_room.getX_min(),
						param_room.getX_max(),
						param_room.getY_min(),
						param_room.getY_max()
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

	public boolean ifFind(Room param_room) throws SQLException {
		// verification of the presence of the same value in the data base
		boolean to_return = false;
		String SQL_SELECTALL = "SELECT count(*) as number from room where room_name = ? ";
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
	        		, 	param_room.getRoom_name()
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

	public Room find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<Room> presentData() throws SQLException {
		ArrayList<Room> var_table						 ;
		var_table = new ArrayList<Room>()	 			 ;
		String SQL_SELECTALL = "SELECT * from room ";
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
						new Room(
								resultSet.getInt("room_id"),
								resultSet.getString("room_name"),
							     resultSet.getInt("x_min"),
							   resultSet.getInt("x_max"),
							  resultSet.getInt("y_min"),
							   resultSet.getInt("y_max")
							   
						))											 ;
			} 
	    }
	    catch(Exception e)
	    {
	    }
		return var_table										 ;
	}

	private static Room map( ResultSet resultSet ) throws SQLException {
	    Room var_room = new Room();
	    
	    var_room.setRoom_id( resultSet.getInt( "id" ) );
	    var_room.setRoom_name( resultSet.getString( "nom" ) );
	    var_room.setX_min( resultSet.getInt( "x_min" ) );
	    var_room.setX_max( resultSet.getInt( "x_max" ) );
	    var_room.setY_min( resultSet.getInt( "y_min" ) );
	    var_room.setY_max( resultSet.getInt( "y_max" ) );
	    
	    return var_room;
	    
	}
	
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public Return_information select(Room obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	


}
