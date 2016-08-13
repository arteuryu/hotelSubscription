package com.wechat.subscription.hotelSubscription.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wechat.subscription.hotelSubscription.common.SignUtil;

/** 
* @Description: TODO 
* @author : yuerte969  
* @date 13 Aug 2016 3:40:51 am  
*/
@RestController  
@RequestMapping("/hotel")  
public class HotelController {
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	@RequestMapping("/arteur")  
    public String view() {  
        return "hello world";  
    }  
	@RequestMapping("/authenrize")  
	public String validateWeixin(@RequestParam("signature") String signature,
			@RequestParam("timestamp") String timestamp,@RequestParam("nonce") String nonce,
			@RequestParam("echostr") String echostr){
//		return "fdsafdsa";	
		logger.info("here");
		if(SignUtil.checkSignature(signature, timestamp, nonce)){
			return echostr;
		}
		return "authenrize fail";		
	}
}
