package com.zou.system.service.impl;

import com.zou.system.domain.Testresult;
import com.zou.system.domain.dto.ParamDto;
import com.zou.system.domain.vo.TestReportVo;
import com.zou.system.mapper.TestresultMapper;
import com.zou.system.service.ITestresultService;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试结果Service业务层处理
 *
 * @author zou
 * @date 2024-01-30
 */
@Service
public class TestresultServiceImpl implements ITestresultService {
  @Autowired private TestresultMapper testresultMapper;

  /**
   * 生成测试报告
   *
   * @param testresult
   * @return
   */
  @Override
  public TestReportVo selectTestReport(Testresult testresult) {
    // 查询要生成报告的数据
    List<Testresult> testresults = selectTestresultList(testresult);
    TestReportVo testReportVo = new TestReportVo();

    //        byStream(testresults, testReportVo);
    byFor(testresults, testReportVo);

    return testReportVo;
  }

  /**
   * 使用for循环进行数据处理
   *
   * @param testresults
   * @param testReportVo
   */
  private void byFor(List<Testresult> testresults, TestReportVo testReportVo) {
    Set<String> uniqueInterNames = new HashSet<>();
    Set<String> uniqueCaseNames = new HashSet<>();
    Set<String> uniqueEnvirNames = new HashSet<>();
    // 使用 for 循环查询每一天的数据数量
    Map<String, Long> dailyDataCount = new HashMap<>();
    // 查询每个用例执行频率
    Map<String, Long> caseFrequency = new HashMap<>();

    int successNum = 0;
    for (Testresult testresult : testresults) {
      if (testresult.getResCode() == 200) {
        successNum++;
      }
      // 将 Date 转换为 LocalDate,只保留日期
      String date =
          testresult
              .getTestTime()
              .toInstant()
              .atZone(ZoneId.systemDefault())
              .toLocalDate()
              .toString();

      dailyDataCount.put(date, dailyDataCount.getOrDefault(date, 0L) + 1);
      caseFrequency.put(
          testresult.getCaseName(), caseFrequency.getOrDefault(testresult.getCaseName(), 0L) + 1);

      String interName = testresult.getInterName();
      if (interName != null) {
        uniqueInterNames.add(interName);
      }

      String caseName = testresult.getCaseName();
      if (caseName != null) {
        uniqueCaseNames.add(caseName);
      }

      String envirName = testresult.getEnvirName();
      if (envirName != null) {
        uniqueEnvirNames.add(envirName);
      }
    }
    testReportVo.setSuccessCaseNum(successNum);
    // 设置失败用例数
    testReportVo.setFailCaseNum(testresults.size() - successNum);
    testReportVo.setInterSum(uniqueInterNames.size());
    testReportVo.setCaseSum(uniqueCaseNames.size());
    testReportVo.setEnvirSum(uniqueEnvirNames.size());
    testReportVo.setCaseTimeDistributionList(new ArrayList<>(dailyDataCount.entrySet()));
    testReportVo.setCaseFrequency(new ArrayList<>(caseFrequency.entrySet()));
  }

  /**
   * 使用stream流进行数据处理
   *
   * @param testresults
   * @param testReportVo
   */
  private void byStream(List<Testresult> testresults, TestReportVo testReportVo) {
    // 设置成功用例数
    testReportVo.setSuccessCaseNum(
        (int)
            testresults.stream()
                .filter(Objects::nonNull)
                .filter(data -> data.getResCode() == 200)
                .count());

    // 设置失败用例数
    testReportVo.setFailCaseNum(testresults.size() - testReportVo.getSuccessCaseNum());

    // 设置涉及接口数量
    testReportVo.setInterSum(
        (int)
            testresults.stream()
                .map(Testresult::getInterName)
                .filter(Objects::nonNull)
                .distinct()
                .count());
    // 设置涉及用例数量
    testReportVo.setCaseSum(
        (int)
            testresults.stream()
                .map(Testresult::getCaseName)
                .filter(Objects::nonNull)
                .distinct()
                .count());
    // 设置涉及环境数量
    testReportVo.setEnvirSum(
        (int)
            testresults.stream()
                .map(Testresult::getEnvirName)
                .filter(Objects::nonNull)
                .distinct()
                .count());

    // 查询每一天的数据数量
    //    Map<Date, Long> dailyDataCount =
    //        testresults.stream()
    //            .collect(Collectors.groupingBy(Testresult::getTestTime, Collectors.counting()));
    //
    // 查询每个用例执行频率
    //    Map<String, Long> caseFrequency =
    //        testresults.stream()
    //            .collect(Collectors.groupingBy(Testresult::getCaseName, Collectors.counting()));

    //    testReportVo.setCaseTimeDistributionList();
  }

