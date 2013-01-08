package com.facetime.cloud.data.entity.file;

import com.facetime.cloud.data.bean.file.FileOperationLogBean;
import com.facetime.cloud.data.entity.support.CloudBusinessObject;
import com.facetime.cloud.data.support.EntityConstants;
import com.facetime.cloud.data.support.FileOperation;

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
 * 文件和文件夹操作记录实体
 */
@Entity
public class FileOperationLogEntity implements CloudBusinessObject {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = EntityConstants.SEQ_FILE)
	@SequenceGenerator(name = EntityConstants.SEQ_FILE, sequenceName = EntityConstants.SEQ_FILE)
	private long id;
	private FileOperation operation = FileOperation.ADD;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
	private String comment;
	@ManyToOne
	@JoinColumn
	private FileEntity folder;

	@SuppressWarnings("unchecked")
	@Override
	public FileOperationLogBean asBean() {
		FileOperationLogBean operateLog = new FileOperationLogBean();
		BeanUtils.copyProperties(this, operateLog);
		return operateLog;
	}

	public String getComment() {
		return comment;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public FileEntity getFolder() {
		return folder;
	}

	public long getId() {
		return id;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public FileOperation getOperation() {
		return operation;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setFolder(FileEntity folder) {
		this.folder = folder;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setOperation(FileOperation operation) {
		this.operation = operation;
	}

}
