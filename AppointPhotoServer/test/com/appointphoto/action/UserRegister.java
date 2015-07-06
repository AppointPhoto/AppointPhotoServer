package com.appointphoto.action;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

import org.junit.Test;

public class UserRegister {
	@Test
	public void test() {	
		
	//	ApplicationContext ctx=(ApplicationContext) new ClassPathXmlApplicationContext("beans.xml");
	//	UserManager um=(UserManager)ctx.getBean("UserManager");
	
		try {
			String urlStr="http://localhost:8080/AppointPhotoServer/userRegisterAction";  
			String testString="test";
			JSONObject jsonObject = new JSONObject();	
			//User u = new User();
			//u.setName("b");
			//u.setPassword("a");	
			jsonObject.put("name","1");
			jsonObject.put("password","1");	
			jsonObject.put("password2","1");	
			jsonObject.put("emailAddress","1");
			jsonObject.put("level","0");

			URL url = new URL(urlStr);
			 HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
			 connection.setDoOutput(true); 
	         connection.setDoInput(true); 
	         connection.setRequestMethod("POST"); 
	         connection.setUseCaches(false); 
	         connection.setInstanceFollowRedirects(true); 
//	         connection.setRequestProperty("Content-Type", 
//	                    "application/x-www-form-urlencoded"); 
	        // connection.setRequestProperty("testString",testString);
	         
	         connection.setRequestProperty("Content-Type", 
	                    "application/json");
	         connection.connect(); 
	         DataOutputStream out = new DataOutputStream(connection.getOutputStream()); 
	         out.writeBytes(jsonObject.toString()); 	         
	        /* connection.setRequestProperty("Content-Type", 
	                    "application/x-www-form-urlencoded");
	         
	         out.writeBytes(testString);*/
	         
	         out.flush(); 
	         
	         out.close(); 
	         
	         //读取响应 
	         BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
	         String lines; 
	         StringBuffer sb = new StringBuffer(""); 
	         while ((lines = reader.readLine()) != null) { 
	              lines = new String(lines.getBytes(), "utf-8"); 
	                sb.append(lines); 
	          } 
	          System.out.println(sb); 
	          reader.close(); 
	         
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
}
