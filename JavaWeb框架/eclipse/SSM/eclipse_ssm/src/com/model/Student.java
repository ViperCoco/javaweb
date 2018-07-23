package com.model;

import java.io.Serializable;

public class Student implements Serializable {

	private Integer _id;

	private String stuId;

	private String stuName;

	private String stuSex;

	private Integer stuAge;
	private String stuHobby;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Integer _id, String stuId, String stuName, String stuSex, Integer stuAge, String stuHobby) {
		super();
		this._id = _id;
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.stuHobby = stuHobby;
	}
	@Override
	public String toString() {
		return "Student [_id=" + _id + ", stuId=" + stuId + ", stuName=" + stuName + ", stuSex=" + stuSex + ", stuAge="
				+ stuAge + ", stuHobby=" + stuHobby + "]";
	}
	public Integer get_id() {
		return _id;
	}
	public void set_id(Integer _id) {
		this._id = _id;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public Integer getStuAge() {
		return stuAge;
	}
	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}
	public String getStuHobby() {
		return stuHobby;
	}
	public void setStuHobby(String stuHobby) {
		this.stuHobby = stuHobby;
	}
	
	
	

}
