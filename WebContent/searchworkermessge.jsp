<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>职工操作页面</title>
</head>
<body>
			工号：<%=request.getParameter("num") %> 姓名：<%=request.getParameter("name") %> <br>
			部门号：<%=request.getParameter("dnum") %> 岗位编号：<%=request.getParameter("pnum") %> <br>  
			<tr>
				<td><a href="wage.jsp?num=<%=request.getParameter("num") %>&name=<%=request.getParameter("name")%>">查看职工工资</a> 
				<a href="belong.jsp?num=<%=request.getParameter("num") %>&name=<%=request.getParameter("name")%>
				&dnum=<%=request.getParameter("dnum") %>&pnum=<%=request.getParameter("pnum") %>">查看职工所属部门和岗位</a></td>
				<td><a href="skill.jsp?num=<%=request.getParameter("num") %>&name=<%=request.getParameter("name")%>">查看职工技能</a> 
				<a href="course.jsp?num=<%=request.getParameter("num") %>&name=<%=request.getParameter("name")%>">查看职工选课</a></td>
				<td><a href="rewardandpenalty.jsp?num=<%=request.getParameter("num") %>&name=<%=request.getParameter("name")%>">查看职工奖惩</a></td>
			</tr>
  </body>
</html>