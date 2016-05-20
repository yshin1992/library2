package com.library.cache;

import java.util.HashMap;
import java.util.Map;

import com.library.entity.LoginUserInfo;
import com.library.entity.SysFunc;

/**
 * 全局缓存类
 * 
 * @author YanShuai
 * @version 1.0,2015年7月13日
 * @See
 * @since V1.0
 */
public class SystemCache implements Cache {
	private static final long serialVersionUID = -6476752272362392219L;

	private static SystemCache instance;

	/**
	 * 缓存所有登录的用户
	 */
	private Map<String, LoginUserInfo> loginSessionMap = new HashMap<String, LoginUserInfo>();

	/**
	 * 缓存一级菜单
	 */
	private Map<Integer, SysFunc> sysFuncMap = new HashMap<Integer, SysFunc>();

	private SystemCache() {
	}

	/**
	 * 获取实例的静态方法
	 * 
	 * @return
	 */
	public static SystemCache getInstance() {
		if (null == instance) {
			instance = new SystemCache();
		}
		return instance;
	}

	public Map<String, LoginUserInfo> getLoginSessionMap() {
		return loginSessionMap;
	}

	public void putLoginUserInfo(LoginUserInfo loginUserInfo) {
		this.loginSessionMap.put(loginUserInfo.getSessionId(), loginUserInfo);
	}

	public LoginUserInfo getLoginUserWithSessionId(String sessionId) {
		return this.loginSessionMap.get(sessionId);
	}

	public void removeLoginUser(String sessionId) {
		LoginUserInfo loginUserInfo = getLoginUserWithSessionId(sessionId);
		if (loginUserInfo != null) {
			loginSessionMap.remove(sessionId);
		}
	}

	public Map<Integer, SysFunc> getSysFuncMap() {
		return sysFuncMap;
	}

	public void setSysFuncMap(Map<Integer, SysFunc> sysFuncMap) {
		this.sysFuncMap = sysFuncMap;
	}

}
