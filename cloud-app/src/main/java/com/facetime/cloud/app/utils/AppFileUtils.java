package com.facetime.cloud.app.utils;

import com.facetime.cloud.data.bean.file.FileBean;

public class AppFileUtils {

	public static String getBasePath() {
		return AppUtils.BASE_DIR;
	}

	public static String getUserRootPath(long userId) {
		return getBasePath() + "/" + userId;
	}

	public static String getFilePath(FileBean fileBean) {
		return getBasePath() + "/" + fileBean.getGuidname();
	}
}
