
package com.library.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.library.cache.SystemCache;
import com.library.constants.SysConstants;
import com.library.entity.LoginUserInfo;
import com.library.entity.SysFunc;

public class NavigationTag extends SimpleTagSupport
{
    /**
     * css样式
     */
    private String cssClass;

    public String getCssClass()
    {
        return cssClass;
    }

    public void setCssClass(String cssClass)
    {
        this.cssClass = cssClass;
    }

    @Override
    public void doTag() throws JspException, IOException
    {
        /**
         * 这里的写法只适用于二级菜单
         */
        StringBuilder navBuilder = new StringBuilder();
        PageContext pageCtx = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageCtx.getRequest();
        LoginUserInfo loginUserInfo = (LoginUserInfo) request.getSession().getAttribute(
                SysConstants.SESSION_KEY_LOGIN_USER_INFO);
        SysFunc sysFunc = loginUserInfo.getUrlFunc().get(request.getAttribute(SysConstants.ACCESS_URL));
        if (sysFunc != null)
        {
        	if("Button".equals(sysFunc.getFuncType())){
        		navBuilder.append(">> ").append(sysFunc.getFuncName());
        		List<SysFunc> sysFuncs=loginUserInfo.getSysFunc();
        		for(SysFunc tmp:sysFuncs){
        			if(tmp.getAiid()==sysFunc.getParentId()){
        				sysFunc=tmp;
        				break;
        			}
        		}
        	}
            navBuilder.insert(0,sysFunc.getFuncName()).insert(0,">> ").insert(0,SystemCache.getInstance().getSysFuncMap().get(sysFunc.getParentId()).getFuncName());
        }
        navBuilder.insert(0, "<div class='"+cssClass+"'>您的当前位置:");
        navBuilder.append("</div>").append("<hr/>");
        getJspContext().getOut().println(navBuilder);
        getJspContext().getOut().flush();
    }
}
