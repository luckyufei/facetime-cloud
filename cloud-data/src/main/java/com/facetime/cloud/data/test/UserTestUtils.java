/**
 * 
 */
package com.facetime.cloud.data.test;

import com.facetime.cloud.data.bean.user.UserBean;
import com.facetime.core.security.Security;

import java.util.UUID;

/**
 * 
 *
 * @author yufei
 * @Create_by 2012-11-15
 * @Design_by eclipse  
 */
public class UserTestUtils {

	public static final String USER_NAME = "TEST_USER";

	public static final String PASS_WORD = "123456";

	public static final String EMAIL = "TEST_USER@qq.com";

	public static final String USER_NAME2 = "TEST_USER2";

	/**
	 * @return
	 */
	public static UserBean createUserBean() {
		return createUserBean(USER_NAME);
	}

	/**
	 * @return
	 */
	public static UserBean createUserBean(String username) {
		UserBean userBean = new UserBean();
		userBean.setUsername(username);
		userBean.setPassword(PASS_WORD);
		userBean.setEmail(EMAIL);
		securityUserBean(userBean);
		userBean.setClientId(UUID.randomUUID().toString());
		userBean.setCloudDiskIp("127.0.0.1");
		userBean.setCurrentIp("127.0.0.1");
		return userBean;
	}

	/**
	 * @return
	 */
	public static UserBean createRegisterUser() {
		UserBean userBean = new UserBean();
		userBean.setUsername(USER_NAME);
		userBean.setPassword(PASS_WORD);
		userBean.setEmail(EMAIL);
		securityUserBean(userBean);
		userBean.setClientId(UUID.randomUUID().toString());
		return userBean;
	}

	/**
	 * @param string
	 * @return
	 */
	public static void securityUserBean(UserBean userBean) {
		/*
		dto.nonce = Security.randomCharString();
		dto.password = Crypto.SHA256(dto.password);
		dto.hashKey = Crypto.SHA256(dto.username + dto.password+ dto.nonce);
		
		dto.password = Security.codeDecode(dto.nonce, Security.byteStringToHexString(dto.password));
		return dto;
		 */
		Security security = new Security();
		userBean.setNonce(Security.randomCharString());
		userBean.setPassword(Security.SHA256(userBean.getPassword()));
		userBean.setHashKey(Security.SHA256(userBean.getUsername() + userBean.getPassword() + userBean.getNonce()));

		userBean.setPassword(security.codeDecode(userBean.getNonce(),
				Security.byteStringToHexString(userBean.getPassword())));
	}

}
