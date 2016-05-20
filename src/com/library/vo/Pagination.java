package com.library.vo;

import java.io.Serializable;
import java.util.List;

import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;

import com.library.constants.SysConstants;

public class Pagination<T> implements PaginatedList, Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -5184882621748540437L;

    /**
     * 降序
     */
    public static final String SORT_DESC = "desc";

    /**
     * 升序
     */
    public static final String SORT_ASC = "asc";

    /**
     * 总记录数
     */
    private int fullListSize = 0;

    /**
     * 存放记录的列表
     */
    private List<T> list;

    /**
     * 每页记录数，默认为每页10行
     */
    private int objectsPerPage = SysConstants.DEFAULT_PAGA_SIZE;

    /**
     * 当前页数
     */
    private int pageNumber = 1;

    /**
     * 查询ID（未使用）
     */
    private String searchId;

    /**
     * 排序字段
     */
    private String sortCriterion;

    /**
     * 排序方式，升序还是降序
     */
    private SortOrderEnum sortDirection;

    @Override
    public int getFullListSize()
    {
        return this.fullListSize;
    }

    /**
     * 设置总记录数
     * @param fullListSize
     */
    public void setFullListSize(int fullListSize)
    {
        this.fullListSize = fullListSize;
    }

    @Override
    public List<T> getList()
    {
        return this.list;
    }

    /**
     * 设置记录列表
     * @param list
     */
    public void setList(List<T> list)
    {
        this.list = list;
    }

    @Override
    public int getObjectsPerPage()
    {
        return this.objectsPerPage;
    }

    /**
     * 设置每页记录数
     * @param objectsPerPage
     */
    public void setObjectsPerPage(int objectsPerPage)
    {
        this.objectsPerPage = objectsPerPage;
    }

    @Override
    public int getPageNumber()
    {
        return this.pageNumber;
    }

    /**
     * 设置当前页数
     * @param pageNumber
     */
    public void setPageNumber(int pageNumber)
    {
        this.pageNumber = pageNumber;
    }

    @Override
    public String getSearchId()
    {
        return this.searchId;
    }

    public void setSearchId(String searchId)
    {
        this.searchId = searchId;
    }

    @Override
    public String getSortCriterion()
    {
        return this.sortCriterion;
    }

    /**
     * 设置排序字段
     * @param sortCriterion
     */
    public void setSortCriterion(String sortCriterion)
    {
        this.sortCriterion = sortCriterion;
    }

    @Override
    public SortOrderEnum getSortDirection()
    {
        return this.sortDirection;
    }

    /**
     * 设置排序方向
     * @param sortDirection
     */
    public void setSortDirection(SortOrderEnum sortDirection)
    {
        this.sortDirection = sortDirection;
    }

    /**
     * 设置排序方向
     * @param sortDirection
     */
    public void setSortDirection(String sortDirection)
    {
        if (SORT_DESC.equalsIgnoreCase(sortDirection))
        {
            this.sortDirection = SortOrderEnum.DESCENDING;
        }
        else
        {
            this.sortDirection = SortOrderEnum.ASCENDING;
        }
    }

    /**
     * 获取总页数
     * @return
     */
    public int getTotalPage()
    {
        return ((fullListSize - 1) / objectsPerPage) + 1;
    }

}
