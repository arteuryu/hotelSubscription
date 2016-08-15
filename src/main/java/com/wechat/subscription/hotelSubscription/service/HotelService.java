package com.wechat.subscription.hotelSubscription.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wechat.subscription.hotelSubscription.dao.entity.HotelInfo;
@SpringBootApplication
public interface HotelService {
	/**   
	* @Title: HotelService.java 
	* @Package com.wechat.subscription.hotelSubscription.service 
	* @Description: TODO
	* @author yuerte969  
	* @date 14 Aug 2016 1:23:17 pm 
	* @version V1.0   
	*/
	public HotelInfo testService();
}
