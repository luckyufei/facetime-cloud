package com.facetime.cloud.data.support;

/**
 * 消息类型<br>
 * 字符串长度不超过10
 */
public enum MessageType {

	ChatMessage,
	/**
	 * 新邮件到达消息
	 */
	NewMailNotify,
	/**
	 * 邮件接收完成消息
	 */
	MailNotify, InviteBuddy,
	/**
	 * 加好友，同意
	 */
	Agree,
	/**
	 * 加好友，拒绝
	 */
	Refuse,
	/**
	 * 邀请好友回复， 代表被邀请方接受邀请，邀请方处理
	 */
	Reply,
	/**
	 * 强行下线
	 */
	ForceOffline,
	/**
	 * 即时文件传输
	 */
	InstantFile,
	/**
	 * 私聊时共享文件
	 */
	ShareFileInPrivacy,
	/**
	 * 群聊时共享文件
	 */
	ShareFileInGroup,
	/**
	 * 群聊共享即时文件，文件为客户端上传
	 */
	ShareInstantFile,
	/**
	 * 群聊天记录
	 */
	GroupChat,
	/**
	 * 删除好友时， 通知对方
	 */
	InformDeleteBuddy,
	/**
	 * 邀请好友加入聊天组
	 */
	InviteBuddyToChatGroup,
	/**
	 * 好友回复是否加入聊天组
	 */
	ReplyForInvitedToChatGroup,
	/**
	 * 某聊天组成员通知组内所有成员获取最新的成员列表
	 */
	InformChatGroupToGetMemberList,
	/**
	 * 某聊天组成员通知组内所有成员获取最新的成员列表
	 */
	InformJoinChatGroup,
	/**
	 * 聊天组成员退出通知
	 */
	InformRemoveChatGroupMember,
	/**
	 * 通知编辑状态
	 */
	InformEditStatus,
	/**
	 * 视频邀请
	 */
	VideoInvite,
	/**
	 * 视频开始
	 */
	VideoStart,
	/**
	 * 拒绝视频
	 */
	VideoRefuse,
	/**
	 * 视频结束
	 */
	VideoEnd,
	/**
	 * 音频邀请
	 */
	AudioInvite,
	/**
	 * 音频开始
	 */
	AudioStart,
	/**
	 * 拒绝音频
	 */
	AudioRefuse,
	/**
	 * 音频结束
	 */
	AudioEnd,

	/**
	 * 用户登入
	 */
	UserJoin,
	/**
	 * 用户改变状态，其新状态值由
	 * {@link com.conlect.oatos.dto.autobean.IMessgeDTO#getMessageBody()}获取
	 */
	UserStatusChange,
	/**
	 * 用户离开
	 */
	UserLeave,
	/**
	 * 用户信息更新
	 */
	UserInfoUpdate,

	/**
	 * after user agreed import contacts from YAHOO! or GOOGLE, it returns a
	 * verifier.
	 */
	BuddyImportFromWeb,

	/**
	 * offline file
	 */
	OfflineFile,

	/**
	 * voice mail
	 */
	VoiceMail,
	/**
	 * 客户请求服务，客服处理
	 */
	CustomerRequest,
	/**
	 * 客服响应，客户处理
	 */
	ServiceResponse,
	/**
	 * 客户退出，客服处理
	 */
	CustomerLeave,
	/**
	 * 客服退出，客户处理
	 */
	ServiceLeave,
	/**
	 * 企业用户登录记录
	 */
	Login,
	/**
	 * 文件进入记录
	 */
	FileIn,
	/**
	 * 文件输出记录
	 */
	FileOut,
	/**
	 * 客户连接通知，客户发出，客服处理
	 */
	CustomerConnect,
	/**
	 * 客服连接响应，客服发出，客户处理
	 */
	ServiceConnectRes,
	/**
	 * 客服移除客户通知，客服发出，客户处理
	 */
	RemoveCustomer,
	/**
	 * 共享网盘文件更新
	 */
	ShareFileNew,
	/**
	 * 同事更新
	 */
	ColleagueNew,
	/**
	 * 通知阻止状态更新，message body true 标识 block，false 标识 unblock
	 */
	InformBlock,
	/**
	 * 系统消息
	 */
	SystemMsg;
}
