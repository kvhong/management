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
    <title>更新职工技能信息</title>
  </head>
  <body >
  <form action="UpdateServlet?flag=Skill" method="post" style="padding-top:-700px;">
  	   工号:<input name="jobnum" type="text" value=<%=request.getParameter("num") %> readonly><br><br>
	   姓名:<input name="name" type="text" value=<%=request.getParameter("name") %> readonly><br><br>
	  时间:<input name="time" type="date" value=<%=request.getParameter("time") %>><br><br>
	   地点:<input name="place" type="text" value=<%=request.getParameter("place") %>><br><br>
	   技能编号:<input name="skillnum" type="text" value=<%=request.getParameter("snum") %> readonly><br><br>
	   技能名称:<input name="skillname" type="text" value=<%=request.getParameter("sname") %>><br><br>
	   技能等级:<input name="skillgrade" type="text" value=<%=request.getParameter("sgrade") %>><br><br>
	   <input type="reset" value='重置' ><input type="submit" value='更新' >
   </form>
  </body>
</html>