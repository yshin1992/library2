package com.library.service;

public interface BaseService<T> {
	public Integer insert(T t);

	public Integer delete(T t);

	public T query(T t);

	public Integer update(T t);
}
