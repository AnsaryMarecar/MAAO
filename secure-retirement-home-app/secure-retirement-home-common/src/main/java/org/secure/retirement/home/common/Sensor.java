/**
 * 
 */
package org.secure.retirement.home.common;

/**
 * @author Ansary MARECAR
 *
 */
public class Sensor {
	private int sensor_id = 0;
	private int sensor_status;
//	private Zone zone_id;
	private Type_sensor type_sensor = null;
//  private Risq risq_id;	
	
	
	

	public Sensor(int sensor_id, Type_sensor type_sensor, int sensor_status ) {
		super();
		this.sensor_id = sensor_id;
		this.type_sensor = type_sensor;
		this.sensor_status = sensor_status;
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
	public int getSensor_status() {
		return sensor_status;
	}
	public void setSensor_status(int sensor_status) {
		this.sensor_status = sensor_status;
	}

}
