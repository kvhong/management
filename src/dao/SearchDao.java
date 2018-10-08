package dao;

import java.util.List;

import entity.Department;
import entity.Workman;
import entity.course;

public interface SearchDao {
	public List<Workman> getWorkerbynum(String num);
	public List<Department> getDepartmentbynum(String num);
	public List<course> getCoursebynum(String num);
	public List<Workman> getWorkerbyname(String name);
	public List<Department> getDepartmentbyname(String name);
	public List<course> getCoursebyname(String name);
}
