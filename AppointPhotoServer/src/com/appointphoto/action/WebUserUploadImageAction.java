package com.appointphoto.action;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.appointphoto.dto.UserRegisterDto;
import com.appointphoto.model.CheckUser;
import com.appointphoto.model.User;
import com.appointphoto.model.UserPictures;
import com.appointphoto.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


//处理用户注冊
public class WebUserUploadImageAction extends ActionSupport {

	 private String username;
	    
	//这里用List来存放上传过来的文件，file同样指的是临时文件夹中的临时文件，而不是真正上传过来的文件
	    private List<File> file;
	    
	//这个List存放的是文件的名字，和List<File>中的文件相对应
	    private List<String> fileFileName;
	    
	    private List<String> fileContentType;
	    
	    private String pathRoot;
	    
	    private UserManager um;
	    
	    
	    public String getPathRoot() {
			return pathRoot;
		}

		public void setPathRoot(String pathRoot) {
			this.pathRoot = pathRoot;
		}

		public String getUsername()
	    {
	        return username;
	    }

	    public void setUsername(String username)
	    {
	        this.username = username;
	    }

	    public List<File> getFile()
	    {
	        return file;
	    }

	    public void setFile(List<File> file)
	    {
	        this.file = file;
	    }

	    public List<String> getFileFileName()
	    {
	        return fileFileName;
	    }

	    public void setFileFileName(List<String> fileFileName)
	    {
	        this.fileFileName = fileFileName;
	    }

	    public List<String> getFileContentType()
	    {
	        return fileContentType;
	    }

	    public void setFileContentType(List<String> fileContentType)
	    {
	        this.fileContentType = fileContentType;
	    }
	    
	    @Override
	    public String execute() throws Exception
	    {	        
	        User user;
	        UserPictures userPictures=new UserPictures();
	        if(makeUserDir(getPathRoot() + "/" + username)){
	        	setPathRoot(getPathRoot() + "/" + username);
	        }
	        for(int i = 0; i < file.size(); i++)
	        {
	        	 if(saveUserPictures(fileFileName.get(i),getPathRoot(), file.get(i))){
	             	
	        		System.out.println("文件上传成功");  	
	             	user=um.getUserWithname(username);
	             	System.out.println("id:"+user.getId());
	             	userPictures.setUser(user);
	             	userPictures.setPic(pathRoot);
	             	userPictures.setuId(user.getId());
	             	userPictures.setCaptain(fileFileName.get(i));
	             	
	             	CheckUser checkUser=new CheckUser();
	             	checkUser.setuId(user.getId());
	             	System.out.println("uid:"+ checkUser.getuId());
	             	checkUser.setStatus(1);
	             	checkUser.setUser(user);
	             	
	             	um.addUserPictures(userPictures);
	             	um.addCheckUser(checkUser);
	             }
	            else {
					return ERROR;
				}	           
	          
	        }
	        
	        return SUCCESS;
	    }
	    //创建用户目录
	    public boolean makeUserDir(String fileDir) {
	    	Boolean flag=false;
	    	File file =new File(fileDir);
	    	if (!file.isDirectory()||!file.exists())      
	    	{         	      
	    	    file.mkdir();  	    
	    	    
	    	    flag=true;
	    	} else   
	    	{  
	    	    System.out.println("//目录存在");  
	    	    
	    	    flag=true;
	    	}  
	    	return flag;
	    }
	    
	    public boolean saveUserPictures(String fileName,String filePath ,File file) {
	    	System.out.println("pathRoot:"+ getPathRoot());
	    	System.out.println("file:"+ file.getName());
	    	System.out.println("fileName:"+ fileName);
	    	FileOutputStream fos = null;  
	        FileInputStream fis = null; 
	    	try {
	    		System.out.println("获取Android端传过来的普通信息：");  
	            //System.out.println("用户名："+request.getParameter("username"));  
	            //System.out.println("密码："+request.getParameter("pwd"));  
	            //System.out.println("年龄："+request.getParameter("age")); 
	            
	            System.out.println("文件存放目录: "+filePath);  
	            //System.out.println("文件名称: "+file.getName());                         
	            System.out.println("文件大小: "+file.length());             
	            System.out.println("用户名: "+username);  
	    		 
	        	fos = new FileOutputStream(new File(pathRoot,fileName));  
	            fis = new FileInputStream(file);  
	            byte[] buffer = new byte[1024];  
	            int len = 0;  
	            while ((len = fis.read(buffer)) != -1) {  
	                fos.write(buffer, 0, len);  
	            }  
			    close(fos, fis);
	    	} catch (Exception e) {
				return false;
			}
	    	
	    	return true;
		}
	    private void close(FileOutputStream fos, FileInputStream fis) {  
	        if (fis != null) {  
	            try {  
	                fis.close();  
	                fis=null;  
	            } catch (IOException e) {  
	                System.out.println("FileInputStream关闭失败");  
	                e.printStackTrace();  
	            }  
	        }  
	        if (fos != null) {  
	            try {  
	                fos.close();  
	                fis=null;  
	            } catch (IOException e) {  
	                System.out.println("FileOutputStream关闭失败");  
	                e.printStackTrace();  
	            }  
	        }  
	    }
		public UserManager getUm() {
			return um;
		}

		public void setUm(UserManager um) {
			this.um = um;
		}

		
}
