<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="form1" method="post" action="regist.do">



		<center>
			<h2>注册</h2>
		</center>

		<hr>
		<table width="805" height="205" border="1" align="center"
			cellpadding="0" cellspacing="0">
			<tr>
				<td width="279" align="center">用户名：</td>
				<td width="520" align="center"><label for="textfield"></label>
					<input type="text" name="username" id="text_username" required
					></td>
			</tr>
			<tr>
				<td align="center">密码：</td>
				<td align="center"><label for="textfield2"></label> <input
					type="password" name="password" id="textfield2" required></td>
			</tr>

			<tr>
				<td align="center">确认密码：</td>
				<td align="center"><label for="textfield2"></label> <input
					type="password" name="password2" id="textfield3" required></td>
			</tr>
			<tr>
				<td colspan="2" align="center" bgcolor="#CCFFFF"><input
					type="submit" name="button" id="button" value="注册"
					onclick="return check_password()"> <input type="button"
					name="button2" id="button2" value="返回"
					onclick="javascript:history.back();">
			</tr>
		</table>

	</form>

	<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>

	<script type="text/javascript" charset="UTF-8">
		window.onload = function() {
			document.getElementById("text_username").focus();
		}

		function check_password() {

			var password1 = document.getElementById('textfield2').value;

			var password2 = document.getElementById('textfield3').value;

			if (password1 == password2) {

				return true;

			} else {

				alert('密码不一致!');

				document.getElementById('textfield3').value = "";

				return false;

			}

		}

		
	</script>
</body>
</html>