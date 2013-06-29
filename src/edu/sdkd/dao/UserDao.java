package edu.sdkd.dao;

import java.util.ArrayList;

import edu.sdkd.domain.User;

public interface UserDao {
	public User find(String name,String password);
	//修改密码
	void modifyPassword(int id,String newPassword);
	
	//查询并显示所有用户
	public ArrayList<User> showUserList();
	public  void addUser( String name ,String password);
	public void deleteUser(int id);
	public void updateUser(String name ,String password,int id);
}
