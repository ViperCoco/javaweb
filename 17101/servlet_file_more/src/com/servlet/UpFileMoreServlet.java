package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UpFileMoreServlet
 */

@MultipartConfig
// !!!
@WebServlet("/upfilemore.do")
public class UpFileMoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpFileMoreServlet() {
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

		// ��ȡ�����ϴ��ļ�����Ŀ¼��url��ַ

		String url = request.getServletContext().getContextPath() + "/files/";

		// ׼�����ϣ������ļ���url��ַ

		List<String> list_url = new ArrayList<String>();

		// ��ȡ�����ϴ��ļ�����Ϣ

		Collection<Part> list = request.getParts();

		if (list.size() > 0) {

			for (Part part : list) {

				// ��ȡ����ͷ��Ϣ
				String header = part.getHeader("content-disposition");

				System.out.println(header);

				// �������ļ���
				String filename = getFileName(header);

				System.out.println("�ļ���Ϊ��" + filename);

				if (!"".equals(filename)) {

					// �ϴ��ļ��������ļ����ļ���

					part.write(path + "\\" + filename);

					// ���ļ���url��ַ��ӽ�list_url

					String file_url = url + filename;

					list_url.add(file_url);

				}

			}

		}

		/*
		 * ��ת���ļ��鿴ҳ��
		 */

		request.setAttribute("list_url", list_url);

		// ת��
		request.getRequestDispatcher("WEB-INF/jsp/success.jsp").forward(
				request, response);

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
