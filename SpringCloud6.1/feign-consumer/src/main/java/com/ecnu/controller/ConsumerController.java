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
	
	@RequestMapping(value="/feign-consumer2",method=RequestMethod.GET)
	public String helloConsumer2() {
		StringBuilder sb =new StringBuilder();
		sb.append(helloservice.hello()).append("\n");
		sb.append(helloservice.hellox("DIDI")).append("\n");
		sb.append(helloservice.helloxx("DIDI",30)).append("\n");
		sb.append(helloservice.helloxxx(new User("DIDI",30))).append("\n");
		return sb.toString();
	}
}
