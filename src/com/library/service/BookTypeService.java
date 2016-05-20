package com.library.service;

import java.util.List;

public interface BookTypeService<T> extends BaseService<T>
{
    public List<T> queryAll();
    
    public Integer getMaxId();
    
    public Integer batchDelete(String[] PKs);
}
