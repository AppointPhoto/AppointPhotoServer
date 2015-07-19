package com.appointphoto.service;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.appointphoto.model.User;
import com.appointphoto.model.UserPictures;


public class UserManagerTest {

	@Test
	public void test() {
		ApplicationContext ctx=(ApplicationContext) new ClassPathXmlApplicationContext("beans.xml");
		UserManager um=(UserManager)ctx.getBean("UserManager");
		User u = new User();
		u.setName("b");
		u.setPassword("a");		
		//um.addUser(u);
		boolean exists = um.userExists(u);
		if(!exists) {
			um.addUser(u);			
			Assert.assertEquals(true, um.userExists(u));
			
		} else {
			Assert.fail("not added");
		}
	}

	@Test
	public void saveUser() {
		ApplicationContext ctx=(ApplicationContext) new ClassPathXmlApplicationContext("beans.xml");
		UserManager um=(UserManager)ctx.getBean("UserManager");
		User u = new User();
		u.setName("beyond");
		u.setPassword("a");	
		UserPictures pictures =new UserPictures();
		pictures.setCaptain("test");
		pictures.setuId(2);
		pictures.setPic("/home/beyond/GitHubSrc/UserPictures/beyond/test2.jpg");
		Set<UserPictures> set=new HashSet<UserPictures>();
		set.add(pictures);
//		u.getPictures().add(pictures);
		u.setPictures(set);
		//um.addUser(u);
		um.addUserPictures(pictures);
	}
	
	@Test
	public void saveUserPictures() {
		ApplicationContext ctx=(ApplicationContext) new ClassPathXmlApplicationContext("beans.xml");
		UserManager um=(UserManager)ctx.getBean("UserManager");
		 User user =um.getUserWithname("beyond");
         
         UserPictures picture1 = new UserPictures();
         picture1.setCaptain("test");
         picture1.setUser(user);
         picture1.setuId(user.getId());
         um.addUserPictures(picture1);
	}
}
