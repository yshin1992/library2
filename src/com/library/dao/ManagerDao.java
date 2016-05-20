package com.library.dao;

import java.util.List;

import com.library.criteria.QueryCriteria;
import com.library.domain.Manager;

public interface ManagerDao<T> extends BaseDao<T> {
	
	public List<T> queryList(QueryCriteria<Manager> bean);
	
	public void batchDelete(String[] ids);
	
	public void updatePhoto(T t);
	
	public T getPhoto(String managerID);
	
}
