package com.appointphoto.action;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.appointphoto.utils.FormFile;
import com.appointphoto.utils.SocketHttpRequester;

public class UserUploadImage {
	@Test
	public void test() {	
		
        try {  
        	String requestUrl = "http://localhost:8080/AppointPhotoServer/UserUploadImageAction";
        	File imageFile1=new File("/home/beyond/Src/test.jpg");
        	File imageFile2=new File("/home/beyond/Src/test2.jpg");
        	// 请求普通信息  
            Map<String, String> params = new HashMap<String, String>();  
            // params.put("filename", "beyond");  
            params.put("name", "beyond");  
            params.put("fileName1", imageFile1.getName());  
            params.put("fileName2", imageFile2.getName()); 
            // 上传文件  
            
            FormFile formfile1 = new FormFile(imageFile1.getName(), imageFile1,  
                    "image1", "application/octet-stream");
            FormFile formfile2= new FormFile(imageFile2.getName(), imageFile2,  
                            "image2", "application/octet-stream");
            FormFile [] formfiles=new FormFile[2];
            formfiles[0]=formfile1;
            formfiles[1]=formfile2;
            
            SocketHttpRequester.post(requestUrl, params, formfiles); 
        
        }
        
        catch(Exception e){
    	System.out.println(e.toString());
    	}
    }
	
}
