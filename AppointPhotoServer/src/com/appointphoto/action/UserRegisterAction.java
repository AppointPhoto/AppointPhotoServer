package com.appointphoto.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.http.HttpRequest;

import com.appointphoto.dto.UserRegisterDto;
import com.appointphoto.model.User;
import com.appointphoto.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.xml.internal.ws.developer.Serialization;

//处理用户注冊
public class UserRegisterAction extends ActionSupport {

	// private UserRegisterDto userRegisterDto;
	// 保存结果
	private String result;
	private UserManager um;
	private String name;
	private String password;
	private String password2;
	private String emailAddress;
	private String phoneNum;
	private int level;
	private String teString;

	public String registerUser() throws Exception {

		System.out.println("pass1" + password);
		System.out.println("pass2" + password2);
		
		
		HttpServletRequest request =ServletActionContext.getRequest();
		
		teString=(String)request.getAttribute("testString");
		System.out.println("testString:"+teString);
		// 檢查2次輸入密碼正確
		if (password.equals(password2)) {
			User u = new User();
			u.setEmailAddress(emailAddress);
			u.setName(name);
			u.setLevel(level);
			u.setPassword(password);
			u.setPhoneNum(phoneNum);
			// 檢查有沒有用戶重名
			if (um.userExists(u)) {
				result = "registed";
			} else {
				try {

					um.addUser(u);
					result = SUCCESS;
				} catch (Exception e) {
					result = ERROR;
				}
			}
		} else {
			result = "passwordError";
		}

		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@JSON(serialize = false)
	public String getTeString() {
		return teString;
	}

	public void setTeString(String teString) {
		this.teString = teString;
	}

}
