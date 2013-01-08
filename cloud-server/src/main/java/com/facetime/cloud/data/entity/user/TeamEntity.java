package com.facetime.cloud.data.entity.user;

import com.facetime.cloud.data.bean.user.TeamBean;
import com.facetime.cloud.data.entity.file.TeamFolderEntity;
import com.facetime.cloud.data.support.EntityConstants;
import com.facetime.core.bean.BusinessObject;
import com.facetime.core.utils.CollectionUtils;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.beans.BeanUtils;

/**
 * 用户团队实体
 *
 */
@Entity
public class TeamEntity implements BusinessObject {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = EntityConstants.SEQ_USER)
	@SequenceGenerator(name = EntityConstants.SEQ_USER, sequenceName = EntityConstants.SEQ_USER)
	private Integer id;
	private String name;
	private Integer maxUserNum;
	private String logo;
	/** 用户注册的cloud-app所在服务器的IP */
	private String cloudDiskIp;

	@OneToOne(optional = false)
	@JoinColumn
	private UserEntity admin;

	@OneToMany
	private List<TeamUserEntity> teamUsers = CollectionUtils.newList(0);

	@OneToMany(mappedBy = "team")
	private List<TeamRoleEntity> teamRoles = CollectionUtils.newList(0);

	@OneToMany(mappedBy = "team")
	private List<TeamFolderEntity> teamFolders = CollectionUtils.newList(0);

	public TeamEntity() {
		super();
	}

	public TeamEntity(int teamId) {
		this.id = teamId;
	}

	public TeamEntity(TeamBean bean) {
		BeanUtils.copyProperties(bean, this);
	}

	public TeamBean asBean() {
		TeamBean bean = new TeamBean();
		BeanUtils.copyProperties(this, bean);
		return bean;
	}

	public List<TeamUserEntity> getTeamUsers() {
		return teamUsers;
	}

	public void setTeamUsers(List<TeamUserEntity> teamUsers) {
		this.teamUsers = teamUsers;
	}

	public List<TeamRoleEntity> getTeamRoles() {
		return teamRoles;
	}

	public void setTeamRoles(List<TeamRoleEntity> teamRoles) {
		this.teamRoles = teamRoles;
	}

	public List<TeamFolderEntity> getTeamFolders() {
		return teamFolders;
	}

	public void setTeamFolders(List<TeamFolderEntity> teamFolders) {
		this.teamFolders = teamFolders;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getMaxUserNum() {
		return maxUserNum;
	}

	public void setMaxUserNum(Integer maxUserNum) {
		this.maxUserNum = maxUserNum;
	}

	public String getCloudDiskIp() {
		return cloudDiskIp;
	}

	public void setCloudDiskIp(String cloudDiskIp) {
		this.cloudDiskIp = cloudDiskIp;
	}

	public UserEntity getAdmin() {
		return admin;
	}

	public void setAdmin(UserEntity admin) {
		this.admin = admin;
	}

}
