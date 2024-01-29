package com.zou.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zou.common.annotation.Excel;
import com.zou.common.core.domain.BaseEntity;

/**
 * 用例管理对象 caseinfo
 * 
 * @author zou
 * @date 2024-01-28
 */
public class Caseinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用例ID */
    private Long caseId;

    /** 用例名称 */
    @Excel(name = "用例名称")
    private String caseName;

    /** 请求头 */
    @Excel(name = "请求头")
    private String header;

    /** 请求参数 */
    @Excel(name = "请求参数")
    private String param;

    /** 接口id */
    private Long interId;

    /** 描述 */
    @Excel(name = "描述")
    private String caseDesc;

    /** 用户id */
    private Long userId;

    public void setCaseId(Long caseId) 
    {
        this.caseId = caseId;
    }

    public Long getCaseId() 
    {
        return caseId;
    }
    public void setCaseName(String caseName) 
    {
        this.caseName = caseName;
    }

    public String getCaseName() 
    {
        return caseName;
    }
    public void setHeader(String header) 
    {
        this.header = header;
    }

    public String getHeader() 
    {
        return header;
    }
    public void setParam(String param) 
    {
        this.param = param;
    }

    public String getParam() 
    {
        return param;
    }
    public void setInterId(Long interId) 
    {
        this.interId = interId;
    }

    public Long getInterId() 
    {
        return interId;
    }
    public void setCaseDesc(String caseDesc) 
    {
        this.caseDesc = caseDesc;
    }

    public String getCaseDesc() 
    {
        return caseDesc;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("caseId", getCaseId())
            .append("caseName", getCaseName())
            .append("header", getHeader())
            .append("param", getParam())
            .append("interId", getInterId())
            .append("caseDesc", getCaseDesc())
            .append("userId", getUserId())
            .toString();
    }
}
