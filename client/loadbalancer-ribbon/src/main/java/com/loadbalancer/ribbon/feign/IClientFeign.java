package com.loadbalancer.ribbon.feign;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(url = "http://chatbook",name = "DEMO-SERVER")
public interface IClientFeign {

    @LoadBalanced
    @GetMapping("/api/instance")
    String demoEndpoint();

}
