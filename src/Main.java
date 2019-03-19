//import controler.DAOFactory;
import connection.pool.DataSource;
import frame.FirstF;
import frame.WindowConnection;

public class Main {
	
	
	public static void main(String [] args) {
		
		//DAOFactory.getInstance();
		
		DataSource 			ds 	=	new DataSource()		;
		if (ds.fillCon().isEmpty()==false) {
			FirstF firstWindow = new FirstF();
		}
	}
}