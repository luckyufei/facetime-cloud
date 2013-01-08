package com.facetime.cloud.data.entity;

import java.lang.reflect.InvocationTargetException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.beanutils.BeanUtils;

import com.facetime.cloud.data.bean.CloudServerBean;
import com.facetime.core.bean.BusinessObject;

@Entity
public class CloudServerEntity implements BusinessObject {

	private static final long serialVersionUID = 8491457967221715689L;

	@Id
	@GeneratedValue
	private Integer id;
	private String projectName;
	private String projectVersion;

	public CloudServerEntity() {
		super();
	}

	public CloudServerEntity(CloudServerBean bean) {
		try {
			BeanUtils.copyProperties(this, bean);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public Integer getId() {
		return id;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getProjectVersion() {
		return projectVersion;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectVersion(String projectVersion) {
		this.projectVersion = projectVersion;
	}
}
