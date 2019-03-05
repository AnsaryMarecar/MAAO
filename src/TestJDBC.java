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
	    /* Connexion à la base de données */
	    String url = "jdbc:mysql://localhost:3306/maao";
	    String utilisateur = "root";
	    String motDePasse = "";
	    Connection connexion = null;
	    try {
	        connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
	        /* Création de l'objet gérant les requêtes */
	        java.sql.Statement statement = connexion.createStatement();
	        /* Exécution d'une requête d'écriture */
	        int statut = statement.executeUpdate( "INSERT INTO maao.role (role_name) VALUES ('Admin')" );
	        /* Ici, nous placerons nos requêtes vers la BDD */
	        /* ... */

			/* Formatage pour affichage dans la JSP finale. */
			//Message.add( "Résultat de la requête d'insertion : " + statut + "." );
	    } catch ( SQLException e ) {
	    	
	        /* Gérer les éventuelles erreurs ici */
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