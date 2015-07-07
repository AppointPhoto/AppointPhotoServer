package com.appointphoto.action;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.appointphoto.dto.UserRegisterDto;
import com.appointphoto.model.User;
import com.appointphoto.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


//处理用户注冊
public class UserUploadImageAction extends ActionSupport {

	 // 上传文件域  
    private File image;  
    // 上传文件类型  
    private String imageContentType;  
    // 封装上传文件名  
    private String imageFileName;  
    // 接受依赖注入的属性  
    private String savePath;  
    
    private Map<String, String> params;
  
    @Override  
    public String execute() {  
        HttpServletRequest request=ServletActionContext.getRequest();  
        FileOutputStream fos = null;  
        FileInputStream fis = null;  
        try {  
            System.out.println("获取Android端传过来的普通信息：");  
            //System.out.println("用户名："+request.getParameter("username"));  
            //System.out.println("密码："+request.getParameter("pwd"));  
            //System.out.println("年龄："+request.getParameter("age"));  
            System.out.println("文件名："+request.getParameter("fileName"));  
            System.out.println("获取Android端传过来的文件信息：");  
            System.out.println("文件存放目录: "+getSavePath());  
            System.out.println("文件名称: "+imageFileName);  
            System.out.println("文件大小: "+image.length());  
            System.out.println("文件类型: "+imageContentType);  
           // System.out.println("name: "+params.get("name").toString());  
            
              
            fos = new FileOutputStream(getSavePath() + "/" + getImageFileName());  
            fis = new FileInputStream(getImage());  
            byte[] buffer = new byte[1024];  
            int len = 0;  
            while ((len = fis.read(buffer)) != -1) {  
                fos.write(buffer, 0, len);  
            }  
            System.out.println("文件上传成功");  
        } catch (Exception e) {  
            System.out.println("文件上传失败");  
            e.printStackTrace();  
        } finally {  
            close(fos, fis);  
        }  
        return SUCCESS;  
    }  
  
    /** 
     * 文件存放目录 
     *  
     * @return 
     */  
    public String getSavePath() throws Exception{  
        return ServletActionContext.getServletContext().getRealPath(savePath);   
    }  
  
    public void setSavePath(String savePath) {  
        this.savePath = savePath;  
    }  
  
    public File getImage() {  
        return image;  
    }  
  
    public void setImage(File image) {  
        this.image = image;  
    }  
  
    public String getImageContentType() {  
        return imageContentType;  
    }  
  
    public void setImageContentType(String imageContentType) {  
        this.imageContentType = imageContentType;  
    }  
  
    public String getImageFileName() {  
        return imageFileName;  
    }  
  
    public void setImageFileName(String imageFileName) {  
        this.imageFileName = imageFileName;  
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

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}  
}