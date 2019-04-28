package org.secure.retirement.home.common;

import javax.print.attribute.DateTimeSyntax;
import org.secure.retirement.home.common.Sensor;
/**
 * @author Ansary MARECAR
 *
 */
public class Historic {
	
	private int 			historic_id			;
	private Sensor 			sensor				;
	private DateTimeSyntax 	historic_datetime	;
	private double			historic_value		;
	
	
	
	public Historic(int historic_id, Sensor sensor, DateTimeSyntax historic_datetime, double historic_value) {

		this.historic_id = historic_id;
		this.sensor = sensor;
		this.historic_datetime = historic_datetime;
		this.historic_value = historic_value;
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
	}
	
	/**
	 * @param sensor
	 * @param historic_value
	 */
	public Historic(Sensor sensor, double historic_value) {

		this.sensor = sensor;
		this.historic_value = historic_value;
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
	 * @param sensor the sensor to set
	 */
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	/**
	 * @return the historic_datetime
	 */
	public DateTimeSyntax getHistoric_datetime() {
		return historic_datetime;
	}
	/**
	 * @param historic_datetime the historic_datetime to set
	 */
	public void setHistoric_datetime(DateTimeSyntax historic_datetime) {
		this.historic_datetime = historic_datetime;
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
		return "Historic [historic_id=" + historic_id + ", sensor=" + sensor + ", historic_datetime="
				+ historic_datetime + ", historic_value=" + historic_value + "]";
	}
}
