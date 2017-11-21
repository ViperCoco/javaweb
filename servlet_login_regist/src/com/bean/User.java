package com.bean;

public class User {

	private int _id;

	private String username;

	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int _id, String username, String password) {
		super();
		this._id = _id;
		this.username = username;
		this.password = password;
	}
	
	

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [_id=" + _id + ", username=" + username + ", password="
				+ password + "]";
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
