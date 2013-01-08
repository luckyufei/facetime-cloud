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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 团队文件夹实体
 *
 * @author YUFEI
 * @Created 2012-11-15
 * @IDE  Eclipse
 */
@Entity
public class TeamFolderEntity implements BusinessObject, Comparable<TeamFolderEntity> {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = EntityConstants.SEQ_FILE)
	@SequenceGenerator(name = EntityConstants.SEQ_FILE, sequenceName = EntityConstants.SEQ_FILE)
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	@OneToOne(optional = false)
	@JoinColumn
	private FileEntity folder;

	@ManyToOne(optional = false)
	@JoinColumn
	private TeamEntity team;

	private int level;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public FileEntity getFolder() {
		return folder;
	}

	public void setFolder(FileEntity folder) {
		this.folder = folder;
	}

	public TeamEntity getTeam() {
		return team;
	}

	public void setTeam(TeamEntity team) {
		this.team = team;
	}

	/**
	 * 倒序排列
	 */
	@Override
	public int compareTo(TeamFolderEntity o) {
		return this.level - o.getLevel();
	}
}
