package com.service;

import com.bean.User;
import com.utils.DBUtils;

public class UserService {

	private DBUtils utils = new DBUtils();

	// 登录

	public boolean login(User user) {

		if (utils.findUser(user) != null) {

			return true;
		} else {

			return false;

		}

	}

	// 注册

	public boolean regist(User user) {

		String username = user.getUsername();

		// 用户名不重复
		if (utils.findUserByName(username) == null) {

			// 将用户信息添加进数据库

			utils.addUser(user);

			return true;

		} else {

			return false;
		}

	}

}
