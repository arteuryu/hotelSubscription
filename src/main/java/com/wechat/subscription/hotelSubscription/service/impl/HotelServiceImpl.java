package com.wechat.subscription.hotelSubscription.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.subscription.hotelSubscription.dao.entity.HotelInfo;
import com.wechat.subscription.hotelSubscription.dao.mapper.HotelMapper;
import com.wechat.subscription.hotelSubscription.service.HotelService;

@Service("hotelService")
public class HotelServiceImpl implements HotelService{
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
//	@Autowired
//    private HotelMapper hotelMapper;
	public HotelInfo testService() {
		// TODO Auto-generated method stub
//		Integer count = hotelMapper.countLineNum("");
//		logger.info("count is "+count);
		return null;
	}
	
}
