package org.secure.retirement.home.service;
/**
 * 
 */

import java.sql.SQLException;
import java.util.ArrayList;

import org.secure.retirement.home.common.Return_information;
public interface DAO<T> {
	
	
	public abstract Return_information create(T obj) 		throws SQLException;
	public abstract Return_information delete(T obj)	 	throws SQLException;
	public abstract Return_information update(T obj) 		throws SQLException;
	public abstract Return_information select(T obj) 		throws SQLException;
	public abstract boolean ifFind(T obj) 		throws SQLException;
	public abstract T find(int id) 				throws SQLException;
	public abstract void close()				throws SQLException;
	public abstract ArrayList<T> presentData() 	throws SQLException;

	
}