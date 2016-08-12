package com.wechat.subscription.hotelSubscription.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
@RequestMapping("/user")  
public class HotelController {
	@RequestMapping("/arteur")  
    public String view() {  
        return "hello world";  
    }  
}
