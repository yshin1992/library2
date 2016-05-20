package com.library.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.library.cache.SystemCache;
import com.library.entity.SysFunc;
import com.library.service.SysFuncService;
import com.library.util.LogUtil;

@WebListener
public class ContextInitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		LogUtil.getLogger(this)
				.debug("........................contextDestroyed........................");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		LogUtil.getLogger(this).debug(
				"........................系统开始启动........................");
		LogUtil.getLogger(this).debug(
				"........................开始加载缓存........................");
		WebApplicationContext webCtx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(event.getServletContext());
		SysFuncService<SysFunc> sysFuncService = (SysFuncService<SysFunc>) webCtx
				.getBean("sysFuncService");
		List<SysFunc> sysFuncs = sysFuncService.getMenuSysFunc();
		if (null != sysFuncs && sysFuncs.size() > 0) {
			Map<Integer, SysFunc> sysFuncMap = new HashMap<Integer, SysFunc>();
			for (SysFunc sysFunc : sysFuncs) {
				sysFuncMap.put(sysFunc.getAiid(), sysFunc);
			}
			SystemCache.getInstance().setSysFuncMap(sysFuncMap);
		}
		LogUtil.getLogger(this).debug(
				"........................加载缓存结束........................");
	}

}
