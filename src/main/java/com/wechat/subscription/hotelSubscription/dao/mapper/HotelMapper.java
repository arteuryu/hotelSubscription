package com.wechat.subscription.hotelSubscription.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HotelMapper {  
   
	@Select("SELECT count(*) FROM arteur")
    public int countLine(@Param("id") int id); 
}  
