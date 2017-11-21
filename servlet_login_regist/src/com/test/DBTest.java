package com.test;

import com.bean.User;
import com.utils.DBUtils;

public class DBTest {

	public static void main(String[] args) {

		DBUtils utils = new DBUtils();

		User user = new User("Ð¡À¼", "abc123");

//		System.out.println(utils.findUser(user).toString());
//		
//		
//		System.out.println(utils.findUserByName("Ð¡Ã÷").toString());
		
		System.out.println(utils.addUser(user));

	}

}
