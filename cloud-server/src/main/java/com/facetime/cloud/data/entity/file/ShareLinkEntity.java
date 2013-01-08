package com.facetime.cloud.data.entity.file;

import com.facetime.cloud.data.bean.file.ShareLinkBean;
import com.facetime.cloud.data.entity.support.CloudBusinessObject;
import com.facetime.cloud.data.entity.user.UserEntity;
import com.facetime.cloud.data.support.EntityConstants;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.BeanUtils;

/**
 * 共享链接实体
 */
@Entity
public class ShareLinkEntity implements CloudBusinessObject {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = EntityConstants.SEQ_FILE)
	@SequenceGenerator(name = EntityConstants.SEQ_FILE, sequenceName = EntityConstants.SEQ_FILE)
	private long id;
	@Column(unique = true, nullable = false, length = 100)
	private String code;
	private int limitSize;
	private int downloadCount;
	private String password;
	@Temporal(TemporalType.TIMESTAMP)
	private Date expirationTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyTime;

	@OneToMany(mappedBy = "shareLink")
	private List<FileEntity> folderList;

	@ManyToOne(optional = true, cascade = { CascadeType.REMOVE })
	@JoinColumn
	private UserEntity user;

	public ShareLinkEntity() {
		super();
	}

	public ShareLinkEntity(long shareLinkId) {
		this.id = shareLinkId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getLimitSize() {
		return limitSize;
	}

	public void setLimitSize(int limitSize) {
		this.limitSize = limitSize;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public List<FileEntity> getFolderList() {
		return folderList;
	}

	public void setFolderList(List<FileEntity> folderList) {
		this.folderList = folderList;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ShareLinkBean asBean() {
		ShareLinkBean bean = new ShareLinkBean();
		BeanUtils.copyProperties(this, bean);
		return bean;
	}

}
