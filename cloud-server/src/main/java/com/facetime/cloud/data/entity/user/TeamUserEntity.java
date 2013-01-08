package com.facetime.cloud.data.entity.user;

import com.facetime.cloud.data.support.EntityConstants;
import com.facetime.core.bean.BusinessObject;

import java.util.Date;

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
 * 团队成员中间表实体
 */
@Entity
public class TeamUserEntity implements BusinessObject {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = EntityConstants.SEQ_USER)
	@SequenceGenerator(name = EntityConstants.SEQ_USER, sequenceName = EntityConstants.SEQ_USER)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	@ManyToOne
	@JoinColumn
	private TeamEntity team;

	@ManyToOne
	@JoinColumn
	private UserEntity user;

	public Date getCreateDate() {
		return createDate;
	}

	public int getId() {
		return id;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public TeamEntity getTeam() {
		return team;
	}

	public void setTeam(TeamEntity team) {
		this.team = team;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
