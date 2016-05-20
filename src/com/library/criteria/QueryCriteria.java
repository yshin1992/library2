package com.library.criteria;

import java.io.Serializable;
import java.util.Map;

public interface QueryCriteria<T>  extends Serializable{
	
	/**
     * 获取模型
     * @return
     */
    public T getModel();

    /**
     * 设置模型
     * @param model
     */
    public void setModel(T model);

    /**
     * 获取符号Map
     * @return
     */
    public Map<String, String> getSymbol();

    /**
     * 设置符号Map
     * @param symbol
     */
    public void setSymbol(Map<String, String> symbol);

    /**
     * 获取排序字段
     * @return
     */
    public String getSort();

    /**
     * 设置排序字段
     * @param sort
     */
    public void setSort(String sort);

    /**
     * 获取排序方向
     * @return
     */
    public String getDir();

    /**
     * 设置排序方向
     * @param dir
     */
    public void setDir(String dir);

    /**
     * 获取查询方式：false精确、true模糊
     * @return
     */
    public Boolean getFuzzy();

    /**
     * 设置查询方式：false精确、true模糊
     * @param fuzzy
     */
    public void setFuzzy(Boolean fuzzy);
	
}
