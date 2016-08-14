package com.wechat.subscription.hotelSubscription.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HotelMapper {  
      
	  @Select("SELECT * FROM USER WHERE NAME = #{name}")
	  String findByName(@Param("name") String name);

	  @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
	  int insert(@Param("name") String name, @Param("age") Integer age);
      
}  
