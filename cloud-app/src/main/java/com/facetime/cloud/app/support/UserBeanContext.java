package com.facetime.cloud.app.support;

import java.util.HashMap;
import java.util.Map;

import com.facetime.cloud.data.bean.user.UserBean;
import com.facetime.core.utils.StringUtils;

/**
 * 用户Bean上下文环境
 *
 * @author YUFEI
 * @Created 2012-11-25
 * @IDE  Eclipse
 */
public class UserBeanContext {

	private Map<String, UserBean> sessionIdToUserBeanMap = new HashMap<String, UserBean>();

	private static UserBeanContext context;

	private UserBeanContext() {
	}

	public static final UserBeanContext get() {
		if (context == null)
			context = new UserBeanContext();
		return context;
	}

	public UserBean get(String sessionId) {
		return StringUtils.isValid(sessionId) ? sessionIdToUserBeanMap.get(sessionId) : null;
	}

	public void put(String sessionId, UserBean userBean) {
		if (StringUtils.isValid(sessionId) && userBean != null)
			sessionIdToUserBeanMap.put(sessionId, userBean);
	}

	public void remove(String sessionId) {
		if (StringUtils.isValid(sessionId))
			sessionIdToUserBeanMap.remove(sessionId);
	}
}
