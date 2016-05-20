package com.library.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.library.dao.SystemOperateLogDao;
import com.library.entity.SystemOperateLog;
import com.library.service.SystemOperateLogService;

@Service("systemOperateLogService")
public class SystemOperateLogServiceImpl implements
		SystemOperateLogService<SystemOperateLog> {

	@Resource
	private SystemOperateLogDao<SystemOperateLog> systemOperateLogDao;

	@Override
	public Integer insert(SystemOperateLog t) {
		return systemOperateLogDao.insert(t);
	}

	@Override
	public Integer delete(SystemOperateLog t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemOperateLog query(SystemOperateLog t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(SystemOperateLog t) {
		// TODO Auto-generated method stub
		return null;
	}

}
