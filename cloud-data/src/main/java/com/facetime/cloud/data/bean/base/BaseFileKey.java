package com.facetime.cloud.data.bean.base;

public interface BaseFileKey {

	public abstract void setRightKey(long right);

	public abstract long getRightKey();

	public abstract void setLeftKey(long leftKey);

	public abstract long getLeftKey();

	public abstract void setFileId(long fileId);

	public abstract long getFileId();

}
