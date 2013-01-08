/**
 * 
 */
package com.facetime.cloud.server.logic;

import static com.facetime.core.conf.SysLogger.cloudServerLogger;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.facetime.cloud.data.bean.user.UserBean;
import com.facetime.cloud.data.entity.user.UserEntity;
import com.facetime.cloud.data.test.UserTestUtils;
import com.facetime.spring.support.PMLO;
import com.facetime.spring.support.QueryFilter;
import com.facetime.spring.test.BaseLogicTest;

import java.util.List;

/**
 * 测试UserLogic
 *
 * @author yufei
 * @Create_by 2012-11-15
 * @Design_by eclipse  
 */
public class UserLogicTest extends BaseLogicTest {

	@Autowired
	private UserLogic userLogic;

	@Test
	public void testRegisterOK() {
		UserBean userBean = UserTestUtils.createUserBean();
		userLogic.register(userBean);
		Assert.notNull(userBean.getUserId());
		cloudServerLogger.debug("userId:" + userBean.getUserId());
	}

	@After
	public void after() {
		List<UserEntity> users = userLogic.findList(UserEntity.class, new QueryFilter("username", PMLO.IN,
				new String[] { UserTestUtils.USER_NAME, UserTestUtils.USER_NAME2 }));
		for (UserEntity user : users)
			userLogic.deleteUser(user.getUserId());
	}

}
