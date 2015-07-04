package com.appointphoto.action;


import com.appointphoto.dto.UserRegisterDto;
import com.appointphoto.model.User;
import com.appointphoto.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//处理用户注冊
public class UserRegisterAction extends ActionSupport implements ModelDriven<UserRegisterDto>{

	private UserRegisterDto userRegisterDto;
	//保存结果
	private String result;
	private UserManager um;
	
	
	public String registerUser() throws Exception{
		//檢查2次輸入密碼正確
		if (userRegisterDto.getPassword().equals(userRegisterDto.getPassword2())) {
			
		}
		else {
			result="passwordError";
		}
		//檢查有沒有用戶重名
		if (um.userNameExists(userRegisterDto.getName())) {
			result="registed";
		}
		else {
			try {
				User u=new User();
				u.setName(userRegisterDto.getName());
				u.setPassword(userRegisterDto.getPassword());
				u.setEmailAddress(userRegisterDto.getEmailAddress());
				u.setLevel(userRegisterDto.getLevel());
				u.setPhoneNum(userRegisterDto.getEmailAddress());
				
				um.addUser(u);
				result=SUCCESS;
			} catch (Exception e) {
				result=ERROR;
			}
		}
		return SUCCESS;
	}


	public UserRegisterDto getUserRegisterDto() {
		return userRegisterDto;
	}


	public void setUserRegisterDto(UserRegisterDto userRegisterDto) {
		this.userRegisterDto = userRegisterDto;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	@Override
	public UserRegisterDto getModel() {
		 if (null == userRegisterDto) {  
			    userRegisterDto = new UserRegisterDto();  
			  }  
			  return userRegisterDto;  			 
		
	}
	
	
}
