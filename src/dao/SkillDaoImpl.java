package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.skill;
import util.DBconn;

public class SkillDaoImpl implements SkillDao{

	@Override
	public List<skill> getSkillMessage(String jobnum) {
		List<skill> list = new ArrayList<skill>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectsql("select evaluation.*,skill.* from workers INNER JOIN evaluation on "
					+ "workers.jobnum=evaluation.jobnum&&workers.jobnum='"+jobnum+"' INNER JOIN skill on evaluation.skillnum=skill.skillnum");
			while(rs.next()) {
				String skillnum = rs.getString("skillnum");
				String skillname = rs.getString("skillname");
				String skillgrade = rs.getString("skillgrade");
				Date time = rs.getDate("time");
				String place = rs.getString("place");
				
				skill skill = new skill();
				skill.setSkillnum(skillnum);
				skill.setSkillname(skillname);
				skill.setSkillgrade(skillgrade);
				skill.setTime(time);
				skill.setPlace(place);
				list.add(skill);
			}
			DBconn.closeconn();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean update(String jobnum,String skillnum, String skillname, String skillgrade, Date time, String place) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("update skill set skillnum ='"+skillnum+"', skillname ='"+skillname+
				"', skillgrade ='"+skillgrade+"' where skillnum ="+skillnum);
		int j = DBconn.addUpdDel("update evaluation set jobnum ='"+jobnum+"', skillnum ='"+skillnum+
				"', time ='"+time+"', place ='"+place+"' where jobnum ="+jobnum);
		if(i>0) {
			if(j>0) {
			flag = true;
			}
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean delete(String skillnum) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("delete from skill where skillnum ='"+skillnum+"'");
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean insert(String jobnum,String skillnum, String skillname, String skillgrade, Date time, String place) {
		boolean flag = false;
		DBconn.init();
		try {
			ResultSet rs = DBconn.selectsql("select * from skill where skillname ='"+skillname+"' and skillgrade ='"+skillgrade+"'");
			if(rs.next()) {
				int i = DBconn.addUpdDel("INSERT INTO evaluation VALUES ('"+jobnum+"','"+rs.getString("skillnum")+"','"+time+"','"+place+"')");
				if(i>0) {
					flag = true;
				}
			}else {
				int i = DBconn.addUpdDel("INSERT INTO skill VALUES ('"+skillnum+"','"+skillname+"','"+skillgrade+"')");
				int j = DBconn.addUpdDel("INSERT INTO evaluation VALUES ('"+jobnum+"','"+skillnum+"','"+time+"','"+place+"')");
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

}
