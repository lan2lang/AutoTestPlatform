import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestFormRequest {

    public static void main(String[] args) {
        // 目标URL
        String url = "http://example.com/submit-form";

        // 创建 HttpClient 实例
        HttpClient httpClient = HttpClients.createDefault();

        // 创建 HttpPost 请求
        HttpPost httpPost = new HttpPost(url);

        // 准备表单数据
        List<NameValuePair> formData = new ArrayList<>();
        formData.add(new BasicNameValuePair("name", "John"));
        formData.add(new BasicNameValuePair("age", "25"));

        try {
            // 将表单数据添加到请求体中
            httpPost.setEntity(new UrlEncodedFormEntity(formData));

            // 发送请求并获取响应
            HttpResponse response = httpClient.execute(httpPost);

            // 处理响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            StringBuilder responseContent = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }

            // 输出响应内容
            System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
            System.out.println("Response Content: " + responseContent.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
