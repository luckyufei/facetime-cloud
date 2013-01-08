package com.facetime.cloud.data.entity.file;

import com.facetime.cloud.data.bean.base.BaseFileKey;
import com.facetime.cloud.data.bean.file.FileKeyBean;
import com.facetime.cloud.data.entity.support.CloudBusinessObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.BeanUtils;

@Entity
public class FileKeyEntity implements CloudBusinessObject, BaseFileKey {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "foreigner")
	@GenericGenerator(name = "foreigner", strategy = "foreign", parameters = { @Parameter(name = "property", value = "file") })
	private long fileId;
	@Index(name = "idx_file_left_key")
	@Column
	private long leftKey;
	@Index(name = "idx_file_right_key")
	@Column
	private long rightKey;
	@OneToOne
	@PrimaryKeyJoinColumn
	private FileEntity file;

	@Override
	public long getFileId() {
		return fileId;
	}

	@Override
	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public long getLeftKey() {
		return leftKey;
	}

	public void setLeftKey(long leftKey) {
		this.leftKey = leftKey;
	}

	public long getRightKey() {
		return rightKey;
	}

	public void setRightKey(long rightKey) {
		this.rightKey = rightKey;
	}

	public FileEntity getFile() {
		return file;
	}

	public void setFile(FileEntity file) {
		this.file = file;
	}

	@Override
	@SuppressWarnings("unchecked")
	public FileKeyBean asBean() {
		FileKeyBean bean = new FileKeyBean();
		BeanUtils.copyProperties(this, bean);
		return bean;
	}

}
