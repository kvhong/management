<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>更新部门信息</title>
  </head>
  <body >
  <form action="UpdateServlet?flag=Department"method="post" style="padding-top:-700px;">
  	   部门号:<input name="departmentnumber" type="text" value=<%=request.getParameter("num") %> readonly><br><br>
	   部门名称:<input name="departmentname" type="text" value=<%=request.getParameter("name") %>><br><br>
	   职能:<input name="function" type="text" value=<%=request.getParameter("function") %>><br><br>
	   <input type="reset" value='重置' ><input type="submit" value='更新' >
   </form>
  </body>
</html>
