package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import entity.Department;


public class DepartmentServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException{
		DepartmentDao dd = new DepartmentDaoImpl();
		List<Department> list = dd.getDepartmentAll();
		request.setAttribute("DepartmentAll", list);
		request.getRequestDispatcher("/department.jsp").forward(request, response);
	}
}
