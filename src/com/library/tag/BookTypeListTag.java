package com.library.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class BookTypeListTag extends SimpleTagSupport
{
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
        super.doTag();
    }
    
}
