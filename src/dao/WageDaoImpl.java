package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.wages;
import util.DBconn;

public class WageDaoImpl implements WageDao{

	@Override
	public List<wages> getWageMessage(String jobnum) {
		List<wages> list = new ArrayList<wages>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectsql("select wages.* from workers JOIN wages on workers.jobnum=wages.jobnum&&workers.jobnum='"+jobnum+"';");
			while(rs.next()) {
				String basicmoney = rs.getString("basicmoney");
				String levelmoney = rs.getString("levelmoney");
				String oldmoney = rs.getString("old-money");
				String unemploymentmoney = rs.getString("unemployment-money");
				String Accumulationmoney = rs.getString("Accumulation-money");
				String paymoney = rs.getString("pay-money");
				
				wages wages = new wages();
				wages.setJobnum(jobnum);
				wages.setBasicmoney(basicmoney);
				wages.setLevelmoney(levelmoney);
				wages.setOldmoney(oldmoney);
				wages.setUnemploymentmoney(unemploymentmoney);
				wages.setAccumulationmoney(Accumulationmoney);
				wages.setPaymoney(paymoney);
				list.add(wages);
			}
			DBconn.closeconn();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean update(String jobnum, String basicmoney, String levelmoney, String oldmoney,
			String unemploymentmoney, String Accumulationmoney, String paymoney) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("update wages set jobnum ='"+jobnum+"', basicmoney ='"+basicmoney+
				"', levelmoney ='"+levelmoney+"', `old-money` ='"+oldmoney+"', `unemployment-money` ='"+unemploymentmoney+"', "
						+ "`Accumulation-money` ='"+Accumulationmoney+"',`pay-money` ='"+paymoney+"' where jobnum ="+jobnum);
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
		int i = DBconn.addUpdDel("delete from wages where jobnum = '"+jobnum+"'");
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

	@Override
	public boolean insert(String jobnum, String basicmoney, String levelmoney, String oldmoney,
			String unemploymentmoney, String Accumulationmoney, String paymoney) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("INSERT INTO wages VALUES ('"+jobnum+"','"+basicmoney+"','"+levelmoney+"','"+oldmoney+"','"+unemploymentmoney+
				"','"+Accumulationmoney+"','"+paymoney+"')");
		if(i>0) {
			flag = true;
		}
		DBconn.closeconn();
		return flag;
	}

}
