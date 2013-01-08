<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/WEB-INF/pages/share/taglib.jsp" %>
<jsp:include page="/WEB-INF/pages/share/head.jsp" />
<title>汇智云 - 网盘</title>
<link href='../customer/css/facetime-file.css' rel='stylesheet'>
</head>

<body data-spy="scroll" data-target=".bs-docs-sidebar">
	<div class="container-fluid fs-container" id="storage">
		<div class="span12">
			<jsp:include page="/WEB-INF/pages/file/file_header.jsp" />
			<div>
				<div class='row-fluid'>
					<ul class="breadcrumb">
						<li><a href="#">Home</a> <span class="divider">&gt;</span>
						</li>
						<li><a href="#">Dashboard</a>
						</li>
					</ul>
				</div>

				<div class="row-fluid">
					<div id="js_fileter_box" class="list-filter">
						  <div btn="check_all_file" class="fs-checkbox"></div>
						  <input type="checkbox" name="checkall" style="display:none;">
						   <div class="filter-type">
						     <ul rel="filter">
						       <li val="lf"><a ><i class="lf-all"></i><span>全部</span></a></li>
						       <li val="lf-1"><a><i class="lf-document"></i><span>文档</span></a></li>
						       <li val="lf-2"><a><i class="lf-photo"></i><span>图片</span></a></li>
						       <li val="lf-3"><a><i class="lf-music"></i><span>音乐</span></a></li>
						       <li val="lf-4"><a><i class="lf-video"></i><span>视频</span></a></li>
						       <li val="lf-5"><a><i class="lf-archive"></i><span>压缩包</span></a></li>
						       <li val="lf-6"><a><i class="lf-application"></i><span>应用</span></a></li>
						       </ul><ul rel="none_text"><li rel="star"><a><i class="lf-star"></i><span>星标</span></a></li>
						       <li rel="cal"><a><i class="lf-date"></i><span>日期</span></a></li>
						       <li rel="is_q"><a><i class="lf-circle"></i><span>圈子</span></a></li>
						       <li><a target="_blank" href="http://115.com/u/21767051"><i class="lf-share"></i><span>分享</span></a></li>
						       </ul>
						     </div>
						     <div style="padding-left:5px;" class="filter-sub">
						     <div style="padding-right: 5px; padding-left: 0px;" class="filter-order">
							      <a class="filter-menu" rel="taxis" href="javascript:;"><span>时间从新到旧</span><i></i></a>
							      <ul rel="taxis_con" style="display: none;">
								      <li val="a_file_name"><a>按文件名倒序</a></li><li val="d_file_name"><a>按文件名顺序</a></li>
								      <li val="a_user_ptime"><a>时间从新到旧</a></li><li val="d_user_ptime"><a>时间从旧到新</a></li>
								      <li val="a_file_size"><a>文件从大到小</a></li><li val="d_file_size"><a>文件从小到大</a></li>
							      </ul>
						      </div>
						      <ul rel="view" class="filter-thumb">
						      	<li style="padding-right:5px;" val="list"><a ><i class="ls-list"></i><span>列表</span></a></li>
						      	<li val="view_large"><a><i class="ls-thumb"></i><span>图标</span></a></li>
						      </ul>
						      </div>
						</div><!-- / .list-filter -->	
				</div>
				
				<!-- page list -->
				<div class="row-fluid box">
					<div class="box-content page-list">
							<ul rel="list" id="js_data_list_inner">
							 <input type="hidden" id="current_folder_id" value="${currentFolder.id}"/>
                             <c:forEach items="${currentFolder.children}" var="subFile">
                               <li rel="item" data-file-option="${subFile.json}">
                                 <input type="checkbox" value="${subFile.id}">
                                 <div class="fs-checkbox"></div>
                                 <i class="file-type tp-folder"></i>
                                 <div class="file-name">
                                  <a href="javascript:;" btn="goto_dir" aid="1" cid="2220068" rel="view_folder">${subFile.name}</a>
                                 </div>
                                 <div class="file-info">
	                                  <em><fmt:formatDate  value="${subFile.modifyDate}" type="date" pattern="yyyy-MM-dd" /></em> 
	                                  <span class="file-ctrl hide">
	                                    <a href="javascript:;" class="ico-lio  i-open" btn="goto_dir" aid="1" cid="2220068" title="打开" data-rel="tooltip">打开</a>
	                                    <a href="#" target="_blank" class="ico-lio  i-download" menu="download_dir_one" data_title="下载">下载</a>
	                                    <a href="javascript:;" class="ico-lio  i-share" menu="share_one" data_title="分享">分享</a> 
	                                  </span>
                                 </div>
                                </li>
                             </c:forEach>
							</ul>
						</div>
	
						<div class="pagination pagination-centered">
							<ul>
								<li><a href="#">Prev</a></li>
								<li class="active"><a href="#">1</a>
								</li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">Next</a></li>
							</ul>
						</div>
					</div>
					<!-- / .box -->
				</div>
			</div><!-- / span11 -->
			<jsp:include page="/WEB-INF/pages/share/rightside.jsp" />
		</div><!-- / #storage  -->
	<!--/.fluid-container-->
       
	<jsp:include page="/WEB-INF/pages/share/foot.jsp" />
	<jsp:include page="/WEB-INF/pages/file/upload.jsp" />
 <script type="text/javascript">
	window["contextPath"] = "${pageContext.request.contextPath}";
	window["sessionId"]="${pageContext.session.id}";
	window["sessionName"]="JSESSIONID";
	
	window.log = log4javascript.getDefaultLogger();
	log.debug("sessionName:",window["sessionName"]);
	log.debug("sessionId:",window["sessionId"]);

 </script>
    <script type="text/javascript" src="../customer/js/file.js"></script>
</body>
</html>
