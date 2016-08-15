package com.wechat.subscription.hotelSubscription.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.subscription.hotelSubscription.dao.mapper.HotelMapper;

@Service
public class HotelDAO {
	@Autowired
	private HotelMapper hotelMapper;
	public int countLine(int id) {
		return hotelMapper.countLine(id);
	}
}
