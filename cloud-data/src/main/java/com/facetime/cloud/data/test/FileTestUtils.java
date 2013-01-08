package com.facetime.cloud.data.test;

import com.facetime.cloud.data.bean.file.FileBean;
import com.facetime.cloud.data.support.CloudFileUtils;

import java.util.Date;

public class FileTestUtils {

	public static FileBean createTxtFile(int userId, long parentFolderId) {
		FileBean fileBean = new FileBean();
		fileBean.setCreateDate(new Date());
		fileBean.setName("test.txt");
		fileBean.setSize(1024L);
		fileBean.setType(CloudFileUtils.getFileType(fileBean.getName()));
		fileBean.setGuidname(CloudFileUtils.getFileUUIDName(fileBean.getType()));
		fileBean.setCreateDate(new Date());
		fileBean.setModifyDate(fileBean.getCreateDate());
		fileBean.setParentId(parentFolderId);
		fileBean.setUserId(userId);
		return fileBean;
	}

}
