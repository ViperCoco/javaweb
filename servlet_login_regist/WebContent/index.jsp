<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>login</title>
</head>

<body>


	<%
		String username = "";

		String password = "";

		//清除cookie信息
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {

			for (int i = 0; i < cookies.length; i++) {

				if ("username".equals(cookies[i].getName())) {

					username = cookies[i].getValue();

					username = java.net.URLDecoder
							.decode(username, "UTF-8");

				}

				if ("password".equals(cookies[i].getName())) {

					password = cookies[i].getValue();

					password = java.net.URLDecoder
							.decode(password, "UTF-8");

				}

			}

		}
	%>
<form name="form1" method="post" action="login.do">



		<center>
			<h2>欢迎登录</h2>
		</center>

		<hr>
		<table width="805" height="205" border="1" align="center"
			cellpadding="0" cellspacing="0">
			<tr>
				<td width="279" align="center">用户名：</td>
				<td width="520" align="center"><label for="textfield"></label>
					<input type="text" name="username" id="textfield" value="<%=username%>"
					required="required"></td>
			</tr>
			<tr>
				<td align="center">密码：</td>
				<td align="center"><label for="textfield2"></label> <input
					type="password" name="password" id="textfield2"  value="<%=password%>" required ></td>
			</tr>
			<tr>
			  <td colspan="2" align="right" bgcolor="#CCFFFF">           <input type="checkbox" name="checkbox" id="checkbox" value="save" checked>记住用户名和密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		      <label for="checkbox"></label></td>
		  </tr>
			<tr>
				<td colspan="2" align="center" bgcolor="#CCFFFF"><input
					type="submit" name="button" id="button" value="登录"> <a
					href="toregist.do">注册</a></td>
			</tr>
		</table>
	</form>
</body>
</html>
