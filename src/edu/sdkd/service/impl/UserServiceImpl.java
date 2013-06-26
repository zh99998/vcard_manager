package edu.sdkd.service.impl;

import javax.mail.internet.NewsAddress;

import edu.sdkd.dao.UserDao;
import edu.sdkd.dao.impl.UserDaoImpl;
import edu.sdkd.domain.User;
import edu.sdkd.service.UserService;
import edu.sdkd.utils.EncryptionUtils;

public class UserServiceImpl implements UserService {
	
	//...
	/* (non-Javadoc)
	 * @see edu.sdkd.service.impl.LoginService#login(java.lang.String, java.lang.String)
	 */
	UserDao userDao = new UserDaoImpl();
	public User login(String name,String password){
		
		//password = EncryptionUtils.md5(password);//加密
		return userDao.find(name, password);
	}
	
	public void modifyPassword(int id,String newPassword) {
		userDao.modifyPassword(id, newPassword);
	}
}
