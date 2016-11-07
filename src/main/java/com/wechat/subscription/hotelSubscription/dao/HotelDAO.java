package com.wechat.subscription.hotelSubscription.dao;

import java.util.List;
import java.util.Map;

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
	public List menuTest() {
		return hotelMapper.menuTest();
	}
	
	public List getUserInfoList(Map paramMap) {
		return hotelMapper.getUserInfoList(paramMap);
	}
	
	public Integer getUserCount() {
		return hotelMapper.getUserCount();
	}
	
	public List getUserRoleList() {
		return hotelMapper.getUserRoleList();
	}
	
	public List getUserCityList() {
		return hotelMapper.getUserCityList();
	}
	
	public void addUser(Map paramMap){
		hotelMapper.addUser(paramMap);
	}
	
	public void modUser(Map paramMap){
		hotelMapper.modUser(paramMap);
	}
	
	public List getBannerInfoList(Map paramMap){
		return hotelMapper.getBannerInfoList(paramMap);
	}
	
	public Integer getBannerCount() {
		return hotelMapper.getBannerCount();
	}
	
	public void addBanner(Map paramMap) {
		hotelMapper.addBanner(paramMap);
	}
	
	public void modBanner(Map paramMap) {
		hotelMapper.modBanner(paramMap);
	}
	
	public List configInfoList(Map paramMap) {
		return hotelMapper.configInfoList(paramMap);
	}
	
	public Map searchConfidId(Map paramMap) {
		return hotelMapper.searchConfidId(paramMap);
	}
	
	public void addConfig(Map paramMap) {
		hotelMapper.addConfig(paramMap);
	}
	
	public void modConfig(Map paramMap) {
		hotelMapper.modConfig(paramMap);
	}
	
	public List getRoomInfoList(Map paramMap) {
		return hotelMapper.getRoomInfoList(paramMap);
	}
	
	public Integer getRoomInfoCount(Map paramMap) {
		return hotelMapper.getRoomInfoCount(paramMap);
	}
	
	public void submitRoonInfo(Map tmpMap) {
		hotelMapper.submitRoonInfo(tmpMap);
	}
	
	public List roomInfoDetail(Map paramMap) {
		return hotelMapper.roomInfoDetail(paramMap);
	}
	
	public void delRoomInfo (Map paramMap) {
		hotelMapper.delRoomInfo(paramMap);
	public List<Map<String,Object>> roomList(String city){
		return hotelMapper.getRoomList(city);
	}
}
