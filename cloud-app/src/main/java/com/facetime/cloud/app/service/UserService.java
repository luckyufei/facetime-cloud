package com.facetime.cloud.app.service;

import static com.facetime.core.conf.SysLogger.cloudAppLogger;

import com.facetime.cloud.app.support.AppRESTurl;
import com.facetime.cloud.app.utils.AppFileUtils;
import com.facetime.cloud.data.bean.file.FileBean;
import com.facetime.cloud.data.bean.user.UserBean;
import com.facetime.cloud.data.support.CloudRESTurl;
import com.facetime.cloud.data.support.RequestConstants;
import com.facetime.core.conf.ConfigUtils;
import com.facetime.core.file.FileConstants;
import com.facetime.core.file.FileUtils;
import com.facetime.core.http.ErrorType;
import com.facetime.core.http.PojoMapper;
import com.facetime.core.utils.web.CookieUtils;
import com.facetime.spring.action.ServiceAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = { RequestConstants.KEY_USER_BEAN })
public class UserService extends ServiceAction {

	@RequestMapping(AppRESTurl.userRegister)
	@ResponseBody
	public String register(@RequestParam(RequestConstants.DATA) String json, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserBean userBean = PojoMapper.getObject(json, UserBean.class);
		userBean.setCloudDiskIp(ConfigUtils.getProperty("cloudDiskIp"));
		userBean.setCurrentIp(request.getRemoteAddr());
		json = PojoMapper.toJson(userBean);
		String strUserBean = remoteLogic.postToUri(null, CloudRESTurl.userRegister, json);
		cloudAppLogger.debug("register, result=" + strUserBean);

		UserBean user = processUserBean(model, response, strUserBean);
		createDefaultFolder(user);
		return ErrorType.OK;
	}

	private void createDefaultFolder(UserBean user) throws Exception {
		FileUtils.mkdir(AppFileUtils.getBasePath() + user.getUserId());
		for (String fileName : FileConstants.DEFAULT_FOLDER_NAMES) {
			FileUtils.mkdir(AppFileUtils.getUserRootPath(user.getUserId()) + "/" + fileName);
		}
	}

	private UserBean processUserBean(ModelMap model, HttpServletResponse response, String strUserBean) {
		UserBean user = PojoMapper.getObject(strUserBean, UserBean.class);
		model.addAttribute(RequestConstants.KEY_USER_BEAN, user);
		model.addAttribute(RequestConstants.KEY_CURRENT_FOLDER, remoteLogic.getFromUri(user.getUserToken(),
				CloudRESTurl.getRootFolder, "userId=" + user.getUserId(), FileBean.class));

		CookieUtils.setCookieToRootPath(response, RequestConstants.COOKIE_EMAIL, user.getEmail());
		CookieUtils.setCookieToRootPath(response, RequestConstants.COOKIE_USER_TOKEN, user.getUserToken());
		return user;
	}

	@RequestMapping(AppRESTurl.userLogin)
	@ResponseBody
	public String login(@RequestParam(RequestConstants.DATA) String json, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		UserBean userBean = PojoMapper.getObject(json, UserBean.class);
		userBean.setCurrentIp(request.getRemoteAddr());
		json = PojoMapper.toJson(userBean);
		String strUserBean = remoteLogic.postToUri(null, CloudRESTurl.userLogin, json);
		cloudAppLogger.debug("login, result=" + strUserBean);

		processUserBean(model, response, strUserBean);
		return ErrorType.OK;
	}
}
