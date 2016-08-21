package com.wechat.subscription.hotelSubscription.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/cms")
public class CmsController {
	@RequestMapping("/index")
	public String index(){
		return "blank";
	}
	
	@RequestMapping("/fileUpload")
	public String FileUpload(@RequestParam("file") MultipartFile file){
		return "";
	}
}
