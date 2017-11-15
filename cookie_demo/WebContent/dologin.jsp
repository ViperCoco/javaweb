<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");

		String password = request.getParameter("password");

		String result = request.getParameter("checkbox");

		System.out.println(username);
		System.out.println(password);

		//模拟验证

		if ("小明".equals(username) && "abc".equals(password)) {

			//判断是否选择记住用户信息

			if ("save".equals(result)) {

				//创建cookie保存用户信息

				Cookie cookie = new Cookie("username",
						java.net.URLEncoder.encode(username, "UTF-8"));
				Cookie cookie2 = new Cookie("password",
						java.net.URLEncoder.encode(password, "UTF-8"));

				//设置cookie的有效期为30天

				cookie.setMaxAge(60 * 60 * 24 * 30);

				cookie2.setMaxAge(60 * 60 * 24 * 30);

				response.addCookie(cookie);

				response.addCookie(cookie2);

			} else {

				//清除cookie信息
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

			//转发到登录成功页面

			request.getRequestDispatcher("login_success.jsp").forward(
					request, response);

		} else {

			//转发到登录失败页面

			request.getRequestDispatcher("login_failed.jsp").forward(
					request, response);

		}
	%>




</body>
</html>