<html>
<head>
<title>汇智云 - 登录</title>
<jsp:include page="/WEB-INF/pages/share/head.jsp" />
</head>
<body>
 <div class="container-fluid">
  <div class="row-fluid">
   <div class="row-fluid">
    <div class="span12 center login-header">
     <h2>欢迎光临汇智云</h2>
    </div>
    <!--/span-->
   </div>
   <!--/row-->
   <div class="row-fluid">
    <div class="well span5 center login-box">
     <div class="alert alert-info" id="message">请输入您的用户名和密码.</div>
     <form class="form-horizontal" action="index.html" method="post">
      <fieldset>
       <div class="input-prepend" title="用户名/邮箱" data-rel="tooltip">
        <span class="add-on"><i class="icon-user"></i></span><input autofocus class="input-large span10" name="username"
         id="username" type="text" value="" />
       </div>
       <div class="clearfix"></div>
       <div class="input-prepend" title="密码" data-rel="tooltip">
        <span class="add-on"><i class="icon-lock"></i></span><input class="input-large span10" name="password"
         id="password" type="password" value="" />
       </div>
       <div class="clearfix"></div>
       <div class="input-prepend">
        <label class="remember checkbox inline" for="remember"><input type="checkbox" id="remember" />Remember me</label>
        <label class="remember checkbox inline" for="useHttps"><input type="checkbox" id="useHttps" />Use https</label>
       </div>
       <div class="clearfix"></div>
       <p class="center span8">
        <button type="button" class="btn btn-primary" id="login">登录</button>
        <a href="./register" class="btn btn-primary">注册</a>
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
 <!-- foot.jsp  -->
 <jsp:include page="/WEB-INF/pages/share/foot.jsp" />
 
 
 <!-- // customer js -->
 <script src="../js/customer/crypto-sha256.js"></script>
 <script src="../js/customer/md5.js"></script>
 <script src="../js/customer/security.js"></script>
 <script src="../js/customer/jquery.i18n.properties-1.0.9.nameSpace.js"></script>
 <script src="../js/customer/util.js"></script>
 <script src="../js/customer/i18n.js"></script>
 <script src="../js/customer/dtos.js"></script>
 <script src="../js/customer/facetime-login.js"></script>
</body>
</html>
