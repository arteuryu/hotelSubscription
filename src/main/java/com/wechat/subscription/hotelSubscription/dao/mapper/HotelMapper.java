package com.wechat.subscription.hotelSubscription.dao.mapper;

import java.util.List;

import com.wechat.subscription.hotelSubscription.dao.entity.HotelInfo;  


public interface HotelMapper {  
      
    int save(HotelInfo hotelInfo);  
      
    HotelInfo selectById(Integer id);  
      
    int updateById(HotelInfo hotelInfo);  
      
    int deleteById(Integer id);  
      
    List<HotelInfo> queryAll();  
      
}  
