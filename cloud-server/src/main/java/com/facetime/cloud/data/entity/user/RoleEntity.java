package com.facetime.cloud.data.entity.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.facetime.cloud.data.support.EntityConstants;
import com.facetime.core.bean.BusinessObject;

/**
 * 用户角色实体
 *
 */
@Entity
public class RoleEntity implements BusinessObject {

	private static final long serialVersionUID = 798747487407403410L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = EntityConstants.SEQ_USER)
	@SequenceGenerator(name = EntityConstants.SEQ_USER, sequenceName = EntityConstants.SEQ_USER)
	private int id;
	@Column(nullable = false, length = 30)
	private String name;

	@OneToMany(mappedBy = "role")
	private List<RoleFunctionEntity> roleFunctions;

	public List<RoleFunctionEntity> getRoleFunctions() {
		return roleFunctions;
	}

	public void setRoleFunctions(List<RoleFunctionEntity> roleFunctions) {
		this.roleFunctions = roleFunctions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
