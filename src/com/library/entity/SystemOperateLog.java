package com.library.entity;

import java.util.Date;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.BrowserType;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.RenderingEngine;
import eu.bitwalker.useragentutils.UserAgent;

public class SystemOperateLog {
	private Long id;

	private String url;

	private String targetObject;

	private Short operateResult;

	private String sessionId;

	private String ip;

	private Date operateDate;

	private String userId;

	/**
	 * 代理信息
	 */
	private String userAgent;

	/**
	 * 语言
	 */
	private String acceptLanguage;

	/**
	 * 浏览器分类
	 */
	private Browser browser;

	/**
	 * 浏览器名称
	 */
	private String browserName;

	/**
	 * 浏览器版本
	 */
	private String browserVersion;

	/**
	 * 浏览器类型：WEB_BROWSER MOBILE_BROWSER
	 */
	private BrowserType browserType;

	/**
	 * 浏览器内核
	 */
	private RenderingEngine renderingEngine;

	/**
	 * 操作系统分类
	 */
	private OperatingSystem operatingSystem;

	/**
	 * 操作系统名称
	 */
	private String systemName;

	/**
	 * 设备类型：COMPUTER MOBILE TABLET
	 */
	private DeviceType deviceType;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTargetObject() {
		return targetObject;
	}

	public void setTargetObject(String targetObject) {
		this.targetObject = targetObject;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
		if (userAgent != null) {
			UserAgent agent = new UserAgent(userAgent);
			if (agent != null) {
				Browser browser = agent.getBrowser();
				this.browser = browser.getGroup();
				this.browserVersion = agent.getBrowserVersion().getVersion();
				this.browserType = browser.getBrowserType();
				this.browserName = browser.getName();
				this.renderingEngine = browser.getRenderingEngine();
			}
			OperatingSystem operatingSystem = agent.getOperatingSystem();
			if (operatingSystem != null) {
				this.operatingSystem = operatingSystem.getGroup();
				this.systemName = operatingSystem.getName();
				this.deviceType = operatingSystem.getDeviceType();
			}
		}
	}

	public String getBrowserVersion() {
		return browserVersion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcceptLanguage() {
		return acceptLanguage;
	}

	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}

	public Browser getBrowser() {
		return browser;
	}

	public String getBrowserName() {
		return browserName;
	}

	public BrowserType getBrowserType() {
		return browserType;
	}

	public RenderingEngine getRenderingEngine() {
		return renderingEngine;
	}

	public OperatingSystem getOperatingSystem() {
		return operatingSystem;
	}

	public String getSystemName() {
		return systemName;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public Short getOperateResult() {
		return operateResult;
	}

	public void setOperateResult(Short operateResult) {
		this.operateResult = operateResult;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	@Override
	public String toString() {
		return "SystemOperateLog [id=" + id + ", url=" + url
				+ ", targetObject=" + targetObject + ", operateResult="
				+ operateResult + ", sessionId=" + sessionId + ", ip=" + ip
				+ ", operateDate=" + operateDate + ", userId=" + userId
				+ ", userAgent=" + userAgent + ", acceptLanguage="
				+ acceptLanguage + ", browser=" + browser + ", browserName="
				+ browserName + ", browserVersion=" + browserVersion
				+ ", browserType=" + browserType + ", renderingEngine="
				+ renderingEngine + ", operatingSystem=" + operatingSystem
				+ ", systemName=" + systemName + ", deviceType=" + deviceType
				+ "]";
	}

}
