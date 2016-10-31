package com.wechat.subscription.hotelSubscription.service;

import java.util.List;
import java.util.Map;

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
	
	public List menuTest() throws Exception;
	
	public List getUserInfoList(Map paramMap) throws Exception;
	
	public Integer getUserCount() throws Exception;
	
	public List getUserRoleList() throws Exception;
	
	public List getUserCityList() throws Exception;
	
	public void submitUser(Map paramMap) throws Exception;
	
	public List getBannerInfoList(Map paramMap) throws Exception;
	
	public Integer getBannerCount() throws Exception;
	
	public void submitBanner(Map paramMap) throws Exception;
	
	public List configInfoList(Map paramMap) throws Exception;
	
	public Map searchConfidId(Map paramMap) throws Exception;
	
	public void submitConfig(Map paramMap) throws Exception;
	
	public List getRoomInfoList (Map paramMap) throws Exception;
	
	public Integer getRoomInfoCount(Map paramMap) throws Exception;
	
	public void submitRoonInfo(Map tmpMap) throws Exception;
		
}