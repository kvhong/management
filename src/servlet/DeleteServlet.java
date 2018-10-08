package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;

public class DeleteServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException{
		String id = request.getParameter("id");
		String flag = request.getParameter("flag");
		
		switch (flag) {
		case "Worker":
			WorkerDao wd = new WorkerDaoImpl();
			
			if(wd.delete(id)) {
				request.setAttribute("xiaoxi", "删除成功");
				request.getRequestDispatcher("/showall.jsp").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
			break;
		case "Department":
			DepartmentDao dd = new DepartmentDaoImpl();
			
			if(dd.delete(id)) {
				request.setAttribute("xiaoxi", "删除成功");
				request.getRequestDispatcher("/department.jsp").forward(request, response);
			}else {
				response.sendRedirect("index.jsps");
			}
			break;
		case "Post":
			PostDao pd = new PostDaoImpl();
			
			if(pd.delete(id)) {
				request.setAttribute("xiaoxi", "删除成功");
				request.getRequestDispatcher("/post.jsp").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
			break;
		case "Wage":
			String namew = request.getParameter("name");
			WageDao wad = new WageDaoImpl();
			
			if(wad.delete(id)) {
				request.setAttribute("xiao", "删除成功");
				request.getRequestDispatcher("/wage.jsp?num="+id+"&name="+namew+"").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
			break;
		case "Belong":
			String nameb = request.getParameter("name");
			BelongDao bd = new BelongDaoImpl();
			
			if(bd.delete(id)) {
				request.setAttribute("xiaoxi", "删除成功");
				request.getRequestDispatcher("/belong.jsp?num="+id+"&name="+nameb+"").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
			break;
		case "Skill":
			String names = request.getParameter("name");
			SkillDao sd = new SkillDaoImpl();
			
			if(sd.delete(id)) {
				request.setAttribute("xiaoxi", "删除成功");
				request.getRequestDispatcher("/skill.jsp?num="+id+"&name="+names+"").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
			break;
		case "RandP":
			String namer = request.getParameter("name");
			RandPDao rd = new RandPDaoImpl();
			
			if(rd.delete(id)) {
				request.setAttribute("xiaoxi", "删除成功");
				request.getRequestDispatcher("/rewardandpenalty.jsp?num="+id+"&name="+namer+"").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
			break;
		case "Course":
			String namec = request.getParameter("name");
			CourseDao cd = new CourseDaoImpl();
			
			if(cd.delete(id)) {
				request.setAttribute("xiaoxi", "删除成功");
				request.getRequestDispatcher("/course.jsp?num="+id+"&name="+namec+"").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
			break;
		case "CourseM":
			CourseDao cdm = new CourseDaoImpl();
			if(cdm.deletecourse(id)) {
				request.setAttribute("xiaoxi", "删除成功");
				request.getRequestDispatcher("/CourseMessage.jsp").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
			break;
		default:
			break;
		}
	}
}
