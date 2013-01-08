package com.facetime.cloud.data.bean.user;

import com.facetime.cloud.data.bean.base.BaseUser;
import com.facetime.cloud.data.support.Gender;
import com.facetime.cloud.data.support.UserStatus;
import com.facetime.core.bean.BusinessBean;

import java.util.Date;

/**
 * 
 * 用户相关Bean
 * 
 * @author yufei
 * @Create_by 2012-11-14
 * @Design_by eclipse  
 */
public class UserBean implements BusinessBean, BaseUser {

	private static final long serialVersionUID = 1L;

	private String nonce;
	private String hashKey;
	private String clientId;
	private String verifyCode;
	private String userToken;
	/**
	 * 用户进入系统当前的IP
	 */
	private String currentIp;

	private Integer userId;
	private String username;
	private String email;
	private String realname;
	private String password;

	private Date createDate;
	private Date modifyDate;

	private String mobile;
	private String telphone;
	private String cloudDiskIp;
	private Gender gender;
	private UserStatus status;

	@Override
	public UserStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getClientId() {
		return clientId;
	}

	@Override
	public String getCloudDiskIp() {
		return cloudDiskIp;
	}

	@Override
	public Date getCreateDate() {
		return createDate;
	}

	public String getCurrentIp() {
		return currentIp;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public Gender getGender() {
		return gender;
	}

	public String getHashKey() {
		return hashKey;
	}

	@Override
	public String getMobile() {
		return mobile;
	}

	@Override
	public Date getModifyDate() {
		return modifyDate;
	}

	public String getNonce() {
		return nonce;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getRealname() {
		return realname;
	}

	@Override
	public String getTelphone() {
		return telphone;
	}

	@Override
	public Integer getUserId() {
		return userId;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public String getUserToken() {
		return userToken;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public void setCloudDiskIp(String cloudDiskIp) {
		this.cloudDiskIp = cloudDiskIp;
	}

	@Override
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setCurrentIp(String currentIp) {
		this.currentIp = currentIp;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}

	@Override
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Override
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	@Override
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
}
