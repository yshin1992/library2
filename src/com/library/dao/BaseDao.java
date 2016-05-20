
package com.library.dao;

public interface BaseDao<T>
{
    public Integer insert(T t);

    public Integer delete(T t);

    public T query(T t);

    public Integer update(T t);

    public Integer queryRecordCount();
}
