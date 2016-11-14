package com.wechat.subscription.hotelSubscription.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping("/meetingDetail")
	public ModelAndView getMeetingDetailNc(@RequestParam String title,@RequestParam String text,@RequestParam String url){
		ModelAndView mav = new ModelAndView();  
		mav.setViewName("meetingDetail");
		Map<String,String> map = new HashMap<String,String>();  
        map.put("title", title);  
        map.put("text", text);  
        map.put("url", url);  
        mav.addObject("data",map);  
		return mav;
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
	public ModelAndView getMediaDetail(@RequestParam String title,@RequestParam String text,@RequestParam String url){
		ModelAndView mav = new ModelAndView();  
		mav.setViewName("mediaDetail");
		Map<String,String> map = new HashMap<String,String>();  
        map.put("title", title);  
        map.put("text", text);  
        map.put("url", url);  
        mav.addObject("data",map);  
		return mav;
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
	@RequestMapping("/historyTra")
	public String getHistoryTraPage(){
		return "historyTra";
	}
	@RequestMapping("/privacyTra")
	public String getPrivacyTraPage(){
		return "privacyTra";
	}
	@RequestMapping("/aboutTra")
	public String getAboutTraPage(){
		return "aboutTra";
	}
	@RequestMapping("/commingSoonTra")
	public String commingSoonTraPage(){
		return "commingSoonTra";
	}
	@RequestMapping("/hotelSelectTra")
	public String getHotelPreorderTra(){
		return "hotelSelectTra";
	}
	@RequestMapping("/restaurantPreorderTra")
	public String getRestaurantPreorderTra(){
		return "restaurantPreorderTra";
	}
	@RequestMapping("/brandOverviewTra")
	public String getBrandOverviewTra(){
		return "brandOverviewTra";
	}
	@RequestMapping("/guestRoomPreorderTra")
	public String getGuestRoomPreorderTra(){
		return "guestRoomPreorderTra";
	}
	@RequestMapping("/meetingPreorderTra")
	public String getMeetingPreorderTra(){
		return "meetingPreorderTra";
	}
	@RequestMapping("/meetingDetailNcTra")
	public String getMeetingDetailNcTra(){
		return "meetingDetailNcTra";
	}
	@RequestMapping("/meetingDetailXmTra")
	public String getMeetingDetailXmTra(){
		return "meetingDetailXmTra";
	}
	@RequestMapping("/mediaCenterTra")
	public String getMediaCenterTra(){
		return "mediaCenterTra";
	}
	@RequestMapping("/mediaDetailTra")
	public String getMediaDetailTra(){
		return "mediaDetailTra";
	}
	@RequestMapping("/joinUsTra")
	public String joinUsTra(){
		return "joinUsTra";
	}
	@RequestMapping("/indexTra")
	public String indexTra(){
		return "mobileIndexTra";
	}
	@RequestMapping("/comingsoonTra")
	public String comingsoonTra(){
		return "comingsoonTra";
	}
	@RequestMapping("/location")
	public String location(){
		return "location";
	}
}
