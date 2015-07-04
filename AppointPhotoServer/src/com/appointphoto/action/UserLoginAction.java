package com.appointphoto.action;


import com.appointphoto.model.User;
import com.appointphoto.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

//处理用户登录
public class UserLoginAction extends ActionSupport {

	//private User user;
	private String name;
	private String password;
	private UserManager um;
	//保存结果
	private String result;
	
	
	public String checkUser() throws Exception{
		User user =new User();
		user.setName(name);
		user.setPassword(password);
		System.out.println(um.getClass().getName());
		System.out.println("name:"+user.getName());
		System.out.println("password:"+user.getPassword());
		if(um.userExists(user)){
			result=SUCCESS;
		}
		else {
			result=ERROR;
		}		
		
		return SUCCESS;
	}
	
	public UserManager getUm() {
		return um;
	}
	public void setUm(UserManager um) {
		this.um = um;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
