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
		String username = request.getParameter("username");

		String password = request.getParameter("password");

		String result = request.getParameter("checkbox");

		//模拟验证

		if ("小明".equals(username) && "abc".equals(password)) {

			//判断是否选择记住用户信息

			if ("save".equals(result)) {

				//创建cookie保存用户信息

			}

		}
	%>

	<%=result%>


</body>
</html>