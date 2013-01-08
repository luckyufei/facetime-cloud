package com.facetime.cloud.data.entity.support;

import com.facetime.core.bean.BusinessBean;
import com.facetime.core.bean.BusinessObject;

public interface CloudBusinessObject extends BusinessObject {

	public <T extends BusinessBean> T asBean();
}
