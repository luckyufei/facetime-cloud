package com.facetime.cloud.app.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.facetime.cloud.app.support.AppRESTurl;
import com.facetime.cloud.data.support.RequestConstants;
import com.facetime.spring.action.ServiceAction;

/**
 * 用户登录注册等相关的Action 
 *
 * @author yufei
 * @Create_by 2012-11-14
 * @Design_by eclipse  
 */

@Controller
@SessionAttributes(value = { RequestConstants.KEY_USER_BEAN })
public class UserAction extends ServiceAction {

	@RequestMapping(AppRESTurl.userLogout)
	public String logout(HttpServletRequest request) {
		request.getSession().setAttribute(RequestConstants.KEY_USER_BEAN, null);
		request.getSession().invalidate();
		return "forward:/user/login";
	}

	@RequestMapping(value = AppRESTurl.registerView)
	public String register() {
		return "user/register";
	}

	@RequestMapping(value = AppRESTurl.loginView)
	public String login() {
		return "user/login";
	}

}
