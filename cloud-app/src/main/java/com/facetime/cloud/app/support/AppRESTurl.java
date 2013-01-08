/**
 * 
 */
package com.facetime.cloud.app.support;

/**
 * Cloud App 项目中的Uri配置
 *
 * @author yufei
 * @Create_by 2012-11-14
 * @Design_by eclipse  
 */
public interface AppRESTurl {

	/***
	 * ============================================================
	 * 				user module restful  
	 * ============================================================
	 */

	String loginView = "/user/login";
	String registerView = "/user/register";
	String userRegister = "/pub/register";
	String userLogin = "/pub/login";
	String userLogout = "/user/logout";
	/**
	 * 创建验证码
	 * @param key 存在Session中的验证码的Key 
	 */
	String createVerifyCode = "/verify/create";
	/**
	 * 检验验证码
	 * @param key 存在Session中的验证码的Key 
	 * @param code  用户输入的验证码
	 */
	String verifyCode = "/verify/code";

	String service = "/sc/service";
	String chartView = "/chart/list";

	/***
	 * ============================================================
	 * 				file module restful  
	 * ============================================================
	 */

	/**
	 * 显示根文件夹视图
	 */
	String listRootFolder = "/file/list";
	/**
	 * 文件上传测试
	 */
	String FileUploadTest = "/file/upload/test";
	/**
	 * 文件上传URI
	 * @param FileUploadBean
	 */
	String fileUpload = "/file/upload";

	/**
	 *  显示文件夹列表
	 *  @param folderId
	 */
	String listFolder = "/file/list/{folderId}";
}
