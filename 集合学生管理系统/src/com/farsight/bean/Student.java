package com.farsight.bean;

public class Student {

	// ����

	public String stuId;

	public String stuName;

	public String stuSex;

	public int stuAge;

	public String stuHobby;

	// ���췽��
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
	
	// ��ȡѧ����Ϣ

	public String getInfo() {

		return stuId + "\t\t" + stuName + "\t\t" + stuSex + "\t\t" + stuAge
				+ "\t\t" + stuHobby;

	}

}
