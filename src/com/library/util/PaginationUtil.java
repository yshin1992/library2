package com.library.util;

import com.library.constants.SysConstants;


public class PaginationUtil
{
    /**
     * 获取每页记录数，如果传入的参数为空，或者小于等于0，则返回默认大小10
     * @param pageSize
     * @return
     */
    public static int getPageSize(Integer pageSize)
    {
        int size = SysConstants.DEFAULT_PAGA_SIZE;
        if ((null != pageSize) && (0 < pageSize.intValue()))
        {
            size = pageSize.intValue();
        }
        return size;
    }

    /**
     * 获取当前页数，如果传入的参数为空，或者小于等于0，则返回1
     * @param curPage
     * @return
     */
    public static int getCurPage(Integer curPage)
    {
        if ((null != curPage) && (0 < curPage.intValue()))
        {
            return curPage.intValue();
        }
        else
        {
            return 1;
        }
    }

    /**
     * 分页查询时，获取Skip记录数
     * @param curPage
     * @param pageSize
     * @param fullSize
     * @return
     */
    public static int getSkipNum(Integer curPage , Integer pageSize , Integer fullSize)
    {
        int page = getCurPage(curPage);
        int size = getPageSize(pageSize);
        int maxSize = getCountResultInt(fullSize);
        int totalPage = countTotalPage(maxSize, size);
        if (totalPage < page)
        {
            page = totalPage;
        }
        int skip = (page - 1) * size;
        return skip;
    }

    /**
     * 分页查询时，获取Skip记录数
     * @param curPage
     * @param pageSize
     * @return
     */
    public static int getSkipNum(Integer curPage , Integer pageSize)
    {
        int page = getCurPage(curPage);
        int size = getPageSize(pageSize);
        int skip = (page - 1) * size;
        return skip;
    }

    /**
     * 分页查询时，获取To记录数
     * @param curPage
     * @param pageSize
     * @return
     */
    public static int getToNum(Integer curPage , Integer pageSize)
    {
        int page = getCurPage(curPage);
        int size = getPageSize(pageSize);
        int skip = page * size;
        return skip;
    }

    /**
     * 根据Integer对象获取int数据，如果Integer为null，则返回0
     * @param integer Integer对象
     * @return 如果Integer为null，则返回0，如果不为null，则返回对应的int
     */
    public static int getCountResultInt(Integer integer)
    {
        if (null != integer)
        {
            return integer.intValue();
        }
        else
        {
            return 0;
        }
    }

    public static int countTotalPage(int fullListSize , int pageSize)
    {
        if ((0 == fullListSize) || (0 == pageSize))
        {
            return 0;
        }
        else
        {
            return ((fullListSize - 1) / pageSize) + 1;
        }
    }

    public static int getNewCurPage(int fullListSize , int pageSize , int oldCurPage)
    {
        int totalPage = countTotalPage(fullListSize, pageSize);
        if (oldCurPage > totalPage)
        {
            return totalPage;
        }
        else
        {
            return oldCurPage;
        }
    }

}
