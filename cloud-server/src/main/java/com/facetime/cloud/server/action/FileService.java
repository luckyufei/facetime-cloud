package com.facetime.cloud.server.action;

import com.facetime.cloud.data.bean.file.FileBean;
import com.facetime.cloud.data.support.CloudRESTurl;
import com.facetime.cloud.data.support.RequestConstants;
import com.facetime.cloud.server.logic.FileLogic;
import com.facetime.core.http.ErrorType;
import com.facetime.core.http.PojoMapper;
import com.facetime.core.utils.StringUtils;
import com.facetime.spring.action.ServiceAction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileService extends ServiceAction {

	@RequestMapping(value = CloudRESTurl.getFileById, method = RequestMethod.GET)
	public @ResponseBody
	String getFileById(String fileId) {
		if (!StringUtils.isValid(fileId)) {
			return ErrorType.ERR_REQ_PARAM_EMPTY;
		}
		FileBean folder = locate(FileLogic.class).getFolderById(Long.parseLong(fileId));
		return PojoMapper.toJson(folder);
	}

	@RequestMapping(value = CloudRESTurl.getRootFolder, method = RequestMethod.GET)
	public @ResponseBody
	String getRootFolder(int userId) {
		if (userId <= 0) {
			return ErrorType.ERR_REQ_PARAM_EMPTY;
		}
		FileBean folder = locate(FileLogic.class).getRootFolder(userId);
		return PojoMapper.toJson(folder);
	}

	@RequestMapping(value = CloudRESTurl.getExistFile, method = RequestMethod.POST)
	public @ResponseBody
	String getExistFile(@RequestBody String strFileBean) {
		if (!StringUtils.isValid(strFileBean))
			return ErrorType.ERR_REQ_PARAM_EMPTY;
		FileBean fileBean = locate(FileLogic.class).getExistFile(PojoMapper.getObject(strFileBean, FileBean.class));
		return fileBean != null ? PojoMapper.toJson(fileBean) : RequestConstants.NULL_STR;
	}

	@RequestMapping(value = CloudRESTurl.saveFileRecord, method = RequestMethod.POST)
	public @ResponseBody
	String saveFileRecord(@RequestBody String strFileBean) {
		if (!StringUtils.isValid(strFileBean))
			return ErrorType.ERR_REQ_PARAM_EMPTY;
		FileBean file = locate(FileLogic.class).saveFile(PojoMapper.getObject(strFileBean, FileBean.class));
		return PojoMapper.toJson(file);
	}

}
