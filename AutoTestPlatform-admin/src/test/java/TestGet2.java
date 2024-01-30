import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * 查询员工列表接口
 */
public class TestGet2 {

    public static void main(String[] args) {
        String environmentUrl="http://127.0.0.1:8089";
        String apiUrl = "/admin/employee/page";
        String token="eyJhbGciOiJIUzI1NiJ9.eyJlbXBJZCI6MSwiZXhwIjoxNzA2MjU3NzUxfQ.grT0F8x5cG3PvXWIPJvFB5IVpGJIqVWNh0efO0qyQ4c";

        // 创建一个HttpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            // 使用URIBuilder构建带有参数的URI
            URI uri = new URIBuilder(environmentUrl+apiUrl)
                    .setParameter("pageSize", "2")
                    .setParameter("page", "1")
                    .build();



            // 创建HttpGet请求实例，指定请求的URL
            HttpGet httpGet = new HttpGet(uri);
            HttpPut httpPut = new HttpPut(uri);

//            httpPut.seE
//            httpGet.setE

            httpGet.setHeader("token",token);
            // 执行请求并获取响应
            CloseableHttpResponse response = httpClient.execute(httpGet);

            // 从响应中读取内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            // 输出响应的状态码和内容
            System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
            System.out.println("Response Body: " + result.toString());
//            response
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
//            httpClient.
        }
    }
}
