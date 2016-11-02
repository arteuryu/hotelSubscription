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
	@RequestMapping("/privacy")
	public String getPrivacyPage(){
		return "privacy";
	}
	@RequestMapping("/about")
	public String getAboutPage(){
		return "about";
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
	@RequestMapping("/meetingDetailNc")
	public String getMeetingDetailNc(){
		return "meetingDetailNc";
	}
	@RequestMapping("/meetingDetailXm")
	public String getMeetingDetailXm(){
		return "meetingDetailXm";
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
	@RequestMapping("/comingsoon")
	public String comingsoon(){
		return "comingsoon";
	}
	@RequestMapping("/historyEn")
	public String getHistoryPageEn(){
		return "historyEn";
	}
	@RequestMapping("/privacyEn")
	public String getPrivacyPageEn(){
		return "privacyEn";
	}
	@RequestMapping("/aboutEn")
	public String getAboutPageEn(){
		return "aboutEn";
	}
	@RequestMapping("/commingSoonEn")
	public String commingSoonPageEn(){
		return "commingSoonEn";
	}
	@RequestMapping("/hotelSelectEn")
	public String getHotelPreorderEn(){
		return "hotelSelectEn";
	}
	@RequestMapping("/restaurantPreorderEn")
	public String getRestaurantPreorderEn(){
		return "restaurantPreorderEn";
	}
	@RequestMapping("/brandOverviewEn")
	public String getBrandOverviewEn(){
		return "brandOverviewEn";
	}
	@RequestMapping("/guestRoomPreorderEn")
	public String getGuestRoomPreorderEn(){
		return "guestRoomPreorderEn";
	}
	@RequestMapping("/meetingPreorderEn")
	public String getMeetingPreorderEn(){
		return "meetingPreorderEn";
	}
	@RequestMapping("/meetingDetailNcEn")
	public String getMeetingDetailNcEn(){
		return "meetingDetailNcEn";
	}
	@RequestMapping("/meetingDetailXmEn")
	public String getMeetingDetailXmEn(){
		return "meetingDetailXmEn";
	}
	@RequestMapping("/mediaCenterEn")
	public String getMediaCenterEn(){
		return "mediaCenterEn";
	}
	@RequestMapping("/mediaDetailEn")
	public String getMediaDetailEn(){
		return "mediaDetailEn";
	}
	@RequestMapping("/joinUsEn")
	public String joinUsEn(){
		return "joinUsEn";
	}
	@RequestMapping("/indexEn")
	public String indexEn(){
		return "mobileIndexEn";
	}
	@RequestMapping("/comingsoonEn")
	public String comingsoonEn(){
		return "comingsoonEn";
	}
}
