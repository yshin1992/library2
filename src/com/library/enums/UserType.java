package com.library.enums;

/**
 * 
 * 用户类型枚举类
 * 
 * @author YanShuai
 * @version 1.0,2015年7月15日
 * @See
 * @since V1.0
 */
public enum UserType {

	TEACHER("teacher"), STUDENT("student");

	String userType;

	private UserType(String userType) {
		this.userType = userType;
	}

	public String getUserType() {
		return userType;
	}

	public static boolean isCorrectType(String userType) {
		for (UserType type : UserType.values()) {
			if (type.toString().equals(userType)) {
				return true;
			}
		}
		return false;
	}

	public static UserType getUserType(String userType) {
		for (UserType type : UserType.values()) {
			if (type.toString().equals(userType)) {
				return type;
			}
		}
		return null;
	}

	public String toString() {
		return userType;
	}
}
