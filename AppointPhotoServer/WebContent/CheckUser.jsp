<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.io.*"   %>
   <%@ page import="java.util.*"   %>
   <%@ page import="com.appointphoto.model.*"   %>
   <%@ page import="com.google.gson.*"   %>
   <%@ page import="java.lang.reflect.Type"   %>
    <%@ page import="com.google.gson.reflect.TypeToken"%>
  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>审查摄影师资格</title>
    <link type="text/css" href="css/css.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jQuery.asyncLoading.js"></script>
</head>
<body>
 <%
    int fileNum = 0;  
    String jsonString = (String)request.getAttribute("jsonUsers");
    Gson jsonUsers=new Gson();
    
    Type type= new TypeToken<List<User>>(){
    	
    }.getType();
    
    List <User> users =jsonUsers.fromJson(jsonString, type);
    
    out.print("user size:"+users.size());
    out.print("userpicture2 size:"+users.get(1).getPictures().size());
    %>
	<div id="content">
    	<div id="button">
        	<ul>
            	<li>小图</li>
                <li>中图</li>
                <li>大图</li>
            </ul>
        </div>
        <div id="image"></div>
    </div>
   
    
    <script type="text/javascript">
    	$(function() {
			//把图片写入htm
			//alert("123")
			var imgArr = ""
			//服务器保存上传图片的虚拟地址
			var imgPathRoot="http://localhost:8080/UserPicture/"
			var imgPath
			var userNum=<%= users.size()%>
			var userPictures1Size=<%=users.get(0).getPictures().size()%>
		
			for(var i=0 ; i<userPictures1Size ; i++) {
				//alert("name:" + imgPathRoot + dataobj.json[0].beyond[i].captain)
				imgPath=imgPathRoot+<%users.get(0).getName()%> +<%=users.get(0).getPictures().get(i).getCaptain()%>
				imgArr += '<img class="scrollLoading" data-url="'+ imgPath + '" src="image/grey.gif" />';
				
			}
			$("#image").append(imgArr);
			$("img").load(function () {
				//图片默认隐藏  
				$(this).hide();
				//使用fadeIn特效  
				$(this).stop().fadeIn("5000");
			});
			// 异步加载图片，实现逐屏加载图片
			$(".scrollLoading").scrollLoading(); 
			
			
			////以下代码为效果代码，非异步加载核心
			
			//设置页面最外层容器的最小高度为屏幕的高度
			$("#content").css({"min-height" : $(window).height()});
			$("#button li:first-child").addClass("li_hover");
			var index_button = 0;
			$("#button").on("click", "ul li", function(){
				index_button = $(this).index();
				$("#button li").removeClass("li_hover");
				$(this).addClass("li_hover");
				if(index_button == 0) {//效果一
					$("img").stop().animate({"width" : "225px", "height" : "132px"},600);
				} else if (index_button == 1) {//效果二
					$("img").stop().animate({"width" : "500px", "height" : "294px"},600);
				} else {//效果三
					$("img").stop().animate({"width" : "1050px", "height" : "618px"},600);
				}
			});
			$("#button li").hover(function(){
				$(this).addClass("li_hover");
			},function(){
				if(index_button != $(this).index()) {
					$(this).removeClass("li_hover");
				}
			});
			
		});
    </script>
<div style="text-align:center;clear:both">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>
</div>
</body>
</html>
