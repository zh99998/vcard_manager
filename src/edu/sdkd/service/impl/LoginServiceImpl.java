package edu.sdkd.service.impl;

import javax.mail.internet.NewsAddress;

import edu.sdkd.dao.UserDao;
import edu.sdkd.dao.impl.UserDaoImpl;
import edu.sdkd.domain.User;
import edu.sdkd.utils.EncryptionUtils;

public class LoginServiceImpl {
	
	UserDao userDao = new UserDaoImpl();
	
	public User login(String name,String password){
		password = EncryptionUtils.md5(password);
		return userDao.find(name, password);
	}
}
