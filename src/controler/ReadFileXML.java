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
 * <p>parsing an XML file</p>
 *
 * @author oussama.bouachrine
 *
 */
public class ReadFileXML {
	//connection attribute
	protected 	static String 			value			;
	protected 	static String 			key				;
	
	// other attribute
	protected 	static Enumeration<?> 	enumeration		;
	public 		static Connection c						;
		
	/**
	 * <p>this method do a reading of xml file</p>
	 * 
	 * @param champ1
	 * @param champ2
	 * @return 
	 * @throws IOException
	 * 
	 * @author oussama.bouachrine
	 */
	public boolean readFile(String champ1, String champ2) throws IOException{
		Properties p = new Properties()					;
		boolean bool=false;
		
		try (FileInputStream xml_file = new FileInputStream("properties.xml")){
			p.loadFromXML(xml_file)						;
			enumeration = p.propertyNames() 			;
			while (enumeration.hasMoreElements()){
				key = (String) enumeration.nextElement();
				value = p.getProperty(key)				;
				System.out.println("key: "+key)			;
				if(key.equals(champ1) && value.equals(champ2)) {
			 			c = DataSource.useConnect();
			 			new WindowStair(c); // open the next window
			 			return true;
				}
				else {
					JOptionPane.showMessageDialog(null,"Your id or password is incorrect");
					return false;
				} 
			}
			
		} 
		catch (Exception e) {
		}
		return bool;
	}
}