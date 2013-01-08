package com.facetime.cloud.data.bean.file;

import com.facetime.cloud.data.bean.base.BaseFileKey;
import com.facetime.core.bean.BusinessBean;

public class FileKeyBean implements BusinessBean, BaseFileKey {

	private static final long serialVersionUID = 1L;
	private long fileId;
	private long rightKey;
	private long leftKey;

	public long getRightKey() {
		return rightKey;
	}

	public void setRightKey(long rightKey) {
		this.rightKey = rightKey;
	}

	public long getLeftKey() {
		return leftKey;
	}

	public void setLeftKey(long leftKey) {
		this.leftKey = leftKey;
	}

	@Override
	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	@Override
	public long getFileId() {
		return this.fileId;
	}
}
