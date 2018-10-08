package dao;

import java.util.List;
import entity.Department;

public interface DepartmentDao {
	public boolean delete(String departmentnumber);
	public boolean update(String departmentnumber,String departmentname,String function);
	public boolean insert(String departmentnumber,String departmentname,String function);
	public List<Department> getDepartmentAll();
}
