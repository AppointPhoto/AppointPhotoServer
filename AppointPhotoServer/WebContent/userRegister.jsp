<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
﻿<html><head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="viewport" content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="description" content="约拍是中国首家摄影服务的O2O平台, 登陆浙江卫视《天生我有才》栏目。直接预约摄影师，为您提供个性化的专业摄影服务。新生儿/满月/百天上门拍摄服务，儿童特色外景纪实拍摄。约拍 – 约摄影师，拍我想拍!">
<meta name="keywords" content="摄影师,孕妈照,满月照,百天照,上门拍照,孕妈写真,儿童摄影">
<title>随影！</title>
<link href="css/index.css" rel="stylesheet" type="text/css">
<script src="//hm.baidu.com/hm.js?203f2d762da9a9606811206cc87c8143"></script><script src="js/main.js"></script>
<script src="js/jquery.validationEngine.js"></script>
<link href="css/base.css" rel="stylesheet" type="text/css">
<link href="css/home.css" rel="stylesheet" type="text/css">
<link href="css/validationEngine.jquery.css" rel="stylesheet" type="text/css">
<link rel="Shortcut Icon" href="http://cdn.51yuepai.com/static/fav.ico">
<script>
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
        <span class="user"><b class="user_icon"></b><a href="login.html">用户登录</a></span>
        <span class="photo"><b class="photo_icon"></b><a href="register�source=photographer.html">摄影师注册</a> | <a href="login�source=photographer.html">登录</a></span>
     </div>
            </div><!--header_yp end-->
 </div>
<div class="user_reg">
   <div class="user_reg_n">
      <h4>注册为约拍用户</h4>
      <form id="register_form" action="userRegisterAction.action" method="post" class="user_form">
        <input class="validate[required,custom[number],minSize[11],maxSize[11]] form_put" name="phoneNum" id="phoneNum" placeholder="手机号码">
        <!-- <div class="yzm"><input class="validate[required,custom[number],minSize[6],maxSize[6]] form_put" id="validation_code" name="validation_code" type="text" placeholder="验证码"><a href="javascript:void(0)" id="send_btn" class="send">发送验证码</a></div>
         -->
        <input class="validate[required,minSize[2]] form_put" name="name" id="name" type="text" placeholder="昵称">
        <input class="form_put validate[required,minSize[3]]" id="password" name="password" type="password" placeholder="密码">
        <input id="password2" name="password2"  type="password" placeholder="确认密码" class="form_put validate[equals[password]]">
        <input class="form_put" name="emailAddress" id="emailAddress" type="text" placeholder="邮箱地址">
        
        <dl><dt></dt><dd style="color:#E95431;" id="error"></dd></dl>
        <input name="" type="submit" id="register_btn" class="form_btn" value="立即注册">
     	<input type="hidden" id="user_type" name="user_type" value="user">
		<input type="hidden" id="from" name="from" value="">
     </form>
     <p>已有约拍账户，<a href="login.jsp">立即登录</a></p>
   </div><!--user_reg_n end-->
</div><!--user_reg-->

<div class="index_footer">
  <dl>
   <dt class="settled">
      <div class="title"><b class="sett"></b>摄影师入驻申请</div>
      <a href="register�source=photographer.html">我要申请</a>
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
        <span><b class="emil_icon"></b>servic@xiguateng.cn</span>
        <span class="time_kf">（周一至周五9：00-19：00）</span>
        <span class="time_kf tl">（周六日及法定节假日9：00-18：00）</span>
       </li>
     </ul>
   </dd>
  </dl>
</div><!--index_footer end-->
<div class="filing_bar">京ICP备12039603号  北京西瓜藤网络科技有限公司</div><!--filing_bar end-->
<script>
  $(document).ready(function(){
    var time=60;
    function time_60(ob){
  	  if(time==0){
  		ob.css("color","#666");//#666
  	    ob.removeAttr('disabled');
  		ob.html('发送验证码');
  		time=60;
  	  }else{
  		ob.css("color","#e2e2e2");//#666
  	    ob.attr('disabled',true);
  		ob.html('重新发送'+time+'s');
  		time--;
  		setTimeout(function(){
  		  time_60(ob);
  		},1000);
  	  }
  	}
    // 点击发送验证码...
    $('#send_btn').click(function(){
    	var ob=$(this);
    	if(ob.attr('disabled')){
			return false;
        }
	  	var mobile=$('#mobile').val();
	  	if(mobile=='' || mobile==null){alert('手机号不得为空');return false;}
	  	time_60(ob);
	  	$.post('http://www5.51yuepai.com/user/send_validation_code',{mobile:mobile});
	});
    // 表单验证
	$('#register_form').validationEngine('attach');
	// 提交注册...
  
  });
</script>


</body>
</html>