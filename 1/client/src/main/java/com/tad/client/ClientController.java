package com.tad.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationPid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/health")
public class ClientController {


    @GetMapping("/ping")
    public String ping() {
        return "alive";
    }

    @GetMapping("/instance")
    public String instance() {
        return "Instance running with PID " + new ApplicationPid().toString();
    }
}
