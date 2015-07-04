package com.appointphoto.service;

import com.appointphoto.dao.UserDao;
import com.appointphoto.model.User;



public class UserManager {
private UserDao userDao;

public UserDao getUserDao() {
	return userDao;
}

public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
}

public void addUser(User u) {
	userDao.add(u);
}
public boolean userExists(User u) {
	return userDao.checkUserExistsWithName(u.getName());
}

public boolean userNameExists(String name) {
	return userDao.checkUserExistsWithName(name);
}

}
