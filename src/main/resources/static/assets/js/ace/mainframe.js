var superWindow = false;
var frameWindow = false;
$(function() {
	superWindow = window.parent;
	frameWindow = window;
	var rightboxIframe = window.parent.document.getElementById("rightboxIframe");
	if (rightboxIframe) {
		frameWindow = window.parent.document.getElementById("rightboxIframe").contentWindow;
	}
	$(window.parent.document).find("#loadingDiv").hide();
	if(parent.document.getElementById("rightboxIframe") != null){
		setInterval("initDiv()", 1000);
	}
});
// 设置当前位置信息
$(function() {
	var menuItem2 = $(superWindow.document).find(".text_onn a");
	var menuItem1 = menuItem2.parents("li").find("p a b");
	if (menuItem1.length > 0 && menuItem2.length > 0) {
		var items = [menuItem1.html(), menuItem2.html()];
		createPosition(items);
	}
	//是否新旧版本，设置当前位置信息
	if(parent.hideLocation != null){
		parent.hideLocation();
	}
});

function initDiv(){
	if(parent.document.getElementById("rightboxIframe").contentDocument.body != null){
		var iframeHeight = parent.document.getElementById("rightboxIframe").contentDocument.body.scrollHeight;
		if(iframeHeight >  parent.$(".page-content").height()){
			parent.$(".page-content").height(iframeHeight + 20);
		}
	}
}

/**
 * 弹出层
 * title,标题 && content 内容页面
 * width,宽(整数),height:高(整数)
 * closeInnser 关闭页面
 */
var closeInnser ="";
function openDiv(content, title, width, height){
	//计算当前屏幕距离顶部多少px
	var top = window.screen.availHeight - window.screenTop * 2 - height > 0? (window.screen.availHeight - window.screenTop * 2 - height)/2 : 0;
	//计算当前屏幕距离左边多少px
	var left = $(document.body).width() - width > 0? ($(document.body).width() - width)/2 : 0;
	//iframe层-父子操作
	closeInnser = layer.open({
	  type: 2,
	  title: title,
	  //skin: 'layui-layer-rim', //加上边框
	  shadeClose: false, //开启遮罩关闭
	  area: [width+ 'px', height+ 'px'],
	  offset: [top+ 'px', left+ 'px'],
	  fix: false, //不固定
	  maxmin: false,//最大最小化
	  scrollbar: false,//屏蔽浏览器滚动条
	  content: content
	}); 
	//$(".layui-layer-title").attr("style","background-color:#ff6600;color: #fff;font-weight: bold;");
}
/**
 * 关闭层
 */
function closeDiv(){
	layer.close(closeInnser);
}	
/**
 * 信息提示框
 * @param content 需要提示的信息
 */
function showMsg(content){
	var width = 50;
	var height = 30;
	//计算当前屏幕距离顶部多少px
	var top = window.screen.availHeight - window.screenTop * 2 - height > 0? (window.screen.availHeight - window.screenTop * 2 - height)/2 : 0;
	//计算当前屏幕距离左边多少px
	var left = $(document.body).width() - width > 0? ($(document.body).width() - width)/2 : 0;
	layer.msg(content, {
		  	  time: 2000,//默认2秒
		  	  offset: [top+ 'px', left+ 'px']//可见视图中演示,,offset: 0,屏幕正上方显示
	});
}

