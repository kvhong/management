package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class ZhuceServlet extends HttpServlet{
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
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		String department = request.getParameter("department");
		String position = request.getParameter("position");
		String phone = request.getParameter("phone");
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPwd(pwd);
		user.setSex(sex);
		user.setAge(age);
		user.setDepartment(department);
		user.setPosition(position);
		user.setPhone(phone);
		
		UserDao ud = new UserDaoImpl();
		if(ud.register(user)) {
			request.getSession().setAttribute("username", name);
			response.setContentType("text/html");
			response.getWriter().println("<script>alert('×¢²á³É¹¦');location.href='Denglu.jsp'</script>");
		}else {
			String script = "<script>alert('×¢²áÊ§°Ü£¬ÇëÖØÐÂ×¢²á');location.href='Zhuce.jsp'</script>";
			   response.getWriter().println(script);
		}
	}
}
