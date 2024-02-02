package com.zou.system.controller;

import com.zou.common.core.domain.AjaxResult;
import com.zou.common.utils.SecurityUtils;
import com.zou.system.domain.Testresult;
import com.zou.system.service.ITestresultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zou.system.domain.vo.Record;
@RestController()
public class TestReportController {
  @Autowired
  private ITestresultService testresultService;
  /**
   * 生成测试报告
   *
   * @return
   */
  @GetMapping("/report")
  public AjaxResult report(Testresult testresult) {
    // 设置用户id
    testresult.setUserId(SecurityUtils.getUserId());

    return AjaxResult.success(testresultService.selectTestReport(testresult));
  }

  @GetMapping("/list")
  public AjaxResult test(Testresult testresult) {
    // 设置用户id
    testresult.setUserId(SecurityUtils.getUserId());

    return AjaxResult.success(testresultService.selectTestReport(testresult));
  }
}
