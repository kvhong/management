<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>加入新职工</title>
  </head>
  <body >
  <form action="InsertServlet?flag=Worker"method="post" style="padding-top:-700px;">
  	   工号:<input name="jobnum" type="text"><br><br>
	   姓名:<input name="name" type="text"><br><br>
	   选择性别:<input type="radio"name="sex"value="男"checked>男
	        <input type="radio"name="sex"value="女">女<br><br>
	   年龄:<input name="age" type="text"><br><br>
	   学历:<input name="education" type="text"><br><br>
	   部门号:<input name="departmentnum" type="text"><br><br>
	   职位编号:<input name="postnum" type="text"><br><br>
	   <input type="reset" value='重置' ><input type="submit" value='加入' >
   </form>
  </body>
</html>
