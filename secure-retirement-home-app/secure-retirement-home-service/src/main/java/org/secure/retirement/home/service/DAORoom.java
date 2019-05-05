package org.secure.retirement.home.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.secure.retirement.home.common.DAOException;
import org.secure.retirement.home.common.Return_information;
import org.secure.retirement.home.common.Room;
import org.secure.retirement.home.common.*;



public class DAORoom implements DAO<Room> {
	
	private DAOFactory daofactory;
	
	public DAORoom(DAOFactory daofactory) throws Exception {
		this.daofactory = daofactory;
	}
	/**
	 * <p>select in the database</p>
	 */
	public Return_information select( Room param_room ) throws SQLException {
		//select
		Return_information val_return_information = Return_information.att_notfound;
		String SQL_SELECT = " SELECT FROM room WHERE room_id = ? ; 	";
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		int status = 0;
		try {
			/* Get connection from the Factory */
			connexion = daofactory.getConnection();
			preparedStatement = DAOUtility.initPreparedRequest( 
			        			connexion
			        		,	SQL_SELECT
			        		,	true
			        		,	param_room.getRoom_id()
			        		);
			status = preparedStatement.executeUpdate();
			System.out.println("status "+status);
			if( status == 0 ) {
				val_return_information = Return_information.att_db_cannot_select;
				throw new DAOException( "cannot select" );
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
	public ArrayList <Room> presentData() throws SQLException {
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
	public Return_information create(Room obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public Return_information delete(Room obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public Return_information update(Room obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean ifFind(Room obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	public Room find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}


}
