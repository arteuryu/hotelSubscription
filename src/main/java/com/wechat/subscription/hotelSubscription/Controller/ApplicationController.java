package com.wechat.subscription.hotelSubscription.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

 
/** 
* @Description: TODO 
* @author : yuerte969  
* @date 13 Aug 2016 3:57:48 pm  
*/
@Configuration  
@ComponentScan  
@EnableAutoConfiguration  
public class ApplicationController {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationController.class);
	}
}
