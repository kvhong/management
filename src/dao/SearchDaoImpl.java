package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Department;
import entity.Workman;
import entity.course;
import util.DBconn;

public class SearchDaoImpl implements SearchDao{

	@Override
	public List<Workman> getWorkerbynum(String num) {
		List<Workman> list = new ArrayList<Workman>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectsql("SELECT * FROM workers WHERE jobnum like '%"+num+"%';");
			while(rs.next()) {
				Workman workman = new Workman();
				workman.setJobnum(rs.getString("jobnum"));
				workman.setName(rs.getString("name"));
				workman.setSex(rs.getString("sex"));
				workman.setAge(rs.getInt("age"));
				workman.setEducation(rs.getString("education"));
				workman.setDepartmentnum(rs.getString("departmentnum"));
				workman.setPostnum(rs.getString("postnum"));
				list.add(workman);
			}
			DBconn.closeconn();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Department> getDepartmentbynum(String num) {
		List<Department> list = new ArrayList<Department>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectsql("SELECT * FROM department WHERE departmentnumber like '%"+num+"%';");
			while(rs.next()) {
				Department department = new Department();
				department.setDepartmentnumber(rs.getString("departmentnumber"));
				department.setDepartmentname(rs.getString("departmentname"));
				department.setFunction(rs.getString("function"));
				list.add(department);
			}
			DBconn.closeconn();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<course> getCoursebynum(String num) {
		List<course> list = new ArrayList<course>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectsql("SELECT * FROM `training courses` WHERE coursenum like '%"+num+"%';");
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
	public List<Workman> getWorkerbyname(String name) {
		List<Workman> list = new ArrayList<Workman>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectsql("SELECT * FROM workers WHERE name like '"+name+"';");
			while(rs.next()) {
				Workman workman = new Workman();
				workman.setJobnum(rs.getString("jobnum"));
				workman.setName(rs.getString("name"));
				workman.setSex(rs.getString("sex"));
				workman.setAge(rs.getInt("age"));
				workman.setEducation(rs.getString("education"));
				workman.setDepartmentnum(rs.getString("departmentnum"));
				workman.setPostnum(rs.getString("postnum"));
				list.add(workman);
			}
			DBconn.closeconn();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Department> getDepartmentbyname(String name) {
		List<Department> list = new ArrayList<Department>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectsql("SELECT * FROM department WHERE departmentname like '%"+name+"%';");
			while(rs.next()) {
				Department department = new Department();
				department.setDepartmentnumber(rs.getString("departmentnumber"));
				department.setDepartmentname(rs.getString("departmentname"));
				department.setFunction(rs.getString("function"));
				list.add(department);
			}
			DBconn.closeconn();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<course> getCoursebyname(String name) {
		List<course> list = new ArrayList<course>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectsql("SELECT * FROM `training courses` WHERE coursename like '%"+name+"%';");
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

}
