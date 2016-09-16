package com.wechat.subscription.hotelSubscription.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
	@RequestMapping("/testFileupload")
	public String testFile(){
		return "file";
	}
	@RequestMapping("/fileUpload")
	@ResponseBody
	public String FileUpload(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file){
		if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("/tmp/images/"+name + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
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
