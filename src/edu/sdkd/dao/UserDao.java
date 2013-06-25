package edu.sdkd.dao;

import edu.sdkd.domain.User;

public interface UserDao {
	public User find(String name,String password);
}
