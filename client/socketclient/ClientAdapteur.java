package socketclient;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class ClientAdapteur {



	public static void main(String[] args) {
		Socket socket;
		BufferedReader in;
		PrintWriter out;

		try {
		
			socket = new Socket(InetAddress.getLocalHost(),2009);	
			JOptionPane.showMessageDialog(null,"Demande de connexion",  "client", JOptionPane.ERROR_MESSAGE);
		        System.out.println("Demande de connexion");

		        in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		        String message_distant = in.readLine();
		    	JOptionPane.showMessageDialog(null,message_distant,  "client", JOptionPane.ERROR_MESSAGE);
		        System.out.println(message_distant);
		        
		        socket.close();
		       
		}catch (UnknownHostException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	}

