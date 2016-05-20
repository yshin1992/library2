
package com.library.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 图书类别信息实体类
 * 
 * @author YanShuai
 * @version 1.0,2015年7月12日
 * @See
 * @since V1.0
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BookType implements AbstractModel
{
    private static final long serialVersionUID = -4015168832361999057L;

    /**
     * 图书类别ID
     */
    private int id;

    /**
     * 图书类别名称
     */
    private String typeName;

    /**
     * 可借天数
     */
    private int days;

    /**
     * 迟还一天的罚金
     */
    private float fine;

    /**
     * 图书类别的等级
     */
    private int level;

    /**
     * 图书类别的父ID
     */
    private int parentId;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    public int getDays()
    {
        return days;
    }

    public void setDays(int days)
    {
        this.days = days;
    }

    public float getFine()
    {
        return fine;
    }

    public void setFine(float fine)
    {
        this.fine = fine;
    }

    public int getParentId()
    {
        return parentId;
    }

    public void setParentId(int parentId)
    {
        this.parentId = parentId;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    @Override
    public String toString()
    {
        return "BookType [id=" + id + ", typeName=" + typeName + ", days=" + days + ", fine=" + fine + ", level="
                + level + ", parentId=" + parentId + "]";
    }

}