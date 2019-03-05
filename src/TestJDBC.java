import java.sql.*;
import java.text.MessageFormat;
import java.util.*;

import com.mysql.jdbc.Statement;

public class TestJDBC {
	public static void main(String[] args) {    
		save("momo");
	}
	public static void save(String nb) {
		String an_url 			= "jdbc:mysql://127.0.0.1:3306/maao";
	    String an_user 			= "root";
	    String a_password 		= "toto";
	    Connection a_connection = null;
	    Statement a_statement = null;
	    /* Connexion � la base de donn�es */
	    String url = "jdbc:mysql://localhost:3306/maao";
	    String utilisateur = "root";
	    String motDePasse = "";
	    Connection connexion = null;
	    try {
	        connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
	        /* Cr�ation de l'objet g�rant les requ�tes */
	        java.sql.Statement statement = connexion.createStatement();
	        /* Ex�cution d'une requ�te d'�criture */
	        int statut = statement.executeUpdate( "INSERT INTO maao.role (role_name) VALUES ('Admin')" );
	        /* Ici, nous placerons nos requ�tes vers la BDD */
	        /* ... */

			/* Formatage pour affichage dans la JSP finale. */
			//Message.add( "R�sultat de la requ�te d'insertion : " + statut + "." );
	    } catch ( SQLException e ) {
	    	
	        /* G�rer les �ventuelles erreurs ici */
	    } finally {
	        if ( connexion != null )
	            try {
	                /* Fermeture de la connexion */
	                connexion.close();
	            } catch ( SQLException ignore ) {
	                /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
	            }
	    }
	    

	}
}