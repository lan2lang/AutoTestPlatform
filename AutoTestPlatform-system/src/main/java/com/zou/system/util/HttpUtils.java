package com.zou.system.util;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class HttpUtils {

  public static HttpResponse<String> sendGet(String urlStr, String cookieStr) throws Exception {
    HashMap<String, String> hashMap = new HashMap<>();
    hashMap.put("Cookie", cookieStr);
    return sendGet(urlStr, hashMap);
  }

  /**
   * 发生get请求不携带参数，带请求头
   * @param urlStr
   * @param headers
   * @return
   * @throws KeyManagementException
   * @throws NoSuchAlgorithmException
   * @throws IOException
   * @throws InterruptedException
   */
  public static HttpResponse<String> sendGet(String urlStr, Map<String, String> headers)
      throws KeyManagementException, NoSuchAlgorithmException, IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest.Builder reqBuilder = getReqBuilder(urlStr);

    reqBuilder.GET();

    for (String key : headers.keySet()) {
      reqBuilder.header(key, headers.get(key));
    }

    HttpRequest request = reqBuilder.build();
    HttpResponse<String> result = client.send(request, HttpResponse.BodyHandlers.ofString(UTF_8));
    return result;

  }

  private static HttpResponse<String> sendPost(
      String contentType, String urlStr, String bodyStr, String cookieStr) throws Exception {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest.Builder reqBuilder = getReqBuilder(urlStr);

    HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.ofString(bodyStr);

    reqBuilder.header("Content-Type", contentType).POST(bodyPublisher).header("Cookie", cookieStr);

    HttpRequest request = reqBuilder.build();

    HttpResponse<String> result = client.send(request, HttpResponse.BodyHandlers.ofString(UTF_8));

    return result;
  }

  public static HttpResponse<String> sendFormPost(String urlStr, String formStr, String cookieStr)
      throws Exception {
    return sendPost("application/x-www-form-urlencoded;charset=utf-8", urlStr, formStr, cookieStr);
  }

  public static HttpResponse<String> sendJsonPost(String urlStr, String jsonStr, String cookieStr)
      throws Exception {
    return sendPost("application/json;charset=utf-8", urlStr, jsonStr, cookieStr);
  }

  /**
   * 设置地址和用户标识
   * @param urlStr
   * @return
   */
  public static HttpRequest.Builder getReqBuilder(String urlStr) {
    return HttpRequest.newBuilder()
        .uri(URI.create(urlStr))
        .header(
            "User-Agent",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:96.0) Gecko/20100101 Firefox/96.0");
  }
}
