package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDao;
import dao.PostDaoImpl;
import entity.Post;

public class PostServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException{
		String departmentnum = request.getParameter("departmentnum");
		PostDao pd = new PostDaoImpl();
		List<Post> list = pd.getPostAll(departmentnum);
		request.setAttribute("PostAll", list);
		request.getRequestDispatcher("/post.jsp?departmentnum="+departmentnum+"").forward(request, response);
	}
}
