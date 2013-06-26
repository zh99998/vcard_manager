package edu.sdkd.service;

import edu.sdkd.domain.User;

public interface UserService {

	//...
	public abstract User login(String name, String password);
	
	public abstract void modifyPassword(int id,String newPassword);
}