<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.RandPDao"%>
<%@page import="dao.RandPDaoImpl"%>
<%@page import="entity.rewardandpenalty" %>
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
	  		<th>奖惩日期</th>
	  		<th>序号</th>
	  		<th>奖惩标志</th>
	  		<th>项目</th>
	  		<th>奖惩金额</th>
  		</tr>
 		 <%   
 		 RandPDao rd = new RandPDaoImpl(); 
 		 List<rewardandpenalty> list =rd.getRandPMessage(request.getParameter("num"));   
 		 for(rewardandpenalty tl:list)
         {
         %>
	           <tr>
	               <td><%=request.getParameter("num") %></td>
	               <td><%=request.getParameter("name") %></td>
	               <td><%=tl.getTime() %></td>
	               <td><%=tl.getSequencenum() %></td>
	                <td><%=tl.getSign() %></td>
	               <td><%=tl.getProject() %></td>
	               <td><%=tl.getMoney() %></td>
	               <td><a href="DeleteServlet?id=<%=tl.getSequencenum() %>&name=<%=request.getParameter("name") %>&flag=RandP" target="_blank">删除</a> </td>
	               <td><a href="updateRandP.jsp?num=<%=request.getParameter("num") %>&name=<%=request.getParameter("name") %>
	               &time=<%=tl.getTime() %>&snum=<%=tl.getSequencenum() %>&sign=<%=tl.getSign() %>
	               &project=<%=tl.getProject() %>&money=<%=tl.getMoney() %>" target="_blank">更新</a></td>
	          </tr>
             <%}%>     
    </table>
    <form action="newRandP.jsp" method="post" target="_blank">
    			<input type="hidden" name="id" value="<%=request.getParameter("num")%>" />
    			<input type="hidden" name="name" value="<%=request.getParameter("name")%>" />
             	<input type="submit" value="加入新所属信息">
             </form>
  </body>
</html>