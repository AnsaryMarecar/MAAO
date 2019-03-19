package socketserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerAdaptor {
	
	
	public static void main(String[] args) throws IOException {
		ServerSocket socketServer;
		Socket socketofServer;
		InetAddress localAdress;
		PrintWriter out;
		try {
			localAdress= InetAddress.getLocalHost();
			socketServer = new ServerSocket(5009, 1000,localAdress );
			socketofServer= socketServer.accept();
			System.out.println("Quelqu'un est connecté");
			out = new PrintWriter(socketofServer.getOutputStream());
	        out.println("Vous êtes connecté zéro !");
	        out.flush();
			
			socketServer.close();
			socketofServer.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		

	}
}
