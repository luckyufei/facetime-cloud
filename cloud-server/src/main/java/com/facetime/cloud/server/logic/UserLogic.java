/**
 * 
 */
package com.facetime.cloud.server.logic;


import com.facetime.cloud.data.bean.user.UserBean;
import com.facetime.spring.logic.Logic;
import com.facetime.spring.support.LogicException;

/**
 * 
 *  用户相关Logic
 *  
 * @author yufei
 * @Create_by 2012-11-14
 * @Design_by eclipse  
 */
public interface UserLogic extends Logic {

	/**
	 * 用户注册
	 * 
	 * @param userBean
	 * @return TODO
	 * @throws LogicException
	 */
	UserBean register(UserBean userBean) throws LogicException;

	UserBean getUserById(int userId) throws LogicException;

	/**
	 * 用户登录
	 * @param userBean
	 * @return TODO
	 */
	UserBean login(UserBean userBean);

	public abstract void deleteUser(int userId);
}
