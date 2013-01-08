package com.facetime.cloud.server.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.facetime.cloud.data.bean.user.UserBean;
import com.facetime.cloud.data.support.CloudErrorType;
import com.facetime.cloud.data.support.CloudRESTurl;
import com.facetime.cloud.server.logic.UserLogic;
import com.facetime.core.http.PojoMapper;
import com.facetime.core.security.Security;
import com.facetime.core.utils.StringUtils;
import com.facetime.spring.action.ServiceAction;

/**
 * 
 * 用户相关的Action
 * 
 * @author yufei
 * @Create_by 2012-11-14
 * @Design_by eclipse
 */
@Controller
public class UserService extends ServiceAction {

	@Autowired
	private UserLogic userLogic;

	@RequestMapping(value = CloudRESTurl.userRegister, method = RequestMethod.POST)
	public @ResponseBody
	String register(@RequestBody String strUser) {
		if (!StringUtils.isValid(strUser)) {
			return CloudErrorType.ERR_REQ_PARAM_IS_EMPTY;
		}
		UserBean userBean = PojoMapper.getObject(strUser, UserBean.class);
		userBean = userLogic.register(userBean);
		String token = Security.CreateToken(Integer.toString(userBean.getUserId()));
		userBean.setUserToken(token);
		return PojoMapper.toJson(userBean);
	}

	@RequestMapping(value = CloudRESTurl.userLogin, method = RequestMethod.POST)
	public @ResponseBody
	String login(@RequestBody String strUser) {
		if (!StringUtils.isValid(strUser)) {
			return CloudErrorType.ERR_REQ_PARAM_IS_EMPTY;
		}
		UserBean userBean = PojoMapper.getObject(strUser, UserBean.class);
		userBean = userLogic.login(userBean);
		String token = Security.CreateToken(Integer.toString(userBean.getUserId()));
		userBean.setUserToken(token);
		String result = PojoMapper.toJson(userBean);
		return result;
	}

	@RequestMapping(value = CloudRESTurl.getUserById, method = RequestMethod.POST)
	public @ResponseBody
	String getUserById(@RequestBody String strUserId) {
		if (!StringUtils.isValid(strUserId)) {
			return CloudErrorType.ERR_REQ_PARAM_IS_EMPTY;
		}
		UserBean userBean = userLogic.getUserById(Integer.parseInt(strUserId));
		return PojoMapper.toJson(userBean);
	}

}
