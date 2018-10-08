package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.rewardandpenalty;
import util.DBconn;

public class RandPDaoImpl implements RandPDao{

	@Override
	public List<rewardandpenalty> getRandPMessage(String jobnum) {
		List<rewardandpenalty> list = new ArrayList<rewardandpenalty>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectsql("select accept.*,`rewards and penalties`.* from workers "
					+ "INNER JOIN accept on workers.jobnum=accept.jobnum&&workers.jobnum='"+jobnum+"' INNER JOIN `rewards and penalties` "
					+ "on accept.sequencenum=`rewards and penalties`.sequencenum");
			while(rs.next()) {
				Date time = rs.getDate("time");
				String sequencenum = rs.getString("sequencenum");
				String sign = rs.getString("sign");
				String project = rs.getString("project");
				String money = rs.getString("money");
				
				rewardandpenalty rewardandpenalty = new rewardandpenalty();
				rewardandpenalty.setTime(time);
				rewardandpenalty.setSequencenum(sequencenum);
				rewardandpenalty.setSign(sign);
				rewardandpenalty.setProject(project);
				rewardandpenalty.setMoney(money);
				list.add(rewardandpenalty);
			}
			DBconn.closeconn();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean update(String jobnum,Date time, String sequencenum, String sign, String project,String money) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("update `rewards and penalties` set sequencenum ='"+sequencenum+"', sign ='"+sign+
				"', project ='"+project+"', money ='"+money+"' where sequencenum ="+sequencenum);
		int j = DBconn.addUpdDel("update accept set jobnum ='"+jobnum+"', sequencenum ='"+sequencenum+
				"', time ='"+time+"' where sequencenum ="+sequencenum);
		if(i>0) {
			if(j>0) {
			flag = true;
			}
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean delete(String sequencenum) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("delete from `rewards and penalties` where sequencenum ='"+sequencenum+"'");
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean insert(String jobnum,Date time, String sequencenum, String sign, String project,String money) {
		boolean flag = false;
		DBconn.init();
		try {
			ResultSet rs = DBconn.selectsql("select * from `rewards and penalties` where sign ='"+sign+"' and project ='"+project+"' and money ='"+money+"'");
			if(rs.next()) {
				int i = DBconn.addUpdDel("INSERT INTO accept VALUES ('"+jobnum+"','"+rs.getString("sequencenum")+"','"+time+"')");
				if(i>0) {
					flag = true;
				}
			}else {
				int i = DBconn.addUpdDel("INSERT INTO `rewards and penalties` VALUES ('"+sequencenum+"','"+sign+"','"+project+"','"+money+"')");
				int j = DBconn.addUpdDel("INSERT INTO accept VALUES ('"+jobnum+"','"+sequencenum+"','"+time+"')");
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
