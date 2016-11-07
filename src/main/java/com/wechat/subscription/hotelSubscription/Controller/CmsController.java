package com.wechat.subscription.hotelSubscription.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.wechat.subscription.hotelSubscription.service.HotelService;

import net.sf.json.JSONObject;
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
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	public Map formatStringToMap(String target) {
		JSONObject jsonObject = JSONObject.fromObject(target);
		Iterator it = jsonObject.keys();
		Map desMap = new HashMap();
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			String value = (String) jsonObject.get(key);
			desMap.put(key, value);
		}
		return desMap;
	}
	
	/**
	 * 菜单列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
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
	
	/**
	 * 获取用户信息列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryUsers")
	@ResponseBody
	public Map queryUsers(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map paramMap = new HashMap();
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));//当前在第几页
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));//每页有多少条
		int beginNum = (pageNum-1)*pageSize;
		int endNum = (pageNum)*pageSize;
		paramMap.put("beginNum", beginNum);
		paramMap.put("endNum", endNum);
		List userInfoList = hotelService.getUserInfoList(paramMap);
		Integer count = 0;
		count = hotelService.getUserCount();
		Map resultMap = new HashMap();
		resultMap.put("flag", "Y");
		resultMap.put("userInfoList", userInfoList);
		resultMap.put("dataCount",count);
		return resultMap;
	}
	
	
	/***
	 * 获取用户角色List
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getUserRoleList")
	@ResponseBody
	public Map getUserRoleList(HttpServletRequest request,HttpServletResponse response) throws Exception{
		List userRoleList = hotelService.getUserRoleList();
		List userCityList = hotelService.getUserCityList();
		Map resultMap = new HashMap();
		resultMap.put("userRoleList", userRoleList);
		resultMap.put("userCityList", userCityList);
		resultMap.put("flag", "Y");
		return resultMap;
	}
	/**
	 * 创建/更新用户信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/submitUser")
	@ResponseBody
	public Map submitUser(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map paramMap = new HashMap();
		String flag = request.getParameter("flag");
		String userId = "";
		if("mod".equals(flag)){
			userId = request.getParameter("userId");
		}
		String userName = request.getParameter("userName");
		String userCellNum = request.getParameter("userCellNum");
		String userRole = request.getParameter("userRole");
		String userStatus = request.getParameter("userStatus");
		String userRegion = request.getParameter("userRegion");
		paramMap.put("flag",flag);
		paramMap.put("userId",userId);
		paramMap.put("userName",userName);
		paramMap.put("userCellNum",userCellNum);
		paramMap.put("userRole", userRole);
		paramMap.put("userStatus",userStatus);
		paramMap.put("userRegion", userRegion);
		hotelService.submitUser(paramMap);
		Map resultMap = new HashMap();
		resultMap.put("flag", "Y");
		return resultMap;
	}
	
	/***
	 * 查询首页广告列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/querybanners")
	@ResponseBody
	public Map querybanners(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map paramMap = new HashMap();
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));//当前在第几页
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));//每页有多少条
		int beginNum = (pageNum-1)*pageSize;
		int endNum = (pageNum)*pageSize;
		paramMap.put("beginNum", beginNum);
		paramMap.put("endNum", endNum);
		List bannerInfoList = hotelService.getBannerInfoList(paramMap);
		Integer count = 0;
		count = hotelService.getBannerCount();
		Map resultMap = new HashMap();
		resultMap.put("flag", "Y");
		resultMap.put("bannerInfoList", bannerInfoList);
		resultMap.put("dataCount",count);
		return resultMap;
	}
	
	/**
	 * 图片上传controller
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public void upload(HttpServletRequest request, HttpServletResponse response) throws Exception{
		PrintWriter resultOut = response.getWriter();
		String basicPath = "G:/proBiu/cmsPic"; 
		MultipartRequest multipartRequest = (MultipartRequest) request;
		String uploadType = request.getParameter("uploadType");//上传图片类型
		MultipartFile file = multipartRequest.getFile("uploadFile");
		String originalFilename = file.getOriginalFilename();//上传前的图片名称
		String endName = originalFilename.substring(originalFilename.lastIndexOf("."));//图片后缀
		InputStream in = null;
		FileOutputStream out = null;
		try {
			String saveFileName = UUID.randomUUID().toString().replace("-", "") + endName;//生成图片名称
			String savePath =  basicPath + "/" + uploadType + "/" + saveFileName;//图片上传后的完整路径
			File saveFile = new File(savePath);
			File saveHome = saveFile.getParentFile();
			if (!saveHome.exists()) {
				saveHome.mkdirs();
			}
			in = file.getInputStream();
			out = new FileOutputStream(saveFile);
			byte[] buff = new byte[1024];
			int len = -1;
			while ((len = in.read(buff)) != -1) {
				out.write(buff, 0, len);
				out.flush();
			}
//			String imageUrl = FileHandleUtil.getNasPicIntranetAddr() +"/" +  uploadType + "/" + saveFileName;
			resultOut.print("<script type=\"text/javascript\">window.parent.finishUpload('" + savePath + "', '" + originalFilename + "');</script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			out = null;
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			in = null;
		}
	}

	/**
	 * 创建/更新广告信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/submitBanner")
	@ResponseBody
	public Map submitBanner(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map paramMap = new HashMap();
		String flag = request.getParameter("flag");
		String bannerId = "";
		if("mod".equals(flag)){
			bannerId = request.getParameter("bannerId");
		}
		String bannerName = request.getParameter("bannerName");
		String bannerPicOrignName = request.getParameter("bannerPicOrignName");
		String bannerPic = request.getParameter("bannerPic");
		String bannerUrl = request.getParameter("bannerUrl");
		String bannerPriority = request.getParameter("bannerPriority");
		String bannerStatus = request.getParameter("bannerStatus");
		paramMap.put("flag",flag);
		paramMap.put("bannerId",bannerId);
		paramMap.put("bannerName",bannerName);
		paramMap.put("bannerPicOrignName",bannerPicOrignName);
		paramMap.put("bannerPic", bannerPic);
		paramMap.put("bannerUrl",bannerUrl);
		paramMap.put("bannerPriority", bannerPriority);
		paramMap.put("bannerStatus", bannerStatus);
		hotelService.submitBanner(paramMap);
		Map resultMap = new HashMap();
		resultMap.put("flag", "Y");
		return resultMap;
	}
	
	/***
	 * 查询其他公众号配置列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryconfigs")
	@ResponseBody
	public Map queryconfigs(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map paramMap = new HashMap();
		String type =  request.getParameter("type");
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));//当前在第几页
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));//每页有多少条
		int beginNum = (pageNum-1)*pageSize;
		int endNum = (pageNum)*pageSize;
		paramMap.put("beginNum", beginNum);
		paramMap.put("endNum", endNum);
		paramMap.put("type", type);
		List configInfoList = hotelService.configInfoList(paramMap);
		Integer count = 0;
		if(configInfoList.size() != 0){
			count = configInfoList.size();
		}
		Map resultMap = new HashMap();
		resultMap.put("flag", "Y");
		resultMap.put("configInfoList", configInfoList);
		resultMap.put("dataCount",count);
		return resultMap;
	}
	
	/***
	 * 查询其他信息（通过ID）
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/searchConfidId")
	@ResponseBody
	public Map searchConfidId(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map paramMap = new HashMap();
		String confidId =  request.getParameter("confidId");
		paramMap.put("confidId", confidId);
		Map configInfoMap = hotelService.searchConfidId(paramMap);
		Map resultMap = new HashMap();
		resultMap.put("flag", "Y");
		resultMap.put("configInfoMap", configInfoMap);
		return resultMap;
	}
	
	/***
	 * 提交其他配置信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/submitConfig")
	@ResponseBody
	public Map submitConfig(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map paramMap = new HashMap();
		String flag = request.getParameter("flag");
		String confidId = "";
		if("mod".equals(flag)){
			confidId = request.getParameter("confidId");
		}
		String configType = request.getParameter("configType");
		String configName = request.getParameter("configName");
		String configAttr = request.getParameter("configAttr");
		String configLoc = request.getParameter("configLoc");
		String configDetail = request.getParameter("configDetail");
		String configPic = request.getParameter("configPic");
		String configPicOrignName = request.getParameter("configPicOrignName");
		String configStatus = request.getParameter("configStatus");
		paramMap.put("flag",flag);
		paramMap.put("confidId",confidId);
		paramMap.put("configType",configType);
		paramMap.put("configName",configName);
		paramMap.put("configAttr", configAttr);
		paramMap.put("configLoc",configLoc);
		paramMap.put("configDetail", configDetail);
		paramMap.put("configPic", configPic);
		paramMap.put("configPicOrignName",configPicOrignName);
		paramMap.put("configStatus", configStatus);
		hotelService.submitConfig(paramMap);
		Map resultMap = new HashMap();
		resultMap.put("flag", "Y");
		return resultMap;
	}
	
	/***
	 * 客房预订查询
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryRooms")
	@ResponseBody
	public Map queryRooms(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map paramMap = new HashMap();
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));//当前在第几页
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));//每页有多少条
		int beginNum = (pageNum-1)*pageSize;
		int endNum = (pageNum)*pageSize;
		paramMap.put("beginNum", beginNum);
		paramMap.put("endNum", endNum);
		List roomInfoList = hotelService.getRoomInfoList(paramMap);
		Integer count = 0;
		count = hotelService.getRoomInfoCount(paramMap);
		int maxNum = (int) Math.floor(count/pageSize)+1;//最大页数
		if(pageNum>maxNum){
			pageNum = maxNum;
		}
		Map resultMap = new HashMap();
		resultMap.put("flag", "Y");
		resultMap.put("roomInfoList", roomInfoList);
		resultMap.put("dataCount",count);
		return resultMap;
	}
	
	/***
	 * 提交房间信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/submitRoomInfo")
	@ResponseBody
	public Map submitRoomInfo(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
		String roomInfoStr = (String)request.getParameter("roomInfoMap");
		String roomRegion = (String) request.getParameter("roomRegion");
		String roomName = (String) request.getParameter("roomName");
		String roomPic = (String) request.getParameter("roomPic");
		String roomDesc = (String) request.getParameter("roomDesc");
		String pageFlag = (String) request.getParameter("flag");
		if("mod".equals(pageFlag)){
			String roomNameOrign = (String) request.getParameter("roomNameOrign");
			Map paramMap =new HashMap<String, String>();
			paramMap.put("roomNameOrign", roomNameOrign);
			hotelService.delRoomInfo(paramMap);
		}
		Map roomInfoMap = formatStringToMap(roomInfoStr);
		String roomPrizeName = (String) roomInfoMap.get("roomPrizeName");
		String roomBreakfast = (String) roomInfoMap.get("roomBreakfast");
		String roomWifi = (String) roomInfoMap.get("roomWifi");
		String roomPrize = (String) roomInfoMap.get("roomPrize");
		String roomPayType = (String) roomInfoMap.get("roomPayType");
		if(StringUtils.isNotEmpty(roomPrizeName)){
			String[] roomPrizeNames = roomPrizeName.split(";");
			String[] roomBreakfasts =  roomBreakfast.split(";");
			String[] roomWifis =  roomWifi.split(";");
			String[] roomPrizes =  roomPrize.split(";");
			String[] roomPayTypes =  roomPayType.split(";");
			for(int i=0;i<roomPrizeNames.length;i++){
				Map tmpMap = new HashMap();
				tmpMap.put("roomPrizeName", roomPrizeNames[i]);
				tmpMap.put("roomBreakfast", roomBreakfasts[i]);
				tmpMap.put("roomWifi", roomWifis[i]);
				tmpMap.put("roomPrize", roomPrizes[i]);
				tmpMap.put("roomPayType", roomPayTypes[i]);
				tmpMap.put("roomRegion", roomRegion);
				tmpMap.put("roomName", roomName);
				tmpMap.put("roomPic", roomPic);
				tmpMap.put("roomDesc", roomDesc);
				hotelService.submitRoonInfo(tmpMap);
			}
		}
		Map resultMap = new HashMap();
		return resultMap;
	}
	
	/***
	 * 客房查询详情 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/roomInfoDetail")
	@ResponseBody
	public Map roomInfoDetail(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map paramMap = new HashMap();
		String roomType = request.getParameter("roomType");
		paramMap.put("roomType", roomType);
		List roomInfoDetailList = hotelService.roomInfoDetail(paramMap);
		Map resultMap = new HashMap();
		resultMap.put("flag", "Y");
		resultMap.put("roomInfoDetailList", roomInfoDetailList);
		return resultMap;
	}
	
}
