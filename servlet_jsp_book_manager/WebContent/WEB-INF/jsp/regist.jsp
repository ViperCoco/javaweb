<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>regist</title>

<style>
input {
	width: 300px;
	height: 50px;
	margin-left: 30px;
}

#bt {
	color: #FFF;
	background: #EE6363;
}
</style>
</head>

<body>
	<center>
		<h3>用户注册</h3>
	</center>
	<hr>
	
	<form name="form1" method="post" action="regist.do">
	<table width="576" height="460" border="1" align="center"
		cellpadding="0" cellspacing="0">
		<tr>
			<td width="115" align="center">用户名：</td>
			<td width="455" align="center"><label for="textfield"></label> <input
				type="text" name="username" id="text_username" required="required" onblur="checkUser()"></td>
		</tr>
		<tr>
			<td align="center">密码：</td>
			<td align="center"><label for="textfield2"></label> <input
				type="text" name="password" id="textfield2" required="required"></td>
		</tr>
		<tr>
			<td align="center">确认密码：</td>
			<td align="center"><label for="textfield3"></label> <input
				type="text" name="password2" id="textfield3" required="required"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input id="bt" type="submit"
				name="button" value="立即注册" onclick="return check_password()"></td>
		</tr>
	</table>
	
	</form>
	
	<script src="./js/jquery-3.2.1.min.js" type="text/javascript"></script>

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

		function checkUser() {
			

			var userName = document.getElementById('text_username').value;

			$.ajax({
				type : "post",
				url : "checkuser.do",
				dataType : "text",
				data : {
					"name" : userName,
				},
				success : function(data) {
					

					if (data == "exists") {

						alert("该用户名已被注册！");
						document.getElementById("text_username").focus();

					}

					//$("#content").html("<span style='color:green;'>"+data+"</span>");
				},
				error : function(e) {
					// $("#content").html("<span style='color:red;'>请求失败</span>");

					alert("请求失败！");
					document.getElementById('text_username').value="";

					
				}
			});

		}
	</script>
</body>
</html>
