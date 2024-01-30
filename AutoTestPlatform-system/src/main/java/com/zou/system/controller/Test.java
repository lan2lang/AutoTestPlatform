package com.zou.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 访问github并返回给前端
 */
@Controller()
@Api(tags = "test")
@RequestMapping("/test")
public class Test {
  private static String encodeUrl(String url) {
      return URLEncoder.encode(url, StandardCharsets.UTF_8);
  }

  @GetMapping("/1")
  @ApiOperation("test")
  public void test(HttpServletRequest request, HttpServletResponse response)
      throws IOException, InterruptedException {
    // 创建代理对象
    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));

    // 创建自定义的 ProxySelector
    ProxySelector proxySelector =
        new ProxySelector() {
          @Override
          public List<Proxy> select(URI uri) {
            return Collections.singletonList(proxy);
          }

          @Override
          public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
            // 处理连接失败的情况
          }
        };

    HttpClient httpClient = HttpClient.newBuilder().proxy(proxySelector).build();

    HttpRequest request1 =
        HttpRequest.newBuilder()
            .uri(
                URI.create(

                        "https://raw.githubusercontent.com/lan2lang/lsp_pic/master/lsp-db2/P-FXHMRW%40FXHMRW%20(3)"))
            .header(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36")
            .build();

    HttpResponse<byte[]> res = httpClient.send(request1, HttpResponse.BodyHandlers.ofByteArray());

    response.setHeader("Content-Type", "image/jpeg");
    response.getOutputStream().write(res.body());
  }
}
