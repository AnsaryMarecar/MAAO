package org.secure.retirement.home.common;

import java.util.Date;

public class Failure {
	
	private int failure_id;
	public int getFailure_id() {
		return failure_id;
	}

	public void setFailure_id(int failure_id) {
		this.failure_id = failure_id;
	}

	public Date getFailure_dateTime() {
		return failure_dateTime;
	}

	public void setFailure_dateTime(Date failure_dateTime) {
		this.failure_dateTime = failure_dateTime;
	}

	public String getFailure_information() {
		return failure_information;
	}

	public void setFailure_information(String failure_information) {
		this.failure_information = failure_information;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	private Date failure_dateTime;
	private String failure_information;
	private Sensor sensor;
	
	public Failure (int failure_id, Date failure_dateTime, String failure_information, Sensor sensor) {
		this.failure_id=failure_id;
		this.failure_dateTime=failure_dateTime;
		this.failure_information=failure_information;
		this.sensor=sensor;
	}
	
	public Failure(Date failure_dateTime, String failure_information, Sensor sensor) {
		this.failure_dateTime=failure_dateTime;
		this.failure_information=failure_information;
		this.sensor=sensor;
	}

}
