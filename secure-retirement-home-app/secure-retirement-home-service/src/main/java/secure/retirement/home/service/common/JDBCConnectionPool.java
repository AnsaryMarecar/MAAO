/**
 * 
 */
package secure.retirement.home.service.common;

/**
 * <p>JDBC Connexion pool</p>
 *
 */
import java.util.ArrayList;



public class JDBCConnectionPool {		


	private 	static 	DAOFactory 				att_daofactory			;
	private 	static	int			 			att_number_connection=5	;
	private  	static 	ArrayList<DAOFactory> 	att_list=new ArrayList<DAOFactory>()		;
	
	/**
	 * <p>To initiate the number of connection the array will contain</p>
	 */
	public JDBCConnectionPool() {
	}
	 
	/**
	 * <p>To fill the array with connection's object</p>
	 * 
	 * @author Oussama.bouachrine
	 * @author amine.maza
	 *
	 */
	public  static ArrayList<DAOFactory> initializList(){
		//System.out.println("nb " + att_number_connection);
		DAOFactory var_daofactory = DAOFactory.getInstance();
		if (var_daofactory!= null) {
			for(int i=0; i<att_number_connection;i++) { 
				if(i==0) {
					att_list.add(var_daofactory);
				}
				else {
					att_list.add(DAOFactory.getInstance());
				}
				//connex.add(ConnectionBDD.getInst());
			}
		}
		return att_list;
	}
	
	// to return the content 
	public static ArrayList<DAOFactory> displayConnex() {
		return att_list ;
	}

	// to give a connection
	public  static DAOFactory getConnection() {	 
			//System.out.println("getConnection");
			att_daofactory = att_list.get(0);
			att_list.remove(0);
			return att_daofactory;
	}

	// to return the connection after finish with using it
	public static boolean AddConnection(DAOFactory param_daofactory) { 
			 return  att_list.add(param_daofactory);
	}
	

	// to close all connection
	public static void closeAllConnection() {
		
		if ( att_list.isEmpty()	==	false	) {
			att_list.clear();
		}
	}
}