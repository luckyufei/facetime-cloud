<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <!-- Navbar
    ================================================== -->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="./storage"><img alt="Charisma Logo" src="../img/logo20.png" /> <span>Cloud</span></a>
          <!-- theme selector starts -->
        <div class="btn-group pull-right theme-container" >
          <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="icon-tint"></i><span class="hidden-phone"> 切换主题/皮肤 </span>
            <span class="caret"></span>
          </a>
          <ul class="dropdown-menu" id="themes">
            <li><a data-value="classic" href="#"><i class="icon-blank"></i> Classic</a></li>
            <li><a data-value="cerulean" href="#"><i class="icon-blank"></i> Cerulean</a></li>
            <li><a data-value="cyborg" href="#"><i class="icon-blank"></i> Cyborg</a></li>
            <li><a data-value="redy" href="#"><i class="icon-blank"></i> Redy</a></li>
            <li><a data-value="journal" href="#"><i class="icon-blank"></i> Journal</a></li>
            <li><a data-value="simplex" href="#"><i class="icon-blank"></i> Simplex</a></li>
            <li><a data-value="slate" href="#"><i class="icon-blank"></i> Slate</a></li>
            <li><a data-value="spacelab" href="#"><i class="icon-blank"></i> Spacelab</a></li>
            <li><a data-value="united" href="#"><i class="icon-blank"></i> United</a></li>
          </ul>
        </div>
        <!-- theme selector ends -->
        <!-- user dropdown starts -->
        <div class="btn-group pull-right" >
          <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="icon-user"></i><span class="hidden-phone"> admin</span>
            <span class="caret"></span>
          </a>
          <ul class="dropdown-menu">
            <li><a href="#">用户资料</a></li>
            <li class="divider"></li>
            <li><a href="login.html">退出</a></li>
          </ul>
        </div>
        <!-- user dropdown ends -->
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li><a href="./storage">网盘</a></li>
              <li class=""><a href="./update">更新</a></li>
              <li class=""><a href="./contact">联系人</a></li>
              <li class=""><a href="./team">团队</a></li>
              <li class=""><a href="./chart">报表</a></li>
              <li class=""><a href="./application">应用</a></li>
              <li class=""><a href="./share">我的分享</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>