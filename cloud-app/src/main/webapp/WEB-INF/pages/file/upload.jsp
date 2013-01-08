<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- model area -->
<div class="modal hide fade" id="mdl-upload">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">×</button>
		<h3>文件上传</h3>
	</div>
	<div class="modal-body">
		<div class="well-small">
			<span>本目录可以删除5GB的文件, <a href="#">升级VIP</a>即可删除<strong>50GB</strong>超大文件, <a href='#'>使用115云备份可删除文件夹</a></span>
			<div class="btn-group " id="swfupload-ctrl">
				<button class="btn btn-primary btn-medium">
					<span id="btn-upload">添加文件</span>
				</button>
				<button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
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
					<tr class="hide">
						<td></td>
						<td class="center"><div class="progress progress-striped progress-success active"> <div style="width: 2%;" class="bar"></div> </div></td>
						<td class="center"></td>
						<td class="center">
						    <span class="label label-info">Wait</span>
							<div class='btn-group' data-toggle='buttons-radio'>
							<button class='btn' title='暂停'><i class='icon-pause'></i></button>
							<button class='btn' title='移除'><i class='icon-remove'></i></button>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn" data-dismiss="modal">关闭</a> <a href="#" class="btn btn-primary">确定</a>
	</div>
</div>