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
	
	public DAO(){
	}
	 
	public abstract boolean create(T obj) 		throws SQLException;
	public abstract boolean delete(int id)	 	throws SQLException;
	public abstract boolean update(T obj) 		throws SQLException;
	public abstract boolean ifFind(T obj) 		throws SQLException;
	public abstract T find(int id) 				throws SQLException;
	public abstract ArrayList<T> presentData() 	throws SQLException;
}
