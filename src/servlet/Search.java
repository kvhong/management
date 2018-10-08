package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import entity.Department;
import entity.Workman;
import entity.course;

import java.util.*;

public class Search extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException{
		String flag = request.getParameter("select");
		String search = request.getParameter("search");
		String moresearch = request.getParameter("moreselect");
		
		SearchDao sd = new SearchDaoImpl();
		
		switch (flag) {
		case "worker":
			if(moresearch.equals("num")) {
				List<Workman> list = sd.getWorkerbynum(search);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/searchworker.jsp").forward(request, response);
			}else if(moresearch.equals("name")){
				List<Workman> list = sd.getWorkerbyname(search);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/searchworker.jsp").forward(request, response);
			}
			break;
		case "department":
			if(moresearch.equals("num")) {
				List<Department> list = sd.getDepartmentbynum(search);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/searchdepartment.jsp").forward(request, response);
			}else if(moresearch.equals("name")){
				List<Department> list = sd.getDepartmentbyname(search);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/searchdepartment.jsp").forward(request, response);
			}
			break;
		case "course":
			if(moresearch.equals("num")) {
				List<course> list = sd.getCoursebynum(search);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/searchcourse.jsp").forward(request, response);
			}else if(moresearch.equals("name")){
				List<course> list = sd.getCoursebyname(search);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/searchcourse.jsp").forward(request, response);
			}
			break;
		default:
			break;
		}
		
	}
}
