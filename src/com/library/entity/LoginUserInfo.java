package com.library.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.library.domain.AbstractModel;
import com.library.enums.UserType;

public class LoginUserInfo {

	private AbstractModel model;

	private String sessionId;

	private Date loginTime;

	private String loginIp;

	private List<SysFunc> sysFunc;

	private Map<String, SysFunc> urlFunc;

	/**
	 * 用户类型
	 */
	private UserType userType;

	public AbstractModel getModel() {
		return model;
	}

	public void setModel(AbstractModel model) {
		this.model = model;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Map<String, SysFunc> getUrlFunc() {
		return urlFunc;
	}

	public List<SysFunc> getSysFunc() {
		return sysFunc;
	}

	public void setSysFunc(List<SysFunc> sysFunc) {
		this.sysFunc = sysFunc;
	}

	public void setUrlFunc(List<SysFunc> sysFunc) {
		this.urlFunc = new HashMap<String, SysFunc>();
		for (SysFunc temp : sysFunc) {
			this.urlFunc.put(temp.getUrl(), temp);
		}
	}

	@Override
	public String toString() {
		return "LoginUserInfo [model=" + model + ", sessionId=" + sessionId
				+ ", loginTime=" + loginTime + ", loginIp=" + loginIp
				+ ", userType=" + userType + "]";
	}

}
