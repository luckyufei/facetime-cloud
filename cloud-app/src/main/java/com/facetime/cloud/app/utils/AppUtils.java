package com.facetime.cloud.app.utils;

import java.io.InputStream;
import java.util.Properties;

import com.facetime.cloud.data.bean.file.FileBean;
import com.facetime.cloud.data.support.CloudConstants;
import com.facetime.core.conf.ConfigUtils;

public class AppUtils {
	/** 保存缺省配置文件的配置信息 */
	public static Properties confProperties = new Properties();
	/**
	 * 用户文件存放更路径
	 */
	public static String BASE_DIR;

	static {
		try {
			InputStream resourceAsStream = ConfigUtils.class.getClassLoader().getResourceAsStream(
					CloudConstants.APP_CONFIG_NAME);
			confProperties.load(resourceAsStream);
			if (confProperties == null)
				throw new RuntimeException("Can't Load conf.properties in classpath.");

			BASE_DIR = getProperty(CloudConstants.USER_FILE_DIR);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getServiceUrl(String restful) {
		return getProperty(CloudConstants.CLOUD_SERVICE_URL) + restful;
	}

	/**
	 * 根据key值取得缺省配置文件中相应的内容
	 */
	public static String getProperty(String key, Object defaultValue) {
		String str = confProperties.getProperty(key);
		if (str != null)
			return str.trim();
		if (defaultValue != null)
			return defaultValue.toString();
		return null;
	}

	/**
	 * 根据key值取得缺省配置文件中相应的内容
	 */
	public static String getProperty(String key) {
		return getProperty(key, null);
	}

	public static void main(String[] args) {
		String url = AppUtils.getServiceUrl("/hello");
		System.out.println(url);
	}

}
