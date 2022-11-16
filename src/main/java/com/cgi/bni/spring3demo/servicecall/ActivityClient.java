package com.cgi.bni.spring3demo.servicecall;

import org.springframework.http.MediaType;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;

@HttpExchange(url = "/api", accept = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface ActivityClient {

    @GetExchange(value = "/activity")
    Mono<ActivityServiceResponse> getRandomActivity();
}
