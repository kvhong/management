package dao;

import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import entity.course;
import util.DBconn;

public class CourseDaoImpl implements CourseDao{

	@Override
	public List<course> getCourseMessage(String jobnum) {
		List<course> list = new ArrayList<course>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectsql("select `curricula-variable`.*,`training courses`.* from workers INNER JOIN "
					+ "`curricula-variable` on workers.jobnum=`curricula-variable`.jobnum&&workers.jobnum='"+jobnum+"' INNER JOIN "
					+ "`training courses` on `curricula-variable`.coursenum=`training courses`.coursenum");
			while(rs.next()) {
				String coursenum = rs.getString("coursenum");
				String coursename = rs.getString("coursename");
				String material = rs.getString("material");
				String studytime = rs.getString("studytime");
				Date time = rs.getDate("time");
				String score = rs.getString("score");
				
				course course = new course();
				course.setCoursenum(coursenum);
				course.setCoursename(coursename);
				course.setMaterial(material);
				course.setStudytime(studytime);
				course.setTime(time);
				course.setScore(score);
				list.add(course);
				
			}
			DBconn.closeconn();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean update(String jobnum, String coursenum, Date time,String score) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("update `curricula-variable` set jobnum ='"+jobnum+"', coursenum ='"+coursenum+
				"', time ='"+time+"', score ='"+score+"' where jobnum ="+jobnum);
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean delete(String coursenum) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("delete from `curricula-variable` where coursenum ='"+coursenum+"'");
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean insert(String jobnum, String coursenum, Date time,String score) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("INSERT INTO `curricula-variable` VALUES ('"+jobnum+"','"+coursenum+"','"+time+"','"+score+"')");
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public List<course> getCourse() {
		List<course> list = new ArrayList<course>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectsql("select * from `training courses`");
			while(rs.next()) {
				course course = new course();
				course.setCoursenum(rs.getString("coursenum"));
				course.setCoursename(rs.getString("coursename"));
				course.setMaterial(rs.getString("material"));
				course.setStudytime(rs.getString("studytime"));
				list.add(course);
			}
			DBconn.closeconn();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean deletecourse(String coursenum) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("delete from `training courses` where coursenum ='"+coursenum+"'");
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean updatecourse(String coursenum, String coursename, String material, String studytime) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("update `training courses` set coursenum ='"+coursenum+"', coursename ='"+coursename+"', material ='"+material+
				"', studytime ='"+studytime+"' where coursenum ="+coursenum);
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean insertcourse(String coursenum, String coursename, String material, String studytime) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("insert into `training courses` values ('"+coursenum+"','"+coursename+"','"+material+"','"+studytime+"')");
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

}
