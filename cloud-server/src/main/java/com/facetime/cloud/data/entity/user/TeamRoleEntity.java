package com.facetime.cloud.data.entity.user;

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

import com.facetime.cloud.data.support.EntityConstants;
import com.facetime.core.bean.BusinessObject;

/**
 * 团队角色中间表实体
 */
@Entity
public class TeamRoleEntity implements BusinessObject {

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
	private RoleEntity role;

	public Date getCreateDate() {
		return createDate;
	}

	public int getId() {
		return id;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public RoleEntity getRole() {
		return role;
	}

	public TeamEntity getTeam() {
		return team;
	}

	public void setTeam(TeamEntity team) {
		this.team = team;
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

	public void setRole(RoleEntity role) {
		this.role = role;
	}

}
