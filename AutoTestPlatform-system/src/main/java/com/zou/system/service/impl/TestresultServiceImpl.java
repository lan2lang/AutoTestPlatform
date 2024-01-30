package com.zou.system.service.impl;

import com.zou.system.domain.Testresult;
import com.zou.system.domain.dto.ParamDto;
import com.zou.system.mapper.TestresultMapper;
import com.zou.system.service.ITestresultService;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    requestBuilder.headers(
        headerList.stream()
            .flatMap(entry -> Stream.of(entry.getParamName(), entry.getValue()))
            .toArray(String[]::new));

    // 执行
    HttpRequest request = requestBuilder.build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    // 解析响应码、响应体
    testresult.setResCode((long) response.statusCode());

    testresult.setResBody(response.body());

    // 查询环境名称

    // 插入测试结果
    return insertTestresult(testresult);
  }
}
