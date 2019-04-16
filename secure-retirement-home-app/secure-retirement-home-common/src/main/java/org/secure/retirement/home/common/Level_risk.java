/**
 * 
 */
package org.secure.retirement.home.common;

import java.awt.Color;

/**
 * @author Ansary MARECAR
 *
 */
public class Level_risk {
	private int level_risk_id;
	private String level_risk_name;
	private Color level_risk_color;
	private Type_sensor type_sensor;
	/**
	 * @param level_risk_id
	 * @param level_risk_name
	 * @param level_risk_color
	 * @param type_sensor
	 */
	public Level_risk(int level_risk_id, String level_risk_name, Color level_risk_color, Type_sensor type_sensor) {
		super();
		this.level_risk_id = level_risk_id;
		this.level_risk_name = level_risk_name;
		this.level_risk_color = level_risk_color;
		this.type_sensor = type_sensor;
	}
	/**
	 * @param level_risk_name
	 * @param level_risk_color
	 * @param type_sensor
	 */
	public Level_risk(String level_risk_name, Color level_risk_color, Type_sensor type_sensor) {
		super();
		this.level_risk_name = level_risk_name;
		this.level_risk_color = level_risk_color;
		this.type_sensor = type_sensor;
	}
	/**
	 * @return the level_risk_id
	 */
	public int getLevel_risk_id() {
		return level_risk_id;
	}
	/**
	 * @param level_risk_id the level_risk_id to set
	 */
	public void setLevel_risk_id(int level_risk_id) {
		this.level_risk_id = level_risk_id;
	}
	/**
	 * @return the level_risk_name
	 */
	public String getLevel_risk_name() {
		return level_risk_name;
	}
	/**
	 * @param level_risk_name the level_risk_name to set
	 */
	public void setLevel_risk_name(String level_risk_name) {
		this.level_risk_name = level_risk_name;
	}
	/**
	 * @return the level_risk_color
	 */
	public Color getLevel_risk_color() {
		return level_risk_color;
	}
	/**
	 * @param level_risk_color the level_risk_color to set
	 */
	public void setLevel_risk_color(Color level_risk_color) {
		this.level_risk_color = level_risk_color;
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
