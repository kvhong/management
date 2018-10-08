<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>加入职工选课信息</title>
  </head>
  <body >
  <form action="InsertServlet?flag=CourseM" method="post" style="padding-top:-700px;">
  	    课程号:<input name="coursenum" type="text" ><br><br>
	   课程名称:<input name="coursename" type="text"><br><br>
	   教材:<input name="material" type="text"><br><br>
	   学时:<input name="studytime" type="text"><br><br>
	   <input type="reset" value='重置' ><input type="submit" value='加入' >
   </form>
  </body>
</html>