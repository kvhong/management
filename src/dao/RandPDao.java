package dao;

import java.sql.Date;
import java.util.List;

import entity.rewardandpenalty;

public interface RandPDao {
	public List<rewardandpenalty> getRandPMessage(String jobnum);
	public boolean update(String jobnum,Date time,String sequencenum,String sign,String project,String money);
	public boolean delete(String sequencenum);
	public boolean insert(String jobnum,Date time,String sequencenum,String sign,String project,String money);
}
