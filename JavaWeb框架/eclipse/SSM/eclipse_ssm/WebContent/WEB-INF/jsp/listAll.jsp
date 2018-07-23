<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width="1393" border="1" align="center" cellpadding="0"
		cellspacing="0">


		<tr>
			<td width="176" align="center" bgcolor="#99FFFF">编号</td>
			<td width="277" align="center" bgcolor="#99FFFF">姓名</td>
			<td width="234" align="center" bgcolor="#99FFFF">性别</td>
			<td width="181" align="center" bgcolor="#99FFFF">年龄</td>
			<td width="243" align="center" bgcolor="#99FFFF">爱好</td>
		</tr>

		<c:forEach items="${ stulist}" var="student">

			<tr>

				<td align="center">${ student.stuId}</td>
				<td align="center">${ student.stuName}</td>
				<td align="center">${ student.stuSex}</td>
				<td align="center">${ student.stuAge}</td>
				<td align="center">${ student.stuHobby}</td>
			</tr>


		</c:forEach>


	</table>

</body>
</html>