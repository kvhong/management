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
    <title>课程信息页面</title>
  </head>
  
  <body>
  <h1>${xiaoxi}</h1>
  <table  width="600" border="1" cellpadding="0" >
  		<tr>
	  		<th>课程号</th>
	  		<th>课程名</th>
	  		<th>教材</th>
	  		<th>学时</th>
  		</tr>
 		 <c:forEach var="U" items="${list}"  >
	           <tr>
	               <td>${U.coursenum }</td>
	               <td>${U.coursename }</td>
	                <td>${U.material }</td>
	               <td>${U.studytime }</td>
	               <td><a href="DeleteServlet?id=${U.coursenum }&flag=CourseM" target="_blank">删除</a> </td>
	               <td><a href="updatecoursemsg.jsp?cnum=${U.coursenum }&cname=${U.coursename }
	               &material=${U.material }&studytime=${U.studytime }" target="_blank">更新</a></td>
	          </tr>
             </c:forEach>  
    </table>
    <form action="newcoursemsg.jsp" method="post" target="_blank">
             	<input type="submit" value="加入新课程信息">
             </form> 
  </body>
</html>