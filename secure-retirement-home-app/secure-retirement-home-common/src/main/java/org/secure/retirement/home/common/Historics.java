/**
 * 
 */
package org.secure.retirement.home.common;

import java.util.ArrayList;

/**
 * @author Ansary MARECAR
 *
 */
public class Historics{
	private int sensor_id;
	private ArrayList<Historic> historic_array;
	
	public Historics(int sensor_id, ArrayList<Historic> historic_array) {
		this.sensor_id = sensor_id;
		this.historic_array = historic_array;
	}
	/**
	 * @return the historics_id
	 */
	public int getHistorics_id() {
		return sensor_id;
	}
	/**
	 * @param historics_id the historics_id to set
	 */
	public void setHistorics_id(int sensor_id) {
		this.sensor_id = sensor_id;
	}
	/**
	 * @return the historic_array
	 */
	public ArrayList<Historic> getHistoric_array() {
		return historic_array;
	}
	/**
	 * @param historic_array the historic_array to set
	 */
	public void setHistoric_array(ArrayList<Historic> historic_array) {
		this.historic_array = historic_array;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Historics [getHistorics_id()=" + getHistorics_id() + ", getHistoric_array()=" + getHistoric_array()
				+ "]";
	}
	
	
	
}
