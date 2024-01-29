package com.zou.system.domain;

import com.zou.system.domain.dto.ParamDto;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zou.common.annotation.Excel;
import com.zou.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 用例管理对象 caseinfo
 *
 * @author zou
 * @date 2024-01-28
 */
public class Caseinfo extends BaseEntity {
  private static final long serialVersionUID = 1L;

  /** 用例ID */
  private Long caseId;

  /** 用例名称 */
  @Excel(name = "用例名称")
  private String caseName;

  /** 接口名称 */
  private String interName;

  /** 接口地址 */
  private String interUrl;

  /** 完整地址 */
  private String fullUrl;

  /** 请求头 */
  @Excel(name = "请求头")
  private String header;

  /** 请求头列表 */
  private List<ParamDto> headerList;

  /** 请求参数列表 */
  private List<ParamDto> paramList;

  /** 请求参数 */
  @Excel(name = "请求参数")
  private String param;

  /** 接口id */
  private Long interId;

  /** 请求方法 */
  private String method;

  /** 参数类型 */
  private String paramType;

  /** 描述 */
  @Excel(name = "描述")
  private String caseDesc;

  /** 用户id */
  private Long userId;

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

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getParamType() {
    return paramType;
  }

  public void setParamType(String paramType) {
    this.paramType = paramType;
  }

  public String getFullUrl() {
    return fullUrl;
  }

  public void setFullUrl(String fullUrl) {
    this.fullUrl = fullUrl;
  }

  public String getInterName() {
    return interName;
  }

  public void setInterName(String interName) {
    this.interName = interName;
  }

  public String getInterUrl() {
    return interUrl;
  }

  public void setInterUrl(String interUrl) {
    this.interUrl = interUrl;
  }

  public Long getCaseId() {
    return caseId;
  }

  public void setCaseId(Long caseId) {
    this.caseId = caseId;
  }

  public String getCaseName() {
    return caseName;
  }

  public void setCaseName(String caseName) {
    this.caseName = caseName;
  }

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public String getParam() {
    return param;
  }

  public void setParam(String param) {
    this.param = param;
  }

  public Long getInterId() {
    return interId;
  }

  public void setInterId(Long interId) {
    this.interId = interId;
  }

  public String getCaseDesc() {
    return caseDesc;
  }

  public void setCaseDesc(String caseDesc) {
    this.caseDesc = caseDesc;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
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
