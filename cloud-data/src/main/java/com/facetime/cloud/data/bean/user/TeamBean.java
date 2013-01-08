package com.facetime.cloud.data.bean.user;

import com.facetime.cloud.data.bean.file.TeamFolderBean;

import java.util.List;

public class TeamBean {

	private Integer id;
	private String name;
	private Integer maxUserNum;
	private String logo;
	/** 用户注册的cloud-app所在服务器的IP */
	private String cloudDiskIp;

	private UserBean user;

	private List<UserBean> teamUsers;

	private List<RoleBean> teamRoles;

	private List<TeamFolderBean> teamFolders;

}
