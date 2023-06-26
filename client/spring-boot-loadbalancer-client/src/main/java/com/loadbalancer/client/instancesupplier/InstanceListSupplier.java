package com.loadbalancer.client.instancesupplier;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Component
public class InstanceListSupplier implements ServiceInstanceListSupplier {

    private String serviceId;

   /* public InstanceListSupplier() {
    }

    public InstanceListSupplier(String serviceId) {
        this.serviceId = serviceId;
    }*/

    @Override
    public String getServiceId() {
        return this.serviceId;
    }

    @Override
    public Flux<List<ServiceInstance>> get() {
        return Flux.just(Arrays
                .asList(new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8082, false),
                        new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8083, false)));
    }
}