  /**
   * 查询测试结果
   *
   * @param resultId 测试结果主键
   * @return 测试结果
   */
  @Override
  public Testresult selectTestresultByResultId(Long resultId) {
    return testresultMapper.selectTestresultByResultId(resultId);
  }

  /**
   * 查询测试结果列表
   *
   * @param testresult 测试结果
   * @return 测试结果
   */
  @Override
  public List<Testresult> selectTestresultList(Testresult testresult) {
    return testresultMapper.selectTestresultList(testresult);
  }

  /**
   * 新增测试结果
   *
   * @param testresult 测试结果
   * @return 结果
   */
  @Override
  public int insertTestresult(Testresult testresult) {
    return testresultMapper.insertTestresult(testresult);
  }

  /**
   * 修改测试结果
   *
   * @param testresult 测试结果
   * @return 结果
   */
  @Override
  public int updateTestresult(Testresult testresult) {
    return testresultMapper.updateTestresult(testresult);
  }

  /**
   * 批量删除测试结果
   *
   * @param resultIds 需要删除的测试结果主键
   * @return 结果
   */
  @Override
  public int deleteTestresultByResultIds(Long[] resultIds) {
    return testresultMapper.deleteTestresultByResultIds(resultIds);
  }

  /**
   * 删除测试结果信息
   *
   * @param resultId 测试结果主键
   * @return 结果
   */
  @Override
  public int deleteTestresultByResultId(Long resultId) {
    return testresultMapper.deleteTestresultByResultId(resultId);
  }

  /**
   * 执行测试用例
   *
   * @param testresult
   * @return
   */
  @Override
  @Transactional
  public int executeCase(Testresult testresult) throws IOException, InterruptedException {

    // 创建连接
    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder();

    // 设置请求地址
    requestBuilder.uri(URI.create(testresult.getFullUrl()));

    // 请求体
    String requestBody = "";

    // 生成请求体
    switch (testresult.getParamType()) {
      case "URL" -> {
        // 把参数拼接到地址后
        requestBuilder.uri(
            URI.create(
                testresult.getFullUrl()
                    + "?"
                    + testresult.getParamList().stream()
                        .map(entry -> entry.getParamName() + "=" + entry.getValue())
                        .collect(Collectors.joining("&"))));
      }
      case "JSON" -> {
        // 将表单数据转换为 json 格式
        requestBuilder.header("Content-Type", "application/json;charset=utf-8");
        requestBody =
            "{"
                + testresult.getParamList().stream()
                    .map(
                        entry ->
                            "\""
                                + entry.getParamName()
                                + "\""
                                + ":"
                                + "\""
                                + entry.getValue()
                                + "\"")
                    .collect(Collectors.joining(","))
                + "}";
      }
      case "FORM" -> {
        // 将表单数据转换为 x-www-form-urlencoded 格式
        requestBuilder.header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        requestBody =
            testresult.getParamList().stream()
                .map(entry -> entry.getParamName() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));
      }
    }

    // 设置请求方法
    switch (testresult.getMethod()) {
      case "GET" -> {
        requestBuilder.GET();
      }
      case "POST" -> {
        requestBuilder.POST(HttpRequest.BodyPublishers.ofString(requestBody));
      }
      case "PUT" -> {
        requestBuilder.PUT(HttpRequest.BodyPublishers.ofString(requestBody));
      }
      case "DELETE" -> {
        requestBuilder.DELETE();
      }
    }

    // 设置请求头信息
    List<ParamDto> headerList = testresult.getHeaderList();

    if (headerList != null && !headerList.isEmpty()) {
      requestBuilder.headers(
          headerList.stream()
              .flatMap(entry -> Stream.of(entry.getParamName(), entry.getValue()))
              .toArray(String[]::new));
    }
    // 执行
    HttpRequest request = requestBuilder.build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    // 解析响应码、响应体
    testresult.setResCode((long) response.statusCode());

    testresult.setResBody(response.body());

    // 查询环境名称(根据接口id)
    testresult.setEnvirName(testresultMapper.selectEnvirNameByInterId(testresult.getInterId()));

    // 插入测试结果
    return insertTestresult(testresult);
  }
}
