package com.bean;

import java.io.Serializable;

public class Student implements Serializable{

	private int id;

	private String name;

	private String sex;

	private int age;

	private String hobby;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String sex, int age, String hobby) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return id+"\t\t"+name+"\t\t"+sex+"\t\t"+age+"\t\t"+hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
