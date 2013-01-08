package com.facetime.cloud.data.bean.file;

import com.facetime.cloud.data.bean.base.BaseFile;
import com.facetime.cloud.data.support.FileStatus;
import com.facetime.cloud.data.support.FileType;
import com.facetime.core.bean.BusinessBean;
import com.facetime.core.http.PojoMapper;
import com.facetime.core.utils.CollectionUtils;
import com.facetime.core.utils.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileBean implements BusinessBean, BaseFile {

	private static final long serialVersionUID = 3333204743859139314L;

	private long id;
	private String name;
	/**
	 * 文件随即名, 唯一标识. 路径的一部分
	 */
	private String guidname;
	private FileStatus status = FileStatus.NORMAL;
	private String thumb;
	private String remark;
	private long size;
	private boolean shared;
	private FileType type;
	private int version;

	private Date createDate;
	private Date modifyDate;
	// 排序使用
	private int level;
	private int userId;
	private long shareLinkId;
	private int fileCount;
	private int folderCount;
	private long parentId;
	private long rightKey;
	private long leftKey;

	private List<FileBean> children = CollectionUtils.newList(0);
	private transient String json;

	public String getJson() {
		if (json != null) {
			return json;
		}

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("id", id);
		jsonMap.put("type", type);
		jsonMap.put("shared", shared);
		jsonMap.put("fileCount", fileCount);
		jsonMap.put("folderCount", folderCount);
		jsonMap.put("size", size);
		jsonMap.put("createDate", DateUtil.getDateStr(createDate));
		jsonMap.put("modifyDate", DateUtil.getDateStr(modifyDate));
		this.setJson(PojoMapper.toJson(jsonMap));
		return json;
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

	public void setJson(String json) {
		this.json = json;
	}

	@Override
	public boolean isShared() {
		return shared;
	}

	@Override
	public void setShared(boolean shared) {
		this.shared = shared;
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

	public List<FileBean> getChildren() {
		return children;
	}

	public void setChildren(List<FileBean> children) {
		if (children != null) {
			this.children = children;
			for (FileBean folder : children) {
				folder.setUserId(userId);
			}
		}
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
	public int getLevel() {
		return level;
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getShareLinkId() {
		return shareLinkId;
	}

	public void setShareLinkId(long shareLinkId) {
		this.shareLinkId = shareLinkId;
	}

	@Override
	public void setRightKey(long rightKey) {
		this.rightKey = rightKey;
	}

	@Override
	public long getRightKey() {
		return this.rightKey;
	}

	@Override
	public void setLeftKey(long leftKey) {
		this.leftKey = leftKey;
	}

	@Override
	public long getLeftKey() {
		return this.leftKey;
	}

}
