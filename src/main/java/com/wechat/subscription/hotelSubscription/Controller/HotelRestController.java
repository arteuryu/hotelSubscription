package com.wechat.subscription.hotelSubscription.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wechat.subscription.hotelSubscription.common.SignUtil;
import com.wechat.subscription.hotelSubscription.service.HotelService;

/** 
* @Description: TODO 
* @author : yuerte969  
* @date 13 Aug 2016 3:40:51 am  
*/
@RestController  
@RequestMapping("/hotelRest")  
public class HotelRestController {
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	@Autowired
	private HotelService hotelService;
	@RequestMapping("/arteur")  
    public String view() {  
		hotelService.testService();
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
	@RequestMapping("/getRoomList")
	public List<Map<String,Object>> getRoomList(@RequestParam("city") String city){
		List<Map<String,Object>> roomList = new ArrayList<Map<String,Object>>();
		try {
			roomList = hotelService.roomList(city);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roomList;
	}
}
