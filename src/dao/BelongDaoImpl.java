package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Belong;
import util.DBconn;

public class BelongDaoImpl implements BelongDao{

	@Override
	public List<Belong> getDPMessage(String jobnum) {
		List<Belong> list = new ArrayList<Belong>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectsql("select department.*,post.* from workers INNER "
					+ "JOIN department on workers.departmentnum=department.departmentnumber&&workers.jobnum='"+jobnum+"' "
					+ "INNER JOIN post on workers.postnum=post.postnumber");
			while(rs.next()) {
				String departmentnum = rs.getString("departmentnumber");
				String departmentname = rs.getString("departmentname");
				String function = rs.getString("function");
				String postnum = rs.getString("postnumber");
				String postname = rs.getString("postname");
				String postgrade = rs.getString("postgrade");
				
				Belong belong = new Belong();
				belong.setDepartmentnum(departmentnum);
				belong.setDepartmentname(departmentname);
				belong.setFunction(function);
				belong.setPostnum(postnum);
				belong.setPostname(postname);
				belong.setPostgrade(postgrade);
				list.add(belong);
			}
			DBconn.closeconn();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean update(String jobnum,String departmentnum, String postnum) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("update workers set jobnum ='"+jobnum+"', departmentnum ='"+departmentnum+"', postnum ='"+postnum+"' where jobnum ="+jobnum);
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean delete(String jobnum) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("update workers set departmentnum ='нч',postnum ='нч' where jobnum ='"+jobnum+"'");
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean insert(String jobnum,String departmentnum, String postnum) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("update workers set departmentnum ='"+departmentnum+"', postnum ='"+postnum+"' where jobnum ='"+jobnum+"'");
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

}
