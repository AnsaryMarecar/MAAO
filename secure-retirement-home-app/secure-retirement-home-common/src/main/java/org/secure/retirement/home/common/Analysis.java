package org.secure.retirement.home.common;

import java.util.Date;

public class Analysis {
	public Analysis(String sensor_mac, String sensor_ip, String type_sensor_name, String room_name,
				Date historic_datetime, Double historic_value) {
		super();
		this.sensor_mac = sensor_mac;
		this.sensor_ip = sensor_ip;
		this.type_sensor_name = type_sensor_name;
		this.room_name = room_name;
		this.historic_datetime = historic_datetime;
		this.historic_value = historic_value;
	}
	public String getSensor_mac() {
		return sensor_mac;
	}
	public void setSensor_mac(String sensor_mac) {
		this.sensor_mac = sensor_mac;
	}
	public String getSensor_ip() {
		return sensor_ip;
	}
	public void setSensor_ip(String sensor_ip) {
		this.sensor_ip = sensor_ip;
	}
	public String getType_sensor_name() {
		return type_sensor_name;
	}
	public void setType_sensor_name(String type_sensor_name) {
		this.type_sensor_name = type_sensor_name;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public Date getHistoric_datetime() {
		return historic_datetime;
	}
	public void setHistoric_datetime(Date historic_datetime) {
		this.historic_datetime = historic_datetime;
	}
	public Double getHistoric_value() {
		return historic_value;
	}
	public void setHistoric_value(Double historic_value) {
		this.historic_value = historic_value;
	}
	private String sensor_mac;
	private String sensor_ip;
	private String type_sensor_name;
	private String room_name;
	private Date historic_datetime;
	private Double historic_value;
	
	
	
	
	
	
	
	
	

}
