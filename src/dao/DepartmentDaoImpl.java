package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Department;
import util.DBconn;

public class DepartmentDaoImpl implements DepartmentDao{

	@Override
	public boolean delete(String departmentnumber) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("delete from department where departmentnumber = '"+departmentnumber+"'");
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean update(String departmentnumber, String departmentname, String function) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("update department set departmentnumber ='"+departmentnumber+"', departmentname ='"+departmentname+
				"', function ='"+function+"' where departmentnumber ="+departmentnumber);
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean insert(String departmentnumber, String departmentname, String function) {
		boolean flag = false;
		DBconn.init();
		int i =DBconn.addUpdDel("INSERT INTO department VALUES ('"+departmentnumber+"','"+departmentname+"','"+function+"')");
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public List<Department> getDepartmentAll() {
		List<Department> list = new ArrayList<Department>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectsql("select * from department");
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

}
