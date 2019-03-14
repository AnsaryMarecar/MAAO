/**
 * 
 */
package controler;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.Properties;
import javax.swing.JOptionPane;

import view.WindowStair;

/**
 * @author Oussama & Amine
 *
 */
public class ReadFichier {
	//identifiant connexion atribut 
	protected 	static String 			value			;
	protected 	static String 			key				;
	
	// other atribut
	protected 	static Enumeration<?> 	enumeration		;
	public 		static Connection c						;
		
	/**
	 * 
	 * @param champ1
	 * @param champ2
	 * @throws IOException
	 * object method : this method do a reading of xml file
	 */
	public void readFile(String champ1, String champ2) throws IOException{
		Properties p = new Properties()					;
		
		try (FileInputStream xml_file = new FileInputStream("properties.xml")){
			p.loadFromXML(xml_file)						;
			enumeration = p.propertyNames() 			;
			while (enumeration.hasMoreElements()){
				key = (String) enumeration.nextElement();
				value = p.getProperty(key)				;
				System.out.println("key: "+key)			;
				if(key.equals(champ1) && value.equals(champ2)) {
					
			 		if (JDBCConnectionPool.connex.size()!=0) {
			 			c = DataSource.renvoieConex();
			 			new WindowStair(c); // open the next window
			 		}
			 		else {
			 			JOptionPane.showMessageDialog(null,"The number of connected person is too far, "
			 					+ "be patient and use it after");
			 		} 
			 		break;
				}
				else {
					JOptionPane.showMessageDialog(null,"Your id or password is incorrect");
					break;
				} 
			}
		} 
		catch (Exception e) {
		}			
	}
}