package org.secure.retirement.home.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.secure.retirement.home.common.DAOException;
import org.secure.retirement.home.common.Return_information;
import org.secure.retirement.home.common.Room;


public class DAORoom implements DAO<DAORoom> {
	
	private DAOFactory daofactory;
	
	public DAORoom(DAOFactory daofactory) throws Exception {
		this.daofactory = daofactory;
	}
	/**
	 * <p>select in the database</p>
	 */
	public Return_information select( Room param_room ) throws SQLException {
		//select
		Return_information val_return_information = Return_information.att_notfoud;
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
				/*val_return_information = Return_information.att_db_cannot_select;
				throw new DAOException( "cannot delete" );*/
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
	public Return_information create(DAORoom obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public Return_information delete(DAORoom obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public Return_information update(DAORoom obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public Return_information select(DAORoom obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean ifFind(DAORoom obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	public DAORoom find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<DAORoom> presentData() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
