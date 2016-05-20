
package com.library.criteria;

import java.util.Map;

import com.library.constants.SysConstants;

public abstract class AbstractPaginationQueryCriteria<T> implements PaginationQueryCriteria<T>
{
    private static final long serialVersionUID = -236587936490382180L;

    private Map<String, String> symbol;

    /**
     * 当前页数
     */
    private Integer page = 1;

    /**
     * 每页大小，默认值为10
     */
    private Integer pageSize = SysConstants.DEFAULT_PAGA_SIZE;

    /**
     * 排序字段
     */
    private String sort;

    /**
     * 排序类型，升序为“asc”，降序为“desc”
     */
    private String dir;

    /**
     * 模糊查询
     */
    private Boolean fuzzy = true;

    /**
     * 默认从0开始
     */
    private Integer startIndex = 0;

    /**
     * 默认为pageSize
     */
    private Integer endIndex = pageSize;

    public Map<String, String> getSymbol()
    {
        return symbol;
    }

    public void setSymbol(Map<String, String> symbol)
    {
        this.symbol = symbol;
    }

    public Integer getPage()
    {
        return page;
    }

    public void setPage(Integer page)
    {
        this.page = page;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public String getSort()
    {
        return sort;
    }

    public void setSort(String sort)
    {
        this.sort = sort;
    }

    public String getDir()
    {
        return dir;
    }

    public void setDir(String dir)
    {
        this.dir = dir;
    }

    public Boolean getFuzzy()
    {
        return fuzzy;
    }

    public void setFuzzy(Boolean fuzzy)
    {
        this.fuzzy = fuzzy;
    }

    public Integer getStartIndex()
    {
        return (page - 1) * pageSize;
    }

    public Integer getEndIndex()
    {
        return page * pageSize;
    }

}
