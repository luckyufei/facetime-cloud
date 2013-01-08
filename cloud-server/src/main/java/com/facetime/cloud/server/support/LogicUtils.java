package com.facetime.cloud.server.support;

import com.facetime.cloud.data.entity.support.CloudBusinessObject;
import com.facetime.core.utils.CollectionUtils;

import java.util.List;

@SuppressWarnings("unchecked")
public class LogicUtils {

	public static final <T extends CloudBusinessObject, V> List<V> convert(List<T> entityList, Class<V> clazz) {
		List<V> list = CollectionUtils.newList(entityList.size());
		for (CloudBusinessObject entity : entityList) {
			list.add((V) entity.asBean());
		}
		return list;
	}

}
