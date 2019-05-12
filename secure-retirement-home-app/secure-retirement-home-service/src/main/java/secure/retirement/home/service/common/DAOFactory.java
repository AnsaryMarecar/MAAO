package secure.retirement.home.service.common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.secure.retirement.home.common.*;
import org.secure.retirement.home.common.exception.DAOConfigurationException;

/**
 * <p>Have a connexion with the database</p>
 */

public class DAOFactory {

    private static final 	String FILE_PROPERTIES			= "db.properties";
    private static final 	String PROPERTY_LINK			= "link"		 ;
    private static final 	String PROPERTY_DRIVER			= "driver"		 ;
    private static final 	String PROPERTY_USER_NAME 		= "username"	 ;
    private static final 	String PROPERTY_PASSWORD		= "password"	 ;

    private String              link	;
    private String              username;
    private String              password;

    DAOFactory( String param_link, String param_username, String param_password ) {
        this.link 		= param_link	;
        this.username 	= param_username;
        this.password 	= param_password;
    }
    
    /**
     * <p>parsing and create connection</p>
     * 
     * @return
     * @throws DAOConfigurationException
     * 
     * @author ansary.marecar
     */
    public static DAOFactory getInstance() throws DAOConfigurationException {
        Properties 	var_properties 	= new Properties()	;
        String 		var_link							;
        String 		var_driver							;
        String 		var_username						;
        String 		var_password						;
        DAOFactory 	var_instance = null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        
        InputStream fileProperties = classLoader.getResourceAsStream(FILE_PROPERTIES );        
        
        if ( fileProperties == null ) {
        	System.out.println( "We cannot find the " + FILE_PROPERTIES + " file." );
            throw new DAOConfigurationException( "the file:  " + FILE_PROPERTIES + " does not exist." );
        }
        else {
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
	        	 Class.forName( var_driver );
	        	var_instance = new DAOFactory( var_link, var_username, var_password );
	        } catch ( ClassNotFoundException exp ) {
	           throw new DAOConfigurationException( " the driver is not present in the path ", exp );
	        }
        }
        System.out.println("ss: "+var_instance);
        return var_instance;
    }

   public Connection getConnection() throws SQLException {
	   System.out.println("getCo");
       return DriverManager.getConnection( this.link, this.username, this.password );
   }
}