package com.loadbalancer.client.controller;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ClientController {

    private final WebClient.Builder loadBalancedWebClientBuilder;
    private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

    public ClientController(WebClient.Builder webClientBuilder,
                           ReactorLoadBalancerExchangeFilterFunction lbFunction) {
        this.loadBalancedWebClientBuilder = webClientBuilder;
        this.lbFunction = lbFunction;
    }

    @GetMapping("/client1")
    public Mono<String> loadBalance_1(){
        return loadBalancedWebClientBuilder.build().get().uri("http://client-balancer/api/instance")
                .retrieve().bodyToMono(String.class)
                .map(item -> String.format("%s",item));
    }

    @GetMapping("/client2")
    public Mono<String> loadBalance_2(){
        return WebClient.builder()
                .filter(lbFunction)
                .build().get().uri("http://client-balancer/api/instance")
                .retrieve().bodyToMono(String.class)
                .map(item -> String.format("%s",item));
    }


}
