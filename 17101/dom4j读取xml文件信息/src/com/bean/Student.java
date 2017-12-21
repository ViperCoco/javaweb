package com.bean;

import java.io.Serializable;

public class Student implements Serializable {

	private String sid;

	private String name;

	private String sex;

	private String age;

	private String hobby;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String sid, String name, String sex, String age, String hobby) {
		super();
		this.sid = sid;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", hobby=" + hobby + "]";
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
