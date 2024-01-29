package com.zou.system.domain.dto;

/**
 * 用来接收请求头和请求参数
 */
public class ParamDto {
    private String paramName;

    private String value;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
