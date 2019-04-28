package org.secure.retirement.home.service;

import org.secure.retirement.home.service.JDBCConnectionPool;

public class AppServer {
	public static void main(String[] args) {
		System.out.println(JDBCConnectionPool.displayConnex());
		JDBCConnectionPool.initializList();
		System.out.println(JDBCConnectionPool.displayConnex());
		
		//String host = "127.0.0.1";
	    //int port = 2345;
	      
	    ConnectionPool ts = new ConnectionPool();
	    ts.open();
	    System.out.println("Initializ server");
	}
}
