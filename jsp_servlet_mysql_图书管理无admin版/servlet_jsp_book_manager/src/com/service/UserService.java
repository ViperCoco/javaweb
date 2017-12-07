package com.service;

import com.bean.User;
import com.dao.UserDao;

//业务逻辑层
public class UserService {

	private UserDao udao = new UserDao();

	// 登录验证

	public boolean login(User user) {

		User user_find = udao.findByInfo(user);

		if (user_find != null) {

			return true;

		}

		return false;
	}

	// 注册

	public void regist(User user) {

		udao.add(user);

	}

	public boolean registcheck(String username) {
		// TODO Auto-generated method stub

		if (udao.findByName(username) == null) {
			// 可以注册

			return true;

		}

		return false;

	}

}
