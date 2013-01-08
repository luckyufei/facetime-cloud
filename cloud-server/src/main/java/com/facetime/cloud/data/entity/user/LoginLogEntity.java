package com.facetime.cloud.data.entity.user;

import com.facetime.cloud.data.support.EntityConstants;
import com.facetime.core.bean.BusinessObject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 登陆系统日志
 *
 */
@Entity
public class LoginLogEntity implements BusinessObject {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = EntityConstants.SEQ_USER)
	@SequenceGenerator(name = EntityConstants.SEQ_USER, sequenceName = EntityConstants.SEQ_USER)
	private long id;
	@Column(nullable = false)
	private String loginIp;
	@Temporal(TemporalType.TIMESTAMP)
	private Date loginDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date logoutDate;
	@Column(length = 100)
	private String note;
	@ManyToOne(optional = false)
	@JoinColumn
	private UserEntity user;
	/**
	 * 用户停留在系统的时间
	 */
	private long remainSecs;

	public long getRemainSecs() {
		return remainSecs;
	}

	public void setRemainSecs(long remainSecs) {
		this.remainSecs = remainSecs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Date getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
