<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.CourseDao"%>
<%@page import="dao.CourseDaoImpl"%>
<%@page import="entity.course" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>职工信息页面</title>
  </head>
  
  <body>
  <h1>${xiaoxi}</h1>
  <table  width="600" border="1" cellpadding="0" >
  		<tr>
  			<th>工号</th>
	  		<th>姓名</th>
	  		<th>课程号</th>
	  		<th>课程名</th>
	  		<th>教材</th>
	  		<th>学时</th>
	  		<th>时间</th>
	  		<th>成绩</th>
  		</tr>
 		 <%   
 		 CourseDao cd = new CourseDaoImpl(); 
 		 List<course> list =cd.getCourseMessage(request.getParameter("num"));   
 		 for(course tl:list)
         {
         %>
	           <tr>
	               <td><%=request.getParameter("num") %></td>
	               <td><%=request.getParameter("name") %></td>
	               <td><%=tl.getCoursenum() %></td>
	               <td><%=tl.getCoursename() %></td>
	                <td><%=tl.getMaterial() %></td>
	               <td><%=tl.getStudytime() %></td>
	               <td><%=tl.getTime() %></td>
	               <td><%=tl.getScore() %></td>
	               <td><a href="DeleteServlet?id=<%=tl.getCoursenum() %>&name=<%=request.getParameter("name") %>&flag=Course" target="_blank">删除</a> </td>
	               <td><a href="updatecourse.jsp?num=<%=request.getParameter("num") %>&name=<%=request.getParameter("name")%>
	               &cnum=<%=tl.getCoursenum() %>&time=<%=tl.getTime() %>&score=<%=tl.getScore() %>" target="_blank">更新</a></td>
	          </tr>
             <%}%>   
    </table>
    <form action="newcourse.jsp" method="post" target="_blank">
    			<input type="hidden" name="id" value="<%=request.getParameter("num")%>" />
    			<input type="hidden" name="name" value="<%=request.getParameter("name")%>" />
             	<input type="submit" value="加入新所属信息">
             </form> 
  </body>
</html>