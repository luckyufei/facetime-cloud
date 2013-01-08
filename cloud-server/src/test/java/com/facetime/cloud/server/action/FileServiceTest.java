package com.facetime.cloud.server.action;

import com.facetime.cloud.data.bean.file.FileBean;
import com.facetime.cloud.data.bean.user.UserBean;
import com.facetime.cloud.data.entity.file.FileEntity;
import com.facetime.cloud.data.entity.user.LoginLogEntity;
import com.facetime.cloud.data.entity.user.UserEntity;
import com.facetime.cloud.data.support.CloudRESTurl;
import com.facetime.cloud.data.test.FileTestUtils;
import com.facetime.cloud.data.test.UserTestUtils;
import com.facetime.cloud.server.logic.FileLogic;
import com.facetime.cloud.server.logic.UserLogic;
import com.facetime.core.http.PojoMapper;
import com.facetime.spring.support.LogicUtils;
import com.facetime.spring.support.PMLO;
import com.facetime.spring.support.QueryFilter;
import com.facetime.spring.test.BaseActionTest;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

public class FileServiceTest extends BaseActionTest {

	FileLogic fileLogic;
	UserLogic userLogic;
	private UserBean user;
	private FileBean rootFolder;

	@Before
	public void before() {
		this.createJsonRequest();
		fileLogic = this.locate(FileLogic.class);
		userLogic = this.locate(UserLogic.class);
		after();
		user = userLogic.register(UserTestUtils.createUserBean());
		rootFolder = fileLogic.getRootFolder(user.getUserId());
	}

	@After
	public void after() {
		List<UserEntity> users = userLogic.findList(UserEntity.class, new QueryFilter("username", PMLO.IN,
				new String[] { UserTestUtils.USER_NAME, UserTestUtils.USER_NAME2 }));
		for (UserEntity user : users)
			userLogic.deleteUser(user.getUserId());
	}

	@Test
	public void testGetFolderById() throws Exception {
		String strFileBean = this.getFromUrl(CloudRESTurl.getFileById, new QueryFilter("fileId", rootFolder.getId()));

		Assert.isTrue(response.getStatus() == HttpStatus.OK.value(), "response status not 200!");
		Assert.hasLength(strFileBean);
		FileBean fileBean = PojoMapper.getObject(strFileBean, FileBean.class);
		Assert.isTrue(rootFolder.getName().equals(fileBean.getName()));
		Assert.isTrue(fileBean.getUserId() > 0);
	}

	@Test
	public void getRootFolder() {
		String strRootFolder = this.getFromUrl(CloudRESTurl.getRootFolder, new QueryFilter("userId", user.getUserId()));
		FileBean rootFolder = PojoMapper.getObject(strRootFolder, FileBean.class);
		Assert.isTrue(rootFolder.getName().equals(this.rootFolder.getName()));
		Assert.isTrue(rootFolder.getUserId() == user.getUserId());
	}

	@Test
	public void saveFileRecord() {
		FileBean file = FileTestUtils.createTxtFile(user.getUserId(), rootFolder.getId());
		String strFile = this.postToUrl(CloudRESTurl.saveFileRecord, PojoMapper.toJson(file));
		FileBean saveFile = PojoMapper.getObject(strFile, FileBean.class);

		Assert.isTrue(saveFile.getId() > 0);
		Assert.isTrue(file.getName().equals(saveFile.getName()));
	}

}
