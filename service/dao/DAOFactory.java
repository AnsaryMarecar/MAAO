package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <p>Have a connexion with the database</p>
 * @author ansary.marecar
 * @author amine.maza
 *
 */

public class DAOFactory {

    private static final 	String FILE_PROPERTIES			= "db.properties"	;
    private static final 	String PROPERTY_LINK			= "link"		;
    private static final 	String PROPERTY_DRIVER			= "driver"		;
    private static final 	String PROPERTY_USER_NAME 		= "username"	;
    private static final 	String PROPERTY_PASSWORD		= "password"	;

    DAOFactory() {
    }

    
    /**
     * <p>parsing and create connection</p>
     * 
     * @return
     * @throws DAOConfigurationException
     * 
     * @author ansary.marecar
     * @author amine.mazza
     */
    public static Connection getInstance() throws DAOConfigurationException {
        Properties 	var_properties 	= new Properties()	;
        String 		var_link							;
        String 		var_driver							;
        String 		var_username						;
        String 		var_password						;
        Connection 	var_connection 	= null				;
        
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        
        InputStream fileProperties = classLoader.getResourceAsStream(FILE_PROPERTIES );        
        
        if ( fileProperties == null ) {
        	System.out.println( "We cannot find the " + FILE_PROPERTIES + " file." );
            throw new DAOConfigurationException( "the file:  " + FILE_PROPERTIES + " does not exist." );
        }
        
        //attribute value
        try {
            var_properties.load( fileProperties )													;
            var_link 		= ( String ) var_properties.getProperty( PROPERTY_LINK )				;
            var_driver 		= ( String ) var_properties.getProperty( PROPERTY_DRIVER )				;
            var_username 	= ( String ) var_properties.getProperty( PROPERTY_USER_NAME )			;
            var_password 	= ( String ) var_properties.getProperty( PROPERTY_PASSWORD )			;
            System.out.println( "link: " + var_link + " Driver: " + var_driver
            		+" username: " + var_username + " password: " + var_password )					;	
        } 
        catch ( Exception exp ) {
            throw new DAOConfigurationException( " we have difficulty to charge the file : " + FILE_PROPERTIES, exp );
        }

        try {
        	Object newInstanceDriver = Class.forName( var_driver );
        } catch ( ClassNotFoundException exp ) {
           throw new DAOConfigurationException( " the driver is not present in the path ", exp );
        }
        
        //create an object instance with connection
        //DAOFactory instance = new DAOFactory( var_link, var_username, var_password );
        
        try {	
			var_connection = DriverManager.getConnection( var_link, var_username, var_password );
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			throw new DAOConfigurationException( " somethings is wrong (username, password or link) for the connection to the database ", exp );
		}
        System.out.println( " var_connection: " + var_connection );
        return var_connection;
    }


    /*
     * 
     */
    //public DAOStair getDAOStair() {
    //   return new DAOStair(this);
    //}
}