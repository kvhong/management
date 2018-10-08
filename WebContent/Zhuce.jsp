<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册页面</title>
  </head>
  <body >
  <form action="ZhuceServlet"method="post" style="padding-top:-700px;">
  	   请输入ID:<input name="id" type="text"><br><br>
	   输入用户名:<input name="name" type="text"><br><br>
	   输入密码:<input name="pwd" type="password"><br><br>
	   选择性别:<input type="radio"name="sex"value="男"checked>男
	        <input type="radio"name="sex"value="女">女<br><br>
	   年龄:<input name="age" type="text"><br><br>
	   部门:<input name="department" type="text"><br><br>
	   职位:<input name="position" type="text"><br><br>
	   联系方式:<input name="phone" type="text"><br><br>
	   <input type="reset" value='重置' ><input type="submit" value='注册' >
   </form>
  </body>
</html>
