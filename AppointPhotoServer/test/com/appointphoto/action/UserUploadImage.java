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
import java.util.UUID;

import net.sf.json.JSONObject;

import org.junit.Test;

public class UserUploadImage {
	@Test
	public void test() {	
		
		int res = 0;  
        String result = null;  
        String urlStr="http://localhost:8080/AppointPhotoServer/UserUploadImageAction";  
        String BOUNDARY = UUID.randomUUID().toString(); // 边界标识 随机生成  
        String PREFIX = "--", LINE_END = "\r\n";  
        String CONTENT_TYPE ="multipart/form-data";  
        String TAG = "uploadFile";  
        int TIME_OUT = 10 * 1000; // 超时时间  
        String CHARSET = "utf-8"; // 设置编码  
        try {  
            URL url = new URL(urlStr);  
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
            conn.setReadTimeout(TIME_OUT);  
            conn.setConnectTimeout(TIME_OUT);  
            conn.setDoInput(true); // 允许输入流  
            conn.setDoOutput(true); // 允许输出流  
            conn.setUseCaches(false); // 不允许使用缓存  
            conn.setRequestMethod("POST"); // 请求方式  
            conn.setRequestProperty("Charset", CHARSET); // 设置编码  
            conn.setRequestProperty("connection", "keep-alive");  
            conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary="  
                    + BOUNDARY);  
  
            File file=new File("/home/beyond/Src/test.jpg");
            if (file != null) {  
                /**  
                 * 当文件不为空时执行上传  
                 */  
                DataOutputStream dos = new DataOutputStream(conn.getOutputStream());  
                StringBuffer sb = new StringBuffer();  
                sb.append(PREFIX);  
                sb.append(BOUNDARY);  
                sb.append(LINE_END);  
                /**  
                 * 这里重点注意： name里面的值为服务器端需要key 只有这个key 才可以得到对应的文件  
                 * filename是文件的名字，包含后缀名  
                 */  
  
                sb.append("Content-Disposition: form-data; name=\"file\"; filename=\""  
                        + file.getName() + "\"" + LINE_END);  
                sb.append("Content-Type: application/octet-stream; charset="  
                        + CHARSET + LINE_END);  
                sb.append(LINE_END);  
                dos.write(sb.toString().getBytes());  
                InputStream is = new FileInputStream(file);  
                byte[] bytes = new byte[1024];  
                int len = 0;  
                while ((len = is.read(bytes)) != -1) {  
                    dos.write(bytes, 0, len);  
                }  
                is.close();  
                dos.write(LINE_END.getBytes());  
                byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END)  
                        .getBytes();  
                dos.write(end_data);  
                dos.flush();  
                /**  
                 * 获取响应码 200=成功 当响应成功，获取响应的流  
                 */  
               res = conn.getResponseCode();  
                System.out.println( "response code:" + res);  
                if (res == 200) {  
                   System.out.println( "request success");  
                    InputStream input = conn.getInputStream();  
                    StringBuffer sb1 = new StringBuffer();  
                    int ss;  
                    while ((ss = input.read()) != -1) {  
                        sb1.append((char) ss);  
                    }  
                    result = sb1.toString();  
                   System.out.println( "result : " + result);  
                } else {  
                    System.out.println("request error");  
                }  
            }  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        
    }  
	
}
