package com.library.dao;

import java.util.List;

public interface BookTypeDao<T> extends BaseDao<T>
{
    public List<T> queryAll();
    
    public Integer getMaxId();
    
    public Integer batchDelete(String[] PKs);
}
