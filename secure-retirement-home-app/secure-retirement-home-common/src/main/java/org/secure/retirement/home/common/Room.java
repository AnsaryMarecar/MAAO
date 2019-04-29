package org.secure.retirement.home.common;

public class Room {
	private int 	room_id	;
	private String room_name;
	private int	 x_min;
	private int	 x_max;
	private int	 y_min;
	private int	 y_max;
	
	
	public Room() {
		
	}
	public Room(int room_id	,String room_name, int	 x_min, int x_max,int y_min, int	 y_max) {
		this.room_id=room_id;
		this.room_name=room_name;
		this.x_min=x_min;
		this.x_max=x_max;
		this.y_min = y_min;
		this.y_max= y_max;
		
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public int getX_min() {
		return x_min;
	}
	public void setX_min(int x_min) {
		this.x_min = x_min;
	}
	public int getX_max() {
		return x_max;
	}
	public void setX_max(int x_max) {
		this.x_max = x_max;
	}
	public int getY_min() {
		return y_min;
	}
	public void setY_min(int y_min) {
		this.y_min = y_min;
	}
	public int getY_max() {
		return y_max;
	}
	public void setY_max(int y_max) {
		this.y_max = y_max;
	}
	@Override
	public String toString() {
		return "room [getRoom_id()=" + getRoom_id() + ", getRoom_name()=" + getRoom_name() + ", getX_min()="
				+ getX_min() + ", getX_max()=" + getX_max() + ", getY_min()=" + getY_min() + ", getY_max()="
				+ getY_max() + "]";
	}
	
}