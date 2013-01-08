package com.facetime.cloud.data.entity.user;

import com.facetime.cloud.data.bean.user.UserBean;
import com.facetime.cloud.data.support.EntityConstants;
import com.facetime.cloud.data.support.Gender;
import com.facetime.cloud.data.support.UserStatus;
import com.facetime.core.bean.BusinessObject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.BeanUtils;

/**
 * 
 * 用户实体
 * 
 * @author yufei
 * @Create_by 2012-11-13
 * @Design_by eclipse
 */
@Entity
public class UserEntity implements BusinessObject {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = EntityConstants.SEQ_USER)
	@SequenceGenerator(name = EntityConstants.SEQ_USER, sequenceName = EntityConstants.SEQ_USER)
	private Integer userId;
	@Column(unique = true, nullable = false, length = 40)
	private String username;
	@Column(unique = true, nullable = false, length = 50)
	private String email;
	private String realname;
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	private String mobile;
	private String telphone;
	private String cloudDiskIp;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Enumerated(EnumType.STRING)
	private UserStatus status = UserStatus.NORMAL;

	public UserEntity() {
		super();
	}

	public UserEntity(int userId) {
		this.userId = userId;
	}

	public UserEntity(UserBean bean) {
		BeanUtils.copyProperties(bean, this);
	}

	public UserBean asBean() {
		UserBean bean = new UserBean();
		BeanUtils.copyProperties(this, bean);
		return bean;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getCloudDiskIp() {
		return cloudDiskIp;
	}

	public void setCloudDiskIp(String cloudDiskIp) {
		this.cloudDiskIp = cloudDiskIp;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getEmail() {
		return email;
	}

	public Gender getGender() {
		return gender;
	}

	public String getMobile() {
		return mobile;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public String getRealname() {
		return realname;
	}

	public String getTelphone() {
		return telphone;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
