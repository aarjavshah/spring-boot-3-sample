package com.cgi.bni.spring3demo.controller;

import com.cgi.bni.spring3demo.model.Activity;
import com.cgi.bni.spring3demo.servicecall.ActivityService;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping("/activity")
    @Observed(name = "activity.server", contextualName = "activity-call", lowCardinalityKeyValues = {"action", "controller"})
    public Activity getBitcoinPrice() {
        return activityService.getBtcRate();
    }
}
