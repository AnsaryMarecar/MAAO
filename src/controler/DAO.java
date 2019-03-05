package controler;
/**
 * 
 */

/**
 * @author mansa
 *
 */
import Connection.Mysql_connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public abstract class DAO<T> {
	public	 	Connection 			connect 			= Mysql_connect.getInstance();  
	private 	Statement 			statement 			= null;
	protected 	PreparedStatement 	preparedStatement 	= null;
	private 	ResultSet 			resultSet 			= null;
	
	public DAO() throws Exception {
		try {
		/**	// This will load the MySQL driver, each DB has its own driver
	        Class.forName("com.mysql.jdbc.Driver");
	        // Setup the connection with the DB
	        this.connect = DriverManager
	                  .getConnection("jdbc:mysql://localhost:3306/maao?"
	                  + "user=root&password=");
	        System.out.println("co ok"); **/
		}
		catch (Exception e) {
	            throw e;
	    }
		finally {
	            //close();
	    }
	}

			
	 private void close() {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }

	            if (statement != null) {
	                statement.close();
	            }

	            if (connect != null) {
	                connect.close();
	            }
	        } catch (Exception e) {
	        }
	 }
	 
	public abstract boolean create(T obj) 		throws SQLException;
	public abstract boolean delete(int id)	 	throws SQLException;
	public abstract boolean update(T obj) 		throws SQLException;
	public abstract boolean ifFind(T obj) 		throws SQLException;
	public abstract T find(int id) 				throws SQLException;
	public abstract ArrayList<T> presentData() 	throws SQLException;
}
