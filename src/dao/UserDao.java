package dao;

import entity.User;

public interface UserDao {
	public boolean login(String name,String pwd);
	public boolean register(User user);
}
