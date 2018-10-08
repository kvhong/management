<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>加入新岗位</title>
  </head>
  <body >
  <form action="InsertServlet?flag=Post"method="post" style="padding-top:-700px;">
  	    部门号:<input name="departmentnum" type="text" value="<%=request.getParameter("departmentnum")%>" readonly><br><br>
  	    部门名称:<input name="departmentname" type="text" value="<%=request.getParameter("departmentname")%>" readonly><br><br>
  	   岗位编号:<input name="postnumber" type="text"><br><br>
	   岗位名称:<input name="postname" type="text"><br><br>
	   岗位等级:<input name="postgrade" type="text"><br><br>
	   岗位人数:<input name="peoplenum" type="text"><br><br>
	   <input type="reset" value='重置' ><input type="submit" value='加入' >
   </form>
  </body>
</html>
