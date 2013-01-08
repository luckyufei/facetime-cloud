<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="js_page_side" class="frame-side">
	<div class="user-info">
		<div class="user-head">
			<a title="点击修改头像" target="_blank" id="js_main_user_img_face" href="http://my.115.com/?ct=account&amp;ac=update_face">
				<img alt="" src="http://face.my.115.com/01/mocd5_m.png?1353660061"> </a>
		</div>
		<div class="user-name">
			<a id="js_level_icon_btn" style="" target="_blank" href="http://pay.115.com"><img class="icon-level"
				src="../customer/115/img/level/0.png">
			</a>
			<span><a target="_blank" href="http://my.115.com" id="js_main_user_name_link">google_yufei</a>
			</span>
		</div>

		<ul class="user-opt">
			<li><a class="uop-topic" href="javascript:;" id="js_system_q_at_btn" data_title="话题提醒">话题提醒</a></li>
			<li><a class="uop-message" href="javascript:;" id="js_systen_msg_btn" data_title="系统通知">系统通知</a></li>
			<li><a onclick="Ext.Common.Setting();return false;" class="uop-setting" href="javascript:;" data_title="全局设置">全局设置</a>
			</li>
			<li><a class="uop-logout" href="../user/logout">退出</a></li>
		</ul>
		<div style="top: 65px;" class="user-text">
			<div style="position: absolute; height: 16px; overflow: hidden;">
				<ul id="js_box" style="position: relative; top: -48px;">
					<li style="height: 16px; line-height: 16px; vertical-align: middle;"><a target="_blank"
						href="http://v2.tjj.com/click.php?id=10488&amp;tourl=http%3A%2F%2Fvip.115.com%2F%3Fp%3Dright_text">升级VIP,专享百G高速下载</a>
					</li>
					<li style="height: 16px; line-height: 16px; vertical-align: middle;"><a target="_blank"
						href="http://v2.tjj.com/click.php?id=10482&amp;tourl=http%3A%2F%2Fq.115.com%2Freward_hall%3Fgly">觅资源不用愁，发悬赏帮你找</a>
					</li>
					<li style="height: 16px; line-height: 16px; vertical-align: middle;"><a target="_blank"
						href="http://v2.tjj.com/click.php?id=10483&amp;tourl=http%3A%2F%2Fpay.115.com%2Fgift%3Fgly">兑换中心上线啦！赚枫叶换好礼</a>
					</li>
					<li style="height: 16px; line-height: 16px; vertical-align: middle;"><a target="_blank"
						href="http://v2.tjj.com/click.php?id=10485&amp;tourl=http%3A%2F%2Fq.115.com%2F%3Fgly">找资源玩道具，更多精彩上圈子</a>
					</li>
					<li style="height: 16px; line-height: 16px; vertical-align: middle;"><a target="_blank"
						href="http://v2.tjj.com/click.php?id=10489&amp;tourl=https%3A%2F%2Fvip.115.com%2F%3Fp%3Dhurrygo">充VIP开圈子送大量枫叶，快抢</a>
					</li>
					<li style="height: 16px; line-height: 16px; vertical-align: middle;"><a target="_blank"
						href="http://v2.tjj.com/click.php?id=10486&amp;tourl=http%3A%2F%2Fq.115.com%2Freward_hall%3Fgly">我为人人，回答圈友悬赏赚枫叶</a>
					</li>
					<li style="height: 16px; line-height: 16px; vertical-align: middle;"><a target="_blank"
						href="http://v2.tjj.com/click.php?id=10487&amp;tourl=http%3A%2F%2Fquanzi.115.com%2Fpayment%2Fcreate.html%3Fxzy">人人为我，要资源圈友来帮忙！</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="user-nav">
		<ul>
			<li><a onclick="URL_CTL.Home();return false;" href="javascript:;" tab="u" class="focus"><i
					class="icon-nav iv-cloud"></i><span>网盘</span>
			</a>
			</li>
			<li><a target="_blank" href="http://q.115.com" tab="q"><i class="icon-nav iv-circle"></i><span>圈子</span>
			</a>
			</li>
			<li><a onclick="URL_CTL.SelectTab('note', '/note');return false;" href="javascript:;" tab="note"><i
					class="icon-nav iv-notebook"></i><span>记事本</span>
			</a>
			</li>
			<li id="js_mav_more_btn"><a rel="more" href="javascript:;"><i class="icon-nav iv-more"></i><span>更多</span>
			</a></li>
		</ul>

	</div>

	<div class="yaoyaole-btn">
		<a id="js_yaoyao_button" href="javascript:;">摇一摇</a>
	</div>

	<div class="space-progress">
		<div id="js_index_space_info" style="width: 168px" class="space-info">
			<a target="_blank" style="text-decoration: none;" href="http://vip.115.com" title="网盘空间使用率49.66%"> <i
				style="width: 49.66%;" rel="space_line"></i> <em style="cursor: pointer;" rel="space_text"
				title="已用15.36GB, 共30.94GB, 剩余15.57GB">15.4GB/30.9GB</em> </a>
		</div>
		<a class="space-upgrade" target="_blank" style="display: none;" href="http://vip.115.com/?p=right_space">扩容</a>

	</div>
	<div style="" id="js_user_resouce_list" class="resource-list">
		<h3>
			<span><a target="_blank" href="http://u.115.com/u">分享空间</a>
			</span>
			<div class="res-btn">
				<a btn="prev" href="javascript:;"><i class="rb-prev">上一页</i>
				</a> <a btn="next" href="javascript:;"><i class="rb-next">下一页</i>
				</a>
			</div>
		</h3>
		<ul rel="0">
			<li><i></i><a title="酷睿电脑解忧 分享了 “pt80[亲浪]-刘紫玲《_疯潮_2012红色慢摇_》.rar”" target="_blank"
				href="http://115.com/u/9611608">pt80[亲浪]-刘紫玲《_疯潮_2012红色慢摇_》.rar</a>
			</li>
			<li><i></i><a title="酷睿电脑解忧 分享了 “注册序列号.txt”" target="_blank" href="http://115.com/u/9611608">注册序列号.txt</a>
			</li>
			<li><i></i><a title="酷睿电脑解忧 分享了 “录音软件汉化版Recorder4.2.exe”" target="_blank" href="http://115.com/u/9611608">录音软件汉化版Recorder4.2.exe</a>
			</li>
			<li><i></i><a title="酷睿电脑解忧 分享了 “Windows Loader v2.1.4.zip”" target="_blank" href="http://115.com/u/9611608">Windows
					Loader v2.1.4.zip</a>
			</li>
			<li><i></i><a title="酷睿电脑解忧 分享了 “Foobar2000透明.rar”" target="_blank" href="http://115.com/u/9611608">Foobar2000透明.rar</a>
			</li>
		</ul>
		<ul style="display: none;" rel="1">
			<li><i></i><a title="朱尧 分享了 “中小型企业创新基金项目申报工作培训会(0328).zip”" target="_blank" href="http://115.com/u/13232400">中小型企业创新基金项目申报工作培训会(0328).zip</a>
			</li>
			<li><i></i><a title="朱尧 分享了 “nipad-android_2.3.zip”" target="_blank" href="http://115.com/u/13232400">nipad-android_2.3.zip</a>
			</li>
			<li><i></i><a title="朱尧 分享了 “nipad-kindle-fire.zip”" target="_blank" href="http://115.com/u/13232400">nipad-kindle-fire.zip</a>
			</li>
			<li><i></i><a title="朱尧 分享了 “NiPad_亚马逊kindlefire中文ROM(1拖3）.zip”" target="_blank"
				href="http://115.com/u/13232400">NiPad_亚马逊kindlefire中文ROM(1拖3）.zip</a>
			</li>
			<li><i></i><a title="朱尧 分享了 “nipad-android_4.0.3.zip”" target="_blank" href="http://115.com/u/13232400">nipad-android_4.0.3.zip</a>
			</li>
		</ul>
	</div>
	<div class="client-list">
		<h3>
			<span>115客户端</span>
		</h3>
		<ul>
			<li><a title="115云备份" target="_blank" class="cl-cloud" href="http://pc.115.com/">115云备份</a>
			</li>
			<li><a title="115极速浏览器" target="_blank" class="cl-browser" href="http://chrome.115.com">115极速浏览器</a>
			</li>
			<li><a title="IPhone客户端" target="_blank" class="cl-apple" href="http://pc.115.com/iphone.html">IPhone客户端</a>
			</li>
			<li><a title="Android客户端" target="_blank" class="cl-android" href="http://pc.115.com/android.html">Android客户端</a>
			</li>
			<li><a title="Windows Phone客户端" target="_blank" class="cl-windows" href="http://pc.115.com/wphone.html">Windows
					户端</a>
			</li>
		</ul>
	</div>
</div>