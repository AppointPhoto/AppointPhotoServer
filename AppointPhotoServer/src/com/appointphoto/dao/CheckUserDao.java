package com.appointphoto.dao;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import com.appointphoto.model.CheckUser;
import com.appointphoto.model.User;
import com.appointphoto.model.UserPictures;

public interface CheckUserDao {
	public void add(CheckUser checkUser);
	public List<CheckUser> queryAll();
}
