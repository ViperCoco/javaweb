package com.test;

import java.io.File;

import com.utils.DBUtils;

public class TestDemo {

	public static void main(String[] args) {

		DBUtils utils = new DBUtils();

		/**
		 * ���ļ����浽���ݿ�
		 */

		// File file = new File("C:\\Users\\Polaris\\Desktop\\pic1.jpg");
		//
		// if (utils.addFile(file) != 0) {
		//
		// System.out.println("������ϣ�");
		//
		// }

		/**
		 * �����ݿ��ж�ȡ���ļ���Ĭ�ϱ���������
		 * 
		 */

		File file2 = utils.getFile("pic1.jpg");

	}

}
