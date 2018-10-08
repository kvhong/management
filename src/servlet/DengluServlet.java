package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;

public class DengluServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		UserDao ud = new UserDaoImpl();
		
		if(ud.login(name, pwd)) {
			request.getSession().setAttribute("welcome", "欢迎用户	"+name);
			response.setContentType("text/html");
			response.getWriter().println("<script>alert('登录成功');location.href='success.jsp'</script>");
		}else {
			String script = "<script>alert('用户名或密码错误，请重新登陆');location.href='Denglu.jsp'</script>";
			   response.getWriter().println(script);
		}
	}
	
}
