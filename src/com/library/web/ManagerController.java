
package com.library.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.library.cache.SystemCache;
import com.library.criteria.ManagerQueryCriteria;
import com.library.criteria.QueryCriteria;
import com.library.domain.Manager;
import com.library.entity.LoginUserInfo;
import com.library.enums.SearchType;
import com.library.service.ManagerService;
import com.library.util.LogUtil;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController
{

    @Resource
    private ManagerService<Manager> managerService;

    @RequestMapping(value = "/head.html")
    public String getHeadJsp()
    {
        return "common/head";
    }

    @RequestMapping(value = "/main.html")
    public String getMainJsp()
    {
        return "common/main";
    }

    @RequestMapping(value = "/menu.html")
    public String getMenuJsp()
    {
        return "common/menu";
    }

    @RequestMapping(value = "/managerinfo.html")
    public String getMgrInfoJsp()
    {
        return "manager/managerinfo";
    }

    @RequestMapping(value = "/updatemgrinfo.html")
    public String getUpdateMgrInfoJsp()
    {
        return "manager/updatemgrinfo";
    }

    @RequestMapping(value = "/updateMgrCmt.html")
    public String updateMgrInfo(Manager manager , HttpServletRequest request)
    {
        //如果更新信息成功，则将缓存中的manager信息更新
        if (managerService.update(manager) == 1)
        {
            LoginUserInfo loginUserInfo = SystemCache.getInstance().getLoginUserWithSessionId(
                    request.getSession().getId());
            Manager tmp = (Manager) loginUserInfo.getModel();
            manager.setRoleId(tmp.getRoleId());
            manager.setStatus(tmp.getStatus());
            //更新缓存中的manager信息
            loginUserInfo.setModel(manager);
        }
        return "manager/managerinfo";
    }

    @RequestMapping(value = "/addmanager.html")
    public String getAddMgrJsp()
    {
        return "manager/addmanager";
    }

    @RequestMapping(value = "/addMgrCmt.html")
    public String addMgrCmt(Manager manager , HttpServletRequest request)
    {
        String managerID = manager.getManagerID();
        try
        {
            //管理员的初始化密码为身份证的后六位
            manager.setPassword(managerID.substring(managerID.length() - 6));
            managerService.insert(manager);
            //通过查询验证新增管理员是否成功
            manager = managerService.query(manager);
            if (null != manager)
            {
                request.setAttribute("addUser", manager);
                return "manager/addmanagercmt";
            }
        }
        catch (Exception e)
        {
            request.setAttribute("addMgrError", "新增管理员失败!");
            return "manager/addmanager";
        }
        return "manager/addmanager";
    }

    @RequestMapping(value = "/delmanager.html")
    public String getDelMgrJsp(HttpServletRequest request , Manager model)
    {
        QueryCriteria<Manager> criteria = new ManagerQueryCriteria(model);
        String searchType = request.getParameter("searchType");
        if (SearchType.PRECISE.equals(searchType))
        {
            criteria.setFuzzy(false);
        }
        else if (SearchType.FUZZY.equals(searchType))
        {
            criteria.setFuzzy(true);
        }
        List<Manager> mgrList = managerService.queryList(criteria);
        request.setAttribute("mgrList", mgrList);
        request.setAttribute("searchType", searchType);
        return "manager/delmanager";
    }

    @RequestMapping(value = "/delMgrCmt.html")
    public String delMgrCmt(HttpServletRequest request)
    {
        String[] ids = request.getParameterValues("ids");
        if (ids != null)
        {
            managerService.batchDelete(ids);
        }
        List<Manager> mgrList = managerService.queryList(new ManagerQueryCriteria());
        request.setAttribute("mgrList", mgrList);
        return "manager/delmanager";
    }

    @RequestMapping(value = "/querymanager.html")
    public String getMgrListJsp(HttpServletRequest request , Manager model)
    {
        QueryCriteria<Manager> criteria = new ManagerQueryCriteria(model);
        String searchType = request.getParameter("searchType");
        if (SearchType.PRECISE.equals(searchType))
        {
            criteria.setFuzzy(false);
        }
        else if (SearchType.FUZZY.equals(searchType))
        {
            criteria.setFuzzy(true);
        }
        List<Manager> mgrList = managerService.queryList(criteria);
        request.setAttribute("mgrList", mgrList);
        request.setAttribute("searchType", searchType);
        return "manager/managerlist";
    }

    @RequestMapping(value = "/upload.html")
    public String getUploadJsp()
    {
        return "manager/uploadphoto";
    }

    @RequestMapping(value = "/uploadCmt.html")
    public String uploadCmt(@RequestParam("photo") MultipartFile photo , HttpServletRequest request)
    {
        if (!photo.isEmpty())
        {
            try
            {
                LoginUserInfo loginUserInfo = SystemCache.getInstance().getLoginUserWithSessionId(
                        request.getSession().getId());
                Manager manager = (Manager) loginUserInfo.getModel();
                byte[] bytes = photo.getBytes();
                manager.setPhoto(bytes);
                managerService.updatePhoto(manager);
                return "manager/managerinfo";
            }
            catch (IOException e)
            {
                LogUtil.getLogger(this).warn("上传头像失败!", e);
            }
        }
        return "manager/upload";
    }

    @RequestMapping(value = "/showPhoto.do")
    public void showPhoto(@RequestParam("managerID") String managerID , HttpServletResponse response)
    {
        Manager manager = managerService.getPhoto(managerID);
        OutputStream out = null;
        try
        {
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            out = response.getOutputStream();
            out.write(manager.getPhoto());
            out.flush();
        }
        catch (IOException e)
        {
            LogUtil.getLogger(this).warn("显示头像失败!", e);
        }
        finally
        {
            try
            {
                if (null != out)
                {
                    out.close();
                    out = null;
                }
            }
            catch (Exception ex)
            {
                LogUtil.getLogger(this).warn("关闭ServletOutputStream异常：", ex);
            }
        }
    }
}
