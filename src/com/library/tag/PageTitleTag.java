package com.library.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.library.constants.SysConstants;
import com.library.entity.LoginUserInfo;
import com.library.entity.SysFunc;

public class PageTitleTag extends SimpleTagSupport {

	/**
	 * css样式
	 */
	private String cssClass;

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	@Override
	public void doTag() throws JspException, IOException {
		StringBuilder titleBuilder = new StringBuilder("<h1 class='" + cssClass
				+ "'>");
		PageContext pageCtx = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageCtx.getRequest();
		LoginUserInfo loginUserInfo = (LoginUserInfo) request.getSession()
				.getAttribute(SysConstants.SESSION_KEY_LOGIN_USER_INFO);
		SysFunc sysFunc = loginUserInfo.getUrlFunc().get(
				request.getAttribute(SysConstants.ACCESS_URL));
		if (sysFunc != null) {
			titleBuilder.append(sysFunc.getFuncName());
		}
		titleBuilder.append("</h1>");
		getJspContext().getOut().println(titleBuilder);
		getJspContext().getOut().flush();
	}

}
