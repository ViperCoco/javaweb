package com.service;

import com.bean.User;
import com.utils.DBUtils;

public class UserService {

	private DBUtils utils = new DBUtils();

	// ��¼

	public boolean login(User user) {

		if (utils.findUser(user) != null) {

			return true;
		} else {

			return false;

		}

	}

	// ע��

	public boolean regist(User user) {

		String username = user.getUsername();

		// �û������ظ�
		if (utils.findUserByName(username) == null) {

			// ���û���Ϣ��ӽ����ݿ�

			utils.addUser(user);

			return true;

		} else {

			return false;
		}

	}

}
