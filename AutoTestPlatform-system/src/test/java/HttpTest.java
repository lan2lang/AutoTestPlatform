import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpTest {
  public static void main(String[] args) {
//    HttpRequest request =
//        HttpRequest.newBuilder().uri(URI.create("https://javastack.cn")).GET().build();

    try {
      // 新建客户端
      //      CloseableHttpClient httpClient = HttpClients.createDefault();
      HttpClient httpClient = HttpClient.newHttpClient();

      HttpRequest.Builder httpBuilder = HttpRequest.newBuilder();

      httpBuilder.uri(URI.create("https://javastack.cn"));

      // 新建请求(指定请求方法)
      //      HttpGet httpGet = new HttpGet();
//      httpBuilder.();

//      httpBuilder.DELETE();

      httpBuilder.setHeader("2", "3");
      httpBuilder.setHeader("4", "6");

      HttpRequest httpRequest = httpBuilder.build();


      // 同步
      HttpResponse<String> response =
          httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

      System.out.println(response.body());
      System.out.println(response.statusCode());

      //      new UR
      //      httpGet.setURI();

      // 设置请求地址
      //      URIBuilder uriBuilder = new URIBuilder("https://www.example.com");

    } catch (Exception e) {
      e.printStackTrace();
    }

    //    client.
  }
}
