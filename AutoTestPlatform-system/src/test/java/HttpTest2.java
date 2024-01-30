import com.zou.system.domain.Testresult;
import com.zou.system.domain.dto.ParamDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HttpTest2 {

  public static void main(String[] args) {
    //        HttpUtils.sendGet("https://javastack.cn","","json");
    Testresult testresult = new Testresult();
    ParamDto paramDto = new ParamDto();
    ParamDto paramDto2 = new ParamDto();
    paramDto.setParamName("asd");
    paramDto2.setParamName("asd2");

    paramDto.setValue("123");
    paramDto2.setValue("1234");

    ArrayList<ParamDto> list = new ArrayList<>();
    list.add(paramDto);
    list.add(paramDto2);
    testresult.setParamList(list);
    String requestBody =
        testresult.getParamList().stream()
            .map(entry -> entry.getParamName() + "=" + entry.getValue())
            .collect(Collectors.joining("&"));

    String requestBody2 =
        "{"
            + testresult.getParamList().stream()
                .map(
                    entry ->
                        "\"" + entry.getParamName() + "\"" + ":" + "\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","))
            + "}";

    System.out.println(requestBody2);
    System.out.println(requestBody);

    // 定义请求头
    Map<String, String> headersMap =
        Map.of(
            "Content-Type", "application/json",
            "Authorization", "Bearer your_access_token");

    String[] headersArray =
            list.stream()
                    .flatMap(entry -> Stream.of(entry.getParamName(), entry.getValue()))
                    .toArray(String[]::new);

    System.out.println(Arrays.toString(headersArray));
  }
}
