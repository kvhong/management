<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.DepartmentDao"%>
<%@page import="dao.DepartmentDaoImpl"%>
<%@page import="entity.Department" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>部门信息页面</title>
  </head>
  
  <body>
  <h1>${xiaoxi}</h1>
  <table  width="600" border="1" cellpadding="0" >
  		<tr>
  			<th>部门号</th>
	  		<th>部门名称</th>
	  		<th>职能</th>
  		</tr>
 		 <c:forEach var="U" items="${list}"  >
           <tr>
               <td>${U.departmentnumber }</td>
               <td>${U.departmentname }</td>
               <td>${U.function }</td>
	           <td><a href="post.jsp?departmentnum=${U.departmentnumber }&name=${U.departmentname }">查看岗位</a>  
	           <a href="DeleteServlet?id=${U.departmentnumber }&flag=Department" target="_blank">删除</a> </td>
	           <td><a href="updatedepartment.jsp?num=${U.departmentnumber }&name=${U.departmentname }&function=${U.function }" target="_blank">更新</a></td>
          </tr>
             </c:forEach> 
             <form action="newdepartment.jsp" method="post" target="_blank">
             	<input type="submit" value="加入新部门">
             </form>
    </table>
  </body>
</html>
