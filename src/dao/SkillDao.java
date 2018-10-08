package dao;
import java.sql.Date;
import java.util.*;
import entity.skill;

public interface SkillDao {
	public List<skill> getSkillMessage(String jobnum);
	public boolean update(String jobnum,String skillnum,String skillname,String skillgrade,Date time,String place);
	public boolean delete(String skillnum);
	public boolean insert(String jobnum,String skillnum,String skillname,String skillgrade,Date time,String place);
}
