package com.library.listener;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.library.cache.SystemCache;
import com.library.domain.Manager;
import com.library.entity.LoginUserInfo;
import com.library.entity.SystemOperateLog;
import com.library.service.SystemOperateLogService;
import com.library.util.LogUtil;

@WebListener
public class SessionStateListener implements HttpSessionListener,
		HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		LogUtil.getLogger(this).debug(
				"sessionAttributeAdded：" + event.getSession().getId());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		LogUtil.getLogger(this).debug(
				"sessionAttributeRemoved：" + event.getSession().getId());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		LogUtil.getLogger(this).debug(
				"sessionAttributeReplaced：" + event.getSession().getId());
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		LogUtil.getLogger(this)
				.debug("session创建：" + event.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("session销毁:" + event.getSession().getId());
		LoginUserInfo loginUserInfo = SystemCache.getInstance()
				.getLoginUserWithSessionId(event.getSession().getId());
		// 用户超时退出
		if (loginUserInfo != null) {
			SystemCache.getInstance().removeLoginUser(
					event.getSession().getId());
			// 系统操作日志
			SystemOperateLog systemOperateLog = new SystemOperateLog();
			systemOperateLog.setSessionId(event.getSession().getId());
			if (loginUserInfo.getModel() instanceof Manager) {
				Manager manager = (Manager) loginUserInfo.getModel();
				systemOperateLog.setUserId(manager.getManagerID());
			}
			systemOperateLog.setTargetObject("超时退出");
			systemOperateLog.setOperateDate(new Date());
			systemOperateLog.setOperateResult((short) 0);
			WebApplicationContext webCtx = WebApplicationContextUtils
					.getRequiredWebApplicationContext(event.getSession()
							.getServletContext());
			SystemOperateLogService<SystemOperateLog> systemOperateLogService = (SystemOperateLogService<SystemOperateLog>) webCtx
					.getBean("systemOperateLogService");
			systemOperateLogService.insert(systemOperateLog);
		}
	}

}
