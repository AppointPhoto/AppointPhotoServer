package com.appointphoto.service;

import com.appointphoto.dao.UserDao;
import com.appointphoto.dao.UserPicturesDao;
import com.appointphoto.model.User;
import com.appointphoto.model.UserPictures;



public class UserManager {
private UserDao userDao;
private UserPicturesDao userPicturesDao;

public UserDao getUserDao() {
	return userDao;
}

public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
}

public UserPicturesDao getUserPicturesDao() {
	return userPicturesDao;
}

public void setUserPicturesDao(UserPicturesDao userPicturesDao) {
	this.userPicturesDao = userPicturesDao;
}

public void addUser(User u) {
	userDao.add(u);
}
public void addUserPictures(UserPictures picture) {
	userPicturesDao.add(picture);;
}

public boolean userExists(User u) {
	return userDao.checkUserExistsWithName(u.getName());
}

public boolean userNameExists(String name) {
	return userDao.checkUserExistsWithName(name);
}

public User getUserWithname(String name){
	return userDao.getUserWithName(name);
}
}
