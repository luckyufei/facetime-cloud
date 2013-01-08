/**
 * 
 */
package com.facetime.cloud.server.action;

import com.facetime.cloud.data.bean.user.UserBean;
import com.facetime.cloud.data.entity.user.UserEntity;
import com.facetime.cloud.data.support.CloudErrorType;
import com.facetime.cloud.data.support.CloudRESTurl;
import com.facetime.cloud.data.test.UserTestUtils;
import com.facetime.cloud.server.logic.UserLogic;
import com.facetime.core.http.PojoMapper;
import com.facetime.spring.support.PMLO;
import com.facetime.spring.support.QueryFilter;
import com.facetime.spring.test.BaseActionTest;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

/**
 * 
 * 用户相关Action的测试用例
 * @author yufei
 * @Create_by 2012-11-15
 * @Design_by eclipse  
 */
public class UserServiceTest extends BaseActionTest {

	UserLogic userLogic;

	@Before
	public void before() {
		userLogic = locate(UserLogic.class);
		after();
		this.createJsonRequest();
	}

	@Test
	public void testRegisterOK() throws Exception {
		UserBean userBean = UserTestUtils.createUserBean();

		this.postToUrl(CloudRESTurl.userRegister, PojoMapper.toJson(userBean));

		Assert.isTrue(response.getStatus() == HttpStatus.OK.value(), "response status not 200!");
		String strUserBean = response.getContentAsString();
		Assert.hasLength(strUserBean);
		userBean = PojoMapper.getObject(strUserBean, UserBean.class);
		Assert.isTrue(UserTestUtils.USER_NAME.equals(userBean.getUsername()));
		Assert.isTrue(userBean.getUserId() > 0);
	}

	@Test
	public void testRegisterUsernameExists() throws Exception {
		userLogic.register(UserTestUtils.createUserBean());

		UserBean userBean = UserTestUtils.createUserBean();
		this.postToUrl(CloudRESTurl.userRegister, PojoMapper.toJson(userBean));
		String errorCode = response.getContentAsString();
		Assert.isTrue(CloudErrorType.ERR_USERNAME_EXIST.equals(errorCode));
	}

	@Test
	public void testRegisterEmailExists() throws Exception {
		userLogic.register(UserTestUtils.createUserBean());

		UserBean userBean = UserTestUtils.createUserBean(UserTestUtils.USER_NAME2);
		this.postToUrl(CloudRESTurl.userRegister, PojoMapper.toJson(userBean));
		String errorCode = response.getContentAsString();
		Assert.isTrue(CloudErrorType.ERR_EMAIL_EXIST.equals(errorCode));
	}

	@After
	public void after() {
		List<UserEntity> users = userLogic.findList(UserEntity.class, new QueryFilter("username", PMLO.IN,
				new String[] { UserTestUtils.USER_NAME, UserTestUtils.USER_NAME2 }));
		for (UserEntity user : users)
			userLogic.deleteUser(user.getUserId());
	}
}
