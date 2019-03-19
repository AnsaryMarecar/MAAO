package socketclient;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ClientAdapteur {



	public static void main(String[] args) {
		
			InetAddress LocaleAdresse ;
			BufferedReader in;
	try {
		Socket socket;
		
			LocaleAdresse = InetAddress.getLocalHost();
			System.out.println("L'adresse locale est : "+LocaleAdresse );
			
			   socket = new Socket( LocaleAdresse,5009);	
			   System.out.println("Demande de connexion");
			   in = new BufferedReader ( new InputStreamReader (socket.getInputStream()));
			   String message_dist = in.readLine();
			   System.out.println(message_dist);
			   
	           socket.close();

			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
	catch (IOException e) {
		
		e.printStackTrace();
	}

	}
	}

