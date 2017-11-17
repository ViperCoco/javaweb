package com.farsight.bean;

public class Student {

	// 属性

	public String stuId;

	public String stuName;

	public String stuSex;

	public int stuAge;

	public String stuHobby;

	// 构造方法
	public Student() {
	}

	public Student(String stuId, String stuName, String stuSex, int stuAge,
			String stuHobby) {
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.stuHobby = stuHobby;
	}
	
	// 获取学生信息

	public String getInfo() {

		return stuId + "\t\t" + stuName + "\t\t" + stuSex + "\t\t" + stuAge
				+ "\t\t" + stuHobby;

	}

}
