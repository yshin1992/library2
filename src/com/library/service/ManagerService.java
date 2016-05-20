package com.library.service;

import java.util.List;

import com.library.criteria.PaginationQueryCriteria;
import com.library.criteria.QueryCriteria;
import com.library.vo.Pagination;

public interface ManagerService<T> extends BaseService<T> {

	public List<T> queryList(QueryCriteria<T> bean);
	
	public Pagination<T> queryByPage(PaginationQueryCriteria<T> criteria);
	
	public void batchDelete(String[] ids);
	
	public void checkTransaction();
	
	public void updatePhoto(T t);
	
	public T getPhoto(String managerID);
}
