package com.service;

import com.bean.User;
import com.dao.UserDao;

//ҵ���߼���
public class UserService {

	private UserDao udao = new UserDao();

	// ��¼��֤

	public boolean login(User user) {

		User user_find = udao.findByInfo(user);

		if (user_find != null) {

			return true;

		}

		return false;
	}

	// ע��

	public void regist(User user) {

		udao.add(user);

	}

	public boolean registcheck(String username) {
		// TODO Auto-generated method stub

		if (udao.findByName(username) == null) {
			// ����ע��

			return true;

		}

		return false;

	}

}
