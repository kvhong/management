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
    <title>加入职工奖惩信息</title>
  </head>
  <body >
  <form action="InsertServlet?flag=RandP" method="post" style="padding-top:-700px;">
  	   工号:<input name="jobnum" type="text" value="<%=request.getParameter("id") %>" readonly><br><br>
  	    姓名:<input name="name" type="text" value="<%=request.getParameter("name") %>" readonly><br><br>
	   奖惩日期:<input name="time" type="date"><br><br>
	   序号:<input name="sequencenum" type="text"><br><br>
	   奖惩标志:<input name="sign" type="text"><br><br>
	   项目:<input name="project" type="text"><br><br>
	   奖惩金额:<input name="money" type="text"><br><br>
	   <input type="reset" value='重置' ><input type="submit" value='加入' >
   </form>
  </body>
</html>