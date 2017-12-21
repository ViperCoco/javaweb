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
 * Servlet implementation class UpfileServlet
 */

@MultipartConfig
@WebServlet("/upfile.do")
public class UpfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpfileServlet() {
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

		// ͨ����file�ؼ�(<input type="file"
		// name="file">)������ֱ�ӻ�ȡPart����
		Part part = request.getPart("upfile");

		// ��ȡ����ͷ��Ϣ
		String header = part.getHeader("content-disposition");

		System.out.println(header);

		System.out.println(getFileName(header));

		// �������ļ���

		String filename = getFileName(header);

		// ���ļ�д��ָ��·��
		part.write(savepath + "\\" + filename);

		// ��ת���ļ���ʾҳ��

		// �õ��ļ�url��ַ

		String file_url = request.getServletContext().getContextPath()
				+ "/files/" + filename;

		request.setAttribute("filepath", file_url);

		// ת��

		request.getRequestDispatcher("WEB-INF/jsp/success.jsp").forward(
				request, response);
		;

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
