package com.ecnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecnu.service.HelloService;

@RestController
public class ConsumerController {

	@Autowired
	HelloService helloservice;
	
	
	@RequestMapping(value="/feign-consumer",method=RequestMethod.GET)
	public String helloConsumer() {
		return helloservice.hello();
	}
}
