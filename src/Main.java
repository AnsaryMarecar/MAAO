//import controler.DAOFactory;
import controler.DataSource;
import view.FirstF;
import view.WindowConnection;

public class Main {
	
	
	public static void main(String [] args) {
		
		//DAOFactory.getInstance();
		
		DataSource 			ds 	=	new DataSource()		;
		if (ds.fillCon().isEmpty()==false) {
			FirstF firstWindow = new FirstF();
		}
	}
}