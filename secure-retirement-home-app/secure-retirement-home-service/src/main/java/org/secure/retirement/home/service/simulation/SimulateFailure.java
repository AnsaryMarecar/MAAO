/**
 * 
 */
package org.secure.retirement.home.service.simulation;

import java.sql.SQLException;

import org.secure.retirement.home.common.Historic;
import org.secure.retirement.home.common.Risk;

import secure.retirement.home.service.common.ConnectionPool;
import secure.retirement.home.service.common.DAOFactory;
import secure.retirement.home.service.common.JDBCConnectionPool;

/**
 * @author Ansary MARECAR
 *
 */
public class SimulateFailure extends Thread {

	private DAOFactory att_daofactory;
	/**
	 * 
	 */
	public SimulateFailure() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param target
	 */
	public SimulateFailure(Runnable target) {
		super(target);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 */
	public SimulateFailure(String name
			, DAOFactory param_daofactory
			) {
		super(name);
		//this.att_daofactory = param_daofactory;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param group
	 * @param target
	 */
	public SimulateFailure(ThreadGroup group, Runnable target) {
		super(group, target);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param group
	 * @param name
	 */
	public SimulateFailure(ThreadGroup group, String name) {
		super(group, name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param target
	 * @param name
	 */
	public SimulateFailure(Runnable target, String name) {
		super(target, name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param group
	 * @param target
	 * @param name
	 */
	public SimulateFailure(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param group
	 * @param target
	 * @param name
	 * @param stackSize
	 */
	public SimulateFailure(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);
		// TODO Auto-generated constructor stub
	}

	public void run(){
		int i;
		DAORisk element_dao;
		element_dao = new DAORisk(att_daofactory);
		try{
			while(true) {
			    Thread.sleep(1000);
			    System.out.println("true");
				for(i = 0; i < ConnectionPool.getAtt_sensors().size(); i++) {
					 if(ConnectionPool.getAtt_cache()[i].isFailure()) {
						 Risk val_risk = new Risk(ConnectionPool.getAtt_sensors().get(i));
						 try {
							 
							element_dao.create(val_risk);
						 } catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 }
				}
			}
		}
		catch(InterruptedException ex){
			Thread.currentThread().interrupt();
			//JDBCConnectionPool.AddConnection(att_daofactory);
		}	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
