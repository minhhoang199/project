package com.microservices.customer.loadBalance;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient(name = "SECURITY", configuration = MyCustomLoadBalancer.class)
public class SecurityLoadBalancer {

    @Bean
    @LoadBalanced
    public Feign.Builder feignBuilder(){
        return Feign.builder();
    }
}
