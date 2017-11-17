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

	// ���ļ���������ݿ�

	public int addFile(File file) {

		// �ļ��ֽ�������

		try {
			FileInputStream fis = new FileInputStream(file);

			byte[] bytes = new byte[(int) file.length()];

			fis.read(bytes);

			// �ر���

			fis.close();

			Connection conn = DBConnection.getConnection();

			String sql = "insert into files(name,value) values(?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, file.getName());// ����������ļ���

			ps.setBytes(2, bytes);// �ֽ�����

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

	// �����ݿ��ж�ȡ���ļ�(Ĭ�ϱ�����������)

	public File getFile(String filename) {

		File file = null;

		try {

			file = new File("C:\\Users\\Polaris\\Desktop\\" + filename);// Ŀ���ļ�(����ȡ�����ֽ����飬д�뵽Ŀ���ļ�)

			FileOutputStream fos = new FileOutputStream(file);// �ļ��ֽ������
			// �������ݿ�
			Connection conn = DBConnection.getConnection();

			String sql = "select * from files where name=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, filename);

			ResultSet rs = ps.executeQuery();

			// ����ȡֵ
			byte[] bytes = null;

			while (rs.next()) {

				bytes = rs.getBytes("value");

			}

			fos.write(bytes);// ��Ŀ���ļ�д����

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
