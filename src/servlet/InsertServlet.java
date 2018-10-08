package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;

public class InsertServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException{
		String flag = request.getParameter("flag");
		switch (flag) {
		case "Worker":
			String jobnum = request.getParameter("jobnum");
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			int age = Integer.parseInt(request.getParameter("age"));
			String departmentnum = request.getParameter("departmentnum");
			String postnum = request.getParameter("postnum");
			String education = request.getParameter("education");
			
			WorkerDao wd = new WorkerDaoImpl();
			if(wd.insert(jobnum, name, sex, age, departmentnum, postnum, education)) {
				request.setAttribute("xiaoxi", "加入成功");
				request.getRequestDispatcher("Searchall").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
			break;
		case "Department":
			String departmentnumber = request.getParameter("departmentnumber");
			String departmentname = request.getParameter("departmentname");
			String function = request.getParameter("function");
			
			DepartmentDao dd = new DepartmentDaoImpl();
			if(dd.insert(departmentnumber, departmentname, function)) {
				request.setAttribute("xiaoxi", "加入成功");
				request.getRequestDispatcher("DepartmentServlet").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
			break;
		case "Post":
			String departmentnump = request.getParameter("departmentnum");
			String postnumber = request.getParameter("postnumber");
			String postname = request.getParameter("postname");
			String postgrade = request.getParameter("postgrade");
			String peoplenum = request.getParameter("peoplenum");
			
			PostDao pd = new PostDaoImpl();
			if(pd.insert(departmentnump,postnumber, postname, postgrade,peoplenum)) {
				request.setAttribute("xiaoxi", "加入成功");
				request.getRequestDispatcher("PostServlet").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
			break;
		case "Wage":
			String jobnumw = request.getParameter("jobnum");
			String namew = request.getParameter("name");
			String basicmoney = request.getParameter("basicmoney");
			String levelmoney = request.getParameter("levelmoney");
			String oldmoney = request.getParameter("oldmoney");
			String unemploymentmoney = request.getParameter("unemploymentmoney");
			String Accumulationmoney = request.getParameter("Accumulationmoney");
			String paymoney = request.getParameter("paymoney");
			
			WageDao wad = new WageDaoImpl();
			if(wad.insert(jobnumw, basicmoney, levelmoney, oldmoney, unemploymentmoney, Accumulationmoney, paymoney)) {
				request.setAttribute("xiaoxi", "加入成功");
				request.getRequestDispatcher("/wage.jsp?num="+jobnumw+"&name="+namew+"").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
			break;
		case "Belong":
			String jobnumb = request.getParameter("jobnum");
			String nameb = request.getParameter("name");
			String departmentnumb = request.getParameter("departmentnum");
			String postnumb = request.getParameter("postnum");
			
			BelongDao bd = new BelongDaoImpl();
			if(bd.insert(jobnumb, departmentnumb, postnumb)) {
				request.setAttribute("xiaoxi", "加入成功");
				request.getRequestDispatcher("/belong.jsp?num="+jobnumb+"&name="+nameb+"").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
			break;
		case "Skill":
			String jobnums = request.getParameter("jobnum");
			String names = request.getParameter("name");
			Date time = Date.valueOf(request.getParameter("time"));
			String place = request.getParameter("place");
			String skillnum = request.getParameter("skillnum");
			String skillname = request.getParameter("skillname");
			String skillgrade = request.getParameter("skillgrade");
			
			SkillDao sd = new SkillDaoImpl();
			if(sd.insert(jobnums, skillnum, skillname, skillgrade, time, place)) {
				request.setAttribute("xiaoxi", "加入成功");
				request.getRequestDispatcher("/skill.jsp?num="+jobnums+"&name="+names+"").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
			break;
		case "Course":
			String jobnumc = request.getParameter("jobnum");
			String namec = request.getParameter("name");
			String coursenum = request.getParameter("coursenum");
			Date timec = Date.valueOf(request.getParameter("time"));
			String score = request.getParameter("score");
			
			CourseDao cd = new CourseDaoImpl();
			if(cd.insert(jobnumc, coursenum, timec, score)) {
				request.setAttribute("xiaoxi", "加入成功");
				request.getRequestDispatcher("/course.jsp?num="+jobnumc+"&name="+namec+"").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
			break;
		case "RandP":
			String jobnumr = request.getParameter("jobnum");
			String namer = request.getParameter("name");
			Date timer = Date.valueOf(request.getParameter("time"));
			String sequencenum = request.getParameter("sequencenum");
			String sign = request.getParameter("sign");
			String project = request.getParameter("project");
			String money = request.getParameter("money");
			
			RandPDao rd = new RandPDaoImpl();
			if(rd.insert(jobnumr, timer, sequencenum, sign, project, money)) {
				request.setAttribute("xiaoxi", "加入成功");
				request.getRequestDispatcher("/rewardandpenalty.jsp?num="+jobnumr+"&name="+namer+"").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
			break;
		case "CourseM":
			String coursenumm = request.getParameter("coursenum");
			String coursename = request.getParameter("coursename");
			String material = request.getParameter("material");
			String studytime = request.getParameter("studytime");
			
			CourseDao cdm = new CourseDaoImpl();
			if(cdm.insertcourse(coursenumm, coursename, material, studytime)) {
				request.setAttribute("xiaoxi", "加入成功");
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
