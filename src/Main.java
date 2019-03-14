import controler.DataSource;
import view.WindowConnection;
/**
 * @author 
 *
 */
public class Main {

	public static void main(String [] args) {
		DataSource 			ds 	=	new DataSource()		;
		ds.remplir();
		for(int i = 1 ; i<4  ; i++) {
			new WindowConnection(i)	;
		}
	}
}