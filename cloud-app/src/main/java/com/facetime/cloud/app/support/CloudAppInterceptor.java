/**
 * 
 */
package com.facetime.cloud.app.support;

import static com.facetime.core.conf.SysLogger.cloudAppLogger;

import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.facetime.cloud.data.bean.user.UserBean;
import com.facetime.cloud.data.support.CloudRESTurl;
import com.facetime.cloud.data.support.RequestConstants;
import com.facetime.core.http.ErrorType;
import com.facetime.core.utils.StringUtils;
import com.facetime.spring.support.LogicException;

/**
 * 
 * 用户是否登录的过滤器
 * @author yufei
 * @Create_by 2012-11-14
 * @Design_by eclipse  
 */
@Service
public class CloudAppInterceptor extends HandlerInterceptorAdapter {

	private static final String[] IGNORE_SERVICE_URI = new String[] { CloudRESTurl.userRegister, CloudRESTurl.userLogin };
	private static final String[] IGNORE_URI = new String[] { AppRESTurl.loginView, AppRESTurl.registerView };

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		UserBean userBean = (UserBean) session.getAttribute(RequestConstants.KEY_USER_BEAN);
		String uri = request.getRequestURI();
		if (StringUtils.contains(uri, "/file/upload")) {
			String realSessionId = request.getParameter("realSessionId");
			userBean = UserBeanContext.get().get(realSessionId);
			session.setAttribute(RequestConstants.KEY_USER_BEAN, userBean);
		}
		boolean checkOK = false;
		if (userBean != null && StringUtils.isValid(userBean.getUserToken())) {
			checkOK = true;
		} else if (StringUtils.equalsAnyOf(uri, IGNORE_URI)) {
			checkOK = true;
		} else if (AppRESTurl.service.equals(uri) && StringUtils.equalsAnyOf(uri, IGNORE_SERVICE_URI)) {
			checkOK = true;
		}
		if (checkOK) {
			// setUserBeanToHandler(handler, userBean);
			return true;
		} else {
			cloudAppLogger.info("user enter without user_token or userBean not save in session!");
			String redirectPath = request.getContextPath() + AppRESTurl.loginView;
			response.sendRedirect(redirectPath);
			return false;
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (ex == null) {
			super.afterCompletion(request, response, handler, ex);
			return;
		}
		if (isJsonResponse(handler)) {
			String errorMsg = ErrorType.ERR_SYS_ERR;
			if (ex instanceof LogicException) {
				errorMsg = ((LogicException) ex).getErrorType();
			} else if (ex instanceof Exception) {
				cloudAppLogger.error(String.format("[uri]:%s Fail!", request.getRequestURI()), ex);
				errorMsg = ErrorType.ERR_SYS_ERR;
			}

			PrintWriter writer = response.getWriter();
			writer.write(errorMsg);
			writer.flush();
			writer.close();
			return;
		}

		//!isJsonResponse(handler)
		super.afterCompletion(request, response, handler, ex);
	}

	private boolean isJsonResponse(Object handler) {
		Method[] methods = handler.getClass().getDeclaredMethods();
		for (Method method : methods) {
			boolean isAnnoted = method.isAnnotationPresent(RequestMapping.class);
			isAnnoted = isAnnoted && method.isAnnotationPresent(ResponseBody.class);
			if (isAnnoted)
				return true;
		}
		return false;
	}

}
