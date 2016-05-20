package com.library.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogUtil {
	private static Map<Class<?>, Logger> LogMap = new HashMap<Class<?>, Logger>();

	public static Logger getLogger(Class<?> clazz) {
		Logger log = LogMap.get(clazz);
		if (null == log) {
			log = LogManager.getLogger(clazz);
			LogMap.put(clazz, log);
		}
		return log;
	}

	public static Logger getLogger(Object obj) {
		Class<?> clazz = obj.getClass();
		Logger log = LogMap.get(clazz);
		if (null == log) {
			log = LogManager.getLogger(clazz);
			LogMap.put(clazz, log);
		}
		return log;
	}
}
