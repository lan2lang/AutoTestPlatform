package com.zou.system.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zou.common.annotation.Excel;
import com.zou.common.core.domain.BaseEntity;

/**
 * 接口管理对象 interinfo
 *
 * @author zou
 * @date 2024-01-28
 */
public class Interinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 接口ID */
    private Long interId;

    /** 接口名称 */
    @Excel(name = "接口名称")
    private String interName;

    /**
     * 环境名称
     */
    private String environmentName;

    /** 接口地址 */
    @Excel(name = "接口地址")
    private String interUrl;

    /** 请求方式 */
    @Excel(name = "请求方式")
    private String method;

    /** 参数类型 */
    @Excel(name = "参数类型")
    private String paramType;

    /** 环境id */
    @Excel(name = "环境id")
    private Long envirId;

    /** 备注 */
    @Excel(name = "备注")
    private String interComment;

    /** 用户id */
    private Long userId;

    /** 用例管理信息 */
    private List<Caseinfo> caseinfoList;

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    public void setInterId(Long interId)
    {
        this.interId = interId;
    }

    public Long getInterId()
    {
        return interId;
    }
    public void setInterName(String interName)
    {
        this.interName = interName;
    }

    public String getInterName()
    {
        return interName;
    }
    public void setInterUrl(String interUrl)
    {
        this.interUrl = interUrl;
    }

    public String getInterUrl()
    {
        return interUrl;
    }
    public void setMethod(String method)
    {
        this.method = method;
    }

    public String getMethod()
    {
        return method;
    }
    public void setParamType(String paramType)
    {
        this.paramType = paramType;
    }

    public String getParamType()
    {
        return paramType;
    }
    public void setEnvirId(Long envirId)
    {
        this.envirId = envirId;
    }

    public Long getEnvirId()
    {
        return envirId;
    }
    public void setInterComment(String interComment)
    {
        this.interComment = interComment;
    }

    public String getInterComment()
    {
        return interComment;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public List<Caseinfo> getCaseinfoList()
    {
        return caseinfoList;
    }

    public void setCaseinfoList(List<Caseinfo> caseinfoList)
    {
        this.caseinfoList = caseinfoList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("interId", getInterId())
            .append("interName", getInterName())
            .append("interUrl", getInterUrl())
            .append("method", getMethod())
            .append("paramType", getParamType())
            .append("envirId", getEnvirId())
            .append("interComment", getInterComment())
            .append("userId", getUserId())
            .append("caseinfoList", getCaseinfoList())
            .toString();
    }
}
