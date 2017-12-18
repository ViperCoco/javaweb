<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>listall</title>
</head>

<body>
	<table width="601" height="185" border="1" align="center"
		cellpadding="0" cellspacing="0">
		<tr>
			<td width="96" align="center">id</td>
			<td width="135" align="center">name</td>
			<td width="112" align="center">sex</td>
			<td width="111" align="center">age</td>
			<td width="135" align="center">hobby</td>
		</tr>

		<c:forEach items="${list }" var="student">

			<tr>
				<td align="center">${student.id }</td>
				<td align="center">${student.name }</td>
				<td align="center">${student.sex }</td>
				<td align="center">${student.age }</td>
				<td align="center">${student.hobby }</td>
			</tr>

		</c:forEach>


	</table>
</body>
</html>
