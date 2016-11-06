package com.wechat.subscription.hotelSubscription.dao.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HotelMapper {  
   
	@Select("SELECT count(*) FROM arteur")
    public int countLine(@Param("id") int id); 
	
	@Select("select * from cms_menu_info order by menu_code")
	public List<Map<String,Object>> menuTest();
	
	@Select("select * from cms_room_info where restaurant_region=#{city}")
	public List<Map<String,Object>> getRoomList(String city);
}  
