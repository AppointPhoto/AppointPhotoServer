package com.appointphoto.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import com.appointphoto.dto.UserLoginDto;
import com.appointphoto.model.CheckUser;
import com.appointphoto.model.User;
import com.appointphoto.model.UserPictures;
import com.appointphoto.service.UserManager;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.javafx.collections.MappingChange.Map;
import com.sun.org.apache.xml.internal.security.Init;

public class CheckUserAction extends ActionSupport {
	
	public User user;
	public UserManager um;
	
public String checkUser(){
	
	//CheckUser表里的所有用户信息
	List<CheckUser> checkUsers=um.getAllCheckUsers();
	List<UserPictures> userPictures;
	List<User> users = new ArrayList<User>() ;
	System.out.println("checkuser num:"+checkUsers.size());
	User temp;
	
	Gson gson=new Gson();	
	
	//用户名字和对应的UserPictures
	HashMap<String, List<UserPictures>> dataMap =new HashMap<String,List<UserPictures>>();
	//用户申请的状态的唯一的，保证checkuser表里的uid是唯一的
	for (CheckUser checkUser : checkUsers) {
		temp=um.getUserWithId(checkUser.getuId());
		System.out.println("name:"+temp.getName());
		temp.setPictures(um.getUserPicturesByUid(checkUser.getuId()));
		System.out.println("length:"+temp.getPictures().size());
		users.add(temp);

		//dataMap.put(um.getUserWithId(checkUser.getuId()).getName() ,um.getUserPicturesByUid(checkUser.getuId()) );
	}

	String jsonUsers = gson.toJson(users);
	System.out.println(jsonUsers);
	
	//System.out.println("count checkusers:"+checkUsers.size());
	HttpServletRequest request=ServletActionContext.getRequest();	
	/*JSONObject jsonObject=new JSONObject();
	
	JsonConfig jsonConfig = new JsonConfig(); //建立配置文件
	//jsonConfig.setIgnoreDefaultExcludes(false); //设置默认忽略
	//jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);   //此处是亮点，不过经过测试，第2种方法有些悲剧，虽然可以使用，但其结果貌似循环数次，至于为啥，还请高人指点。
	jsonConfig.setExcludes(new String[]{"user"});
	jsonConfig.setAllowNonStringKeys(true);
	JSONArray jsonArray = JSONArray.fromObject(dataMap,jsonConfig); //加载配置文件
	
	jsonObject.accumulate("json", jsonArray);
	System.out.println("json:"+jsonObject.toString());*/
	request.setAttribute("jsonUsers", jsonUsers.toString());
	
	
	return SUCCESS;
}

public UserManager getUm() {
	return um;
}

public void setUm(UserManager um) {
	this.um = um;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}
	

}
