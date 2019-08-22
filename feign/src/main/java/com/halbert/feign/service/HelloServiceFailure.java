package com.halbert.feign.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceFailure implements HelloService {

    @Override
    public String sayHello() {
        System.out.println("hello world service is not available !");
        return "hello world service is not available !";
    }
}
