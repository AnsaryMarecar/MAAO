/**
 * 
 */
package org.secure.retirement.home.simulator.client;
import org.secure.retirement.home.simulator.frame.FrameSimulator;

/**
 * @author Ansary MARECAR
 *
 */
public class Simulation implements Runnable{

	private FrameSimulator 	att_frame = null;
	private int 			sensor_id = 0	;
	
	/**
	 * @param param_frame : FrameSimulator
	 * @param param_sensor_id : sensor_id
	 */
	public Simulation(FrameSimulator param_frame, int param_sensor_id) {
		super();
		this.setAtt_frame(param_frame);
		this.setSensor_id(param_sensor_id);
	}
	
	public void run() {
		Parser.to_parse(this.getSensor_id(), this.getAtt_frame());
	}

	/**
	 * @return the att_frame
	 */
	public FrameSimulator getAtt_frame() {
		return att_frame;
	}

	/**
	 * @param att_frame the att_frame to set
	 */
	public void setAtt_frame(FrameSimulator att_frame) {
		this.att_frame = att_frame;
	}

	/**
	 * @return the sensor_id
	 */
	public int getSensor_id() {
		return sensor_id;
	}

	/**
	 * @param sensor_id the sensor_id to set
	 */
	public void setSensor_id(int sensor_id) {
		this.sensor_id = sensor_id;
	}
	
}
