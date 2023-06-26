package com.loadbalancer.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class ServerController {

    @Value("${server.instance.id}")
    private String instanceId;


    @GetMapping("/instance")
    public String demoEndpoint(){
        log.info("inside controller endpoint");
        return String.format("Hello from instance %s", instanceId);
    }
}
