package com.loadbalancer.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@Slf4j
public class SpringBootLoadbalancerClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootLoadbalancerClientApplication.class, args);
/*		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(SpringBootLoadbalancerClientApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);

		WebClient loadBalancedClient = ctx.getBean(WebClient.Builder.class).build();

		for(int i = 1; i <= 10; i++) {
			String response =
					loadBalancedClient.get().uri("http://client-balancer/api/instance")
							.retrieve().toEntity(String.class)
							.block().getBody();
			log.info(response);
		}*/
	}

}
