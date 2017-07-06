package com.ecnu.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecnu.service.HelloService;

@RestController
public class ConsumerController {

	@Autowired
	HelloService helloservice;
	
	
	@RequestMapping(value="/ribbon-consumer",method=RequestMethod.GET)
	public String helloConsumer() {
		return helloservice.helloService();
	}
	
	//自己测试用的
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String helloindex() {
		return "helloworld";
	}
}
