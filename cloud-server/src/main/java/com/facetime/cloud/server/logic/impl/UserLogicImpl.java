package com.facetime.cloud.server.logic.impl;

import com.facetime.cloud.data.bean.user.UserBean;
import com.facetime.cloud.data.entity.file.FileEntity;
import com.facetime.cloud.data.entity.user.LoginLogEntity;
import com.facetime.cloud.data.entity.user.UserEntity;
import com.facetime.cloud.data.support.CloudErrorType;
import com.facetime.cloud.data.support.Gender;
import com.facetime.cloud.server.logic.FileLogic;
import com.facetime.cloud.server.logic.UserLogic;
import com.facetime.core.security.Security;
import com.facetime.core.utils.RegexUtils;
import com.facetime.core.utils.StringUtils;
import com.facetime.spring.logic.LogicImpl;
import com.facetime.spring.support.LogicException;
import com.facetime.spring.support.QueryFilter;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserLogicImpl extends LogicImpl implements UserLogic {

	@Autowired
	private FileLogic fileLogic;

	@Override
	public UserBean login(UserBean userBean) {
		if (!StringUtils.isValid(userBean.getEmail()) && !StringUtils.isValid(userBean.getUsername()))
			throw new LogicException(CloudErrorType.ERR_USERNAME_IS_EMPTY);

		if (!checkHashKey(userBean))
			throw new LogicException(CloudErrorType.ERR_HASH_KEY_NOT_EQ);

		UserEntity userEntity = null;
		if (RegexUtils.isEmail(userBean.getUsername()))
			userEntity = this.findUnique(UserEntity.class, QueryFilter.valueOf("email", userBean.getUsername()));
		else
			userEntity = this.findUnique(UserEntity.class, QueryFilter.valueOf("username", userBean.getUsername()));
		if (userEntity == null)
			throw new LogicException(CloudErrorType.ERR_USER_NOT_EXIST);

		userBean.setUserId(userEntity.getUserId());
		userBean.setUsername(userEntity.getUsername());
		userBean.setPassword(Security.CreatePassword(getMD5Password(userBean)));
		if (!userBean.getPassword().equals(userEntity.getPassword()))
			throw new LogicException(CloudErrorType.ERR_PWD_NOT_MATCH);
		saveLoginLog(userBean, userEntity);

		return userEntity.asBean();
	}

	private void saveLoginLog(UserBean userBean, UserEntity user) {
		LoginLogEntity loginLog = new LoginLogEntity();
		loginLog.setLoginDate(new Date());
		loginLog.setLoginIp(userBean.getCurrentIp());
		loginLog.setUser(user);
		loginLog.setRemainSecs(0);
		this.save(loginLog);
	}

	@Override
	public UserBean getUserById(int userId) throws LogicException {
		UserEntity user = this.findById(UserEntity.class, userId);
		if (user == null)
			throw new LogicException(CloudErrorType.ERR_USER_NOT_EXIST);
		UserBean userBean = new UserBean();
		BeanUtils.copyProperties(user, userBean);
		return userBean;
	}

	@Override
	public UserBean register(UserBean userBean) throws LogicException {
		if (!checkHashKey(userBean))
			throw new LogicException(CloudErrorType.ERR_HASH_KEY_NOT_EQ);
		userBean.setPassword(Security.CreatePassword(getMD5Password(userBean)));
		UserEntity existUser = this.findUnique(UserEntity.class,
				QueryFilter.valueOf("username", userBean.getUsername()));
		if (existUser != null)
			throw new LogicException(CloudErrorType.ERR_USERNAME_EXIST);
		existUser = this.findUnique(UserEntity.class, QueryFilter.valueOf("email", userBean.getEmail()));
		if (existUser != null)
			throw new LogicException(CloudErrorType.ERR_EMAIL_EXIST);

		UserEntity user = new UserEntity();
		user.setCreateDate(new Date());
		user.setModifyDate(new Date());
		user.setGender(Gender.UNKNOW);

		BeanUtils.copyProperties(userBean, user);
		this.save(user);

		// create default folder 
		fileLogic.createDefaultFolders(user);

		userBean.setUserId(user.getUserId());

		this.saveLoginLog(userBean, user);
		return userBean;
	}

	/**
	 * 检查用户的hashKey是否被修改
	 */
	private boolean checkHashKey(UserBean userBean) {
		String mdPassword = getMD5Password(userBean);
		// 计算校验码, 验证企业管理员密码完整性
		String hashKey = Security.SHA256(userBean.getUsername() + mdPassword + userBean.getNonce());
		return userBean.getHashKey().equals(hashKey);
	}

	private String getMD5Password(UserBean userBean) {
		Security sc = new Security();
		// 解密
		String hPassword = sc.codeDecode(userBean.getNonce(), userBean.getPassword());
		// 转码
		String mdPassword = Security.hexStringToByteString(hPassword);
		return mdPassword;
	}

	@Override
	public void deleteUser(int userId) {
		this.delete(LoginLogEntity.class, new QueryFilter("user.userId", userId));
		this.delete(FileEntity.class, new QueryFilter("user.userId", userId));
		this.deleteById(UserEntity.class, userId);
	}
}
