package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Department;
import entity.Post;
import util.DBconn;

public class PostDaoImpl implements PostDao{

	@Override
	public boolean delete(String postnumber) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("delete from post where postnumber = '"+postnumber+"'");
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean update(String departmentnum,String postnumber, String postname, String postgrade,String peoplenum) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("update post set postnumber ='"+postnumber+"', postname ='"+postname+
				"', postgrade ='"+postgrade+"' where postnumber ="+postnumber);
		int j = DBconn.addUpdDel("update install set departmentnum ='"+departmentnum+"', postnum ='"+postnumber+"', peoplenum ='"+peoplenum+
				"' where departmentnum ="+departmentnum);
		if(i>0) {
			if(j>0) {
			flag = true;
			}
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean insert(String departmentnum,String postnumber, String postname, String postgrade,String peoplenum) {
		boolean flag = false;
		DBconn.init();
		try {
			ResultSet rs = DBconn.selectsql("select * from post where postname ='"+postname+"' and postgrade ='"+postgrade+"'");
			if(rs.next()) {
				int i = DBconn.addUpdDel("INSERT INTO install VALUES ('"+departmentnum+"','"+rs.getString("postnumber")+"','"+peoplenum+"')");
				if(i>0) {
					flag = true;
				}
			}else {
				int i = DBconn.addUpdDel("INSERT INTO post VALUES ('"+postnumber+"','"+postname+"','"+postgrade+"')");
				int j = DBconn.addUpdDel("INSERT INTO install VALUES ('"+departmentnum+"','"+postnumber+"','"+peoplenum+"')");
				if(i>0) {
					if(j>0) {
					flag = true;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public List<Post> getPostAll(String departmentnum) {
		List<Post> list = new ArrayList<Post>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectsql("SELECT post.*,`install`.peoplenum from `install` INNER JOIN department on department.departmentnumber=`install`.departmentnum&&department.departmentnumber='"+departmentnum+"' INNER JOIN post on `install`.postnum=post.postnumber");
			while(rs.next()) {
				Post post = new Post();
				post.setPostnumber(rs.getString("postnumber"));
				post.setPostname(rs.getString("postname"));
				post.setPostgrade(rs.getString("postgrade"));
				post.setPeoplenum(rs.getString("peoplenum"));
				list.add(post);
			}
			DBconn.closeconn();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
