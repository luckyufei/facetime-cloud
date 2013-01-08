package com.facetime.cloud.server.logic;

import com.facetime.cloud.data.bean.file.FileBean;
import com.facetime.cloud.data.entity.user.UserEntity;
import com.facetime.spring.logic.Logic;

public interface FileLogic extends Logic {

	/**
	 * 创建用户默认的文件和文件夹
	 */
	void createDefaultFolders(UserEntity user);

	FileBean getRootFolder(int userId);

	/**
	 * @param parseLong
	 * @return
	 */
	FileBean getFolderById(long parseLong);

	/**
	 * 判断文件是否已经存在, 如果存在着返回文件信息, 否则返回null
	 * @param object
	 * @return
	 */
	FileBean getExistFile(FileBean object);

	/**
	 * 保存文件信息记录
	 * @param fileBean
	 * @return  fileId
	 */
	FileBean saveFile(FileBean fileBean);

}
