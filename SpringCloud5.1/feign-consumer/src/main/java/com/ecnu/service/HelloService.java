package com.ecnu.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("hello-service1")
public interface HelloService {

	@RequestMapping("/hello")
	String hello();
}
