/**
 * 
 */
package controler;

/**
 * @author Oussama & Amine
 *
 */
import java.sql.*;

import controler.JDBCConnectionPool;


public class DataSource extends JDBCConnectionPool{
	
	public static JDBCConnectionPool jd;
	
	public DataSource() {
		
	}
	
	public static Connection renvoieConex() {
		return (jd.getConnection());	
	}
	
	public static void remetConex(Connection con) {
		System.out.println(jd.retourner(con));
	}
	
	public static void clotAtr(Connection con){
		
		jd.fermerConnection(con);
	}
}