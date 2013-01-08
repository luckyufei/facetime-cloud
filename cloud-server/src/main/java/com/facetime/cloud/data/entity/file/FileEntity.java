package com.facetime.cloud.data.entity.file;

import com.facetime.cloud.data.bean.base.BaseFile;
import com.facetime.cloud.data.bean.file.FileBean;
import com.facetime.cloud.data.entity.support.CloudBusinessObject;
import com.facetime.cloud.data.entity.user.UserEntity;
import com.facetime.cloud.data.support.EntityConstants;
import com.facetime.cloud.data.support.FileStatus;
import com.facetime.cloud.data.support.FileType;

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

import org.springframework.beans.BeanUtils;

/**
 * 个人文件夹实体
 *
 * @author yufei
 * @Created 2012-11-15
 * @IDE  Eclipse
 */
@Entity
public class FileEntity implements CloudBusinessObject, BaseFile, Comparable<FileEntity> {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = EntityConstants.SEQ_FILE)
	@SequenceGenerator(name = EntityConstants.SEQ_FILE, sequenceName = EntityConstants.SEQ_FILE)
	private long id;
	private String name;
	private String guidname;
	private FileStatus status = FileStatus.NORMAL;
	private String thumb;
	private String remark;
	private int version;
	private int fileCount;
	private int folderCount;
	private long size;
	private boolean shared;
	private FileType type = FileType.FOLDER;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
	// 排序使用
	private int level;
	private long leftKey;
	private long rightKey;

	@ManyToOne
	@JoinColumn
	private UserEntity user;

	@ManyToOne
	@JoinColumn
	private ShareLinkEntity shareLink;

	@Override
	public long getLeftKey() {
		return leftKey;
	}

	@Override
	public void setLeftKey(long leftKey) {
		this.leftKey = leftKey;
	}

	@Override
	public long getRightKey() {
		return rightKey;
	}

	@Override
	public void setRightKey(long rightKey) {
		this.rightKey = rightKey;
	}

	@Override
	public String getGuidname() {
		return guidname;
	}

	@Override
	public void setGuidname(String guidname) {
		this.guidname = guidname;
	}

	@Override
	public FileType getType() {
		return type;
	}

	@Override
	public void setType(FileType type) {
		this.type = type;
	}

	@Override
	public int getFileCount() {
		return fileCount;
	}

	@Override
	public void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}

	@Override
	public int getFolderCount() {
		return folderCount;
	}

	@Override
	public void setFolderCount(int folderCount) {
		this.folderCount = folderCount;
	}

	public FileEntity() {
		super();
	}

	public FileEntity(long fileId) {
		this.id = fileId;
	}

	public FileEntity(FileBean fileBean) {
		BeanUtils.copyProperties(fileBean, this);
		if (fileBean.getUserId() > 0)
			this.setUser(new UserEntity(fileBean.getUserId()));
		if (fileBean.getShareLinkId() > 0)
			this.setShareLink(new ShareLinkEntity(fileBean.getShareLinkId()));
	}

	@SuppressWarnings("unchecked")
	public FileBean asBean() {
		FileBean bean = new FileBean();
		BeanUtils.copyProperties(this, bean);
		if (user != null)
			bean.setUserId(user.getUserId());
		return bean;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public FileStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(FileStatus status) {
		this.status = status;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public void setSize(long size) {
		this.size = size;
	}

	@Override
	public boolean isShared() {
		return shared;
	}

	@Override
	public void setShared(boolean shared) {
		this.shared = shared;
	}

	public ShareLinkEntity getShareLink() {
		return shareLink;
	}

	public void setShareLink(ShareLinkEntity shareLink) {
		this.shareLink = shareLink;
	}

	@Override
	public Date getCreateDate() {
		return createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public Date getModifyDate() {
		return modifyDate;
	}

	@Override
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String getThumb() {
		return thumb;
	}

	@Override
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	@Override
	public String getRemark() {
		return remark;
	}

	@Override
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public int getVersion() {
		return version;
	}

	@Override
	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	/**
	 * 倒序排列
	 */
	@Override
	public int compareTo(FileEntity o) {
		return this.level - o.getLevel();
	}

}
