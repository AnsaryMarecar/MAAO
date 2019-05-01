/**
 * 
 */
package org.secure.retirement.home.common;

/**
 * @author Ansary MARECAR
 *
 */
public class Sensor {
	private int sensor_id;
	private Type_sensor type_sensor;
	
	
	/**
	 * @param sensor_id
	 * @param type_sensor
	 */
	public Sensor(int sensor_id, Type_sensor type_sensor) {
		super();
		this.sensor_id = sensor_id;
		this.type_sensor = type_sensor;
	}
	public Sensor(int param_sensor_id) {
		// TODO Auto-generated constructor stub
		this.sensor_id = param_sensor_id;
	}
	public int getSensor_id() {
		return sensor_id;
	}
	public void setSensor_id(int sensor_id) {
		this.sensor_id = sensor_id;
	}
	/**
	 * @return the type_sensor
	 */
	public Type_sensor getType_sensor() {
		return type_sensor;
	}
	/**
	 * @param type_sensor the type_sensor to set
	 */
	public void setType_sensor(Type_sensor type_sensor) {
		this.type_sensor = type_sensor;
	}
		
}
