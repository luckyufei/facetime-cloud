/**
 * 
 */
package com.facetime.cloud.data.support;

import com.facetime.core.http.ErrorType;

/**
 * 
 *
 * @author yufei
 * @Create_by 2012-11-14
 * @Design_by eclipse  
 */
public interface CloudErrorType extends ErrorType {
	/** 请求参数是空的 */
	String ERR_REQ_PARAM_IS_EMPTY = "REQ_PARAM_IS_EMPTY";
	/** haskKey 不一致 */
	String ERR_HASH_KEY_NOT_EQ = "ERR_HASH_KEY";
	/** 用户名或者邮箱重复*/
	String ERR_USERNAME_OR_EMAIL_EXIST = "ERR_USERNAME_OR_EMAIL_EXIST";
	String ERR_USERNAME_EXIST = "ERR_USERNAME_EXIST";
	String ERR_EMAIL_EXIST = "ERR_EMAIL_EXIST";
	/**
	 * 用户不存在
	 */
	String ERR_USER_NOT_EXIST = "ERR_USER_NOT_EXIST";
	/**
	 * 密码不匹配
	 */
	String ERR_PWD_NOT_MATCH = "ERR_PWD_NOT_MATCH";
	String ERR_USERNAME_IS_EMPTY = "ERR_USERNAME_IS_EMPTY";
	/**
	 * 保存文件到硬盘失败
	 */
	String ERR_SAVE_FILE_TO_DISK = "ERR_SAVE_FILE_TO_DISK";
	/**
	 * 后台服务故障
	 */
	String ERR_SERVER_500 = "ERR_SERVER_500";
	/**  文件已经存在*/
	String ERR_FILE_EXIST = "ERR_FILE_EXIST";
}
