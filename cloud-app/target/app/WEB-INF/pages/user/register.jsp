<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Facetime Cloud - Register </title>
<jsp:include page="/WEB-INF/pages/share/head.jsp" />
</head>
<body>
 <div class="container-fluid">
  <div class="row-fluid">
   <div class="row-fluid">
    <div class="span12 center login-header">
     <h2>Welcome to facetime cloud</h2>
    </div>
    <!--/span-->
   </div>
   <!--/row-->
   <div class="row-fluid">
    <div class="well span6 center login-box">
     <div class="alert alert-info" id="message">欢迎来到OATOS</div>
     <form class="form-horizontal" action="index.html" method="post">
      <fieldset>
       <div class="control-group">
		<label class="control-label" for="email">邮箱</label>        
		<div class="controls ">
    	    <input autofocus class="input-large pull-left" name="email" type="text" value="" />
            <span class="help-inline pull-left">请输入常用邮箱</span>
		</div>
       </div>
       <div class="clearfix"></div>
       <div class="control-group">
		<label class="control-label" for="usename">用户名</label>        
		<div class="controls">
    	    <input class="input-large pull-left" name="username" type="text" value="" />
            <span class="help-inline pull-left">请输入你的用户名</span>
		</div>
       </div>
       <div class="clearfix"></div>
       <div class="control-group">
        <label class="control-label">密码</label>
        <div class="controls ">
	        <input class="input-large pull-left" name="password" type="password" value="" />
            <span class="help-inline pull-left">请输入你的密码</span>
        </div>
       </div>
       <div class="clearfix"></div>
       <div class="control-group">
        <label class="control-label">确认密码</label>
        <div class="controls">
          <input class="input-large pull-left" name="repassword" type="password" value="" />
          <span class="help-inline pull-left">请输入确认密码</span>
        </div>
       </div>
       <div class="clearfix"></div>
       <div class="control-group fs-verify-code">
        <label class="control-label">验证码</label>
        <div class="controls">
	        <input class="span4 pull-left" name="verifyCode" type="text" value="" />
	        <img src="../verify/create?key=regVerifyCode" alt="验证码" class="pull-left img-circle" style="height: 28px; width: 90px"/>
            <a href="" class="pull-left"> 看不清? </a>
        </div>
       </div>
       <div class="clearfix"></div>
       <div class="control-group">
         <div class="control-label">  </div>
         <div class="controls fs-controls-chkbox">
         <label class="checkbox inline" for="remember"><input type="checkbox" id="remember" />我已阅读并同意</label>
         <label class="checkbox inline" for="useHttps"><input type="checkbox" name="useHttps" />Use https</label>
         </div>
       </div>
       <div class="clearfix"></div>
       <p class="center span8">
        <button type="button" class="btn btn-primary" id="register">注册</button>
        <a href="login.html" class="btn"> 登录 </a>
       </p>
      </fieldset>
     </form>
    </div>
    <!--/span-->
   </div>
   <!--/row-->
  </div>
  <!--/fluid-row-->
 </div>
 <!--/.fluid-container-->
 <jsp:include page="/WEB-INF/pages/share/foot.jsp"/>
 
 <!-- // customer js -->
 <script src="../js/customer/crypto-sha256.js"></script>
 <script src="../js/customer/md5.js"></script>
 <script src="../js/customer/security.js"></script>
 <script src="../js/customer/jquery.i18n.properties-1.0.9.nameSpace.js"></script>
 <script src="../js/customer/util.js"></script>
 <script src="../js/customer/i18n.js"></script>
 <script src="../js/customer/dtos.js"></script>
 <script src="../js/customer/facetime-login.js"></script>
 <script type="text/javascript">
   $(function(){
	   $(".fs-verify-code a").bind('click',function(){
		   $(this).siblings("img").attr("src","../verify/create?key=regVerifyCode&t="+util.currentTimeMils());
	   });
	   
   });
 </script>
</body>
</html>
