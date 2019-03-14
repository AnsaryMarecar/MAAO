/**
 * 
 */
package controler;

/**
 * @author Oussama & Amine
 *
 */
import java.sql.*;
import java.util.ArrayList;

public class JDBCConnectionPool {		
	protected  static ArrayList<Connection> connex;
	
	public JDBCConnectionPool() {
		this.connex = new ArrayList<Connection>(20);	
	}
	 
	public  static void remplir(){
		for(int i=0; i<2;i++) { 
			connex.add(ConnectionBDD.getInst());
		}
	}
	
	public  static Connection getConnection() {	 
			return connex.remove(0);
	}

	public static boolean retourner(Connection connect) { 
			 return  connex.add(connect);
	}
	
	public static void fermerConnection(Connection connect) {	
		try {
			if (connect !=null) {
				connect.close();
       	 	}
		}     	 
       	catch (Exception e) {
       		 e.printStackTrace();
       		 System.out.println("Error occured while deconnecting to database");
        }
	}
}