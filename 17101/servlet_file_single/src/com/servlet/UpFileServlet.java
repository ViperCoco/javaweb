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

		// 获取保存上传文件的文件夹的绝对路径

		String path = request.getServletContext().getRealPath("files");
		File file = new File(path);

		// 如果不存在，则创建
		if (!file.exists()) {

			file.mkdirs();

		}

		System.out.println("保存上传文件的文件夹的绝对路径：" + file.getAbsolutePath());
		// Part保存上传的文件信息
		Part part = request.getPart("upfile");

		// 获取请求头信息
		String header = part.getHeader("content-disposition");

		System.out.println(header);

		// 解析出文件名
		String filename = getFileName(header);

		System.out.println("文件名为：" + filename);

		if (!"".equals(filename)) {

			// 上传文件到保存文件的文件夹

			part.write(path + "\\" + filename);

			// 跳转到文件浏览界面

			// 获取url地址

			String file_url = request.getServletContext().getContextPath()
					+ "/files/" + filename;

			System.out.println("文件的url地址为：" + file_url);

			request.setAttribute("file_url", file_url);

			// 转发
			request.getRequestDispatcher("WEB-INF/jsp/success.jsp").forward(
					request, response);

		}

	}

	public String getFileName(String header) {

		// 获取文件名，兼容各种浏览器的写法

		String[] tempArr1 = header.split(";");

		String[] tempArr2 = tempArr1[2].split("=");

		String fileName = tempArr2[1].substring(
				tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		return fileName;
	}

}
