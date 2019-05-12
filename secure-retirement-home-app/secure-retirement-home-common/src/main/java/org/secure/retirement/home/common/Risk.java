/**
 * 
 */
package org.secure.retirement.home.common;


/**
 * @author Ansary MARECAR
 *
 */
public class Risk {
	private int risk_id = 0;
	private Sensor sensor = null;
	private Historic historic = null;
	
	/**
	 * 
	 */
	public Risk() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param risk_id
	 * @param sensor
	 * @param historic
	 */
	public Risk(int risk_id, Sensor sensor, Historic historic) {
		super();
		this.risk_id = risk_id;
		this.sensor = sensor;
		this.historic = historic;
	}
	
	/**
	 * @param historic
	 * @param sensor
	 */
	public Risk(Sensor sensor, Historic historic) {
		super();
		this.historic = historic;
		this.sensor = sensor;
	}



	/**
	 * @return the risk_id
	 */
	public int getRisk_id() {
		return risk_id;
	}

	/**
	 * @param risk_id the risk_id to set
	 */
	public void setRisk_id(int risk_id) {
		this.risk_id = risk_id;
	}

	/**
	 * @return the sensor
	 */
	public Sensor getSensor() {
		return sensor;
	}

	/**
	 * @param sensor the sensor to set
	 */
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the historic
	 */
	public Historic getHistoric() {
		return historic;
	}

	/**
	 * @param historic the historic to set
	 */
	public void setHistoric(Historic historic) {
		this.historic = historic;
	}

}
