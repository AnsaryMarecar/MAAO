/**
 * 
 */
package org.secure.retirement.home.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.secure.retirement.home.service.*;

/**
 * @author Ansary MARECAR
 *
 */
public class DAOUtility {

	/**
	 * 
	 */
	public DAOUtility() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * <p>Initilization of the prepared request with connexion, resquest and object in parameters </p>
	 * 
	 * @param param_connexion
	 * @param param_sql
	 * @param param_returnGeneratedKeys
	 * @param param_objets
	 * @return PreparedStatement
	 * @throws SQLException
	 */
	public static PreparedStatement initPreparedRequest(
				Connection 	param_connexion
			,	String 		param_sql
			,	boolean 	param_returnGeneratedKeys
			,	Object... 	param_objets 
			) throws SQLException {
		
	    PreparedStatement r_preparedStatement = param_connexion.prepareStatement( 
	    			param_sql
	    		,	param_returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
	    for ( int i = 0; i < param_objets.length; i++ ) {
	        r_preparedStatement.setObject( i + 1, param_objets[i] );
	    }
	    return r_preparedStatement;
	}

	
	/* Fermeture silencieuse du resultset */
	public static void closeResultSet( ResultSet param_resultSet ) {
	    if ( param_resultSet != null ) {
	        try {
	            param_resultSet.close();
	        } catch ( SQLException e ) {
	            System.out.println( "We cannot closed the ResultSet : " + e.getMessage() );
	        }
	    }
	}

	/* Fermeture silencieuse du statement */
	public static void closeStatement( PreparedStatement param_statement ) {
	    if ( param_statement != null ) {
	        try {
	            param_statement.close();
	        } catch ( SQLException e ) {
	            System.out.println( "We cannot closed the Statement : " + e.getMessage() );
	        }
	    }
	}

	/* Fermeture silencieuse de la connexion */
	public static void closeConnection( Connection param_connetion ) {
	    if ( param_connetion != null ) {
	        try {
	        	param_connetion.close();
	        } catch ( SQLException e ) {
	            System.out.println( "We cannot closed the connexion : " + e.getMessage() );
	        }
	    }
	}

	/* Fermetures silencieuses du statement et de la connexion */
	public static void closeStatementConnection( PreparedStatement param_statement, Connection param_connection ) {
	    closeStatement( param_statement )	;
	    closeConnection( param_connection )	;
	}

	/* Fermetures silencieuses du resultset, du statement et de la connexion */
	public static void closeAll( 
				PreparedStatement param_statement
			,	Connection param_connection
			,	ResultSet param_resultSet
			) {
	    closeResultSet( param_resultSet );
	    closeStatementConnection( param_statement, param_connection );
	}

}
