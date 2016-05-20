package com.library.service;

import java.util.List;

public interface SysFuncService<T> extends BaseService<T> {
	public List<T> getSysFuncWithRole(Integer roleId);
	
	public List<T> getMenuSysFunc();
}
