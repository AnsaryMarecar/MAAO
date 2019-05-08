package org.secure.retirement.home.common;

public class User {
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	} 

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_surname() {
		return user_surname;
	}

	public void setUser_surname(String user_surname) {
		this.user_surname = user_surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	private int user_id;
	private String user_name;
	private String user_surname;
	private String password;
	private Role role;
	
	public User (int user_id, String user_name, String user_surname, String password, Role role) {
		this.user_id=user_id;
		this.user_name=user_name;
		this.user_surname=user_surname;
		this.password=password;
		this.role=role;
	}

}
