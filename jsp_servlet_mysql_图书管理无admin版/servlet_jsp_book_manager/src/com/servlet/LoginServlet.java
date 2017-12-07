package com.servlet;

//控制层
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 业务处理对象

	UserService uservice = new UserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		// 防止中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println(username);
		System.out.println(password);

		// 创建对象保存信息

		User user = new User(username, password);
		// 调用登录业务，判断是否登录成功
		if (uservice.login(user)) {

			// 登录成功

			HttpSession session=request.getSession();
			
			session.setAttribute("username", username);

			// 转发到登录成功页面

			request.getRequestDispatcher("listbook.do?page=1").forward(request,
					response);

		} else {

			// 登录失败

			// 转发到登录失败页面

			request.getRequestDispatcher("WEB-INF/jsp/failed.jsp").forward(
					request, response);

		}

	}

}
