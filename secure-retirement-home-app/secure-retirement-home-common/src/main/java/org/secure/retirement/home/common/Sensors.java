/**
 * 
 */
package org.secure.retirement.home.common;

/**
 * @author melissa
 *
 */
public class Sensors {
	private int sensor_id = 0;
	private int type_sensor_id = 0;
	/**
	 * @return the sensor_id
	 */
	public int getSensor_id() {
		return sensor_id;
	}

	public Sensors(int type_sensor_id, double sensor_min, double sensor_max, String sensor_mac, String sensor_ip,
			double sensor_positionX, double sensor_positionY) {
		super();
		this.type_sensor_id = type_sensor_id;
		this.sensor_min = sensor_min;
		this.sensor_max = sensor_max;
		this.sensor_mac = sensor_mac;
		this.sensor_ip = sensor_ip;
		this.sensor_positionX = sensor_positionX;
		this.sensor_positionY = sensor_positionY;
	}

	/**
	 * @param sensor_id the sensor_id to sets
	 */
	public void setSensor_id(int sensor_id) {
		this.sensor_id = sensor_id;
	}

	/**
	 * @return the type_sensor_id
	 */
	public int getType_sensor_id() {
		return type_sensor_id;
	}

	/**
	 * @param type_sensor_id the type_sensor_id to set
	 */
	public void setType_sensor_id(int type_sensor_id) {
		this.type_sensor_id = type_sensor_id;
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

	private double sensor_min = 0;
	private double sensor_max = 0;
	private String sensor_mac = null;
	private String sensor_ip = null;
	private double sensor_positionX;
	private double sensor_positionY;
	/**
	 * 
	 */
	public Sensors() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
