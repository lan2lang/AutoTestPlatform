package com.zou.system.domain.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 返回给前端的测试报告信息 */
public class TestReportVo {
  /** 成功用例数量 */
  private int successCaseNum;

  /** 失败用例数量 */
  private int failCaseNum;

  /** 用例分布时间集合 */
  private List<HashMap.Entry> caseTimeDistributionList;

  /** 涉及接口数量 */
  private int interSum;

  /** 涉及用例数量 */
  private int caseSum;

  /** 涉及环境数量 */
  private int envirSum;

  /** 用例执行频率 */
  private List<Map.Entry<String, Long>> caseFrequency;

  public List<Map.Entry<String, Long>> getCaseFrequency() {
    return caseFrequency;
  }

  public void setCaseFrequency(List<Map.Entry<String, Long>> caseFrequency) {
    this.caseFrequency = caseFrequency;
  }

  public int getSuccessCaseNum() {
    return successCaseNum;
  }

  public void setSuccessCaseNum(int successCaseNum) {
    this.successCaseNum = successCaseNum;
  }

  public List getCaseTimeDistributionList() {
    return caseTimeDistributionList;
  }

  public void setCaseTimeDistributionList(List caseTimeDistributionList) {
    this.caseTimeDistributionList = caseTimeDistributionList;
  }

  public int getFailCaseNum() {
    return failCaseNum;
  }

  public void setFailCaseNum(int failCaseNum) {
    this.failCaseNum = failCaseNum;
  }

  public int getInterSum() {
    return interSum;
  }

  public void setInterSum(int interSum) {
    this.interSum = interSum;
  }

  public int getCaseSum() {
    return caseSum;
  }

  public void setCaseSum(int caseSum) {
    this.caseSum = caseSum;
  }

  public int getEnvirSum() {
    return envirSum;
  }

  public void setEnvirSum(int envirSum) {
    this.envirSum = envirSum;
  }
}
