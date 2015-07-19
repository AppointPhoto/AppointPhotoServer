package com.appointphoto.action;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.appointphoto.dto.UserRegisterDto;
import com.appointphoto.model.User;
import com.appointphoto.model.UserPictures;
import com.appointphoto.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


//处理用户注冊
public class UserUploadImageAction extends ActionSupport {

	 // 上传文件域  
    private File image1;  
    private File image2; 
    // 上传文件类型  
    private String imageContentType;  
    // 封装上传文件名  
    private String fileName1;  
    private String fileName2; 
    // 接受依赖注入的属性  
    private String savePath;  
    
    private String name;
    private String filePath1; 
    private String filePath2; 
    
    private UserManager um;
    private Set<UserPictures> pictures;
  
    @Override  
    public String execute() {  
       // HttpServletRequest request=ServletActionContext.getRequest();  
        FileOutputStream fos = null;  
        FileInputStream fis = null;  
        try {  
        	filePath1=getSavePath() + "/" + name + "/" + getFileName1();  
        	filePath2=getSavePath() + "/" + name + "/" + getFileName2();  
            if(makeUserDir(getSavePath() + "/" + name)&&saveUserPictures(filePath1, image1)&&saveUserPictures(filePath2, image2)){
            	System.out.println("文件上传成功");  
            }
            User user =um.getUserWithname(name);
            
            UserPictures picture1 = new UserPictures();
            picture1.setCaptain(fileName1);
            picture1.setUser(user);
            picture1.setuId(user.getId());
            um.addUserPictures(picture1);
            
            UserPictures picture2 = new UserPictures();
            picture2.setCaptain(fileName2);
            picture2.setUser(user);
            picture2.setuId(user.getId());
            um.addUserPictures(picture2);
            
            //picture1.setUser(user);
            
        } catch (Exception e) {  
            System.out.println("文件上传失败\n"+e.toString());  
            
            //return ERROR;
        } finally {  
            close(fos, fis);  
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
    
    public boolean saveUserPictures(String filePath ,File file) {
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
            System.out.println("用户名: "+name);  
    		 
        	fos = new FileOutputStream(filePath);  
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
    /** 
     * 文件存放目录 
     *  
     * @return 
     */  
    public String getSavePath() throws Exception{  
        return savePath;   
    }  
  
    public void setSavePath(String savePath) {  
        this.savePath = savePath;  
    }  
  
   
  
    public String getImageContentType() {  
        return imageContentType;  
    }  
  
    public void setImageContentType(String imageContentType) {  
        this.imageContentType = imageContentType;  
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public File getImage1() {
		return image1;
	}

	public void setImage1(File image1) {
		this.image1 = image1;
	}

	public File getImage2() {
		return image2;
	}

	public void setImage2(File image2) {
		this.image2 = image2;
	}

	public String getFileName1() {
		return fileName1;
	}

	public void setFileName1(String filename1) {
		this.fileName1 = filename1;
	}

	public String getFileName2() {
		return fileName2;
	}

	public void setFileName2(String filename2) {
		this.fileName2 = filename2;
	}

	public String getFilePath1() {
		return filePath1;
	}

	public void setFilePath1(String filePath1) {
		this.filePath1 = filePath1;
	}

	public String getFilePath2() {
		return filePath2;
	}

	public void setFilePath2(String filePath2) {
		this.filePath2 = filePath2;
	}

	public UserManager getUm() {
		return um;
	}

	public void setUm(UserManager um) {
		this.um = um;
	}

	public Set<UserPictures> getPictures() {
		return pictures;
	}

	public void setPictures(Set<UserPictures> pictures) {
		this.pictures = pictures;
	}


}
