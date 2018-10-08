package dao;

import java.sql.ResultSet;

import entity.User;
import util.DBconn;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean login(String name, String pwd) {
		boolean flag = false;
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectsql("select * from user where name = '"+name+"' and pwd = '"+pwd+"'");
			while(rs.next()) {
				if(rs.getString("name").equals(name)&&rs.getString("pwd").equals(pwd)) {
					flag = true;
				}
			}
			DBconn.closeconn();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean register(User user) {
		boolean flag = false;
		DBconn.init();
		int i =DBconn.addUpdDel("insert into user(id,name,pwd,sex,age,department,position,phone) "+
				"value('"+user.getId()+"','"+user.getName()+"','"+user.getPwd()+"','"+user.getSex()+"','"+user.getAge()+
				"','"+user.getDepartment()+"','"+user.getPosition()+"','"+user.getPhone()+"')");
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

}
