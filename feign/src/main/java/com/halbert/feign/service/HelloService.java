package com.halbert.feign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Primary
//@FeignClient(value = "SERVICE-HELLOWORLD")
@FeignClient(name = "SERVICE-HELLOWORLD", fallback = HelloServiceFailure.class)
public interface HelloService {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String sayHello();
}
