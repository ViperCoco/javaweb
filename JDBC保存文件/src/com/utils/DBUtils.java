package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

	// 将文件保存进数据库

	public int addFile(File file) {

		// 文件字节输入流

		try {
			FileInputStream fis = new FileInputStream(file);

			byte[] bytes = new byte[(int) file.length()];

			fis.read(bytes);

			// 关闭流

			fis.close();

			Connection conn = DBConnection.getConnection();

			String sql = "insert into files(name,value) values(?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, file.getName());// 方法传入的文件名

			ps.setBytes(2, bytes);// 字节数组

			int result = ps.executeUpdate();

			return result;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	// 从数据库中读取出文件(默认保存在桌面上)

	public File getFile(String filename) {

		File file = null;

		try {

			file = new File("C:\\Users\\Polaris\\Desktop\\" + filename);// 目标文件(将读取出的字节数组，写入到目标文件)

			FileOutputStream fos = new FileOutputStream(file);// 文件字节输出流
			// 连接数据库
			Connection conn = DBConnection.getConnection();

			String sql = "select * from files where name=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, filename);

			ResultSet rs = ps.executeQuery();

			// 遍历取值
			byte[] bytes = null;

			while (rs.next()) {

				bytes = rs.getBytes("value");

			}

			fos.write(bytes);// 向目标文件写数据

			fos.flush();

			fos.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return file;

	}

}
