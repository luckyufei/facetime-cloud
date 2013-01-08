package com.facetime.cloud.data.support;

import com.facetime.core.file.FileConstants;
import com.facetime.core.utils.StringUtils;
import com.facetime.core.utils.UUIDUtils;

public class CloudFileUtils {

	public static String getFileName(String filePath) {
		String name = filePath;
		int i = filePath.lastIndexOf("/");
		if (i < 0) {
			i = filePath.lastIndexOf("\\");
		}
		if (i > 0) {
			name = filePath.substring(i + 1);
		}
		return name;
	}

	public static String getFilePrefix(String fileName) {
		String prefix = fileName;
		if (fileName != null) {
			int i = fileName.lastIndexOf("?");
			int j = fileName.lastIndexOf(".");
			String str = fileName;
			if (i > 0) {
				str = fileName.substring(0, i);
				j = str.lastIndexOf(".");

			}
			if (j > 0) {
				prefix = str.substring(0, j);
			}
		}
		return prefix;
	}

	/**
	 * get file suffix name (file type)
	 * @param fileName
	 * @return
	 */
	public static FileType getFileType(String fileName) {
		String suffix = "";
		if (fileName != null) {
			int i = fileName.lastIndexOf("?");
			int j = fileName.lastIndexOf(".");
			String str = fileName;
			if (i > 0) {
				str = fileName.substring(0, i);
				j = str.lastIndexOf(".");

			}
			if (j > 0) {
				suffix = str.substring(j + 1);
			}
		}
		suffix = suffix.toUpperCase();
		try {
			return FileType.valueOf(suffix);
		} catch (Exception e) {
			return FileType.UNKNOW;
		}
	}

	public static String getFileUUIDName(FileType type) {
		return UUIDUtils.nextUUID() + "." + type.name();
	}

	public static boolean isConvertToHtmlSupported(String fileName) {
		return StringUtils.equalsAnyOf(getFileType(fileName).name(), FileConstants.CONVERT_TO_HTML_SUPPORTED_FORMAT);
	}

	public static boolean isConvertToPdfSupported(FileType type) {
		return StringUtils.equalsAnyOf(type, FileConstants.CONVERT_TO_PDF_SUPPORTED_FORMAT);
	}

	public static boolean isDocx(String fileName) {
		return FileConstants.FILE_FORMAT_DOCX.equalsIgnoreCase(getFileType(fileName).name());
	}

	public static boolean isEditAsHtmlSupported(FileType type) {
		if (isHtml(type)) {
			return true;
		}

		return isHtml(type) || StringUtils.equalsAnyOf(type.name(), FileConstants.EDIT_AS_HTML_SUPPORTED_FORMAT);
	}

	public static boolean isHtml(FileType type) {
		return FileConstants.FILE_FORMAT_HTML.equalsIgnoreCase(type.name());
	}

	public static boolean isImage(FileType type) {
		return StringUtils.equalsAnyOf(type, FileConstants.IMAGE_FORMATS);
	}

	public static boolean isPdf(FileType type) {
		return StringUtils.equals(FileConstants.FILE_FORMAT_PDF, type.name());
	}

	public static boolean isSwf(String fileName) {
		return FileConstants.FILE_FORMAT_SWF.equalsIgnoreCase(getFileType(fileName).name());
	}

	public static boolean isText(String fileName) {
		return StringUtils.equalsAnyOf(getFileType(fileName).name(), FileConstants.VIEW_AS_TEXT_SUPPORTED_FORMAT);
	}

	public static boolean isVideoSupported(FileType type) {
		return StringUtils.equalsAnyOf(type, FileConstants.JWPLAYER_SUPPORTED_FORMAT);
	}

	/**
	 * is view as html supported
	 * @param fileName
	 * @return
	 */
	public static boolean isViewAsHtmlSupported(FileType type) {
		return StringUtils.equalsAnyOf(type.name(), FileConstants.VIEW_AS_HTML_SUPPORTED_FORMAT);
	}

	public static boolean isViewAsSwfSupported(FileType type) {
		return isPdf(type) || isConvertToPdfSupported(type);
	}

	public static boolean isViewAsTEXTSupported(FileType type) {
		return StringUtils.equalsAnyOf(type.name(), FileConstants.VIEW_AS_TEXT_SUPPORTED_FORMAT);
	}

	public static boolean isViewSupported(FileType type) {
		return isImage(type) || isViewAsSwfSupported(type) || isViewAsHtmlSupported(type)
				|| isViewAsTEXTSupported(type) || isVideoSupported(type);
	}

	public static boolean isXls(String fileName) {
		return FileConstants.FILE_FORMAT_XLS.equalsIgnoreCase(getFileType(fileName).name());
	}

	public static boolean isXlsx(String fileName) {
		return FileConstants.FILE_FORMAT_XLSX.equalsIgnoreCase(getFileType(fileName).name());
	}
}
