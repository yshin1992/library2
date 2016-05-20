package com.library.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.library.dao.BookTypeDao;
import com.library.domain.BookType;
import com.library.service.BookTypeService;

@Service("bookTypeService")
public class BookTypeServiceImpl implements BookTypeService<BookType>
{
    @Resource
    private BookTypeDao<BookType> bookTypeDao;

    @Override
    public Integer insert(BookType t)
    {
        return bookTypeDao.insert(t);
    }

    @Override
    public Integer delete(BookType t)
    {
        return bookTypeDao.delete(t);
    }

    @Override
    public BookType query(BookType t)
    {
        return bookTypeDao.query(t);
    }

    @Override
    public Integer update(BookType t)
    {
        return bookTypeDao.update(t);
    }

    @Override
    public List<BookType> queryAll()
    {
        return bookTypeDao.queryAll();
    }

    @Override
    public Integer getMaxId()
    {
        return bookTypeDao.getMaxId();
    }

    @Override
    public Integer batchDelete(String[] PKs)
    {
        return bookTypeDao.batchDelete(PKs);
    }

}
