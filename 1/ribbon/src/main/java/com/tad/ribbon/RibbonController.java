package com.tad.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/health")
public class RibbonController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/ping")
    public String ping() {
        String serviceUrl = "http://ribbon-client/health/ping";
        return restTemplate.getForObject(serviceUrl, String.class);
    }

    @GetMapping("/instance")
    public String instance() {
        String serviceUrl = "http://ribbon-client/health/instance";
        return restTemplate.getForObject(serviceUrl, String.class);
    }
}
