package com.halbert.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    /**
     * public String getHelloContent() {
     * return restTemplate.getForObject("http://SERVICE-HELLOWORLD/",String.class);
     * }
     **/
    @HystrixCommand(fallbackMethod = "serviceFailure")
    public String getHelloContent() {
        return restTemplate.getForObject("http://SERVICE-HELLOWORLD/", String.class);
    }

    public String serviceFailure() {
        return "hello world service is not available !";
    }
}
