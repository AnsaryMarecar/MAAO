package socketserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerAdaptor {
	
	
	public static void main(String[] args)  {
		ServerSocket socketserver  ;
		Socket socketduserveur ;
		BufferedReader in;
		PrintWriter out;
		
		try {
		
			socketserver = new ServerSocket(2009);
			JOptionPane.showMessageDialog(null, "Le serveur est à l'écoute du port "+socketserver.getLocalPort(),  "serveur", JOptionPane.ERROR_MESSAGE);
			System.out.println("Le serveur est à l'écoute du port "+socketserver.getLocalPort());
			socketduserveur = socketserver.accept(); 
			JOptionPane.showMessageDialog(null, "Un zéro s'est connecté",  "serveur", JOptionPane.ERROR_MESSAGE);
		        System.out.println("Un zéro s'est connecté");
			out = new PrintWriter(socketduserveur.getOutputStream());
			JOptionPane.showMessageDialog(null, "Vous êtes connecté zéro !",  "serveur", JOptionPane.ERROR_MESSAGE);
		        out.println("Vous êtes connecté zéro !");
		        out.flush();
		                
		        socketduserveur.close();
		        socketserver.close();
		        
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
