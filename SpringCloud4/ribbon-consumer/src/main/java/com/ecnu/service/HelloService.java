package com.ecnu.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;
	
	/*@HystrixCommand(fallbackMethod="helloFallback")
	public String helloService() {
		return restTemplate.getForEntity("http://HELLO-SERVICE1/hello", String.class).getBody(); 
	}*/
	Logger logger=Logger.getLogger(getClass());;
	@HystrixCommand(fallbackMethod="helloFallback")
	public String helloService() {
		long start = System.currentTimeMillis();
		String string =  restTemplate.getForEntity("http://HELLO-SERVICE1/hello", String.class).getBody(); 
		long end = System.currentTimeMillis();
		logger.info("Spend time:"+(end-start));
		return string;
	}
	
	public String helloFallback() {
		return "error";
	}
}
