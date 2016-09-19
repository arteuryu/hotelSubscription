package com.wechat.subscription.hotelSubscription.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotelPage")  
public class HotelPageController {
	@RequestMapping("/history")
	public String getHistoryPage(){
		return "history";
	}
	@RequestMapping("/commingSoon")
	public String commingSoonPage(){
		return "commingSoon";
	}
	@RequestMapping("/hotelSelect")
	public String getHotelPreorder(){
		return "hotelSelect";
	}
	@RequestMapping("/restaurantPreorder")
	public String getRestaurantPreorder(){
		return "restaurantPreorder";
	}
	@RequestMapping("/brandOverview")
	public String getBrandOverview(){
		return "brandOverview";
	}
	@RequestMapping("/guestRoomPreorder")
	public String getGuestRoomPreorder(){
		return "guestRoomPreorder";
	}
	@RequestMapping("/meetingPreorder")
	public String getMeetingPreorder(){
		return "meetingPreorder";
	}
	@RequestMapping("/mediaCenter")
	public String getMediaCenter(){
		return "mediaCenter";
	}
	@RequestMapping("/mediaDetail")
	public String getMediaDetail(){
		return "mediaDetail";
	}
	@RequestMapping("/joinUs")
	public String joinUs(){
		return "joinUs";
	}
	@RequestMapping("/index")
	public String index(){
		return "mobileIndex";
	}
}
