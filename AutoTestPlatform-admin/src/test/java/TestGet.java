import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 测试get请求
 */
public class TestGet {

    public static void main(String[] args) {
        String environmentUrl="http://127.0.0.1:8089";
        String apiUrl = "/admin/employee/page";

        try {
            // 创建 URL 对象
            URL url = new URL(environmentUrl+apiUrl);

            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置请求方法
            connection.setRequestMethod("GET");

//            connection.set

            // 获取响应代码
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 读取响应内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // 打印响应内容
            System.out.println("Response: " + response.toString());

            // 关闭连接
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
