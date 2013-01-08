package com.facetime.cloud.server.support;

import static com.facetime.core.conf.SysLogger.cloudServerLogger;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.facetime.cloud.data.support.CloudRESTurl;
import com.facetime.cloud.data.support.RequestConstants;
import com.facetime.core.http.ErrorType;
import com.facetime.core.security.Security;

public class UserTokenInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		response.setContentType(RequestConstants.SERVICE_CONTENT_TYPE);
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String token = null;
		String ut = httpRequest.getHeader(RequestConstants.USER_TOKEN);
		if (ut != null) {
			token = URLDecoder.decode(ut, "UTF-8");
		}
		// 检查结果，为 true 则放行请求，为 false 则阻止请求。
		boolean checkResults = false;
		String uri = httpRequest.getRequestURI();
		try {
			if (uri.contains("Test") || uri.contains(CloudRESTurl.sendMessage)) {
				checkResults = true;
			} else if (token == null || token.length() == 0) {
				checkResults = false;
			} else {
				// 检查用户的 token 是否合法
				checkResults = Security.CheckToken(token);
			}
		} catch (Exception ex) {
			checkResults = false;
			cloudServerLogger.error(uri + ": " + token, ex);
		}
		if (checkResults) {
			return true;
		} else {
			response.getWriter().write(ErrorType.ERR_CHECK_TOKEN);
			cloudServerLogger.error("check token fail:" + token);
			return false;
		}
	}

}
