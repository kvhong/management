<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.WorkerDao"%>
<%@page import="dao.WorkerDaoImpl"%>
<%@page import="entity.Workman" %>
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
	  		<th>性别</th>
	  		<th>年龄</th>
	  		<th>学历</th>
	  		<th>部门号</th>
	  		<th>职位编号</th>
  		</tr>
 		 <%   
 		 WorkerDao wd = new WorkerDaoImpl(); 
 		 List<Workman> list =wd.getWorkerAll();   
 		 for(Workman tl:list)
         {
         %>
	           <tr>
	               <td><%=tl.getJobnum() %></td>
	               <td><%=tl.getName() %></td>
	               <td><%=tl.getSex() %></td>
	               <td><%=tl.getAge() %></td>
	                <td><%=tl.getEducation() %></td>
	               <td><%=tl.getDepartmentnum() %></td>
	               <td><%=tl.getPostnum() %></td>
	               <td><a href="searchworkermessge.jsp?num=<%=tl.getJobnum() %>&name=<%=tl.getName() %>&dnum=<%=tl.getDepartmentnum() %>&pnum=<%=tl.getPostnum() %>">操作</a>  
	               <a href="DeleteServlet?id=<%=tl.getJobnum() %>&flag=Worker" target="_blank">删除</a> </td>
	               <td><a href="updateworker.jsp?num=<%=tl.getJobnum() %>&name=<%=tl.getName() %>&sex=<%=tl.getSex() %>&age=<%=tl.getAge() %>
	               &dnum=<%=tl.getDepartmentnum() %>&pnum=<%=tl.getPostnum() %>&edu=<%=tl.getEducation() %>" target="_blank">更新</a></td>
	          </tr>
             <%}%>  
             <form action="newworker.jsp" method="post" target="_blank">
             	<input type="submit" value="加入新职工">
             </form>   
    </table>
  </body>
</html>
