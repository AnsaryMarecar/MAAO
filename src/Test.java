import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
   public class Test
   {
       public static void main (String[] args)
       {
           System.out.println("\n\n***** Test MySQL JDBC Connection *****");
		   Connection conn = null;
           try
           {
               String userName = "root";
               String password = "";
               String url = "jdbc:MySQL://127.0.0.1/maao";  
               System.out.println("\n\n***** new instance *****");
    		   Object newInstance = Class.forName("com.mysql.jdbc.Driver");
    		   conn = DriverManager.getConnection (url, userName, password);
               System.out.println ("\nDatabase Connection Established...");
           }
          catch (Exception e)
           {
		       //System.err.println ("Cannot connect to database server");
			   e.printStackTrace();
           }      
		   
		   finally
           {
               if (conn != null)
               {
                   try
                   {
                       System.out.println("\n***** Let terminate the Connection *****");
					   conn.close ();					   
                       System.out.println ("\nDatabase connection terminated...");
                   }
                   catch (Exception e)
				   {
				   System.out.println ("Error in connection termination!");
				   }
               }
           }
       }
   }
 