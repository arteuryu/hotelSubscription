package com.wechat.subscription.hotelSubscription.dao.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface HotelMapper {  
   
	@Select("SELECT count(*) FROM arteur")
    public int countLine(@Param("id") int id); 
	
	@Select("select t.menu_code as menuCode,"
			+ "t.menu_name as menuName,"
			+ "t.menu_url as menuUrl "
			+ "from cms_menu_info t "
			+ "order by t.menu_code")
	public List<Map<String,Object>> menuTest();
	
	@Select("select t.ID as ID,"
			+ "t.user_name as userName,"
			+ "t.user_cellNum as userCellNum,"
			+ "t.user_role as userRole,"
			+ "t.user_status as userStatus,"
			+ "t.user_region as userRegion,"
			+ "(select r.role_name from cms_role_info r where r.role_code = t.user_role) as userRoleName,"
			+ "(select r.region_name from cms_region_info r where r.region_code = t.user_region) as userRegionName,"
			+ "date_format(t.create_date,'%Y-%c-%d %h:%i:%s') as createDate "
			+ "from cms_user_info t "
			+ "limit #{beginNum},#{endNum}")
	public List<Map<String,Object>> getUserInfoList(Map paramMap);
	
	@Select("select count(1) from cms_user_info")
	public Integer getUserCount();
	
	@Select("select t.role_name as roleName,t.role_code as roleCode from cms_role_info t where t.role_status = 'Y'")
	public List<Map<String,Object>> getUserRoleList();
	
	@Select("select t.region_code as regionCode,t.region_name as regionName from cms_region_info t where t.region_status = 'Y'")
	public List<Map<String,Object>> getUserCityList();
	
	@Insert("insert into cms_user_info(ID,user_name,user_cellNum,user_role,create_date) "
			+ "values(uuid(),#{userName},#{userCellNum},#{userRole},now())")
	public void addUser(Map paramMap);
	
	@Update("update cms_user_info "
			+ "set user_name = #{userName}, "
			+ "user_cellNum = #{userCellNum}, "
			+ "user_role = #{userRole}, "
			+ "user_status = #{userStatus}, "
			+ "user_region = #{userRegion}"
			+ "where ID = #{userId}")
	public void modUser(Map paramMap);
	
	@Select("select t.ID,"
			+ "t.banner_name as bannerName,"
			+ "t.banner_url as bannerUrl,"
			+ "t.banner_pic as bannerPic,"
			+ "t.banner_pic_orign_name as bannerPicOrignName,"
			+ "t.banner_priority as bannerPriority,"
			+ "t.banner_status as bannerStatus "
			+ "from cms_banner_info t "
			+ "order by t.banner_priority "
			+ "limit #{beginNum},#{endNum}")
	public List<Map<String,Object>> getBannerInfoList(Map paramMap);
	
	@Select("select count(1) from cms_banner_info")
	public Integer getBannerCount();
	
	@Insert("insert into cms_banner_info "
			+ "(ID,banner_name,banner_url,banner_pic,banner_pic_orign_name,banner_priority,banner_status,update_date) "
			+ "values (uuid(),#{bannerName},#{bannerUrl},#{bannerPic},#{bannerPicOrignName},#{bannerPriority},#{bannerStatus},now())")
	public void addBanner(Map paramMap);
	
	@Update("update cms_banner_info t "
			+ "set t.banner_name = #{bannerName}, "
			+ "t.banner_pic = #{bannerPic}, "
			+ "t.banner_priority = #{bannerPriority}, "
			+ "t.banner_status = #{bannerStatus}, "
			+ "t.banner_url = #{bannerUrl}, "
			+ "t.banner_pic_orign_name = #{bannerPicOrignName},"
			+ "t.update_date = now()"
			+ "where t.ID = #{bannerId}")
	public void modBanner(Map paramMap);
	
	@Select("select t.ID as ID,"
			+ "t.config_type as configType,"
			+ "t.config_name as configName,"
			+ "date_format(t.create_date,'%Y-%c-%d %h:%i:%s') as createDate,"
			+ "t.create_by as createBy "
			+ "from cms_config_info t "
			+ "where t.config_type = #{type}"
			+ "limit #{beginNum},#{endNum}")
	public List<Map<String,Object>> configInfoList(Map paramMap);
	
	@Select("select config_name as configName,"
			+ "config_attr as configAttr,"
			+ "config_loc as configLoc,"
			+ "config_detail as configDetail,"
			+ "config_pic as configPic,"
			+ "config_pic_orign_name as configPicOrignName,"
			+ "config_status as configStatus "
			+ "from cms_config_info "
			+ "where ID = #{confidId}")
	public Map<String,Object> searchConfidId(Map paramMap);
	
	@Insert("insert into cms_config_info"
			+ "(ID,config_type,config_name,config_attr,config_loc,config_detail,config_pic,config_pic_orign_name,config_status,create_date)"
			+ "values"
			+ "(uuid(),#{configType},#{configName},#{configAttr},#{configLoc},#{configDetail},#{configPic},#{configPicOrignName},#{configStatus},now())")
	public void addConfig(Map paramMap);
	
	@Update("update cms_config_info p "
			+ "set p.config_name = #{configName},"
			+ "p.config_attr = #{configAttr},"
			+ "p.config_loc =#{configLoc},"
			+ "p.config_detail=#{configDetail},"
			+ "p.config_pic=#{configPic},"
			+ "p.config_pic_orign_name=#{configPicOrignName},"
			+ "p.config_status=#{configStatus} "
			+ "where p.ID=#{confidId}")
	public void modConfig(Map paramMap);
	
	@Select("select restaurant_name as restaurantName,"
			+ "room_pic as roomPic,"
			+ "room_desc as roomDesc,"
			+ "updated_by as updatedBy "
			+ "from cms_room_info "
			+ "where room_status = 'Y' "
			+ "group by restaurant_name,room_pic,room_desc,updated_by  "
			+ "limit #{beginNum},#{endNum}")
	public List<Map<String,Object>> getRoomInfoList(Map paramMap);
	
	@Select("select count(1) from cms_room_info where room_status = 'Y'")
	public Integer getRoomInfoCount(Map paramMap);
	
	@Insert("insert cms_room_info"
			+ "(ID,"
			+ "restaurant_name,"
			+ "restaurant_region,"
			+ "room_pic,"
			+ "room_prize_name,"
			+ "room_breakfast,"
			+ "room_wifi,"
			+ "room_prize,"
			+ "room_pay_type,"
			+ "room_desc,"
			+ "room_status,"
			+ "updated_date) "
			+ "values(uuid(),"
			+ "#{roomName},"
			+ "#{roomRegion},"
			+ "#{roomPic},"
			+ "#{roomPrizeName},"
			+ "#{roomBreakfast},"
			+ "#{roomWifi},#{roomPrize},"
			+ "#{roomPayType},"
			+ "#{roomDesc},'Y',now())")
	public void submitRoonInfo(Map tmpMap);
	
	@Select("select ID as id,"
			+ "restaurant_name as restaurantName,"
			+ "restaurant_region as restaurantRgion,"
			+ "room_pic as roomPic,"
			+ "room_prize_name as roomPrizeName,"
			+ "room_breakfast as roomBreakfast,"
			+ "room_wifi as roomWifi,"
			+ "room_prize as roomPrize,"
			+ "room_pay_type as roomPayType,"
			+ "room_desc as roomDesc "
			+ "from cms_room_info "
			+ "where restaurant_name = #{roomType}")
	public List<Map<String,Object>> roomInfoDetail(Map paramMap);
	
	@Delete("delete from cms_room_info where restaurant_name = #{roomNameOrign}")
	public void delRoomInfo(Map paramMap);

	@Select("select * from cms_room_info where restaurant_region=#{city}")
	public List<Map<String,Object>> getRoomList(String city);
}  
