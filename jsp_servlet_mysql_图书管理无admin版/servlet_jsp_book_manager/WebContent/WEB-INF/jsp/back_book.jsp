<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>back_book</title>

<style>
.book_img {
	width: 150px;
	height: 200px;
	padding: 10px;
}

#bt {
	color: #FFF;
	background: #EE6363;
}
</style>
</head>

<body>

	<center>
		<h3>归还图书信息！</h3>
	</center>

	<hr>
	<table border="1" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td rowspan="4" align="center"><img class="book_img"
				src=${back_img } /></td>
			<td width="561" height="65">书名：${ back_name}</td>
		</tr>
		<tr>
			<td height="50">每日租金（元）：${ back_price}</td>
		</tr>
		<tr>
			<td height="47">借出天数（天）：${ back_days}</td>
		</tr>
		<tr>
			<td>租金（元）：${back_money }</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a
				href="listbook.do?page=${back_page }"><input type="button"
				name="button" id="bt" value="确定"></a></td>
		</tr>
	</table>


</body>
</html>
