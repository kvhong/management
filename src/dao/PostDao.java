package dao;

import java.util.List;

import entity.Post;

public interface PostDao {
	public boolean delete(String postnumber);
	public boolean update(String departmentnum,String postnumber,String postname,String postgrade,String peoplenum);
	public boolean insert(String departmentnum,String postnumber,String postname,String postgrade,String peoplenum);
	public List<Post> getPostAll(String departmentnum);
}
