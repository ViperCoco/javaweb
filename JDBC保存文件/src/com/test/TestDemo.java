package com.test;

import java.io.File;

import com.utils.DBUtils;

public class TestDemo {

	public static void main(String[] args) {

		DBUtils utils = new DBUtils();

		/**
		 * 将文件保存到数据库
		 */

		// File file = new File("C:\\Users\\Polaris\\Desktop\\pic1.jpg");
		//
		// if (utils.addFile(file) != 0) {
		//
		// System.out.println("保存完毕！");
		//
		// }

		/**
		 * 从数据库中读取出文件，默认保存在桌面
		 * 
		 */

		File file2 = utils.getFile("pic1.jpg");

	}

}
