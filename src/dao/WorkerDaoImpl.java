package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.*;
import util.DBconn;

public class WorkerDaoImpl implements WorkerDao{

	@Override
	public List<Workman> getWorkerAll() {
		List<Workman> workerall = new ArrayList<Workman>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectsql("select * from workers");
			while(rs.next()) {
				Workman worker = new Workman();
				worker.setJobnum(rs.getString("jobnum"));
				worker.setName(rs.getString("name"));;
				worker.setAge(rs.getInt("age"));
				worker.setSex(rs.getString("sex"));
				worker.setDepartmentnum(rs.getString("departmentnum"));
				worker.setPostnum(rs.getString("postnum"));
				worker.setEducation(rs.getString("education"));
				workerall.add(worker);
			}
			DBconn.closeconn();
			return workerall;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(String jobnum) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("delete from workers where jobnum = '"+jobnum+"'");
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean update(String jobnum, String name, String sex, int age,String education, String departmentnum, String postnum) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("update workers set jobnum ='"+jobnum+"', name ='"+name+"', sex ='"+sex+
				"', age ='"+age+"', education ='"+education+"', departmentnum ='"+departmentnum+"', postnum ='"+postnum+"' where jobnum ="+jobnum);
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean insert(String jobnum, String name, String sex, int age, String education, String departmentnum, String postnum) {
		boolean flag = false;
		DBconn.init();
		int i =DBconn.addUpdDel("INSERT INTO workers VALUES ('"+jobnum+"','"+name+"','"+sex+"','"+age+"','"+education+"','"+departmentnum+
				"','"+postnum+"')");
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

}
