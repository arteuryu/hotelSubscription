package com.wechat.subscription.hotelSubscription.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wechat.subscription.hotelSubscription.service.HotelService;

@Controller
@RequestMapping("/cms")


public class CmsController {
	@Autowired
	private HotelService hotelService;
	@RequestMapping("/index")
	public String index(){
		return "blank";
	}
	
	@RequestMapping("/fileUpload")
	public String FileUpload(@RequestParam("file") MultipartFile file){
		return "";
	}
	@RequestMapping("/menuTest")
	@ResponseBody
	public Map menuTest(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map paramMap = new HashMap();
		List menuList = hotelService.menuTest();
		if(menuList!=null && menuList.size()>0){
			paramMap.put("flag", "Y");
			paramMap.put("menuList", menuList);
		}
		return paramMap;
	}
	
}
