package org.secure.retirement.home.common;

import java.time.Instant;

public class Failure {
	private int failure_id;
	private Instant failure_datetime = Instant.now();
	private Sensor sensor = null;
	
	/**
	 * @param failure_datetime
	 * @param sensor
	 */
	public Failure(Instant failure_datetime, Sensor sensor) {
		super();
		this.failure_datetime = failure_datetime;
		this.sensor = sensor;
	}

	/**
	 * @param sensor
	 */
	public Failure(Sensor sensor) {
		super();
		this.sensor = sensor;
	}
	/**
	 * @param failure_id
	 * @param failure_datetime
	 * @param sensor
	 */
	public Failure(int failure_id, Instant failure_datetime, Sensor sensor) {
		super();
		this.failure_id = failure_id;
		this.failure_datetime = failure_datetime;
		this.setSensor(sensor);
	}

	public int getFailure_id() {
		return failure_id;
	}

	public void setFailure_id(int failure_id) {
		this.failure_id = failure_id;
	}

	
	/**
	 * @return the failure_datetime
	 */
	public Instant getFailure_datetime() {
		return failure_datetime;
	}

	/**
	 * @param failure_datetime the failure_datetime to set
	 */
	public void setFailure_datetime(Instant failure_datetime) {
		this.failure_datetime = failure_datetime;
	}

	/**
	 * @return the sensor
	 */
	public Sensor getSensor() {
		return sensor;
	}

	/**
	 * @param sensor the sensor to set
	 */
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Failure [getFailure_id()=" + getFailure_id() + ", getFailure_datetime()=" + getFailure_datetime()
				+ ", getSensor()=" + getSensor() + "]";
	}

}
