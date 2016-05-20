
package com.library.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.domain.BookType;
import com.library.service.BookTypeService;

@Controller
@RequestMapping(value = "/manager")
public class BookTypeController
{
    @Resource
    private BookTypeService<BookType> bookTypeService;

    @RequestMapping(value = "/booktype.html")
    public String getBookTypeJsp(HttpServletRequest request)
    {
        List<BookType> bookTypeList=bookTypeService.queryAll();
        JSONArray json=JSONArray.fromObject(bookTypeList);
        request.setAttribute("btTree", json);
        return "booktype/booktype";
    }
}
