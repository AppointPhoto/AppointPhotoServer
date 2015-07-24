<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String basePath=application.getRealPath("/");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
﻿<html>
<head>
<meta charset="utf-8">
<basehref="<%=basePath%>">
<title>管理员登录</title>
<link href="css/base.css" rel="stylesheet" type="text/css">
<link href="css/index.css" rel="stylesheet" type="text/css">
<link href="css/home.css" rel="stylesheet" type="text/css">
<link href="css/validationEngine.jquery.css" rel="stylesheet" type="text/css">
<link rel="Shortcut Icon" href="http://cdn.51yuepai.com/static/fav.ico">
<script src="//hm.baidu.com/hm.js?203f2d762da9a9606811206cc87c8143"></script><script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?203f2d762da9a9606811206cc87c8143";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
</head>
<body style="background:#f5f5f5;">


<div class="header_Top">
  <div class="header_yp">
   <h2 class="logo"><a href="http://www5.51yuepai.com/"><img src="image/index/index_logo.png"></a></h2>
                    <div class="default">
        <span class="user"><b class="user_icon"></b><a href="login.jsp">用户登录</a>| <a href="adminLogin.jsp">管理员</a></span>
        <span class="photo"><b class="photo_icon"></b><a href="register�source=photographer.html">摄影师注册</a> | <a href="login�source=photographer.html">登录</a></span>
     </div>
            </div><!--header_yp end-->
 </div>
<div class="user_reg">
   <div class="user_reg_n">
      <h5><span>登录您的管理员帐号</span></h5>
      <form id="login_form" action="adminLoginAction.action" method="post" class="user_form">
        
        <input type="text"  class="form_put" id="name" name="name" placeholder="用户名：" >
       <input type="password" class="form_put" id="password" name="password" placeholder=" 密码："> 
        
        <div class="cz">
         <label class="fl"><input type="checkbox" value="" class="checkbox">记住密码</label>
         <a href="forgot�source=.html" class="fr">忘记密码？</a>
         </div>
         <dl><dt></dt><dd style="color:#E95431;" id="error"></dd></dl>
         <input id="from" type="hidden" name="from" value="">
        <input id="login_btn" type="submit" class="form_btn" value="立即登录">
     </form>
     <p>还没有约拍账户？</p>
     <p>注册只需一分钟，即可享受全站服务</p>
     <p><a href="userRegister.jsp">立即注册</a></p>
   </div><!--user_reg_n end-->
</div><!--user_reg-->

<div class="index_footer">
  <dl>
   <dt class="settled">
      <div class="title"><b class="sett"></b>摄影师入驻申请</div>
      <a href="register�source=photographer&amp;from=.html">我要申请</a>
   </dt>
   <dd>
     <ul>
       <li>
        <div class="title"><b class="gsxx"></b>公司信息</div>
            <a href="http://www5.51yuepai.com/html/about">公司简介</a>
            <a href="http://www5.51yuepai.com/html/contact">联系我们</a>
            <a href="http://www5.51yuepai.com/html/opinion">意见反馈</a>
       </li>
       <li>
        <div class="title"><b class="yhxz"></b>用户须知</div>
            <a href="http://www5.51yuepai.com/html/service">服务流程</a>
            <a href="http://www5.51yuepai.com/html/question">常见问题</a>
            <a href="http://www5.51yuepai.com/html/deal">用户协议</a>
       </li>
       <li class="last">
        <div class="title"><b class="kfxx"></b>客服信息</div>
        <span><b class="phone_icon"></b>400-072-0672</span>
        <span><b class="emil_icon"></b>beyondliangcai@163.com</span>
        <span class="time_kf">（周一至周五9：00-20：00）</span>
        <span class="time_kf tl">（周六日及法定节假日9：00-18：00）</span>
       </li>
     </ul>
   </dd>
  </dl>
</div><!--index_footer end-->
<div class="filing_bar">京ICP备12039603号  北京西瓜藤网络科技有限公司</div><!--filing_bar end-->
<script src="js/jquery-1.8.3.min.js"></script>
<script src="js/jquery.validationEngine.js"></script>
<script>
 
</script>


</body>
</html>