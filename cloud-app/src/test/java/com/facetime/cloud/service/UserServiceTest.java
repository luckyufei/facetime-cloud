package com.facetime.cloud.service;

import com.facetime.cloud.app.support.AppRESTurl;
import com.facetime.cloud.data.bean.user.UserBean;
import com.facetime.cloud.data.test.UserTestUtils;
import com.facetime.core.http.ErrorType;
import com.facetime.core.http.PojoMapper;
import com.facetime.spring.test.AppActionTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * 
 *
 * @author yufei
 * @Create_by 2012-12-7
 * @Design_by eclipse  
 */
public class UserServiceTest extends AppActionTest {

	@Before
	public void before() {
		this.createRequest();
	}

	@Test
	public void testRegisterOK() throws Exception {
		UserBean userBean = UserTestUtils.createRegisterUser();
		this.request.addParameter("data", PojoMapper.toJson(userBean));
		String result = send(AppRESTurl.userRegister);
		Assert.isTrue(ErrorType.OK.equals(result));
	}
}
