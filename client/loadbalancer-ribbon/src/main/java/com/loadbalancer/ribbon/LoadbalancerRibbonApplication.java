package com.loadbalancer.ribbon;

import com.loadbalancer.ribbon.configs.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.netflix.client.config.IClientConfig"})
@ComponentScan("com.loadbalancer.ribbon.controllers")
@EnableFeignClients
@RibbonClient(name = "chatbook",configuration = RibbonConfiguration.class)
public class LoadbalancerRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadbalancerRibbonApplication.class, args);
	}

}
