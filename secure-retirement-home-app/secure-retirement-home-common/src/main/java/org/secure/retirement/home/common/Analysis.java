
package org.secure.retirement.home.common;


public class Analysis {
	private String sensor_mac=null;
	private String sensor_ip=null;
	private String type_sensor_name=null;
	private String room_name=null;
	private String historic_datetime=null;
	private String historic_value=null;
	private String countAnal=null;
	private String countAll=null;
	private String countType=null;
	private String countRoom=null;
	public String getCountDate() {
		return countDate;
	}

	public void setCountDate(String countDate) {
		this.countDate = countDate;
	}
	private String countDate=null;
	
	public String getCountRoom() {
		return countRoom;
	}

	public void setCountRoom(String countRoom) {
		this.countRoom = countRoom;
	}
	
	
	public String getCountType() {
		return countType;
	}

	public void setCountType(String countType) {
		this.countType = countType;
	}
	
	
	
	public String getCountAll() {
		return countAll;
	}

	public void setCountAll(String countAll) {
		this.countAll = countAll;
	}
	
	public String getCountAnal() {
		return countAnal;
	}

	public void setCountAnal(String countAnal) {
		this.countAnal = countAnal;
	}
	
	
	public Analysis(String sensor_mac, String countAnal) {
		this.sensor_mac=sensor_mac;
		this.countAnal=countAnal;
	}
	
	public Analysis (String countAll) {
		this.countAll=countAll;
	}
	
	
	public Analysis(String sensor_mac, String sensor_ip, String type_sensor_name, String room_name,
		String historic_datetime, String historic_value, String countAnal, String countAll, String countType, String countRoom, String countDate) {
		super();
		this.sensor_mac = sensor_mac;
		this.sensor_ip = sensor_ip;
		this.type_sensor_name = type_sensor_name;
		this.room_name = room_name;
		this.historic_datetime = historic_datetime;
		this.historic_value = historic_value;
		this.countAnal=countAnal;
		this.countAll=countAll;
		this.countType=countType;
		this.countRoom=countRoom;
		this.countDate=countDate;
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
	public String getHistoric_datetime() {
		return historic_datetime;
	}
	public void setHistoric_datetime(String historic_datetime) {
		this.historic_datetime = historic_datetime;
	}
	public String getHistoric_value() {
		return historic_value;
	}
	public void setHistoric_value(String historic_value) {
		this.historic_value = historic_value;
	}

	
	
	
}