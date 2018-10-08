package dao;

import java.util.List;

import entity.Belong;

public interface BelongDao {
	public List<Belong> getDPMessage(String jobnum);
	public boolean update(String jobnum,String departmentnum,String postnum);
	public boolean delete(String jobnum);
	public boolean insert(String jobnum,String departmentnum,String postnum);
}
