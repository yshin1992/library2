package com.library.criteria;

/**
 * 分页查询接口类
 * @author admin
 *
 * @param <T>
 */
public interface PaginationQueryCriteria<T> extends QueryCriteria<T> {
	/**
     * 获取当前页数
     * @return
     */
    public Integer getPage();

    /**
     * 设置当前页数
     * @param page
     */
    public void setPage(Integer page);

    /**
     * 获取每页记录数
     * @return
     */
    public Integer getPageSize();

    /**
     * 设置每页记录数
     * @param pageSize
     */
    public void setPageSize(Integer pageSize);
}
