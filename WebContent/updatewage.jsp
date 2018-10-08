<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>更新职工工资信息</title>
  </head>
  <body >
  <form action="UpdateServlet?flag=Wage" method="post" style="padding-top:-700px;">
  	   工号:<input name="jobnum" type="text" value=<%=request.getParameter("num") %> readonly><br><br>
	   姓名:<input name="name" type="text" value=<%=request.getParameter("name") %> readonly><br><br>
	   基本工资:<input name="basicmoney" type="text" value=<%=request.getParameter("bmon") %>><br><br>
	   级别工资:<input name="levelmoney" type="text" value=<%=request.getParameter("lmon") %>><br><br>
	   养老金:<input name="oldmoney" type="text" value=<%=request.getParameter("omon") %>><br><br>
	   失业金:<input name="unemploymentmoney" type="text" value=<%=request.getParameter("umon") %>><br><br>
	   公积金:<input name="Accumulationmoney" type="text" value=<%=request.getParameter("amon") %>><br><br>
	   纳税:<input name="paymoney" type="text" value=<%=request.getParameter("pmon") %>><br><br>
	   <input type="reset" value='重置' ><input type="submit" value='更新' >
   </form>
  </body>
</html>