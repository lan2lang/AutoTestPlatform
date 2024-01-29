package com.zou.system.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zou.common.annotation.Excel;
import com.zou.common.core.domain.BaseEntity;

/**
 * 环境对象 environment
 * 
 * @author zou
 * @date 2024-01-28
 */
public class Environment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 环境ID */
    private Long envirId;

    /** 环境名称 */
    @Excel(name = "环境名称")
    private String envirName;

    /** 前置地址 */
    @Excel(name = "前置地址")
    private String envirUrl;

    /** 用户id */
    private Long userId;

    /** 接口管理信息 */
    private List<Interinfo> interinfoList;

    public void setEnvirId(Long envirId) 
    {
        this.envirId = envirId;
    }

    public Long getEnvirId() 
    {
        return envirId;
    }
    public void setEnvirName(String envirName) 
    {
        this.envirName = envirName;
    }

    public String getEnvirName() 
    {
        return envirName;
    }
    public void setEnvirUrl(String envirUrl) 
    {
        this.envirUrl = envirUrl;
    }

    public String getEnvirUrl() 
    {
        return envirUrl;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public List<Interinfo> getInterinfoList()
    {
        return interinfoList;
    }

    public void setInterinfoList(List<Interinfo> interinfoList)
    {
        this.interinfoList = interinfoList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("envirId", getEnvirId())
            .append("envirName", getEnvirName())
            .append("envirUrl", getEnvirUrl())
            .append("userId", getUserId())
            .append("interinfoList", getInterinfoList())
            .toString();
    }
}
