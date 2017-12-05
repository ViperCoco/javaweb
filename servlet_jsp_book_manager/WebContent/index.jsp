<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>login</title>
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
a {
	text-decoration: none;
	color:#666;
}
</style>
</head>

<body>
<center>
  <h3>账号登录</h3>
</center>
<hr>
<form name="form1" method="post" action="login.do">
  <table width="511" height="325" border="1" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td align="center"><img  src="images/username_logo.jpg"/>
        <label for="textfield"></label>
        <input type="text" name="username" id="textfield" required placeholder="请输入用户名"></td>
    </tr>
    <tr>
      <td align="center"><img   src="images/password_logo.jpg"/>
        <label for="textfield2"></label>
        <input type="password" name="password" id="textfield2" required  placeholder="请输入密码"></td>
    </tr>
    <tr>
      <td align="center"><input type="submit" name="button" id="bt" value="登录"  ></td>
    </tr>
    <tr>
      <td align="center"><a href="toregist.do"  target="_blank" >免费注册</a></td>
    </tr>
  </table>
</form>
</body>
</html>
