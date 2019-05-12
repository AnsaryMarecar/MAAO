/**
 * 
 */
package org.secure.retirement.home.service.simulation;

import secure.retirement.home.service.common.ConnectionPool;

/**
 * @author Ansary MARECAR
 *
 */
public class SimulateFailure extends Thread {

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
	public SimulateFailure(String name) {
		super(name);
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
		while(true) {
			try{
			    Thread.sleep(1000);
			    System.out.println("true");
				for(i = 0; i < ConnectionPool.getAtt_sensors().size(); i++) {
					ConnectionPool.getAtt_cache()[i].isFailure();
				}
			}
			catch(InterruptedException ex){
			    Thread.currentThread().interrupt();
			}
			
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
