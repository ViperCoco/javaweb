package com.test;

import com.bean.User;
import com.utils.DBUtils;

public class DBTest {

	public static void main(String[] args) {

		DBUtils utils = new DBUtils();

		User user = new User("С��", "abc123");

//		System.out.println(utils.findUser(user).toString());
//		
//		
//		System.out.println(utils.findUserByName("С��").toString());
		
		System.out.println(utils.addUser(user));

	}

}
