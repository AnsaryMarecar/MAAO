package org.secure.retirement.home.client;

import org.secure.retirement.home.frame.*;
import java.util.ArrayList;

import org.secure.retirement.home.common.Encode;

public class ClientTransmission {
	
	public static void  transmission ( 	String element, String action_type,
										ArrayList<?> data, Frame param_frame) {
		String host = "127.0.0.1"		;
	    int port = 2345					;
	    //System.out.println(JDBCConnectionPool.displayConnex());
		String val_data = Encode.encoder(data);
		ArrayList<String> val_action_array = new ArrayList<String>();
		val_action_array.add(element)	;
		val_action_array.add(action_type);
		String val_action = Encode.encoder(val_action_array);
		System.out.println(val_action)	;
		System.out.println(val_data)	;
		ClientConnexion cc = new ClientConnexion(host, port, val_action, val_data,param_frame);
		Thread t = new Thread(cc)		;
		t.start()						;
	}
}
