package com.zou.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zou.common.annotation.Excel;
import com.zou.common.core.domain.BaseEntity;

/**
 * 测试结果对象 testresult
 * 
 * @author zou
 * @date 2024-01-28
 */
public class Testresult extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 结果ID */
    private Integer resultId;

    /** 接口名称 */
    @Excel(name = "接口名称")
    private String interName;

    /** 请求地址 */
    @Excel(name = "请求地址")
    private String fullUrl;

    /** 请求方式 */
    @Excel(name = "请求方式")
    private String method;

    /** 参数类型 */
    @Excel(name = "参数类型")
    private String paramType;

    /** 环境名称 */
    @Excel(name = "环境名称")
    private String envirName;

    /** 备注 */
    @Excel(name = "备注")
    private String testComment;

    /** 请求头信息 */
    @Excel(name = "请求头信息")
    private String header;

    /** 请求参数信息 */
    @Excel(name = "请求参数信息")
    private String param;

    /** 响应码 */
    @Excel(name = "响应码")
    private Integer resCode;

    /** 响应内容 */
    @Excel(name = "响应内容")
    private String resBody;

    /** 测试时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "测试时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date testTime;

    /** 用户id */
    private Long userId;

    public void setResultId(Integer resultId) 
    {
        this.resultId = resultId;
    }

    public Integer getResultId() 
    {
        return resultId;
    }
    public void setInterName(String interName) 
    {
        this.interName = interName;
    }

    public String getInterName() 
    {
        return interName;
    }
    public void setFullUrl(String fullUrl) 
    {
        this.fullUrl = fullUrl;
    }

    public String getFullUrl() 
    {
        return fullUrl;
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
    public void setEnvirName(String envirName) 
    {
        this.envirName = envirName;
    }

    public String getEnvirName() 
    {
        return envirName;
    }
    public void setTestComment(String testComment) 
    {
        this.testComment = testComment;
    }

    public String getTestComment() 
    {
        return testComment;
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
    public void setResCode(Integer resCode) 
    {
        this.resCode = resCode;
    }

    public Integer getResCode() 
    {
        return resCode;
    }
    public void setResBody(String resBody) 
    {
        this.resBody = resBody;
    }

    public String getResBody() 
    {
        return resBody;
    }
    public void setTestTime(Date testTime) 
    {
        this.testTime = testTime;
    }

    public Date getTestTime() 
    {
        return testTime;
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
            .append("resultId", getResultId())
            .append("interName", getInterName())
            .append("fullUrl", getFullUrl())
            .append("method", getMethod())
            .append("paramType", getParamType())
            .append("envirName", getEnvirName())
            .append("testComment", getTestComment())
            .append("header", getHeader())
            .append("param", getParam())
            .append("resCode", getResCode())
            .append("resBody", getResBody())
            .append("testTime", getTestTime())
            .append("userId", getUserId())
            .toString();
    }
}
