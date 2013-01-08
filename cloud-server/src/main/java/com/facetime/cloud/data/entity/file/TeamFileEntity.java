package com.facetime.cloud.data.entity.file;

import com.facetime.cloud.data.entity.user.TeamEntity;
import com.facetime.cloud.data.support.EntityConstants;
import com.facetime.core.bean.BusinessObject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 团队文件实体
 */
@Entity
public class TeamFileEntity implements BusinessObject {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = EntityConstants.SEQ_FILE)
	@SequenceGenerator(name = EntityConstants.SEQ_FILE, sequenceName = EntityConstants.SEQ_FILE)
	private long id;

	@OneToOne(optional = false)
	@JoinColumn
	private FileEntity file;

	@OneToOne(optional = false)
	@JoinColumn
	private TeamEntity team;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public FileEntity getFile() {
		return file;
	}

	public void setFile(FileEntity file) {
		this.file = file;
	}

	public TeamEntity getTeam() {
		return team;
	}

	public void setTeam(TeamEntity team) {
		this.team = team;
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
}
