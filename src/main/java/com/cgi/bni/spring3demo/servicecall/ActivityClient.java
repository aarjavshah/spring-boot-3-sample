package com.cgi.bni.spring3demo.servicecall;

import io.micrometer.observation.annotation.Observed;
import org.springframework.http.MediaType;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;

@HttpExchange(url = "/api", accept = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface ActivityClient {

    @GetExchange(value = "/activity")
    @Observed(name = "activity.call", contextualName = "activity-call", lowCardinalityKeyValues = {"action", "ServiceCall"})
    Mono<ActivityServiceResponse> getRandomActivity();
}
