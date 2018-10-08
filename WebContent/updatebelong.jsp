<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>更新职工所属部门、岗位信息</title>
  </head>
  <body >
  <form action="UpdateServlet?flag=Belong" method="post" style="padding-top:-700px;">
  	   工号:<input name="jobnum" type="text" value=<%=request.getParameter("num") %> readonly><br><br>
	   姓名:<input name="name" type="text" value=<%=request.getParameter("name") %> readonly><br><br>
	  部门号:<input name="departmentnum" type="text" value=<%=request.getParameter("dnum") %>><br><br>
	   岗位编号:<input name="postnum" type="text" value=<%=request.getParameter("pnum") %>><br><br>
	   <input type="reset" value='重置' ><input type="submit" value='更新' >
   </form>
  </body>
</html>