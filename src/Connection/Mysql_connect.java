/**
 * 
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author @mansa
 *
 */
public class Mysql_connect {
	/**
	 * URL connexion
	 */
    
	private static 	String 		url 		= "jdbc:mysql://localhost:3306/maao";
	/**
	 * Name user
	 */
	private static 	String 		user 		= "root";
	/**
	 * password user
	 */
	private static 	String 		password 	= ""	;
	/**
	 * Object Connection
	 */
	private static 	Connection 	connect				;
	
	private static 	Statement 	statement	= null	;
	private static	ResultSet 	resultSet 	= null	;
	
	/**
	 * 
	 * ...
	 * @return
	 */
	public static Connection getInstance(){
        // Setup the connection with the DB
      
		if(connect == null){
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connect = DriverManager.getConnection(url, user, password);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return connect;	
	}
	
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if(statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}