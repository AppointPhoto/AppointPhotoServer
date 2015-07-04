package com.appointphoto.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.appointphoto.model.User;


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

}
