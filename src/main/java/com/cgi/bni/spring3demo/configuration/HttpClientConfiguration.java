package com.cgi.bni.spring3demo.configuration;

import com.cgi.bni.spring3demo.servicecall.ActivityClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpClientConfiguration {
    @Bean
    public ActivityClient coinDeskClient() throws Exception {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://www.boredapi.com/")
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder()
                .clientAdapter(WebClientAdapter.forClient(webClient)).build();
        return factory.createClient(ActivityClient.class);
    }
}
