/**
 * 
 */
package org.secure.retirement.home.common;

/**
 * 
 *
 */
public class Sensor {
	private int sensor_id = 0;
	private Type_sensor type_sensor = null;
	private double sensor_min = 0;
	private double sensor_max = 0;
	/**
	 * @param type_sensor
	 * @param sensor_min
	 * @param sensor_max
	 * @param sensor_mac
	 * @param sensor_ip
	 * @param sensor_positionX
	 * @param sensor_positionY
	 */
	public Sensor(Type_sensor type_sensor, double sensor_min, double sensor_max, String sensor_mac, String sensor_ip,
			double sensor_positionX, double sensor_positionY) {
		this.type_sensor = type_sensor;
		this.sensor_min = sensor_min;
		this.sensor_max = sensor_max;
		this.sensor_mac = sensor_mac;
		this.sensor_ip = sensor_ip;
		this.sensor_positionX = sensor_positionX;
		this.sensor_positionY = sensor_positionY;
	}
	private String sensor_mac = null;
	private String sensor_ip = null;
	private double sensor_positionX;
	private double sensor_positionY;
	
	/**
	 * @param sensor_id
	 * @param type_sensor
	 */
	
	public Sensor(int sensor_id, Type_sensor type_sensor) {
		super();
		this.sensor_id = sensor_id;
		this.type_sensor = type_sensor;
	}
	public Sensor() {
	}
	public Sensor(int param_sensor_id) {
		// TODO Auto-generated constructor stub
		this.sensor_id = param_sensor_id;
	}
	/**
	 * @param sensor_id
	 * @param type_sensor
	 * @param sensor_min
	 * @param sensor_max
	 * @param sensor_mac
	 * @param sensor_ip
	 * @param room_id
	 * @param sensor_status
	 * @param sensor_positionX
	 * @param sensor_positionY
	 */
	public Sensor(int sensor_id, Type_sensor type_sensor, double sensor_min, double sensor_max, String sensor_mac,
			String sensor_ip, double sensor_positionX, double sensor_positionY) {
		super();
		this.sensor_id = sensor_id;
		this.type_sensor = type_sensor;
		this.sensor_min = sensor_min;
		this.sensor_max = sensor_max;
		this.sensor_mac = sensor_mac;
		this.sensor_ip = sensor_ip;
		this.sensor_positionX = sensor_positionX;
		this.sensor_positionY = sensor_positionY;
	}
	/**
	 * @param sensor_id
	 * @param type_sensor
	 * @param sensor_min
	 * @param sensor_max
	 */
	public Sensor(int sensor_id, Type_sensor type_sensor, double sensor_min, double sensor_max) {
		super();
		this.sensor_id = sensor_id;
		this.type_sensor = type_sensor;
		this.sensor_min = sensor_min;
		this.sensor_max = sensor_max;
	}
	
	
	
	public Sensor(int sensor_id, Type_sensor type_sensor, String sensor_mac, String sensor_ip, double sensor_min, double sensor_max, double sensor_positionX, double sensor_positionY) {
		super();
		this.sensor_id = sensor_id;
		this.type_sensor = type_sensor;
		this.sensor_min = sensor_min;
		this.sensor_max = sensor_max;
		this.sensor_mac = sensor_mac;
		this.sensor_ip = sensor_ip;
		this.sensor_positionX = sensor_positionX;
		this.sensor_positionY = sensor_positionY;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getType_sensor().getType_sensor_name();
	}
	/**
	 * @return the sensor_min
	 */
	public double getSensor_min() {
		return sensor_min;
	}
	/**
	 * @param sensor_min the sensor_min to set
	 */
	public void setSensor_min(double sensor_min) {
		this.sensor_min = sensor_min;
	}
	/**
	 * @return the sensor_max
	 */
	public double getSensor_max() {
		return sensor_max;
	}
	/**
	 * @param sensor_max the sensor_max to set
	 */
	public void setSensor_max(double sensor_max) {
		this.sensor_max = sensor_max;
	}
	/**
	 * @return the sensor_mac
	 */
	public String getSensor_mac() {
		return sensor_mac;
	}
	/**
	 * @param sensor_mac the sensor_mac to set
	 */
	public void setSensor_mac(String sensor_mac) {
		this.sensor_mac = sensor_mac;
	}
	/**
	 * @return the sensor_ip
	 */
	public String getSensor_ip() {
		return sensor_ip;
	}
	/**
	 * @param sensor_ip the sensor_ip to set
	 */
	public void setSensor_ip(String sensor_ip) {
		this.sensor_ip = sensor_ip;
	}

	/**
	 * @return the sensor_positionX
	 */
	public double getSensor_positionX() {
		return sensor_positionX;
	}
	/**
	 * @param sensor_positionX the sensor_positionX to set
	 */
	public void setSensor_positionX(double sensor_positionX) {
		this.sensor_positionX = sensor_positionX;
	}
	/**
	 * @return the sensor_positionY
	 */
	public double getSensor_positionY() {
		return sensor_positionY;
	}
	/**
	 * @param sensor_positionY the sensor_positionY to set
	 */
	public void setSensor_positionY(double sensor_positionY) {
		this.sensor_positionY = sensor_positionY;
	}		
}
