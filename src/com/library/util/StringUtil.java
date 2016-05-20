package com.library.util;

public class StringUtil {
	/**
	 * 判断字符串集合中是否有字符串为空或Null
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String... string) {
		if (null != string && string.length > 0) {
			for (String str : string) {
				if (str == null || "".equals(str.replaceAll("/\\s/g", "")))
					return true;
			}
		}
		return false;
	}

}
