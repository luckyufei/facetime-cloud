package com.facetime.cloud.data.bean;

import com.facetime.core.bean.BusinessBean;

public class CloudServerBean implements BusinessBean {

	private static final long serialVersionUID = -9169761428973162282L;

	private Integer id;
	private String projectName;
	private String projectVersion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectVersion() {
		return projectVersion;
	}

	public void setProjectVersion(String projectVersion) {
		this.projectVersion = projectVersion;
	}

}
