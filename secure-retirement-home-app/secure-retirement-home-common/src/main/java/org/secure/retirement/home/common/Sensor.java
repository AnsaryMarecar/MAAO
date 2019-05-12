package org.secure.retirement.home.common;


public class Sensor {
	private int sensor_id;
	private String type_sensor;
	private int position_x;
	private int position_y;
	private int sensor_min ;
	private int sensor_max ;
	private String address_ip;
	private String address_mac;

	

	public Sensor(int sensor_id, String type_sensor, int position_x, int position_y, int sensor_min, int sensor_max,
			String address_ip, String address_mac) {
		super();
		this.sensor_id = sensor_id;
		this.type_sensor = type_sensor;
		this.position_x = position_x;
		this.position_y = position_y;
		this.sensor_min = sensor_min;
		this.sensor_max = sensor_max;
		this.address_ip = address_ip;
		this.address_mac = address_mac;
	}
	public Sensor() {
		
	}
	public int getSensor_id() {
		return sensor_id;
	}
	public void setSensor_id(int sensor_id) {
		this.sensor_id = sensor_id;
	}
	public String getType_sensor() {
		return type_sensor;
	}
	public void setType_sensor(String type_sensor) {
		this.type_sensor = type_sensor;
	}
	public String getAddress_ip() {
		return address_ip;
	}
	public void setAddress_ip(String address_ip) {
		this.address_ip = address_ip;
	}
	public String getAddress_mac() {
		return address_mac;
	}
	public void setAddress_mac(String  address_mac) {
		this.address_mac = address_mac;
	}
	public int getSensor_min() {
		return sensor_min;
	}
	public void setSensor_min(int sensor_min) {
		this.sensor_min = sensor_min;
	}
	public int getSensor_max() {
		return sensor_max;
	}
	public void setSensor_max(int sensor_max) {
		this.sensor_max = sensor_max;
	}
	public int getPosition_x() {
		return position_x;
	}
	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}
	public int getPosition_y() {
		return position_y;
	}
	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}
	@Override
	public String toString() {
		return "Sensor [getSensor_id()=" + getSensor_id() + ", getType_sensor()=" + getType_sensor()
				+ ", getAddress_ip()=" + getAddress_ip() + ", getAddress_mac()=" + getAddress_mac()
				+ ", getSensor_min()=" + getSensor_min() + ", getSensor_max()=" + getSensor_max() + ", getPosition_x()="
				+ getPosition_x() + ", getPosition_y()=" + getPosition_y() + "]";
	}


}
	
	
	

