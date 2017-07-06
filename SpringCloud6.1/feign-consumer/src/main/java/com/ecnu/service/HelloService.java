package com.ecnu.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecnu.controller.User;


@FeignClient("HELLO-SERVICE1")
public interface HelloService {

	@RequestMapping(value="/hello",method=RequestMethod.GET)
	String hello();
	
	@RequestMapping(value="/hello1",method=RequestMethod.GET)
	 String hellox(@RequestParam("name") String name);
	
	@RequestMapping(value="/hello2",method=RequestMethod.GET)
	 User helloxx(@RequestHeader("name") String name,@RequestHeader("age") Integer age);
	
	@RequestMapping(value="/hello3",method=RequestMethod.POST)
	 String helloxxx(@RequestBody User user);
}
