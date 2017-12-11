package com.test;

import com.bean.Student;
import com.bean.User;
import com.utils.BeanUtils;

public class BeanTest {
	public static void main(String[] args) {

		BeanUtils utils = new BeanUtils("beans.xml");
		Student stu = (Student) utils.getBean("student");

		Student stu2 = (Student) utils.getBean("student");

		User user = (User) utils.getBean("user");

		User user2 = (User) utils.getBean("user");

		System.out.println(stu.toString());
		System.out.println(stu2.toString());

		System.out.println(user.toString());

		System.out.println(user2.toString());

	}

}
