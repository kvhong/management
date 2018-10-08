package dao;

import java.util.List;

import entity.Workman;

public interface WorkerDao {
	public List<Workman> getWorkerAll();
	public boolean delete(String jobnum);
	public boolean update(String jobnum,String name,String sex,int age,String departmentnum,String postnum,String education);
	public boolean insert(String jobnum,String name,String sex,int age,String departmentnum,String postnum,String education);
}
