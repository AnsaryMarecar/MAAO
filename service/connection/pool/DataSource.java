/**
 * 
 */
package connection.pool;

/**
 * @author Oussama.bouachrine
 *
 */
import java.sql.*;


public class DataSource extends JDBCConnectionPool{
	
	public static JDBCConnectionPool jd;
	
	public DataSource() {
		
	}
	
	public static Connection returnConex() {
		return (jd.getConnection());	
	}
	
	public static void remetConex(Connection con) {
		System.out.println(jd.backCo(con));
		
	}

}