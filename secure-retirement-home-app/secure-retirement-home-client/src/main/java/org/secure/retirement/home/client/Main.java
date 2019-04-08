package org.secure.retirement.home.client;

import java.util.ArrayList;

import org.secure.retirement.home.common.Type_sensor;
import org.secure.retirement.home.service.TimeServer;
import org.secure.retirement.home.common.*;
public class Main {

	   /**public static void main(String[] args) {
	    
	      String host = "127.0.0.1";
	      int port = 2345;
	      
	      TimeServer ts = new TimeServer(host, port);
	      ts.open();
	      System.out.println("Serveur initialisé.");
	      
	      ArrayList<Type_sensor> typesensors = new ArrayList<Type_sensor>();
	      typesensors.add(new Type_sensor(10,"capteur de chocolat SUCRE 10H07"));
	      
	      
	      String val = Encode.encoder(typesensors);
	      //for(int i = 0; i < 5; i++){
	      Thread t = new Thread(new ClientConnexion(host, port, val, val));
	      t.start();
	      //}
	   }**/
	}