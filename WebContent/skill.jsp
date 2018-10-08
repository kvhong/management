<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.SkillDao"%>
<%@page import="dao.SkillDaoImpl"%>
<%@page import="entity.skill" %>
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
	  		<th>时间</th>
	  		<th>地点</th>
	  		<th>技能编号</th>
	  		<th>技能名称</th>
	  		<th>技能等级</th>
  		</tr>
 		 <%   
 		 SkillDao sd = new SkillDaoImpl(); 
 		 List<skill> list =sd.getSkillMessage(request.getParameter("num"));   
 		 for(skill tl:list)
         {
         %>
	           <tr>
	               <td><%=request.getParameter("num") %></td>
	               <td><%=request.getParameter("name") %></td>
	               <td><%=tl.getTime() %></td>
	               <td><%=tl.getPlace() %></td>
	               <td><%=tl.getSkillnum() %></td>
	               <td><%=tl.getSkillname() %></td>
	                <td><%=tl.getSkillgrade() %></td>
	               <td><a href="DeleteServlet?id=<%=tl.getSkillnum() %>&name=<%=request.getParameter("name") %>&flag=Skill" target="_blank">删除</a> </td>
	               <td><a href="updateskill.jsp?num=<%=request.getParameter("num") %>&name=<%=request.getParameter("name") %>
	               &snum=<%=tl.getSkillnum() %>&sname=<%=tl.getSkillname() %>&sgrade=<%=tl.getSkillgrade() %>
	               &time=<%=tl.getTime() %>&place=<%=tl.getPlace() %>" target="_blank">更新</a></td>
	          </tr>
             <%}%>  
    </table>
    <form action="newskill.jsp" method="post" target="_blank">
    			<input type="hidden" name="id" value="<%=request.getParameter("num")%>" />
    			<input type="hidden" name="name" value="<%=request.getParameter("name")%>" />
             	<input type="submit" value="加入新技能信息">
             </form> 
  </body>
</html>