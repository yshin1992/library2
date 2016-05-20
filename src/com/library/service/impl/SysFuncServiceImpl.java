package com.library.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.library.dao.SysFuncDao;
import com.library.entity.SysFunc;
import com.library.service.SysFuncService;

@Service("sysFuncService")
public class SysFuncServiceImpl implements SysFuncService<SysFunc> {
	@Resource
	private SysFuncDao sysFuncDao;

	@Override
	public Integer insert(SysFunc t) {
		return null;
	}

	@Override
	public Integer delete(SysFunc t) {
		return null;
	}

	@Override
	public SysFunc query(SysFunc t) {
		return null;
	}

	@Override
	public Integer update(SysFunc t) {
		return null;
	}

	@Override
	public List<SysFunc> getSysFuncWithRole(Integer roleId) {
		return sysFuncDao.getSysFuncWithRole(roleId);
	}

	@Override
	public List<SysFunc> getMenuSysFunc() {
		// TODO Auto-generated method stub
		return sysFuncDao.getMenuSysFunc();
	}

}
