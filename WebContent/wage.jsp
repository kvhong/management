<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.WageDao"%>
<%@page import="dao.WageDaoImpl"%>
<%@page import="entity.wages" %>
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
	  		<th>基本工资</th>
	  		<th>级别工资</th>
	  		<th>养老金</th>
	  		<th>失业金</th>
	  		<th>公积金</th>
	  		<th>纳税</th>
  		</tr>
 		 <%   
 		 WageDao wd = new WageDaoImpl(); 
 		 List<wages> list =wd.getWageMessage(request.getParameter("num"));   
 		 for(wages tl:list)
         {
         %>
	           <tr>
	               <td><%=request.getParameter("num") %></td>
	               <td><%=request.getParameter("name") %></td>
	               <td><%=tl.getBasicmoney() %></td>
	               <td><%=tl.getLevelmoney() %></td>
	               <td><%=tl.getOldmoney() %></td>
	                <td><%=tl.getUnemploymentmoney() %></td>
	               <td><%=tl.getAccumulationmoney() %></td>
	               <td><%=tl.getPaymoney() %></td>
	               <td><a href="DeleteServlet?id=<%=request.getParameter("num") %>&name=<%=request.getParameter("name") %>&flag=Wage" target="_blank">删除</a> </td>
	               <td><a href="updatewage.jsp?num=<%=request.getParameter("num") %>&name=<%=request.getParameter("name") %>&bmon=<%=tl.getBasicmoney() %>
	               &lmon=<%=tl.getLevelmoney() %>&omon=<%=tl.getOldmoney() %>&umon=<%=tl.getUnemploymentmoney() %>&amon=<%=tl.getAccumulationmoney() %>
	               &pmon=<%=tl.getPaymoney() %>" target="_blank">更新</a></td>
	          </tr>
             <%}%>    
    </table>
    <form action="newwage.jsp" method="post" target="_blank">
    			<input type="hidden" name="id" value="<%=request.getParameter("num")%>" />
    			<input type="hidden" name="name" value="<%=request.getParameter("name")%>" />
             	<input type="submit" value="加入新工资信息">
             </form> 
  </body>
</html>