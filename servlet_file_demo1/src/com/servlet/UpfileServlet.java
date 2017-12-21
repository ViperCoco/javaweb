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
		// 字符编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 设置保存的路径

		String savepath = request.getServletContext().getRealPath("files");
		File file_root = new File(savepath);

		if (!file_root.exists()) {

			file_root.mkdirs();

		}

		System.out.println(file_root.getAbsolutePath());

		// 通过表单file控件(<input type="file"
		// name="file">)的名字直接获取Part对象
		Part part = request.getPart("upfile");

		// 获取请求头信息
		String header = part.getHeader("content-disposition");

		System.out.println(header);

		System.out.println(getFileName(header));

		// 解析出文件名

		String filename = getFileName(header);

		// 把文件写到指定路径
		part.write(savepath + "\\" + filename);

		// 跳转到文件显示页面

		// 得到文件url地址

		String file_url = request.getServletContext().getContextPath()
				+ "/files/" + filename;

		request.setAttribute("filepath", file_url);

		// 转发

		request.getRequestDispatcher("WEB-INF/jsp/success.jsp").forward(
				request, response);
		;

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
