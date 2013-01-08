package com.facetime.cloud.server.logic;

import com.facetime.cloud.data.bean.file.FileBean;
import com.facetime.cloud.data.bean.user.UserBean;
import com.facetime.cloud.data.entity.user.UserEntity;
import com.facetime.cloud.data.test.FileTestUtils;
import com.facetime.cloud.data.test.UserTestUtils;
import com.facetime.core.file.FileConstants;
import com.facetime.core.http.PojoMapper;
import com.facetime.spring.support.PMLO;
import com.facetime.spring.support.QueryFilter;
import com.facetime.spring.test.BaseLogicTest;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * 
 *
 * @author yufei
 * @Create_by 2012-12-3
 * @Design_by eclipse  
 */
public class FileLogicTest extends BaseLogicTest {

	UserLogic userLogic;
	FileLogic fileLogic;
	private UserBean user;

	@Test
	public void testGetRootDirOK() throws Exception {
		FileBean rootFolder = fileLogic.getRootFolder(user.getUserId());
		Assert.isTrue(rootFolder.getName().equals("root"));
		Assert.isTrue(FileConstants.DEFAULT_FOLDER_NAMES.length == rootFolder.getChildren().size());
		Assert.isTrue(rootFolder.getLeftKey() == 0 && rootFolder.getRightKey() > 0);
	}

	@Test
	public void testCreateDefaultFolders() {
		FileBean rootFolder = fileLogic.getRootFolder(user.getUserId());
		Assert.isTrue(rootFolder.getName().equals("root"));
		Assert.isTrue(FileConstants.DEFAULT_FOLDER_NAMES.length == rootFolder.getChildren().size());
	}

	@Test
	public void testSaveFile() {
		FileBean rootFolder = fileLogic.getRootFolder(user.getUserId());

		FileBean fileBean = FileTestUtils.createTxtFile(user.getUserId(), rootFolder.getId());

		FileBean foundFile = fileLogic.saveFile(fileBean);
		System.out.println(PojoMapper.toJson(foundFile));
		Assert.notNull(foundFile);
		Assert.isTrue(foundFile.getName().equals(fileBean.getName()));
		Assert.isTrue(foundFile.getParentId() > 0);
		Assert.isTrue(foundFile.getUserId() > 0);
	}

	@Test
	public void testGetExistFile() {

	}

	@Before
	public void before() {
		userLogic = this.locate(UserLogic.class);
		fileLogic = this.locate(FileLogic.class);
		after();
		user = userLogic.register(UserTestUtils.createUserBean());
	}

	@After
	public void after() {
		List<UserEntity> users = userLogic.findList(UserEntity.class, new QueryFilter("username", PMLO.IN,
				new String[] { UserTestUtils.USER_NAME, UserTestUtils.USER_NAME2 }));
		for (UserEntity user : users)
			userLogic.deleteUser(user.getUserId());
	}
}
