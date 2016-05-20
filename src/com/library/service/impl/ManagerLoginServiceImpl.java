package com.library.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.library.cache.SystemCache;
import com.library.domain.Manager;
import com.library.entity.LoginUserInfo;
import com.library.entity.SysFunc;
import com.library.entity.SystemOperateLog;
import com.library.enums.UserType;
import com.library.service.LoginService;
import com.library.service.ManagerService;
import com.library.service.SysFuncService;
import com.library.service.SystemOperateLogService;

@Service("managerLoginService")
public class ManagerLoginServiceImpl implements LoginService<LoginUserInfo> {

	@Resource
	private SysFuncService<SysFunc> sysFuncService;
	
	@Resource
	private ManagerService<Manager> managerService;
	
	@Resource
	private SystemOperateLogService<SystemOperateLog> systemOperateLogService;
	
	@Override
	public LoginUserInfo login(String managerID, String password,
			HttpServletRequest request) {
		
		Manager manager = new Manager();
		manager.setManagerID(managerID);
		manager.setPassword(password);
		manager = managerService.query(manager);
		
		Date loginDate=new Date();
		 //系统操作日志
        SystemOperateLog systemOperateLog = new SystemOperateLog();
        //        getRemoteAddr方法返回发出请求的客户机的IP地址 
        //        getRemoteHost方法返回发出请求的客户机的完整主机名
        //        getRemotePort方法返回客户机所使用的网络端口号
        systemOperateLog.setIp(request.getRemoteAddr());
        systemOperateLog.setSessionId(request.getSession().getId());
        systemOperateLog.setUserId(managerID);
        systemOperateLog.setTargetObject("登录");
        systemOperateLog.setOperateDate(loginDate);
        systemOperateLog.setUrl(request.getRequestURL().toString());
        systemOperateLog.setAcceptLanguage(request.getHeader("Accept-Language"));
        systemOperateLog.setUserAgent(request.getHeader("User-Agent"));
        LoginUserInfo loginUserInfo=null;
		if (null != manager) {
			List<SysFunc> sysFunc=sysFuncService.getSysFuncWithRole(manager.getRoleId());
			loginUserInfo=new LoginUserInfo();
			loginUserInfo.setModel(manager);
			loginUserInfo.setLoginIp(request.getRemoteAddr());
			loginUserInfo.setLoginTime(loginDate);
			loginUserInfo.setSessionId(request.getSession().getId());
			loginUserInfo.setSysFunc(sysFunc);
			loginUserInfo.setUrlFunc(sysFunc);
			loginUserInfo.setUserType(UserType.TEACHER);
			//将当前用户添加到系统缓存
			SystemCache.getInstance().putLoginUserInfo(loginUserInfo);
			
			//0代表登录操作成功
            systemOperateLog.setOperateResult((short) 0);
		}else{
			//1代表登录操作失败
            systemOperateLog.setOperateResult((short) 1);
		}
		systemOperateLogService.insert(systemOperateLog);
		return loginUserInfo;
	}

	@Override
	public void loginout(String targetObject, HttpServletRequest request) {
		String sessionId = request.getSession().getId();
        LoginUserInfo loginUserInfo = SystemCache.getInstance().getLoginUserWithSessionId(sessionId);
        Manager manager = (Manager) loginUserInfo.getModel();
        //系统操作日志
        SystemOperateLog systemOperateLog = new SystemOperateLog();
        //        getRemoteAddr方法返回发出请求的客户机的IP地址 
        //        getRemoteHost方法返回发出请求的客户机的完整主机名
        //        getRemotePort方法返回客户机所使用的网络端口号
        systemOperateLog.setIp(request.getRemoteAddr());
        systemOperateLog.setSessionId(request.getSession().getId());
        systemOperateLog.setUserId(manager.getManagerID());
        systemOperateLog.setTargetObject(targetObject);
        systemOperateLog.setOperateDate(new Date());
        systemOperateLog.setUrl(request.getRequestURL().toString());
        systemOperateLog.setAcceptLanguage(request.getHeader("Accept-Language"));
        systemOperateLog.setUserAgent(request.getHeader("User-Agent"));
        //0代表登录操作成功
        systemOperateLog.setOperateResult((short) 0);
        systemOperateLogService.insert(systemOperateLog);
        //从系统缓存中移除该用户
        SystemCache.getInstance().removeLoginUser(sessionId);
	}

}
