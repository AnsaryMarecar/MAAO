/**
 * 
 */
package org.secure.retirement.home.service.simulation;

import java.util.ArrayList;

/**
 * @author Ansary MARECAR
 *
 */
public class AnalysisRisk extends Analysis{
	private int	att_sensor_id;
	private double att_value;
	//private int	att_type_sensor;
	
	/**
	 * @param att_sensor_id
	 * @param att_value
	 */
	public AnalysisRisk(int param_sensor_id, double param_value) { 
			//, int param_type_sensor) {
		super();
		this.att_sensor_id = param_sensor_id;
		this.att_value = param_value;
	}
	
	
	/**
	 * @return the att_sensor_id
	 */
	public int getAtt_sensor_id() {
		return att_sensor_id;
	}
	/**
	 * @param att_sensor_id the att_sensor_id to set
	 */
	public void setAtt_sensor_id(int att_sensor_id) {
		this.att_sensor_id = att_sensor_id;
	}
	/**
	 * @return the att_value
	 */
	public double getAtt_value() {
		return att_value;
	}
	/**
	 * @param att_value the att_value to set
	 */
	public void setAtt_value(double att_value) {
		this.att_value = att_value;
	}
	
	public ArrayList<?> seeMyLastValueCach() {
		ArrayList<?> to_return = new ArrayList();
		//TO DO NOT THERE cach
		//TO DO THERE reflex of how to take the cach
		return to_return;
	}
}

