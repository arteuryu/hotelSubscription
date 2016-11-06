package com.wechat.subscription.hotelSubscription.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.subscription.hotelSubscription.dao.HotelDAO;
import com.wechat.subscription.hotelSubscription.dao.entity.HotelInfo;
import com.wechat.subscription.hotelSubscription.service.HotelService;
@Service
public class HotelServiceImpl implements HotelService{
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	@Autowired
    private HotelDAO hotelDAO;
	public HotelInfo testService() {
		// TODO Auto-generated method stub
		Integer count = hotelDAO.countLine(4);
		logger.info("count is "+count);
		return null;
	}
	public List menuTest() throws Exception {
		return hotelDAO.menuTest();
	}
	public List<Map<String,Object>> roomList(String city) throws Exception{
		return hotelDAO.roomList(city);
	}
}
