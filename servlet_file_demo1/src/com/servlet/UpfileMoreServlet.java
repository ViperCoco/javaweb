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
 * Servlet implementation class UpfileServlet
 */

@MultipartConfig
@WebServlet("/upfilemore.do")
public class UpfileMoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpfileMoreServlet() {
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
		// �ַ�����
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// ���ñ����·��

		String savepath = request.getServletContext().getRealPath("files");
		File file_root = new File(savepath);

		if (!file_root.exists()) {

			file_root.mkdirs();

		}

		System.out.println(file_root.getAbsolutePath());

		// ��ȡ�ϴ����ļ�����
		Collection<Part> parts = request.getParts();

		// ���ļ������������

		List<String> filenames = new ArrayList<String>();

		if (parts.size() > 0) {

			for (Part part : parts) {
				// ��ȡ����ͷ��Ϣ
				String header = part.getHeader("content-disposition");

				System.out.println(header);

				System.out.println(getFileName(header));

				// �������ļ���

				String filename = getFileName(header);

				if (!"".equals(filename)) {

					// ���ļ�����ӽ�����
					filenames.add(filename);

					// ���ļ�д��ָ��·��
					part.write(savepath + "\\" + filename);

				}

			}

			// ��ת���ļ���ʾҳ��

			// �õ��ļ�url��ַ����

			String file_url = request.getServletContext().getContextPath()
					+ "/files/";

			List<String> filenames_url = new ArrayList<String>();

			for (String string : filenames) {

				filenames_url.add(file_url + string);

			}

			request.setAttribute("filenames_url", filenames_url);

			// ת��

			request.getRequestDispatcher("WEB-INF/jsp/success.jsp").forward(
					request, response);
			;

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
