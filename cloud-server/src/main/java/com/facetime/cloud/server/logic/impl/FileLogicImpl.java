package com.facetime.cloud.server.logic.impl;

import com.facetime.cloud.data.bean.file.FileBean;
import com.facetime.cloud.data.entity.file.FileEntity;
import com.facetime.cloud.data.entity.file.FileKeyEntity;
import com.facetime.cloud.data.entity.user.UserEntity;
import com.facetime.cloud.data.support.CloudFileUtils;
import com.facetime.cloud.data.support.FileStatus;
import com.facetime.cloud.data.support.FileType;
import com.facetime.cloud.server.logic.FileLogic;
import com.facetime.cloud.server.support.LogicUtils;
import com.facetime.core.file.FileConstants;
import com.facetime.spring.logic.LogicImpl;
import com.facetime.spring.support.PMLO;
import com.facetime.spring.support.QueryFilter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class FileLogicImpl extends LogicImpl implements FileLogic {

	@Override
	public FileBean getExistFile(FileBean fileBean) {
		FileEntity foundFile = this.findUnique(
				FileEntity.class,
				new QueryFilter[] { new QueryFilter("name", fileBean.getName()),
						new QueryFilter("size", fileBean.getSize()),
						new QueryFilter("modifyDate", fileBean.getModifyDate()) });
		if (foundFile != null) {
			FileBean file = foundFile.asBean();
			file.setUserId(foundFile.getUser().getUserId());
			return file;
		}
		return null;
	}

	@Override
	public FileBean getFolderById(long folderId) {
		FileEntity entity = this.findById(FileEntity.class, folderId);

		return entity.asBean();
	}

	@Override
	public FileBean getRootFolder(int userId) {
		FileEntity root = this.findUnique(FileEntity.class, new QueryFilter("user.userId", userId), new QueryFilter(
				"parent", PMLO.ISNULL));
		List<FileEntity> children = this.findList(FileEntity.class, new QueryFilter("parent.id", root.getId()));
		FileBean rootFolder = root.asBean();
		rootFolder.setUserId(userId);
		rootFolder.setChildren(LogicUtils.convert(children, FileBean.class));
		return rootFolder;
	}

	@Override
	public void createDefaultFolders(UserEntity user) {
		FileEntity rootFolder = createRootFolder(user);

		List<FileEntity> folders = new ArrayList<FileEntity>(FileConstants.DEFAULT_FOLDER_NAMES.length);
		for (String folderName : FileConstants.DEFAULT_FOLDER_NAMES) {
			folders.add(createChildFolder(user, rootFolder, folderName));
		}
		this.save(folders);
		rootFolder.setFolderCount(folders.size());
		this.update(rootFolder);
	}

	private FileEntity createChildFolder(UserEntity user, FileEntity rootFolder, String folderName) {
		FileEntity folder = new FileEntity();
		folder.setCreateDate(new Date());
		folder.setName(folderName);
		folder.setType(FileType.FOLDER);
		folder.setGuidname(CloudFileUtils.getFileUUIDName(folder.getType()));
		folder.setModifyDate(new Date());
		folder.setVersion(1);
		folder.setUser(user);
		folder.setLeftKey(rootFolder.getRightKey());
		folder.setRightKey(rootFolder.getRightKey() + 1);

		rootFolder.setRightKey(rootFolder.getRightKey() + 2);
		return folder;
	}

	private FileEntity createRootFolder(UserEntity user) {
		FileEntity rootFolder = new FileEntity();
		rootFolder.setName("root");
		rootFolder.setType(FileType.FOLDER);
		rootFolder.setGuidname(CloudFileUtils.getFileUUIDName(rootFolder.getType()));
		rootFolder.setCreateDate(new Date());
		rootFolder.setStatus(FileStatus.NORMAL);
		rootFolder.setModifyDate(new Date());
		rootFolder.setRemark("this is the root folder");
		rootFolder.setUser(user);
		rootFolder.setLeftKey(0);
		rootFolder.setRightKey(1);
		this.save(rootFolder);
		return rootFolder;
	}

	public void deleteFiles(long parentId, long[] fileIds) {
		FileEntity folder = this.findById(FileEntity.class, parentId);
		long leftKey = folder.getLeftKey(), rightKey = folder.getRightKey(), deleteTotal = rightKey - leftKey + 1;
		this.delete("delete from FileEntity where leftKey > ? and rightKey < ? ", leftKey, rightKey);

		// update file set Lft = Lft – (@rgt - @lft + 1) where Lft > @lft  
		this.update("update FileEntity set leftKey = leftKey - ? where leftKey > ? ", deleteTotal, leftKey);
		//  update Tree set Rgt = Rgt – (@rgt - @lft + 1) where Rgt > @rgt 
		this.update("update FileEntity set rightKey = rightKey - ? where rightKey > ? ", deleteTotal, rightKey);
	}

	public List<FileEntity> getAncestor(long fileId) {
		FileEntity file = this.findById(FileEntity.class, fileId);
		return this.findList(FileEntity.class,
				new QueryFilter[] { new QueryFilter("leftKey", PMLO.LT, file.getLeftKey()),
						new QueryFilter("rightKey", PMLO.GT, file.getRightKey()),
						new QueryFilter("type", FileType.FOLDER) });
	}

	/**
	 * 返回当前文件夹的最后一个孩子文件/文件夹
	 * @param fileId
	 * @return
	 */
	public FileEntity getLastChild(long fileId) {
		FileEntity file = this.findById(FileEntity.class, fileId);
		return this.findUnique(FileEntity.class,
				new QueryFilter[] { new QueryFilter("leftKey", PMLO.GT, file.getLeftKey()),
						new QueryFilter("rightKey", PMLO.EQ, file.getRightKey() - 1) });
	}

	/**
	 * 删除当前文件夹下的全部子文件夹和子文件, 保留文件夹本身
	 * @param folderId
	 */
	public void deleteFolderChildren(long folderId) {
		FileEntity folder = this.findById(FileEntity.class, folderId);
		long leftKey = folder.getLeftKey(), rightKey = folder.getRightKey(), deleteTotal = rightKey - leftKey + 1;
		this.delete("delete from FileEntity where leftKey > ? and rightKey < ? ", leftKey, rightKey);

		// update file set Lft = Lft – (@rgt - @lft + 1) where Lft > @lft  
		this.update("update FileEntity set leftKey = leftKey - ? where leftKey > ? ", deleteTotal, leftKey);
		//  update Tree set Rgt = Rgt – (@rgt - @lft + 1) where Rgt > @rgt 
		this.update("update FileEntity set rightKey = rightKey - ? where rightKey > ? ", deleteTotal, rightKey);
	}

	public void removeFolderToDustin(long folderId) {
		FileEntity folder = this.findById(FileEntity.class, folderId);

	}

	public FileEntity getDustin(int userId) {
		return this.findUnique(FileEntity.class, new QueryFilter[] { QueryFilter.valueOf("user.userId", userId),
				QueryFilter.valueOf("type", FileType.DUSTBIN) });
	}

	/**
	 * 删除当前文件夹下的全部文件和文件夹, 也删除自身
	 * @param folderId
	 */
	public void deleteFolder(long folderId) {
		FileEntity folder = this.findById(FileEntity.class, folderId);
		long leftKey = folder.getLeftKey(), rightKey = folder.getRightKey(), deleteTotal = rightKey - leftKey + 1;
		this.delete("delete from FileEntity where leftKey >= ? and rightKey <= ? ", leftKey, rightKey);

		// update file set Lft = Lft – (@rgt - @lft + 1) where Lft > @lft  
		this.update("update FileEntity set leftKey = leftKey - ? where leftKey > ? ", deleteTotal, leftKey);
		//  update Tree set Rgt = Rgt – (@rgt - @lft + 1) where Rgt > @rgt 
		this.update("update FileEntity set rightKey = rightKey - ? where rightKey > ? ", deleteTotal, rightKey);
	}

	@Override
	public FileBean saveFile(FileBean fileBean) {
		FileEntity entity = new FileEntity(fileBean);
		FileEntity parent = getParent(fileBean.getLeftKey());
		long rightKey = parent.getRightKey();

		this.update("update FileKeyEntity set leftKey = leftKey+2 where leftKey >= ?", rightKey);
		this.update("update FileKeyEntity set rightKey = rightKey + 2 where rightKey >= ?", rightKey);

		entity.setLeftKey(rightKey);
		entity.setRightKey(rightKey + 1);
		this.save(entity);
		return entity.asBean();
	}

	private FileEntity getParent(long leftKey) {
		return this.findById(FileEntity.class,
				this.findUnique(FileKeyEntity.class, QueryFilter.valueOf("leftKey", leftKey - 1)).getFileId());
	}

}
