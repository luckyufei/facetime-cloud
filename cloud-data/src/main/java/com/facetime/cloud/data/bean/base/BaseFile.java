package com.facetime.cloud.data.bean.base;

import com.facetime.cloud.data.support.FileStatus;
import com.facetime.cloud.data.support.FileType;

import java.util.Date;

public interface BaseFile {

	public abstract void setLevel(int level);

	public abstract int getLevel();

	public abstract void setVersion(int version);

	public abstract int getVersion();

	public abstract void setRemark(String remark);

	public abstract String getRemark();

	public abstract void setThumb(String thumb);

	public abstract String getThumb();

	public abstract void setModifyDate(Date modifyDate);

	public abstract Date getModifyDate();

	public abstract void setCreateDate(Date createDate);

	public abstract Date getCreateDate();

	public abstract void setShared(boolean shared);

	public abstract boolean isShared();

	public abstract void setSize(long size);

	public abstract long getSize();

	public abstract void setStatus(FileStatus status);

	public abstract FileStatus getStatus();

	public abstract void setName(String name);

	public abstract String getName();

	public abstract void setId(long id);

	public abstract long getId();

	public abstract void setFolderCount(int folderCount);

	public abstract int getFolderCount();

	public abstract void setFileCount(int fileCount);

	public abstract int getFileCount();

	public abstract void setType(FileType type);

	public abstract FileType getType();

	public abstract void setGuidname(String guidname);

	public abstract String getGuidname();

	public abstract void setRightKey(long rightKey);

	public abstract long getRightKey();

	public abstract void setLeftKey(long leftKey);

	public abstract long getLeftKey();

}
