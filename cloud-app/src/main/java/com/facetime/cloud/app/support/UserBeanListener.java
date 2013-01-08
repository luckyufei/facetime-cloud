package com.facetime.cloud.app.support;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.facetime.cloud.data.bean.user.UserBean;
import com.facetime.cloud.data.support.RequestConstants;

/**
 * 用户登录信息BEAN监听器
 *
 * @author YUFEI
 * @Created 2012-11-25
 * @IDE  Eclipse
 */
public class UserBeanListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if (RequestConstants.KEY_USER_BEAN.equals(event.getName())) {
			UserBeanContext.get().put(event.getSession().getId(), (UserBean) event.getValue());
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if (RequestConstants.KEY_USER_BEAN.equals(event.getName())) {
			UserBeanContext.get().remove(event.getSession().getId());
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		if (RequestConstants.KEY_USER_BEAN.equals(event.getName())) {
			UserBeanContext.get().put(event.getSession().getId(), (UserBean) event.getValue());
		}
	}

}
