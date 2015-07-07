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
        	File imageFile=new File("/home/beyond/Src/test.jpg");
        	File imageFile2=new File("/home/beyond/Src/test2.jpg");
        	// 请求普通信息  
            Map<String, String> params = new HashMap<String, String>();  
            // params.put("filename", "张三");  
            params.put("name", "张三");  
            params.put("fileName", imageFile.getName());  
            // 上传文件  
            
            FormFile formfile[] ={ new FormFile(imageFile.getName(), imageFile,  
                    "image", "application/octet-stream"),
                    new FormFile(imageFile2.getName(), imageFile,  
                            "image", "application/octet-stream")
            };
            SocketHttpRequester.post(requestUrl, params, formfile); 
        
        }
        
        catch(Exception e){
    	System.out.println(e.toString());
    	}
    }
	
}