//设置当前位置信息
function createPosition(items) {
	var html = '<span class="l"><b>您的位置:</b>&nbsp;<a href="/layout/content.html"><b class="menu-msg">首页</b></a>';
	for ( var i = 0; i < items.length; i++) {
		html += '&nbsp;»&nbsp;<b class="menu-msg">' + items[i] + '</b>';
	}
	html += '</span>';
	$(".t-head").html(html);
}
// dataTable
function initTable(tableId, tities, showPager) {
	// titles = [{key: "key", title: "title", filter: function(value, index, row, fieldIndex) {return value;}}];
	var tableObj = $("#" + tableId);
	tableObj.append("<thead></thead>");
	tableObj.append("<tbody></tbody>");
	var dataTitle = tableObj.find("thead");
	dataTitle.append("<tr></tr>");
	var titleLine = dataTitle.find("tr").last();
	for ( var i = 0; i < tities.length; i++) {
		titleLine.append("<th>" + tities[i].title + "</th>");
		if (parseInt(tities[i].width) >= 0) {
			titleLine.find("th").last().width(tities[i].width);
		}
	}
	if (showPager) {
		tableObj.append("<tfoot></tfoot>");
		var dataPager = tableObj.find("tfoot");
		dataPager.append('<tr><td colspan="' + tities.length + '" align="center"><div class="page"></div></td></tr>');
	}
}
// setPager
function setPager(tableId, functionName, dataCount, pageNum, pageSize, pageWidth) {
	var pager = $("#" + tableId).find(".page");
	if (pager.length > 0) {
		pager.html("");
		pager.append('<input type="hidden" name="pageNum" value="1" />');
		pager.append('<span>第<span class="pageNum">0</span>/<span class="pageTotal">0</span>页&nbsp;共<span class="dataCount">0</span>条记录</span>&nbsp;');
		pager.append('<span class="pageBtns"></span>');
		var pageTotal = Math.ceil(dataCount / pageSize);
		var previous = pageNum - 1 > 0 ? pageNum - 1 : 1;
		var next = pageNum + 1 < pageTotal ? pageNum + 1 : pageTotal;
		pager.find(".pageNum").html(pageNum);
		pager.find(".pageTotal").html(pageTotal);
		pager.find(".dataCount").html(dataCount);
		var pageBtns = pager.find(".pageBtns");
		pageBtns.append('<a class="linkStyle" onclick="' + functionName + '(1)">首页</a>\n');
		if(pageNum != 1){
		pageBtns.append('<a class="linkStyle" onclick="' + functionName + '(' + previous + ')">上页</a>\n');
		}
		var firstPage = pageNum - parseInt((pageWidth - 1) / 2);
		firstPage = firstPage > 0 ? firstPage : 1;
		var endPage = firstPage + pageWidth - 1;
		endPage = endPage < pageTotal ? endPage : pageTotal;
		firstPage = endPage - pageWidth + 1;
		firstPage = firstPage > 0 ? firstPage : 1;
		for (var i = firstPage; i <= endPage; i++) {
			if (i == pageNum) {
				pageBtns.append('<font style="color: red">' + i + '</font>\n');
			} else {
				pageBtns.append('<a class="linkStyle" onclick="' + functionName + '(' + i + ')">' + i + '</a>\n');
			}
		}
		if(pageNum != endPage){
			pageBtns.append('<a class="linkStyle" onclick="' + functionName + '(' + next + ')">下页</a>\n');
		}
		pageBtns.append('<a class="linkStyle" onclick="' + functionName + '(' + pageTotal + ')">尾页</a>\n');
		pageBtns.append('&nbsp;跳转到<input type="text" style="width: 40px;" />页');
		pageBtns.append('<input type="button" value="Go" onclick="jumpPage(\'' + functionName + '\', this,\'' + pageTotal + '\')" />');
	}
}
function jumpPage(functionName, btn,endPage) {
	var pageNum = parseInt($(btn).parent().find("input:text").val());
	if(pageNum > 0 && /\d+/.test(pageNum) && pageNum <= endPage){
		eval(functionName + '(' + pageNum + ')');
	}else{
		alert("请输入正确的页码!");
	}
}
// setData
function setData(tableId, tities, rows) {
	// titles = [{key: "a_key", name: "a_title", filter: function(value, index, row, fieldIndex) {return value;}}];
	// rows = [{id: "123", name: "jack", sex: 1, age: 17}];
	var dataBody = $("#" + tableId + " tbody");
	dataBody.html("");
	if(rows){
		for ( var i = 0; i < rows.length; i++) {
			dataBody.append("<tr></tr>");
			var line = dataBody.find("tr").last();
			for ( var ti = 0; ti < tities.length; ti++) {
				var title = tities[ti];
				line.append("<td></td>");
				var html = rows[i][title.key];
				var filter = title.filter;
				if (filter) {
					html = filter(rows[i][title.key], i, rows[i], ti);
				}
				line.find("td").last().html(html);
			}
		}
	}
}

function showRightLoding() {
	$(superWindow.document).find("#loadingDiv").show();
}
function hideRightLoding() {
	$(superWindow.document).find("#loadingDiv").hide();
}
/* 发送异步请求的方法  */
function ajaxResq(url,dt,cal,err){
	$.ajax({
		url:url,
		type: "POST",
		cache: false,
		dataType:"json",
		timeout:10000,
		data: dt,
		beforeSend: function(XMLHttpRequest){
			showRightLoding();
		},
		success:cal,
	    error: function(){
	    	alert("连接失败！请重试！");
	    	if (err) {
	    		err();
	    	}
	    },
		complete: function(XMLHttpRequest, textStatus){
			hideRightLoding();
		}
	});
}
