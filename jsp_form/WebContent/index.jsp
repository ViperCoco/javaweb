<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>regist_table_dw</title>
</head>

<body>
<form name="form1" method="post"  action="result.jsp" >
  <table width="789" height="800" border="1" align="center" cellspacing="0">
    <tr>
      <td colspan="2" align="center">我要报名</td>
    </tr>
    <tr>
      <td width="198">您的姓名：</td>
      <td width="581"><label for="textfield"></label>
      <input type="text" name="user_name" id="textfield" required="required"></td>
    </tr>
    <tr>
      <td>性别：</td>
      <td>男
        <input name="sex" type="radio" id="radio" value="男" checked>
      <label for="radio">女
        <input type="radio" name="sex" id="radio2" value="女">
      </label></td>
    </tr>
    <tr>
      <td>联系电话：</td>
      <td><label for="textfield2"></label>
      <input type="text" name="phone_number" id="textfield2" required="required"></td>
    </tr>
    <tr>
      <td>电子邮件：</td>
      <td><label for="textfield3"></label>
      <input type="text" name="email" id="textfield3" required="required"></td>
    </tr>
    
        
    <tr>
      <td>参加课程：</td>
      <td><label for="select"></label>
        <select name="kc_name" id="select">
          <option value="嵌入式" selected>嵌入式</option>
          <option value="Android">Android</option>
          <option value="JavaEE">JavaEE</option>
          <option value="HTML5">HTML5</option>
          <option value="VR/AR">VR/AR</option>
          <option value="UI设计">UI设计</option>
      </select></td>
    </tr>
    <tr>
      <td>学校或单位：</td>
      <td><label for="textfield4"></label>
      <input type="text" name="school_name" id="textfield4" required="required"></td>
    </tr>
    <tr>
      <td>您从哪里知道我们课程的？（多选）</td>
      <td><p>
        <label>
          <input type="checkbox" name="CheckboxGroup1" value="网络" id="CheckboxGroup1_0">
          网络</label>
        <br>
        <label>
          <input type="checkbox" name="CheckboxGroup1" value="朋友介绍" id="CheckboxGroup1_1">
          朋友介绍</label>
        <br>
        <label>
          <input type="checkbox" name="CheckboxGroup1" value="宣讲会" id="CheckboxGroup1_2">
          宣讲会</label>
        <br>
        <label>
          <input type="checkbox" name="CheckboxGroup1" value="教材" id="CheckboxGroup1_3">
          教材</label>
        <br>
      </p>        <label for="textarea"></label></td>
    </tr>
    <tr>
      <td><p>您参加本课程的时间，以及对本课程有什么期待？</p></td>
      <td><textarea name="quesion" id="textarea" required="required"></textarea></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><input type="submit" name="button" id="button" value="提交">
      <input type="reset" name="button2" id="button2" value="重置"></td>
    </tr>
  </table>
</form>
</body>
</html>
