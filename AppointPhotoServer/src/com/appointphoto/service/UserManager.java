package com.appointphoto.service;

import java.util.List;

import com.appointphoto.dao.CheckUserDao;
import com.appointphoto.dao.UserDao;
import com.appointphoto.dao.UserPicturesDao;
import com.appointphoto.model.CheckUser;
import com.appointphoto.model.User;
import com.appointphoto.model.UserPictures;



public class UserManager {
private UserDao userDao;
private UserPicturesDao userPicturesDao;
private CheckUserDao checkUserDao;

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

public void addCheckUser(CheckUser checkUser) {
	checkUserDao.add(checkUser);
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

public User getUserWithId(long id){
	return userDao.getUserWithId(id);
}

public CheckUserDao getCheckUserDao() {
	return checkUserDao;
}

public void setCheckUserDao(CheckUserDao checkUserDao) {
	this.checkUserDao = checkUserDao;
}

//返回CheckUser表里所有信息
public List<CheckUser> getAllCheckUsers(){
	return checkUserDao.queryAll();
}

//通过uid返回UserPictures表里所有信息
public List<UserPictures> getUserPicturesByUid(long uId){
	return userPicturesDao.queryByUsername(uId);
}
}
