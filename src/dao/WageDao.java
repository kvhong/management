package dao;

import java.util.List;
import entity.wages;

public interface WageDao {
	public List<wages> getWageMessage(String jobnum);
	public boolean update(String jobnum,String basicmoney,String levelmoney,String oldmoney,String unemploymentmoney,String Accumulationmoney,String paymoney);
	public boolean delete(String jobnum);
	public boolean insert(String jobnum,String basicmoney,String levelmoney,String oldmoney,String unemploymentmoney,String Accumulationmoney,String paymoney);
}
