package org.secure.retirement.home.service;

import secure.retirement.home.service.common.ConnectionPool;
import secure.retirement.home.service.common.JDBCConnectionPool;

public class AppServer {
	public static void main(String[] args) {
		System.out.println(JDBCConnectionPool.displayConnex());
		JDBCConnectionPool.initializList();
		System.out.println(JDBCConnectionPool.displayConnex());
	    ConnectionPool ts = new ConnectionPool();
	    ts.open();
	    System.out.println("Initializ server");
	}
}