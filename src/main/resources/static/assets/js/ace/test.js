$.ajax({
    url:'/cms/menuTest', 
    data:{
    },  
    type:'post',  
    cache:false,  
    dataType:'json',  
    success:function(result){
    	if(result.flag == "Y"){
    		var menuData = result.menuList;
    		createMenu(menuData);
    	}else{
    		alert("error");
    	}
	}
});

function createMenu(menuData){
	var menuItemTemplate = $("#menuItemTemplate").text();
	var menuBody = $("#menuDIV");
	for(var i = 0; i < menuData.length; i++){
		menuBody.append(menuItemTemplate);
		var menuItem = menuBody.find("li").last();
		var aObject = menuItem.find("a");
		aObject.attr("url",menuData[i].menuUrl);
		aObject.attr("menucode",menuData[i].menuCode);
		aObject.attr("menuname",menuData[i].menuName);
		aObject.find("span").html(menuData[i].menuName);
	}
}

function gotoMenuUrl(url,obj){
	var html = '<ul class="breadcrumb"><li><i class="ace-icon fa fa-home home-icon"></i><a href="#">主页</a></li>'
		+'<li class="active">'+$(obj).attr("menuname")+'</li></ul>';
	$(".t-head").html(html);
	$(window.parent.document).find("#rightBoxIframe").attr("src","/assets/menupage/"+url);
}