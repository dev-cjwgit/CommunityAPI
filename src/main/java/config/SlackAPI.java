package config;

import exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class SlackAPI {
    @Resource
    RestTemplate restTemplate;


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public void send(@RequestBody BaseException baseException) {
        try {
            Map<String, Object> request = new HashMap<>();
            request.put("username", "알 수 없는 에러"); //slack bot name
            StringBuilder message = new StringBuilder();
            for (String item : baseException.getErrorMessage()) {
                message.append(item).append("\n");
            }

            StringBuilder trace = new StringBuilder();
            for (String item : baseException.getErrorTrace()) {
                trace.append(item).append("\n");
            }


            request.put("text", message.append(trace).toString()); //전송할 메세지
            request.put("icon_emoji", ":ghost:"); //slack bot image

            HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(request);

            String url = "https://hooks.slack.com/services/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"; //복사한 Webhook URL 입력

            restTemplate.postForObject(url, request, String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
