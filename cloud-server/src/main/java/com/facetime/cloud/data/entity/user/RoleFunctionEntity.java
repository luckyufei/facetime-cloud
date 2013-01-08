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
 * 角色功能中间表实体
 */
@Entity
public class RoleFunctionEntity implements BusinessObject {

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
	private RoleEntity role;

	@ManyToOne
	@JoinColumn
	private FunctionEntity function;

	public FunctionEntity getFunction() {
		return function;
	}

	public void setFunction(FunctionEntity function) {
		this.function = function;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

}
