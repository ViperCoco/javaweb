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

		// 获取保存上传文件的文件夹的绝对路径

		String path = request.getServletContext().getRealPath("files");
		File file = new File(path);

		// 如果不存在，则创建
		if (!file.exists()) {

			file.mkdirs();

		}

		System.out.println("保存上传文件的文件夹的绝对路径：" + file.getAbsolutePath());

		// 获取保存上传文件所在目录的url地址

		String url = request.getServletContext().getContextPath() + "/files/";

		// 准备集合，保存文件的url地址

		List<String> list_url = new ArrayList<String>();

		// 获取所有上传文件的信息

		Collection<Part> list = request.getParts();

		if (list.size() > 0) {

			for (Part part : list) {

				// 获取请求头信息
				String header = part.getHeader("content-disposition");

				System.out.println(header);

				// 解析出文件名
				String filename = getFileName(header);

				System.out.println("文件名为：" + filename);

				if (!"".equals(filename)) {

					// 上传文件到保存文件的文件夹

					part.write(path + "\\" + filename);

					// 将文件的url地址添加进list_url

					String file_url = url + filename;

					list_url.add(file_url);

				}

			}

		}

		/*
		 * 跳转到文件查看页面
		 */

		request.setAttribute("list_url", list_url);

		// 转发
		request.getRequestDispatcher("WEB-INF/jsp/success.jsp").forward(
				request, response);

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
