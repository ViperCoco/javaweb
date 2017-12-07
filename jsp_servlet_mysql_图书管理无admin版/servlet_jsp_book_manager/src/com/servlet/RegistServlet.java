package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.service.UserService;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/regist.do")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService uservice = new UserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistServlet() {
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


		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("regist:" + username);
		System.out.println("regist:" + password);

		// 创建对象保存信息

		User user = new User(username, password);
		
		uservice.regist(user);

		// 注册成功!

					request.getRequestDispatcher("WEB-INF/jsp/regist_success.jsp")
							.forward(request, response);


	}

}
