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
import org.secure.retirement.home.service.*;


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
		//super(param_daofactory);
		this.daofactory = param_daofactory;
	}

	/**
	 * <p>this method create in the database a type_sensor</p>
	 * 
	 * @author ansary.marecar
	 */
	public int create( Type_sensor param_type_sensor )  throws IllegalArgumentException,  DAOException {
		int to_return = -5	;
		
		try {
			if(ifFind(param_type_sensor)) {
				String SQL_INSERT = "INSERT INTO type_sensor (type_sensor_name ) VALUES ( ? )";
				
				Connection connexion = null;
				PreparedStatement preparedStatement = null;
				
				ResultSet resultSet = null;
				
				Type_sensor var_type_sensor = null;
				int status = 0;
				try {
					/* Get connection from the Factory */
					connexion = daofactory.getConnection();
					preparedStatement = DAOUtility.initPreparedRequest(
							connexion
							,	SQL_INSERT
							,	true
							,	param_type_sensor.getType_sensor_name()
							);
					status = preparedStatement.executeUpdate();
					System.out.println("status "+status);
				if( status == 0 ) {
					throw new DAOException( "Sorry we have problem, we cannot insert" );
				}
				/* take the generated id */
				try{
					resultSet = preparedStatement.getGeneratedKeys();
				}
				catch(Exception e) {
				//
				}
				if ( resultSet.next() ) {
					param_type_sensor.setType_sensor_id( resultSet.getInt( 1 ));
					to_return = -4;
				} else {
					throw new DAOException( "insertion id is not return to us" );
				}
				} catch ( SQLException e ) {
					throw new DAOException( e );
				} finally {
				DAOUtility.closeAll(preparedStatement, connexion,   resultSet );
				}
			}else {
				System.out.println("erreur");
				to_return = -1;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return to_return;
	}

	
	/**
	 * <p>delete in the database</p>
	 * @author ansary.marecar
	 */
	public int delete( Type_sensor param_type_sensor ) throws SQLException {
		// TODO Auto-generated method stub
		//Remove
		int to_return = 0	;
		//if(!ifFind(param_type_sensor)) {
		
			String SQL_DELETE = " DELETE FROM type_sensor WHERE type_sensor_id = ? ; 	";
			Connection connexion = null;
			PreparedStatement preparedStatement = null;
			int status = 0;
			//if( param_type_sensor.getType_sensor_id() >= 0 ) {
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
			        	 throw new DAOException( "cannot delete" );
			        }else {
			        	to_return = -4;
			        }
			    } catch ( SQLException e ) {
			        throw new DAOException( e );
			    } finally {
			    	DAOUtility.closeStatementConnection(preparedStatement, connexion);
			    }
			//}
		//}else {
			//to_return = -2;
		//}
		return to_return;
	}

	public int update( Type_sensor param_type_sensor ) throws SQLException {
		int to_return = 0	;
		//if(ifFind(param_type_sensor)) {
			String SQL_UPDATE = "UPDATE type_sensor set type_sensor_name = ? WHERE type_sensor.type_sensor_id = ?";
			Connection connexion = null;
			PreparedStatement preparedStatement = null;
			    
			    Type_sensor var_type_sensor = null;
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
			        	 throw new DAOException( "cannot update" );
			        }else {
			        	to_return = -4;
			        }
			    } catch ( SQLException e ) {
			        throw new DAOException( e );
			    } finally {
			    	DAOUtility.closeStatementConnection(preparedStatement, connexion);
			    }
		//}
		//else{
		//	to_return = -1;
		//}
		return to_return;
	}

	public boolean ifFind(Type_sensor param_type_sensor) throws SQLException {
		// TODO Auto-generated method stub
		// verification of the presence of the same value in the data base
		ResultSet 	var_resultSet 	= null						 ;
		boolean to_return = false;
		////////////////////////////////////////////////////////////
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
		// TODO Auto-generated method stub
		ResultSet 	var_resultSet 	= null						 ;
		ArrayList<Type_sensor> var_table						 ;
		var_table = new ArrayList<Type_sensor>()	 			 ;
		boolean to_return = false;
		////////////////////////////////////////////////////////////
		String SQL_SELECTALL = "SELECT * from type_sensor ";
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    
	    ResultSet resultSet = null;
	    ResultSet valeursAutoGenerees = null;
	    
	    Type_sensor var_type_sensor = null;
	    int status = 0;
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

	private static Type_sensor map( ResultSet resultSet ) throws SQLException {
	    Type_sensor var_type_sensor = new Type_sensor();
	    
	    var_type_sensor.setType_sensor_id( resultSet.getInt( "id" ) );
	    var_type_sensor.setType_sensor_name( resultSet.getString( "nom" ) );
	    return var_type_sensor;
	}
	
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	


}


