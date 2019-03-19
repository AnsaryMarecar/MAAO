/**
 * 
 */
package connection.pool;

/**
 * <p>JDBC Connexion pool</p>
 * 
 * @author Oussama.bouachrine
 * @author amine.maza
 *
 */
import java.sql.*;
import java.util.ArrayList;

import dao.DAOFactory;

public class JDBCConnectionPool {		
	protected  static ArrayList<Connection> connex;
	protected static Connection con;
	
	/**
	 * <p>To initiate the number of connection the array will contain</p>
	 * 
	 * @author amine.maza
	 */
	public JDBCConnectionPool() {
		this.connex = new ArrayList<Connection>(5);	
	}
	 
	/**
	 * <p>To fill the array with connection's object</p>
	 * 
	 * @author Oussama.bouachrine
	 * @author amine.maza
	 *
	 */
	public  static ArrayList<Connection> fillCon(){
		Connection var_connection = DAOFactory.getInstance();
		if (var_connection!= null) {
			for(int i=0; i<4;i++) { 
				if(i==0) {
					connex.add(var_connection);
				}
				else {
					connex.add(DAOFactory.getInstance());
				}
				//connex.add(ConnectionBDD.getInst());
			}
		}
		return connex;
	}
	
	// to return the content of connex
	public static ArrayList<Connection> displayConnex() {
		return connex ;
	}

	// to give a connection to the user
	public  static Connection getConnection() {	 
			con= connex.get(0);
			connex.remove(0);
			return con;
	}
	
	// To use the same object connection per user
	public static Connection useConnect() {
		return con;
	}

	// to return the connection after finish with using it
	public static boolean backCo(Connection con) { 
			 return  connex.add(con);
	}
	

	// to close all connection
	public static void closeAllConnection() {
		
		if (connex.isEmpty()==false) {
			connex.clear();
		}
	}
}