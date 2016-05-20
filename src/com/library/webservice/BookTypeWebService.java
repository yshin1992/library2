
package com.library.webservice;

import javax.annotation.Resource;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.library.domain.BookType;
import com.library.service.BookTypeService;
import com.library.util.LogUtil;
import com.library.util.StringUtil;

import static com.library.constants.WebServiceConstants.BOOK_TYPE;
import static com.library.constants.WebServiceConstants.BOOK_TYPE_UPDATE;
import static com.library.constants.WebServiceConstants.QUERY_BY_PK;
import static com.library.constants.WebServiceConstants.BOOK_TYPE_MAX_ID;
import static com.library.constants.WebServiceConstants.BOOK_TYPE_ADD;
import static com.library.constants.WebServiceConstants.BOOK_TYPE_DELETE;

@Service
@Path(BOOK_TYPE)
public class BookTypeWebService
{
    @Resource
    private BookTypeService<BookType> bookTypeService;

    @POST
    @Path(QUERY_BY_PK)
    @Produces(MediaType.APPLICATION_JSON)
    public BookType getBookTypeByPk(@FormParam("id") String id)
    {
        BookType bookType = null;
        try
        {
            if (!StringUtil.isEmpty(id))
            {
                bookType = new BookType();
                bookType.setId(Integer.parseInt(id));
                bookType = bookTypeService.query(bookType);
            }
        }
        catch (Exception e)
        {
            LogUtil.getLogger(this).warn("查询书籍类别信息失败!", e);
        }
        return bookType;
    }

    @PUT
    @Path(BOOK_TYPE_UPDATE)
    public Response updateBookType(@FormParam("id") String id , @FormParam("typeName") String typeName ,
            @FormParam("days") String days , @FormParam("fine") String fine)
    {
        if (!StringUtil.isEmpty(id, typeName, days, fine))
        {
            BookType bookType = new BookType();
            try
            {
                bookType.setId(Integer.parseInt(id));
                bookType.setTypeName(typeName);
                bookType.setDays(Integer.parseInt(days));
                bookType.setFine(Float.parseFloat(fine));
                bookTypeService.update(bookType);
                return Response.ok().build();
            }
            catch (Exception e)
            {
                LogUtil.getLogger(this).warn("更新书籍类别信息失败!", e);
            }
        }
        return Response.serverError().build();
    }

    @GET
    @Path(BOOK_TYPE_MAX_ID)
    public String getMaxId()
    {
        return String.valueOf(bookTypeService.getMaxId());
    }

    @POST
    @Path(BOOK_TYPE_ADD)
    public String addBookType(@FormParam("typeName") String typeName , @FormParam("days") String days ,
            @FormParam("fine") String fine , @FormParam("level") String level , @FormParam("parentId") String parentId)
    {
        if (!StringUtil.isEmpty(typeName, days, fine, level, parentId))
        {
            BookType bookType = new BookType();
            try
            {
                bookType.setTypeName(typeName);
                bookType.setDays(Integer.parseInt(days));
                bookType.setFine(Float.parseFloat(fine));
                bookType.setLevel(Integer.parseInt(level));
                bookType.setParentId(Integer.parseInt(parentId));
                bookTypeService.insert(bookType);
                return bookType.getId() + "";
            }
            catch (Exception e)
            {
                LogUtil.getLogger(this).warn("添加书籍类别信息失败!", e);
            }
        }
        return "-1";
    }

    @DELETE
    @Path(BOOK_TYPE_DELETE)
    public Response delete(@FormParam("ids") String ids)
    {
        if (!StringUtil.isEmpty(ids))
        {
            String[] idArray = ids.split(",");
            try
            {
                bookTypeService.batchDelete(idArray);
                return Response.ok().build();
            }
            catch (Exception e)
            {
                LogUtil.getLogger(this).warn("删除图书类别失败", e);
            }
        }
        return Response.serverError().build();
    }

}
