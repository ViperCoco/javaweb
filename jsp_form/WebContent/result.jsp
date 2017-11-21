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
		request.setCharacterEncoding("utf-8");
			String user_name = request.getParameter("user_name");
			

		String sex = request.getParameter("sex");
		String phone_number = request.getParameter("phone_number");

		String email = request.getParameter("email");

		String kc_name = request.getParameter("kc_name");

		String school_name = request.getParameter("school_name");

		String[] knows = request.getParameterValues("CheckboxGroup1");

		String quesion = request.getParameter("quesion");
	%>
	<center><h3>报名信息</h3></center>
	<hr>
	
	姓名：<%=user_name %><br>
	
	性别：<%=sex %><br>
	
	电话号码：<%=phone_number %><br>
	
	电子邮件：<%=email %><br>
	
	课程名称：<%=kc_name %><br>
	
	
	学习名称：<%=school_name %><br>
	
	了解课程的渠道：<br><%
	
	if(knows!=null){
		

		for(int i=0;i<knows.length;i++){
			
			
			out.print(knows[i]);
			
			out.print("<br>");
			
		}
		
	}
	
	%><br>
	
	问题：<%=quesion %><br>
	
	

</body>
</html>