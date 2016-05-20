
package com.library.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.library.constants.SysConstants;
import com.library.domain.Manager;
import com.library.entity.LoginUserInfo;
import com.library.entity.SysFunc;
import com.library.service.SysFuncService;

public class MenuTreeTag extends SimpleTagSupport
{
    //带有属性的标签必须有get,set方法
    private String imgUrl;

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }
    
    private static SysFuncService<SysFunc> sysFuncService;

    @Override
    public void doTag() throws JspException, IOException
    {
    	PageContext pageCtx = (PageContext) getJspContext();
    	HttpServletRequest request = (HttpServletRequest) pageCtx.getRequest();
    	LoginUserInfo loginUserInfo=(LoginUserInfo) request.getSession().getAttribute(SysConstants.SESSION_KEY_LOGIN_USER_INFO);
    	WebApplicationContext ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(pageCtx.getServletContext());
    	if(null==sysFuncService){
    		sysFuncService=ctx.getBean("sysFuncService",SysFuncService.class);
    	}
    	List<SysFunc> menuList=new ArrayList<SysFunc>();
    	List<SysFunc> sysFuncList=sysFuncService.getSysFuncWithRole(((Manager)loginUserInfo.getModel()).getRoleId());
    	for(Iterator<SysFunc> iter=sysFuncList.iterator();iter.hasNext();){
    		SysFunc temp=iter.next();
    		if(temp.getParentId()==0&&"Menu".equals(temp.getFuncType())){
    			menuList.add(temp);
    			iter.remove();
    		}else if("Button".equals(temp.getFuncType())){
    			iter.remove();
    		}
    	}
    	
    	/**
    	 * 将菜单拼装出来
    	 */
        StringBuilder menuBuilder=new StringBuilder("<div class='container'><div class='leftsidebar_box'><div class='line'></div>");
        for(int i=0;i<menuList.size();i++){
        	SysFunc sysFunc=menuList.get(i);
        	menuBuilder.append("<dl class='").append(sysFunc.getCss()).append("'><dt>")
        			.append(sysFunc.getFuncName()).append("<img src='").append(imgUrl).append("'></dt>");
        	boolean isFirstItem=true;
        	for(Iterator<SysFunc> iter=sysFuncList.iterator();iter.hasNext();){
        		SysFunc temp=iter.next();
        		if(temp.getParentId()==sysFunc.getAiid()&&"MenuItem".equals(temp.getFuncType())){
        			menuBuilder.append("<dd ");
        			if(isFirstItem){
        				isFirstItem=false;
        				menuBuilder.append("class='first_dd' ");
        			}
        			menuBuilder.append("><a href='").append(temp.getUrl()).append("' target='main'>").append(temp.getFuncName()).append("</a></dd>");
        			iter.remove();
        		}
        	}
        	menuBuilder.append("</dl>");
        }
        menuBuilder.append("</div></div>");
        getJspContext().getOut().println(menuBuilder);
        getJspContext().getOut().flush();
    }

}
