package org.secure.retirement.home.common;

public class Type_sensor {
	
	private int 	type_sensor_id	;
	private String	type_sensor_name;
	private int		type_sensor_interval;
	
	/**
	 * 
	 */
	public Type_sensor() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param type_sensor_id
	 * @param type_sensor_name
	 * @param type_sensor_interval
	 */
	public Type_sensor(int type_sensor_id, String type_sensor_name, int type_sensor_interval) {
		super();
		this.type_sensor_id 		= type_sensor_id		;
		this.type_sensor_name 		= type_sensor_name		;
		this.type_sensor_interval 	= type_sensor_interval	;
	}

	/**
	 * @param type_sensor_id
	 * @param type_sensor_name
	 */
	public Type_sensor(int type_sensor_id, String type_sensor_name) {
		this.type_sensor_id 		= type_sensor_id		;
		this.type_sensor_name 		= type_sensor_name		;
	}
	
	/**
	 * @param type_sensor_name
	 */
	public Type_sensor(String type_sensor_name) {
		this.type_sensor_name 		= type_sensor_name		;
	}

	/**
	 * @return the type_sensor_id
	 */
	public int getType_sensor_id() {
		return type_sensor_id								;
	}
	/**
	 * @param type_sensor_id the type_sensor_id to set
	 */
	public void setType_sensor_id(int type_sensor_id) {
		this.type_sensor_id 		= type_sensor_id		;
	}
	/**
	 * @return the type_sensor_name
	 */
	public String getType_sensor_name() {
		return type_sensor_name								;
	}
	/**
	 * @param type_sensor_name the type_sensor_name to set
	 */
	public void setType_sensor_name(String type_sensor_name) {
		this.type_sensor_name 		= type_sensor_name		;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Type_sensor [getType_sensor_id()=" + getType_sensor_id() + ", getType_sensor_name()="
				+ getType_sensor_name() + "]";
	}

	/**
	 * @return the type_sensor_interval
	 */
	public int getType_sensor_interval() {
		return type_sensor_interval							;
	}

	/**
	 * @param type_sensor_interval the type_sensor_interval to set
	 */
	public void setType_sensor_interval(int type_sensor_interval) {
		this.type_sensor_interval = type_sensor_interval	;
	}
}