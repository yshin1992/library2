package com.library.entity;

public class SysFunc {
	private int aiid;

	private String funcKey;

	private String funcName;

	private String funcType;

	private String url;

	private String css;

	private int parentId;

	private String description;

	private byte state;

	public int getAiid() {
		return aiid;
	}

	public void setAiid(int aiid) {
		this.aiid = aiid;
	}

	public String getFuncKey() {
		return funcKey;
	}

	public void setFuncKey(String funcKey) {
		this.funcKey = funcKey;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public String getFuncType() {
		return funcType;
	}

	public void setFuncType(String funcType) {
		this.funcType = funcType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "SysFunc [aiid=" + aiid + ", funcKey=" + funcKey + ", funcName="
				+ funcName + ", funcType=" + funcType + ", url=" + url
				+ ", css=" + css + ", parentId=" + parentId + ", description="
				+ description + ", state=" + state + "]";
	}

}
