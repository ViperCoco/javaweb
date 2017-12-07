package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.UserService;

/**
 * Servlet implementation class CheckUserServlet
 */
@WebServlet("/checkuser.do")
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService uservice = new UserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckUserServlet() {
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
		PrintWriter pw = response.getWriter();

		String username = request.getParameter("name");
		
		System.out.println("CheckUserServlet"+username);
		
		System.out.println("CheckUserServlet:"+uservice.registcheck(username));
		//不能注册，返回已存在
		if (!uservice.registcheck(username)) {

			pw.write("exists");

			pw.flush();
			pw.close();

		}

	}

}
