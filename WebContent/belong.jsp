<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.BelongDao"%>
<%@page import="dao.BelongDaoImpl"%>
<%@page import="entity.Belong" %>
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
  <table  width="800" border="1" cellpadding="0" >
  		<tr>
  			<th>工号</th>
	  		<th>姓名</th>
	  		<th>部门号</th>
	  		<th>部门名称</th>
	  		<th>职能</th>
	  		<th>岗位编号</th>
	  		<th>岗位名称</th>
	  		<th>岗位等级</th>
  		</tr>
 		 <%   
 		 BelongDao bd = new BelongDaoImpl(); 
 		 List<Belong> list =bd.getDPMessage(request.getParameter("num"));   
 		 for(Belong tl:list)
         {
         %>
	           <tr>
	               <td><%=request.getParameter("num") %></td>
	               <td><%=request.getParameter("name") %></td>
	               <td><%=tl.getDepartmentnum() %></td>
	               <td><%=tl.getDepartmentname() %></td>
	               <td><%=tl.getFunction() %></td>
	               <td><%=tl.getPostnum() %></td>
	               <td><%=tl.getPostname() %></td>
	               <td><%=tl.getPostgrade() %></td>
	               <td><a href="DeleteServlet?id=<%=request.getParameter("num") %>&name=<%=request.getParameter("name") %>&flag=Belong" target="_blank">删除</a> </td>
	               <td><a href="updatebelong.jsp?num=<%=request.getParameter("num") %>&name=<%=request.getParameter("name") %>
	               &dnum=<%=tl.getDepartmentnum() %>&pnum=<%=tl.getPostnum() %>" target="_blank">更新</a></td>
	          </tr>
             <%}%>    
    </table>
    <form action="newbelong.jsp" method="post" target="_blank">
    			<input type="hidden" name="id" value="<%=request.getParameter("num")%>" />
    			<input type="hidden" name="name" value="<%=request.getParameter("name")%>" />
             	<input type="submit" value="加入新所属信息">
             </form> 
  </body>
</html>