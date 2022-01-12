package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.dto.SlackDTO;
import exception.BaseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class SlackSender {
    /**
     */
    @Resource
    private RestTemplate restTemplate;

        @Value("${slack_webhook_url}")
    private String webhook_url;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

    public void send(@RequestBody SlackDTO slack) {
        try {
            restTemplate.postForObject(webhook_url, new ObjectMapper().writeValueAsString(slack), String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
