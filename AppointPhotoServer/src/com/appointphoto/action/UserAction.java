package com.appointphoto.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.appointphoto.dto.UserLoginDto;
import com.appointphoto.model.User;
import com.appointphoto.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<UserLoginDto>{
	private UserManager usermanager;
	private UserLoginDto userLoginDto=new UserLoginDto();

	@Override
	public String execute() throws Exception {

		User u = new User();
		u.setName(userLoginDto.getUsername());
		u.setPassword(userLoginDto.getPassword());
		// System.out.println(u.getUsername());
		ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
				"beans.xml");
		usermanager = (UserManager) ctx.getBean("userManager");
		if (usermanager.userExists(u)) {
			return "fail";
		}
		usermanager.addUser(u);
		return "success";

	}

	public UserManager getUsermanager() {
		return usermanager;
	}

	public void setUsermanager(UserManager usermanager) {
		this.usermanager = usermanager;
	}

	
	@Override
	public UserLoginDto getModel() {
		return userLoginDto;
		
	}

	public UserLoginDto getUserLoginDto() {
		return userLoginDto;
	}

	public void setUserLoginDto(UserLoginDto userLoginDto) {
		this.userLoginDto = userLoginDto;
	}

	

	

}
