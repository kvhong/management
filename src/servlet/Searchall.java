package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WorkerDao;
import dao.WorkerDaoImpl;
import entity.Workman;

public class Searchall extends HttpServlet{
	
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
		WorkerDao wd = new WorkerDaoImpl();
		List<Workman> list = wd.getWorkerAll();
		request.setAttribute("workerAll", list);
		request.getRequestDispatcher("/showall.jsp").forward(request, response);
	}
}
