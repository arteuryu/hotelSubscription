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
	
	public List getUserInfoList(Map paramMap) throws Exception {
		return hotelDAO.getUserInfoList(paramMap);
	}
	
	public Integer getUserCount() throws Exception {
		return hotelDAO.getUserCount();
	}
	
	public List getUserRoleList() throws Exception {
		return hotelDAO.getUserRoleList();
	}
	
	public List getUserCityList() throws Exception {
		return hotelDAO.getUserCityList();
	}
	
	public void submitUser(Map paramMap) throws Exception {
		String flag = (String) paramMap.get("flag");
		if("add".equals(flag)){
			hotelDAO.addUser(paramMap);
		}else { 
			hotelDAO.modUser(paramMap);
		}
	}
	
	public List getBannerInfoList(Map paramMap) throws Exception {
		return hotelDAO.getBannerInfoList(paramMap);
	}
	
	public Integer getBannerCount() throws Exception {
		return hotelDAO.getBannerCount();
	}
	
	public void submitBanner(Map paramMap) throws Exception {
		String flag = (String) paramMap.get("flag");
		if("add".equals(flag)){
			hotelDAO.addBanner(paramMap);
		}else { 
			hotelDAO.modBanner(paramMap);
		} 
	}
	
	public List configInfoList(Map paramMap) throws Exception {
		return hotelDAO.configInfoList(paramMap);
	}
	
	public Map searchConfidId(Map paramMap) throws Exception {
		return hotelDAO.searchConfidId(paramMap);
	}
	
	public void submitConfig(Map paramMap) throws Exception {
		String flag = (String) paramMap.get("flag");
		if("add".equals(flag)){
			hotelDAO.addConfig(paramMap);
		}else { 
			hotelDAO.modConfig(paramMap);
		} 
	}
	
	public List getRoomInfoList(Map paramMap) throws Exception {
		return hotelDAO.getRoomInfoList(paramMap);
	}
	
	public Integer getRoomInfoCount(Map paramMap) throws Exception {
		return hotelDAO.getRoomInfoCount(paramMap);
	}
	
	public void submitRoonInfo(Map tmpMap) throws Exception {
		hotelDAO.submitRoonInfo(tmpMap);
	}
	
}
