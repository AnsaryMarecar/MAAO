package org.secure.retirement.home.common;

import java.time.Instant;

import org.secure.retirement.home.common.Sensor;
/**
 * @author Ansary MARECAR
 *
 */
public class Historic {
	
	private int 			historic_id			= 0;
	private Sensor 			sensor				= null;
	private Instant 		historic_datetime	= Instant.now();
	private double			historic_value		= 0.0;
	
	
	
	public Historic(int historic_id, Sensor sensor, Instant historic_datetime, double historic_value) {

		this.historic_id = historic_id;
		this.sensor = sensor;
		this.historic_datetime = historic_datetime;
		this.historic_value = historic_value;
		this.historic_datetime = Instant.now();
		System.out.println(this.getHistoric_datetime());
	}
	 
	
	/**
	 * @param historic_id
	 * @param sensor
	 * @param historic_value
	 */
	public Historic(int historic_id, Sensor sensor, double historic_value) {

		this.historic_id = historic_id;
		this.sensor = sensor;
		this.historic_value = historic_value;
		this.historic_datetime = Instant.now();
		System.out.println(this.getHistoric_datetime());
	}
	
	/**
	 * @param sensor
	 * @param historic_value
	 */
	public Historic(Sensor sensor, double historic_value) {

		this.sensor = sensor;
		this.historic_value = historic_value;
		this.historic_datetime = Instant.now();
		this.historic_datetime = Instant.now();
		System.out.println(this.getHistoric_datetime());
	}

	/**
	 * @return the historic_id
	 */
	public int getHistoric_id() {
	
		return historic_id;
	}
	/**
	 * @param historic_id the historic_id to set
	 */
	public void setHistoric_id(int historic_id) {
	
		this.historic_id = historic_id;
	}
	/**
	 * @return the sensor
	 */
	public Sensor getSensor() {
		
		return sensor;
	}

	/**
	 * @return the historic_datetime
	 */
	public Instant getHistoric_datetime() {
		return historic_datetime;
	}

	/**
	 * @return the historic_value
	 */
	public double getHistoric_value() {
		return historic_value;
	}
	/**
	 * @param historic_value the historic_value to set
	 */
	public void setHistoric_value(double historic_value) {
		this.historic_value = historic_value;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Historic [getHistoric_id()=" + getHistoric_id() + ", getSensor()=" + getSensor()
				+ ", getHistoric_datetime()=" + getHistoric_datetime() + ", getHistoric_value()=" + getHistoric_value()
				+ "]";
	}
	

}
