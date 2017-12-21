package com.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UpFileServlet
 */
@MultipartConfig
@WebServlet("/upfile.do")
public class UpFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpFileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// ��ȡ�����ϴ��ļ����ļ��еľ���·��

		String path = request.getServletContext().getRealPath("files");
		File file = new File(path);

		// ��������ڣ��򴴽�
		if (!file.exists()) {

			file.mkdirs();

		}

		System.out.println("�����ϴ��ļ����ļ��еľ���·����" + file.getAbsolutePath());
		// Part�����ϴ����ļ���Ϣ
		Part part = request.getPart("upfile");

		// ��ȡ����ͷ��Ϣ
		String header = part.getHeader("content-disposition");

		System.out.println(header);

		// �������ļ���
		String filename = getFileName(header);

		System.out.println("�ļ���Ϊ��" + filename);

		if (!"".equals(filename)) {

			// �ϴ��ļ��������ļ����ļ���

			part.write(path + "\\" + filename);

			// ��ת���ļ��������

			// ��ȡurl��ַ

			String file_url = request.getServletContext().getContextPath()
					+ "/files/" + filename;

			System.out.println("�ļ���url��ַΪ��" + file_url);

			request.setAttribute("file_url", file_url);

			// ת��
			request.getRequestDispatcher("WEB-INF/jsp/success.jsp").forward(
					request, response);

		}

	}

	public String getFileName(String header) {

		// ��ȡ�ļ��������ݸ����������д��

		String[] tempArr1 = header.split(";");

		String[] tempArr2 = tempArr1[2].split("=");

		String fileName = tempArr2[1].substring(
				tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		return fileName;
	}

}
