<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录成功页面</title>
  </head>
  <body>
			${welcome} <br>  
			<a href="Searchall">查看职工信息</a>
			<a href="DepartmentServlet">查看部门信息</a>
			<a href="CourseMessage.jsp">查看课程信息</a><br><br>
			<form action="Search" method="post">
				<select style="width:60" class="ui-select" name="select" id="select">
	  				<option value="worker">职工</option>
	  				<option value="department">部门</option>
	  				<option value="course">课程</option>
				</select>
				<select style="width:100" class="ui-select-w" name="moreselect" id="moreselect">
					<option value="num">编号查询</option>
					<option value="name">名称查询</option>
				</select>
				<input name="search" type="text">
				<input type="submit" value="搜索">
			</form>
  </body>
</html>
