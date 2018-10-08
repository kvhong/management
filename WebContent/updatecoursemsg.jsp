<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../js/WdatePicker.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/WdatePicker.css">
     <script type="text/javascript"> </script>
  <head>
    <title>更新课程信息</title>
  </head>
  <body >
  <form action="UpdateServlet?flag=CourseM" method="post" style="padding-top:-700px;">
	   课程号:<input name="coursenum" type="text" value=<%=request.getParameter("cnum") %> readonly><br><br>
	   课程名称:<input name="coursename" type="text" value=<%=request.getParameter("cname") %>><br><br>
	   教材:<input name="material" type="text" value=<%=request.getParameter("material") %>><br><br>
	   学时:<input name="studytime" type="text" value=<%=request.getParameter("studytime") %>><br><br>
	   <input type="reset" value='重置' ><input type="submit" value='更新' >
   </form>
  </body>
</html>