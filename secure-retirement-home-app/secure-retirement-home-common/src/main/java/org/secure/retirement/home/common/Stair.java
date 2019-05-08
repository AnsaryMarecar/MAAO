package org.secure.retirement.home.common;

public class Stair {
	public int getStair_id() {
		return stair_id;
	}

	public void setStair_id(int stair_id) {
		this.stair_id = stair_id;
	}

	public String getStair_name() {
		return stair_name;
	}

	public void setStair_name(String stair_name) {
		this.stair_name = stair_name;
	}

	private int stair_id;
	private String stair_name;
	
	
	public Stair (int stair_id, String stair_name) {
		this.stair_id=stair_id;
		this.stair_name=stair_name;
	}
	
	public Stair(String stair_name) {
		this.stair_name=stair_name;
	}
}
