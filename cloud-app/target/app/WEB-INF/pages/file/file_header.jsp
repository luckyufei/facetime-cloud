<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class='row-fluid btn-toolbar'>
	<div class="btn-group">
		<a href="#mdl-upload" class="btn btn-primary btn-medium fs-btn-upload"
			role="button" data-toggle="modal"> <i class="fs-icon-upload"></i>
			<span class='hidden-tablet'> 上传文件 </span>
		</a>
	</div>
	<div class="btn-group">
		<button class="btn btn-medium dropdown-toggle fs-btn-download"
			data-toggle="dropdown">
			<i class="fs-icon-download"></i><span class='hidden-tablet'>离线下载</span><b
				class='caret'></b>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#"><i class="icon-folder-close"></i>新建文件夹</a></li>
			<li><a href="#"><i class="icon-folder-close"></i>新建局域网文件夹</a></li>
			<li class="divider"></li>
			<li><a href="#"><i class="icon-file"></i>新建Word文档</a></li>
			<li><a href="#"><i class="icon-file"></i>新建Excel文档</a></li>
			<li><a href="#"><i class="icon-file"></i>新建PPT文档</a></li>
		</ul>
	</div>

	<div class="btn-group">
		<button class="btn btn-medium fs-btn-createfile">
			<i class="fs-icon-createfile"></i> <span class='hidden-tablet'>
				新建文件夹 </span>
		</button>
	</div>

	<div class="btn-group" data-toggle="buttons-radio">
		<button class="btn">
			<span>&nbsp;<i class="icon-list"></i>&nbsp;
			</span>
		</button>
		<button class="btn">
			<span>&nbsp;<i class="icon-th">&nbsp;</i>
			</span>
		</button>
	</div>
	<div class="btn-group">
		<button class="btn dropdown-toggle" data-toggle="dropdown">
			<span>排序&nbsp;<b class="caret"></b><span>
		</button>
		<ul class="dropdown-menu">
			<li><a href=""><span> 文件名 <i
						class="icon-chevron-down"></i>
				</span> </a></li>
			<li><a href=""><span> 文件名 <i class="icon-chevron-up"></i>
				</span> </a></li>
			<li><a href=""> 文件大小</a></li>
			<li><a href=""> 修改时间</a></li>
		</ul>
	</div>
	<div class="btn-group" data-toggle="buttons-checkbox">
		<button class="btn">显示删除</button>
		<button class="btn">显示外链</button>
		<button class="btn">显示共享</button>
	</div>
</div>

<!-- model area -->
<div class="modal hide fade" id="mdl-upload">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">×</button>
		<h3>文件上传</h3>
	</div>
	<div class="modal-body">
		<div class="well-small">
			<span>本目录可以删除5GB的文件, <a href="#">升级VIP</a>即可删除<strong>50GB</strong>超大文件,
				<a href='#'>使用115云备份可删除文件夹</a></span>
			<div class="btn-group " id="swfupload-ctrl">
				<button class="btn btn-primary btn-medium">
					<span id="btn-upload">添加文件</span>
				</button>
				<button class="btn btn-primary dropdown-toggle"
					data-toggle="dropdown">
					<span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#">普通上传</a></li>
					<li><a href="#">电信极速上传</a></li>
					<li><a href="#">网通极速上传</a></li>
				</ul>
			</div>
		</div>
		<div>
			<table class="table table-condensed">
				<thead>
					<tr>
						<th>文件名</th>
						<th>上传进度</th>
						<th>大小</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Muhammad Usman</td>
						<td class="center">2012/01/01</td>
						<td class="center">Member</td>
						<td class="center"><span class="label label-success">Active</span>
						</td>
					</tr>
					<tr>
						<td>Sana Amrin</td>
						<td class="center">2012/01/21</td>
						<td class="center">Staff</td>
						<td class="center"><span class="label label-success">Active</span>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn" data-dismiss="modal">关闭</a> <a href="#"
			class="btn btn-primary">确定</a>
	</div>
</div>
