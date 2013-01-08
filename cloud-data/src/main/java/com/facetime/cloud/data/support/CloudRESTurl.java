package com.facetime.cloud.data.support;

import com.facetime.cloud.data.bean.file.FileBean;
import com.facetime.core.http.RESTurl;

/**
 * 配置了server后台所有服务的uri
 *
 * @author yufei
 * @Create_by 2012-11-14
 * @Design_by eclipse  
 */
public interface CloudRESTurl extends RESTurl {

	String saveMessages = "/sc/message/savemessages";
	String sendMessage = "/sc/message/sendMessage";
	String sendMessages = "/sc/message/sendMessages";
	String logout = "/pub/logout";
	String getOnlineBuddyAndColleague = "/sc/getOnlineBuddyAndColleague";
	String enterpriseUserLogin = "";
	/**
	 * 用户注册
	 * @param UserBean
	 */
	String userRegister = "/pub/user/register";
	/**
	 * 用户登录
	 * @param UserBean
	 */
	String userLogin = "/pub/user/login";
	String reLogin = null;
	String getUserById = "/sc/user/getUser";
	String getFileById = "/sc/file/getFolderById";
	/**
	 * 判断文件是否存在, 如果存在返回已经存在的文件信息, 否则返回null
	 * @param {@link FileBean}
	 * @return boolean
	 */
	String getExistFile = "/sc/file/getExistFile";
	/**
	 * 保存文件信息到数据库中
	 * @param {@link FileBean}
	 * @return fileId
	 */
	String saveFileRecord = "/sc/file/saveFileRecord";
	/**
	 * 返回当前用户根文件夹
	 * @param userId
	 */
	String getRootFolder = "/sc/file/getRootFolder";
}
