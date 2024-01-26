import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

public class TestLogin {
  public static void main(String[] args) {

    String environmentUrl = "http://127.0.0.1:8089";
    String apiUrl = "/admin/employee/login";
    //        String
    // token="eyJhbGciOiJIUzI1NiJ9.eyJlbXBJZCI6MSwiZXhwIjoxNzA2MjU3NzUxfQ.grT0F8x5cG3PvXWIPJvFB5IVpGJIqVWNh0efO0qyQ4c";

    try {
      // 使用URIBuilder构建带有参数的URI
      URI uri = new URIBuilder(environmentUrl + apiUrl).build();

      // 创建一个HttpClient实例
      HttpClient httpClient = HttpClients.createDefault();

      // 创建HttpPost请求实例，指定请求的URI
      HttpPost httpPost = new HttpPost(uri);

      httpPost.setHeader("Content-Type", "application/json");

      // 添加请求体内容
      String requestBody = "{\"username\": \"admin\", \"password\": \"123456\"}";

      httpPost.setEntity(new StringEntity(requestBody, "UTF-8"));

      // 执行请求并获取响应
      HttpResponse response = httpClient.execute(httpPost);

      // 从响应中读取内容
      BufferedReader reader =
          new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
      StringBuilder result = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        result.append(line);
      }

      // 输出响应的状态码和内容
      System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
      System.out.println("Response Body: " + result.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
