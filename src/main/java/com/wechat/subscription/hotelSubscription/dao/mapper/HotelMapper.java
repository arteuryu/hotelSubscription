package com.wechat.subscription.hotelSubscription.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
//
public interface HotelMapper {  
      
	  @Select("SELECT count(*) FROM arteur")
	  int countLineNum(@Param("name") String name);

	  @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
	  int insert(@Param("name") String name, @Param("age") Integer age);
      
}  
