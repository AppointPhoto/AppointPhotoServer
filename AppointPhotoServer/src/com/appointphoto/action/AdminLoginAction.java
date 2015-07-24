package com.appointphoto.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.appointphoto.model.CheckUser;
import com.appointphoto.model.User;
import com.appointphoto.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

//处理用户登录
public class AdminLoginAction extends ActionSupport {

	//private User user;
	private String name;
	private String password;
	private UserManager um;
	
	
	public String execute() throws Exception{
		System.out.println(123);
		User user =new User();
		user.setName(name);	
		user.setPassword(password);
		System.out.println(um.getClass().getName());
		System.out.println("name:"+user.getName());
		System.out.println("password:"+user.getPassword());
		//假设beyond为管理员
		if(name.equals("beyond") && um.userExists(user) && password.equals(um.getUserWithname(name).getPassword())){
			HttpServletRequest request=ServletActionContext.getRequest();	
			JSONObject jsonObject=new JSONObject();
			List<CheckUser> checkUsers=um.getAllCheckUsers();
			System.out.println("check user num:"+ checkUsers.size());
			jsonObject.accumulate("checkUserNum", checkUsers.size());
			request.setAttribute("jsonObject", jsonObject.toString());
			
			return SUCCESS;
		}
		else {
			return ERROR;
		}		
		
	}
	
	public UserManager getUm() {
		return um;
	}	
	public void setUm(UserManager um) {
		this.um = um;
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
