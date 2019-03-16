/**
 * 
 */
package controler;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * @author Oussama & Amine
 * @deprecated class deprecated
 */
public class ConnectionBDD {
	protected 	static Connection 	connect = null						;
	
	public static Connection getInst(){
		try {
			String url		=	"jdbc:mysql://localhost:3306/maao"		;
			String user		=	"root"									;
			String password	=	""										;
			
			Object newInstance = Class.forName("com.mysql.jdbc.Driver")	;
			connect= DriverManager.getConnection(url, user, password)	;
		}
		catch (Exception e) {
			e.printStackTrace()											;
			JOptionPane.showMessageDialog(null,"Error occured while connecting "
					+ "to database","",JOptionPane.ERROR_MESSAGE)		;
			}
		return connect													;
		}
}