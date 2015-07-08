package com.appointphoto.dao;

import javax.jws.soap.SOAPBinding.Use;

import com.appointphoto.model.User;
import com.appointphoto.model.UserPictures;

public interface UserPicturesDao {
	public void add(UserPictures picture);
	
}
