package com.library.service;

import javax.servlet.http.HttpServletRequest;

public interface LoginService<T> {
	public T login(String userName,String password,HttpServletRequest request);
	public void loginout(String targetObject,HttpServletRequest request);
}
