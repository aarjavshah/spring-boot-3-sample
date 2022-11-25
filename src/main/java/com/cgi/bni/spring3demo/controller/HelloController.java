package com.cgi.bni.spring3demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
@Slf4j
public class HelloController {

    @GetMapping
    public String getMessage(){
        return "Hello Sai!";
    }

}
