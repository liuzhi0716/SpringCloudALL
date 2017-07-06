package com.ecnu;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class Client1Application {

	private final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private DiscoveryClient client;
	public static void  main(String args[]) {
		SpringApplication.run(Client1Application.class, args);
	}
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(){
		return "Hello ";
	}
	
	@RequestMapping(value="/hello1",method=RequestMethod.GET)
	public String hello(@RequestParam String name){
		return "Hello "+ name;
	}
	
	@RequestMapping(value="/hello2",method=RequestMethod.GET)
	public User hello(@RequestHeader String name,@RequestHeader Integer age){
		return new User(name,age);
	}
	
	@RequestMapping(value="/hello3",method=RequestMethod.POST)
	public String hello(@RequestBody User user){
		return "Hello "+ user.getName()+","+user.getAge();
	}
	
}
