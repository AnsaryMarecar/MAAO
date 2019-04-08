package org.secure.retirement.home.service;
/**
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public interface DAO<T> {
	
	
	public abstract boolean create(T obj) 		throws SQLException;
	public abstract boolean delete(int id)	 	throws SQLException;
	public abstract boolean update(T obj) 		throws SQLException;
	public abstract boolean ifFind(T obj) 		throws SQLException;
	public abstract T find(int id) 				throws SQLException;
	public abstract void close()				throws SQLException;
	public abstract ArrayList<T> presentData() 	throws SQLException;

	
}