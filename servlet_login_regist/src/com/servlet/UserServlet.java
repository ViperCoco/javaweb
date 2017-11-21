package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/login.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService uservice = new UserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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

		// ��ֹ��������

		request.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");

		String password = request.getParameter("password");

		String checkbox = request.getParameter("checkbox");

		// �ж��û��Ƿ����

		User user = new User(username, password);

		if (uservice.login(user)) {

			// �ж��Ƿ񱣴��û���Ϣ

			// �ж��Ƿ�ѡ���ס�û���Ϣ

			if ("save".equals(checkbox)) {

				// ����cookie�����û���Ϣ

				Cookie cookie = new Cookie("username",
						java.net.URLEncoder.encode(username, "UTF-8"));
				Cookie cookie2 = new Cookie("password",
						java.net.URLEncoder.encode(password, "UTF-8"));

				// ����cookie����Ч��Ϊ30��

				cookie.setMaxAge(60 * 60 * 24 * 30);

				cookie2.setMaxAge(60 * 60 * 24 * 30);

				response.addCookie(cookie);

				response.addCookie(cookie2);

			} else {

				// ���cookie��Ϣ
				Cookie[] cookies = request.getCookies();

				if (cookies != null) {

					for (int i = 0; i < cookies.length; i++) {

						if ("username".equals(cookies[i].getName())) {

							cookies[i].setValue("");

							response.addCookie(cookies[i]);

						}

						if ("password".equals(cookies[i].getName())) {
							cookies[i].setValue("");

							response.addCookie(cookies[i]);
						}

					}

				}

			}

			// ���û��������session

			HttpSession session = request.getSession();

			session.setAttribute("username", username);

			// �ض��򵽵�¼�ɹ�ҳ�棡

			request.getRequestDispatcher("WEB-INF/jsp/login_success.jsp")
					.forward(request, response);

		} else {

			request.getRequestDispatcher("WEB-INF/jsp/login_failed.jsp")
					.forward(request, response);
		}

	}

}
