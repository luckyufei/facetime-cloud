package com.facetime.cloud.app.action;

import static com.facetime.core.conf.SysLogger.cloudAppLogger;

import com.facetime.cloud.app.support.AppRESTurl;
import com.facetime.cloud.app.utils.AppFileUtils;
import com.facetime.cloud.data.bean.file.FileBean;
import com.facetime.cloud.data.bean.file.FileUploadBean;
import com.facetime.cloud.data.bean.user.UserBean;
import com.facetime.cloud.data.support.CloudErrorType;
import com.facetime.cloud.data.support.CloudFileUtils;
import com.facetime.cloud.data.support.CloudRESTurl;
import com.facetime.cloud.data.support.FileStatus;
import com.facetime.cloud.data.support.RequestConstants;
import com.facetime.core.file.FileUtils;
import com.facetime.core.http.ErrorType;
import com.facetime.core.http.PojoMapper;
import com.facetime.spring.logic.RemoteLogic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@SessionAttributes(RequestConstants.KEY_USER_BEAN)
public class FileAction {

	@Autowired
	private RemoteLogic remoteLogic;

	@RequestMapping(AppRESTurl.FileUploadTest)
	@ResponseBody
	public String uploadTest(FileUploadBean fileBean) {
		CommonsMultipartFile file = fileBean.getFile();
		System.out.println(file.getName());
		return CloudErrorType.OK;
	}

	@RequestMapping(AppRESTurl.fileUpload)
	public String upload(FileUploadBean uploadFile, @ModelAttribute(RequestConstants.KEY_USER_BEAN) UserBean userBean) {
		FileBean bean = parseUploadFile(uploadFile, userBean);
		FileBean existFile = remoteLogic.postToUri(userBean.getUserToken(), CloudRESTurl.getExistFile,
				PojoMapper.toJson(bean), FileBean.class);
		if (existFile != null) {
			boolean copyOK = copyFileToDisk(bean, existFile);
			if (copyOK)
				return ErrorType.OK;
		}
		boolean saveOK = saveFileToDisk(bean, uploadFile);
		if (!saveOK)
			return CloudErrorType.ERR_SAVE_FILE_TO_DISK;

		insertRecordToDB(userBean, bean);
		return ErrorType.OK;
	}

	private boolean copyFileToDisk(FileBean bean, FileBean existFile) {
		try {
			FileUtils.copyFile(AppFileUtils.getFilePath(existFile), AppFileUtils.getFilePath(bean));
			return true;
		} catch (IOException e) {
			cloudAppLogger.error("copy file to disk fail! exception is: ", e);
			return false;
		}
	}

	private void insertRecordToDB(UserBean userBean, FileBean bean) {
		String strFile = remoteLogic.postToUri(userBean.getUserToken(), CloudRESTurl.saveFileRecord,
				PojoMapper.toJson(bean));
		bean = PojoMapper.getObject(strFile, FileBean.class);
	}

	private boolean saveFileToDisk(FileBean bean, FileUploadBean uploadFile) {
		try {
			FileUtils.writeToFile(new File(AppFileUtils.getFilePath(bean)), uploadFile.getFile().getInputStream());
			return true;
		} catch (Exception e) {
			cloudAppLogger.error("save file to disk fail! exception is: ", e);
			return false;
		}
	}

	private FileBean parseUploadFile(FileUploadBean uploadFile, UserBean userBean) {
		FileBean fileBean = new FileBean();

		CommonsMultipartFile file = uploadFile.getFile();
		fileBean.setName(file.getOriginalFilename());
		fileBean.setSize(file.getSize());
		fileBean.setStatus(FileStatus.NORMAL);
		fileBean.setType(CloudFileUtils.getFileType(fileBean.getName()));
		fileBean.setGuidname(CloudFileUtils.getFileUUIDName(fileBean.getType()));
		fileBean.setCreateDate(new Date());
		fileBean.setModifyDate(new Date());
		fileBean.setUserId(userBean.getUserId());
		fileBean.setVersion(1);
		fileBean.setParentId(uploadFile.getCurrentFolderId());
		return fileBean;
	}
}
