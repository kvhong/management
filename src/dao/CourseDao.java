package dao;

import java.sql.Date;
import java.util.List;
import entity.course;

public interface CourseDao {
	public List<course> getCourseMessage(String jobnum);
	public boolean update(String jobnum,String coursenum,Date time,String score);
	public boolean delete(String coursenum);
	public boolean insert(String jobnum,String coursenum,Date time,String score);
	public List<course> getCourse();
	public boolean deletecourse(String coursenum);
	public boolean updatecourse(String coursenum,String coursename,String material,String studytime);
	public boolean insertcourse(String coursenum,String coursename,String material,String studytime);
}
