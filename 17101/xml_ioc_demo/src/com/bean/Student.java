package com.bean;

import java.io.Serializable;

public class Student implements Serializable {
	
	private String id;
	
	private String name;
	
	private String hobby;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String id, String name, String hobby) {
		super();
		this.id = id;
		this.name = name;
		this.hobby = hobby;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	
	

}
