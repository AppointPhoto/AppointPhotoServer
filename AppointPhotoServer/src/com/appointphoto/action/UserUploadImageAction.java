package com.appointphoto.action;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.appointphoto.dto.UserRegisterDto;
import com.appointphoto.model.User;
import com.appointphoto.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


//处理用户注冊
public class UserUploadImageAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private File photo;// 上传文件
    private String photoFileName;// 上传文件的文件名
    private String photoContentType;// 上传文件的类型
    private String savePath;//上传后的保存目录
     
     
    public File getPhoto() {
        return photo;
    }
 
    public void setPhoto(File photo) {
        this.photo = photo;
    }
 
    public String getPhotoFileName() {
        return photoFileName;
    }
 
    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }
 
    public String getPhotoContentType() {
        return photoContentType;
    }
 
    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }
 
    public String getSavePath() {
        return savePath;
    }
 
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
 
    public UserUploadImageAction() {
        System.out.println("UserUploadImageAction构造方式被执行");
    }
     
    //执行上传功能
    public String execute() {
        System.out.println("执行上传execute（）...");
        HttpServletRequest request=ServletActionContext.getRequest();  
         
        //1.获取上传后文件的真实目录
        String path =ServletActionContext.getServletContext().getRealPath(this.getSavePath());
        System.out.println(path);
        //2.获得上传文件的真实路径
        String f_name=path+File.separator+this.getPhotoFileName();
        //File.separator+
        System.out.println(f_name);
         
        System.out.println("文件名："+request.getParameter("fileName")); 
        System.out.println("获取Android端传过来的文件信息：");  
        System.out.println("文件存放目录: "+getSavePath());  
        System.out.println("文件名称: "+photoFileName);  
        System.out.println("文件大小: "+photo.length());  
        System.out.println("文件类型: "+photoContentType);  
         
         
        //3.创建输入和输出流
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
         
        try {
            bis=new BufferedInputStream(new FileInputStream(photo));
            bos=new BufferedOutputStream(new FileOutputStream(new File(f_name)));
            byte[] buff=new byte[(int)photo.length()];
            int len=0;
            while ((len=bis.read(buff))!=-1) {
                bos.write(buff,0,len);
            }
             
        } catch (Exception ex) {
            // TODO: handle exception
            ex.printStackTrace();
        }
        finally
        {
            try {
                if (bis!=null) {//先close，再null
                    bis.close();
                    bis=null;
                }
                if (bos!=null) {
                    bos.close();
                    bos=null;
                }
                System.out.println("上传成功！");
            } catch (Exception ex) {
                // TODO: handle exception
                ex.printStackTrace();
                System.out.println("上传失败！");
            }
        }
        return SUCCESS;
    }
}
