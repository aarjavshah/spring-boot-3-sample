package com.cgi.bni.spring3demo.servicecall;

import com.cgi.bni.spring3demo.exception.ActivityServiceTechnicalException;
import com.cgi.bni.spring3demo.model.Activity;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityClient activityClient;

    @Observed(name = "activity.service", contextualName = "activity-service", lowCardinalityKeyValues = {"action", "activityService"})
    public Activity getBtcRate() {
        var bitcoinPriceResponseOptional = activityClient.getRandomActivity().blockOptional();
        return bitcoinPriceResponseOptional.map(response -> Activity.builder()
                .name(response.getActivity())
                .price(response.getPrice()).build()).orElseThrow(ActivityServiceTechnicalException::new);
    }

}
