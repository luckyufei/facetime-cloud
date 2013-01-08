package com.facetime.cloud.data.bean.base;

import com.facetime.cloud.data.support.Gender;
import com.facetime.cloud.data.support.UserStatus;

import java.util.Date;

public interface BaseUser {

	public abstract void setUsername(String username);

	public abstract void setUserId(Integer userId);

	public abstract void setTelphone(String telphone);

	public abstract void setRealname(String realname);

	public abstract void setModifyDate(Date modifyDate);

	public abstract void setMobile(String mobile);

	public abstract void setGender(Gender gender);

	public abstract void setEmail(String email);

	public abstract void setCreateDate(Date createDate);

	public abstract String getUsername();

	public abstract Integer getUserId();

	public abstract String getTelphone();

	public abstract String getRealname();

	public abstract Date getModifyDate();

	public abstract String getMobile();

	public abstract Gender getGender();

	public abstract String getEmail();

	public abstract Date getCreateDate();

	public abstract void setPassword(String password);

	public abstract String getPassword();

	public abstract void setCloudDiskIp(String cloudDiskIp);

	public abstract String getCloudDiskIp();

	public abstract void setStatus(UserStatus status);

	public abstract UserStatus getStatus();

}
