package com.zou.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zou.common.annotation.Excel;
import com.zou.common.core.domain.BaseEntity;
import com.zou.system.domain.dto.ParamDto;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 测试结果对象 testresult
 *
 * @author zou
 * @date 2024-01-30
 */
@ApiModel(value = "测试结果实体类")
public class Testresult extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 结果ID */
    private Long resultId;

    /** 用例名称 */
    @Excel(name = "用例名称")
    private String caseName;

    /** 接口名称 */
    @Excel(name = "接口名称")
    private String interName;

    /** 接口id（用来查询环境名称） */
    private Long interId;

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

    /** 请求头列表 */
    private List<ParamDto> headerList;

    /** 请求参数列表 */
    private List<ParamDto> paramList;

    /** 请求参数信息 */
    @Excel(name = "请求参数信息")
    private String param;

    /** 响应码 */
    @Excel(name = "响应码")
    private Long resCode;

    /** 响应内容 */
    @Excel(name = "响应内容")
    private String resBody;

    /** 测试时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "测试时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date testTime;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    public Long getInterId() {
        return interId;
    }

    public void setInterId(Long interId) {
        this.interId = interId;
    }

    public List<ParamDto> getHeaderList() {
        return headerList;
    }

    public void setHeaderList(List<ParamDto> headerList) {
        this.headerList = headerList;
    }

    public List<ParamDto> getParamList() {
        return paramList;
    }

    public void setParamList(List<ParamDto> paramList) {
        this.paramList = paramList;
    }

    public Long getResultId()
    {
        return resultId;
    }

    public void setResultId(Long resultId)
    {
        this.resultId = resultId;
    }

    public String getCaseName()
    {
        return caseName;
    }

    public void setCaseName(String caseName)
    {
        this.caseName = caseName;
    }

    public String getInterName()
    {
        return interName;
    }

    public void setInterName(String interName)
    {
        this.interName = interName;
    }

    public String getFullUrl()
    {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl)
    {
        this.fullUrl = fullUrl;
    }

    public String getMethod()
    {
        return method;
    }

    public void setMethod(String method)
    {
        this.method = method;
    }

    public String getParamType()
    {
        return paramType;
    }

    public void setParamType(String paramType)
    {
        this.paramType = paramType;
    }

    public String getEnvirName()
    {
        return envirName;
    }

    public void setEnvirName(String envirName)
    {
        this.envirName = envirName;
    }

    public String getTestComment()
    {
        return testComment;
    }

    public void setTestComment(String testComment)
    {
        this.testComment = testComment;
    }

    public String getHeader()
    {
        return header;
    }

    public void setHeader(String header)
    {
        this.header = header;
    }

    public String getParam()
    {
        return param;
    }

    public void setParam(String param)
    {
        this.param = param;
    }

    public Long getResCode()
    {
        return resCode;
    }

    public void setResCode(Long resCode)
    {
        this.resCode = resCode;
    }

    public String getResBody()
    {
        return resBody;
    }

    public void setResBody(String resBody)
    {
        this.resBody = resBody;
    }

    public Date getTestTime()
    {
        return testTime;
    }

    public void setTestTime(Date testTime)
    {
        this.testTime = testTime;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("resultId", getResultId())
            .append("caseName", getCaseName())
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
