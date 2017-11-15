<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
</head>

<body>
<form name="form1" method="post" action="dologin.jsp">
  <table width="650" height="250" border="1" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td width="285">用户名：</td>
      <td width="359" align="center"><label for="textfield"></label>
      <input type="text" name="username" id="textfield" required></td>
    </tr>
    <tr>
      <td>密码：</td>
      <td align="center"><label for="textfield2"></label>
      <input type="text" name="password" id="textfield2" required></td>
    </tr>
    <tr>
      <td colspan="2" align="left"><input type="checkbox" name="checkbox" id="checkbox" value="save" checked="checked">保存用户名和密码
      <label for="checkbox"></label></td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#99FFFF"><input type="submit" name="button" id="button" value="登录">
      <input type="reset" name="button2" id="button2" value="取消"></td>
    </tr>
  </table>
</form>
</body>
</html>
    