package com.tad.ribbon;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfiguration {
//    Inject Rest template to routing request
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IPing ribbonPing() {
        return new PingUrl(false, "/health/ping");
    }

//    Define strategy to load balance
    @Bean
    public IRule ribbonRule() {
        return new RoundRobinRule();
    }

}