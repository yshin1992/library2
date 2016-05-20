package com.library.dao;

import java.util.List;

public interface SysFuncDao<T> extends BaseDao<T> {
	
	public List<T> getSysFuncWithRole(Integer roleId);

	public List<T> getMenuSysFunc();
}
