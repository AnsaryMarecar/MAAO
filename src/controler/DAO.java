package controler;
/**
 * 
 */

/**
 * @author Ansary & Amine
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public abstract class DAO<T> {
	public  static Connection 	connect				= null 	;
	private Statement 			statement 			= null	;
	private PreparedStatement 	preparedStatement 	= null	;
	private ResultSet 			resultSet 			= null	;
	
	public DAO(Connection c) throws Exception {
		try {
			this.connect = c 								;
			System.out.println("DOASTAIR : "+connect)		;
		}
		catch (Exception e) {
	            throw e;
	    }
	}

	public abstract boolean create(T obj) 		throws SQLException;
	public abstract boolean delete(int id)	 	throws SQLException;
	public abstract boolean update(T obj) 		throws SQLException;
	public abstract boolean ifFind(T obj) 		throws SQLException;
	public abstract T find(int id) 				throws SQLException;
	public abstract void close()				throws SQLException;
	public abstract ArrayList<T> presentData() 	throws SQLException;

	/**
	 * @return the preparedStatement
	 * object method : this method is necessair for request
	 */
	public PreparedStatement getPreparedStatement() {
		return preparedStatement				;
	}

	/**
	 * @param preparedStatement the preparedStatement to set
	 */
	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}
}