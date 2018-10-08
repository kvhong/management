<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.PostDao"%>
<%@page import="dao.PostDaoImpl"%>
<%@page import="entity.Post" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>岗位信息页面</title>
  </head>
  
  <body>
  <h1>${xiaoxi}</h1>
  <table  width="600" border="1" cellpadding="0" >
  		<tr>
  			<th>岗位编号</th>
	  		<th>岗位名称</th>
	  		<th>岗位等级</th>
	  		<th>人数</th>
  		</tr>
  		
 		 <%   
 		 PostDao wd = new PostDaoImpl(); 
 		 List<Post> list =wd.getPostAll(request.getParameter("departmentnum"));   
 		 for(Post tl:list)
         {
         %>
           <tr>
               <td><%=tl.getPostnumber() %></td>
               <td><%=tl.getPostname() %></td>
               <td><%=tl.getPostgrade() %></td>
               <td><%=tl.getPeoplenum() %></td>
               <td><a href="DeleteServlet?id=<%=tl.getPostnumber() %>&flag=Post" target="_blank">删除</a></td>
               <td><a href="updatepost.jsp?departmentnum=<%=request.getParameter("departmentnum") %>&num=<%=tl.getPostnumber() %>
               &name=<%=tl.getPostname() %>&grade=<%=tl.getPostgrade() %>&peoplenum=<%=tl.getPeoplenum()%>" target="_blank">更新</a></td>
          </tr>
             <%}%> 
             <form action="newpost.jsp" method="post" target="_blank">
             	<input type="hidden" name="departmentnum" value="<%=request.getParameter("departmentnum")%>" />
             	<input type="hidden" name="departmentname" value="<%=request.getParameter("name")%>" />
             	<input type="submit" value="加入新岗位">
             </form>
    </table>
  </body>
</html>
