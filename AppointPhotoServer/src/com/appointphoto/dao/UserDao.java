package com.appointphoto.dao;

import javax.jws.soap.SOAPBinding.Use;

import com.appointphoto.model.User;

public interface UserDao {
	public void add(User u);
	public boolean checkUserExistsWithName(String username);
}
