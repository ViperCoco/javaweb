package com.bean;

import java.io.Serializable;

public class Bean implements Serializable{
	
	private String id;
	
	
	private String clazz;


	public Bean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Bean(String id, String clazz) {
		super();
		this.id = id;
		this.clazz = clazz;
	}


	@Override
	public String toString() {
		return "Bean [id=" + id + ", clazz=" + clazz + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getClazz() {
		return clazz;
	}


	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
	
	

}
