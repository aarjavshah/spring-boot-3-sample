package com.cgi.bni.spring3demo.servicecall;

import com.cgi.bni.spring3demo.exception.ActivityServiceTechnicalException;
import com.cgi.bni.spring3demo.model.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityClient activityClient;

    public Activity getBtcRate() {
        var bitcoinPriceResponseOptional = activityClient.getRandomActivity().blockOptional();
        return bitcoinPriceResponseOptional.map(response -> Activity.builder()
                .name(response.getActivity())
                .price(response.getPrice()).build()).orElseThrow(ActivityServiceTechnicalException::new);
    }

}
