package com.loadbalancer.ribbon.controllers;

import com.loadbalancer.ribbon.feign.IClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RibbonController {

    @Autowired
    private IClientFeign clientFeign;

    @GetMapping("/ribbon")
    public String getString(){
        return this.clientFeign.demoEndpoint();
    }
}
