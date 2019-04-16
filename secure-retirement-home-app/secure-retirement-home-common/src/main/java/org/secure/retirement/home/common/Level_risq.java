/**
 * 
 */
package org.secure.retirement.home.common;

import java.awt.Color;

/**
 * @author Ansary MARECAR
 *
 */
public class Level_risq {
	private int level_risq_id;
	private String level_risq_name;
	private Color level_risq_color;
	private Type_sensor type_sensor;
	/**
	 * @param level_risq_id
	 * @param level_risq_name
	 * @param level_risq_color
	 * @param type_sensor
	 */
	public Level_risq(int level_risq_id, String level_risq_name, Color level_risq_color, Type_sensor type_sensor) {
		super();
		this.level_risq_id = level_risq_id;
		this.level_risq_name = level_risq_name;
		this.level_risq_color = level_risq_color;
		this.type_sensor = type_sensor;
	}
	/**
	 * @param level_risq_name
	 * @param level_risq_color
	 * @param type_sensor
	 */
	public Level_risq(String level_risq_name, Color level_risq_color, Type_sensor type_sensor) {
		super();
		this.level_risq_name = level_risq_name;
		this.level_risq_color = level_risq_color;
		this.type_sensor = type_sensor;
	}
	/**
	 * @return the level_risq_id
	 */
	public int getLevel_risq_id() {
		return level_risq_id;
	}
	/**
	 * @param level_risq_id the level_risq_id to set
	 */
	public void setLevel_risq_id(int level_risq_id) {
		this.level_risq_id = level_risq_id;
	}
	/**
	 * @return the level_risq_name
	 */
	public String getLevel_risq_name() {
		return level_risq_name;
	}
	/**
	 * @param level_risq_name the level_risq_name to set
	 */
	public void setLevel_risq_name(String level_risq_name) {
		this.level_risq_name = level_risq_name;
	}
	/**
	 * @return the level_risq_color
	 */
	public Color getLevel_risq_color() {
		return level_risq_color;
	}
	/**
	 * @param level_risq_color the level_risq_color to set
	 */
	public void setLevel_risq_color(Color level_risq_color) {
		this.level_risq_color = level_risq_color;
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
