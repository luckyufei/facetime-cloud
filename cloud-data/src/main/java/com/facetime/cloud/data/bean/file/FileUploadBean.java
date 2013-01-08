package com.facetime.cloud.data.bean.file;

import com.facetime.core.bean.BusinessBean;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 
 * 文件上传BEAN
 * @author YUFEI
 * @Created 2012-11-25
 * @IDE  Eclipse
 */
public class FileUploadBean implements BusinessBean {

	private static final long serialVersionUID = -4749875938883038783L;

	private CommonsMultipartFile file;
	private long currentFolderId;

	public long getCurrentFolderId() {
		return currentFolderId;
	}

	public void setCurrentFolderId(long currentFolderId) {
		this.currentFolderId = currentFolderId;
	}

	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}

}
