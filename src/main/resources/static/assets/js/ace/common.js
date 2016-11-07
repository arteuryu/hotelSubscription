MyObj={
  // 判断是否为空
  isEmpty:function(s){
    return typeof (s)=="undefined"||s==null||s=="";
  },
  // 为空返回默认值
  withoutEmpty:function(s){
  	if(this.isEmpty(s)){
  		s = "";
  	}
    return s;
  },

  hitch:function(desObj,srcObj){
    return function(){
      return srcObj.apply(desObj,arguments);
    };
  },

  _detectResult:null,

  // 判断浏览器版本
  detect:function(){
    if(this._detectResult){
      return this._detectResult;
    }
    var agent=navigator.userAgent;
    var opera=(agent.indexOf("Opera")!=-1);
    var ie=(agent.indexOf("MSIE")!=-1);
    var gecko=(agent.indexOf("Gecko")!=-1);
    var mozilla=(agent.indexOf("Mozilla")!=-1);
    var ns=(agent.indexOf("Netscape")!=-1);
    var result={browser:{opera:opera,ie:ie,gecko:gecko,mozzila:mozilla,ns:ns},version:navigator.appVersion};
    this._detectResult=result;
    return result;
  },
  splitId:function(obj,reg){
  	return obj.split(reg)[1];
  },
  startWith:function(source,str){
	if(str==null||str==""||source.length==0||str.length>source.length){
	  return false;
	}else if(source.substr(0,str.length)==str){
	  return true;
	}
	return false;
	},
  endWith:function(source,str){
	if(str==null||str==""||source.length==0||str.length>source.length){
	  return false;
	}else if(source.substring(source.length-str.length)==str){
	  return true;
	}
	  return false;
	},
	removeArrEL:function(arr,el){// 移除数组元素
		var l = arr.length;
		if(l > 0){
			var reArr = new Array();
			for(var i=0; i<l; i++) {
				if(arr[i] != el){
					reArr.push(arr[i]);
				}
			}
			return reArr;
		}else{
			return null;
		}
	},
	a:function(str){
		if(true){
			alert(str);
		}
	},
	isShow:function(id){// 检查一个div是否显示
       var obj = document.getElementById(id);
       var ds = obj.style.display;
       if("block" == ds){
       	return true;
       }
       return false;
	},
	trim:function(str){
		var reg = /(^\s*)|(\s*$)/g;
		return str.replace.call(str,reg,"");
	},
	isTel:function(str){// "兼容格式: (+)国家代码(2到3位)-区号(3到4位)-电话号码(7到8位)-分机号(3位)"
	    var realStr = this.trim(str);
	    return (/^((\+?0?\d{2,3}-)?(0?\d{2,3})-)(\d{7,8})(-(\d{3}))?$/.test(realStr));
	},
	isInteger:function(str){
	   var patrn=/^[1-9]+\d*$/;
       return patrn.test(str);
   },
   getStringLength:function(str){
   	    var count =0;
		for (var i=0; i<str.length; i++) {
			if (str.charCodeAt(i)>=256) {
		      		count+=2;
		   	} else {
		      		count+=1;
		    	}
		}
		return count;
   },
   isLimitInteger:function(str){
	   var patrn=/^[1-9]+\d{0,1}$/;
       return patrn.test(str);
   },
   /*全角空格为12288，半角空格为32 
    *其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248 
    *半角转换为全角函数 */
   ToDBC:function(txtstring){
	   	var tmp = ""; 
	   	if(txtstring){
	   		for(var i=0;i<txtstring.length;i++) {
	   			if(txtstring.charCodeAt(i)==32){
	   				tmp= tmp+ String.fromCharCode(12288); 
	   			}
	   			if(txtstring.charCodeAt(i)<127) {
	   				tmp=tmp+String.fromCharCode(txtstring.charCodeAt(i)+65248); 
	   			}
	   		}
	   	}
   	return tmp; 
   }, 
   //全角转换为半角函数 
   ToCDB:function(str){
	   	var tmp = ""; 
	   	if(str){
	   		for(var i=0;i<str.length;i++){
	   			if(str.charCodeAt(i)>65248&&str.charCodeAt(i)<65375){ 
	   				tmp += String.fromCharCode(str.charCodeAt(i)-65248); 
	   			}else{
	   				tmp += String.fromCharCode(str.charCodeAt(i)); 
	   			} 
	   		} 
	   	}
   	
   	return tmp ;
   },
   /**
    * 手机号码去掉+86，全角转半角，去掉空格，_或者-去掉
    */
   getMobileNo:function(cellphone) {
       if (cellphone || cellphone !="null"){
               cellphone = this.ToCDB(cellphone);
               cellphone = cellphone.replace(/\-| |\+86|\s|_/g,"");
               if (MyObj.startWith(cellphone,"86")) {
                       cellphone = cellphone.substring(2, cellphone.length);
               }
               if (MyObj.startWith(cellphone,"0")) {
                       cellphone = cellphone.substring(1, cellphone.length);
               }
       }else{
       	cellphone = "";
       }
       return cellphone;
   }
};

	/**
	 * 开始，结束日期比较 1 开始日期大于结束日期 0 开始日期等于结束日期 -1 开始日期小于结束日期 -2 日期格式不正确 'yyyy-MM-dd'
	 */
	function compareDate(startDate,endDate) {
		var datePattern = /^(\d{4}-\d{1,2}-\d{1,2})|(\d{4}-\d{1,2}-\d{1,2} \d{1,2}:\d{1,2}:\d{1,2})$/;
		if (!datePattern.test(startDate)) {
			return "-2";
		}
		if (!datePattern.test(endDate)) {
			return "-2";
		}
		var date1 = parseStrToDate(startDate);
		var date2 = parseStrToDate(endDate);
		if(date1 > date2)
			return "1";
		else if (date1 < date2)
			return "-1";
		else
			return "0";
	}
	
	function monthBetweenDate(date1,date2){
		var year1 = date1.getYear();
		var year2 = date2.getYear();
		var month1 = date1.getMonth();
		var month2 = date2.getMonth();
		var day1 = date1.getDate();
		var day2 = date2.getDate();
		if(month1!=11)// 如果是12月的情况下另外计算（用date.month月份比实际小1）
		{
			if(year2-year1>0)
			{
				return false;
				}
			if((year2==year1)&&(month2-month1)>1)
			{
				return false;
			}
			if((year2==year1)&&(month2-month1)==1&&(day2>day1))
			{
				return false;
			}
			if((year2==year1)&&(month2-month1)==1&&(day2<=day1))
			{
				return true;
			}
			if((year2==year1)&&(month2-month1)==0)
			{
				return true;
			}
		}else{
			if(year2-year1>1)
			{
				return false;
			}
			if((year2-year1)==1&&month2>=2)
			{
				return false;
			}
			if((year2-year1)==1&&month2==0&&day2>day1)
			{
				return false;
			}
			if((year2-year1)==1&&month2==0&&day2<day1)
			{
				return true;
			}
			if((year2-year1)==0&&month2==11&&day2>=day1)
			{
				return true;
			}
		}
	}

/**
 * 给字符串对象添加截取空格的trim方法
 */
String.prototype.trim = function() {
	var reg = /(^\s*)|(\s*$)/g;
	return this.replace.call(this,reg,"");
}
/**
 * 把"yyyy-MM-dd"的字符串转化为Date对象
 */
function parseStrToDate(str){
	if(str && str.trim() != ""){
		// var regDate = /(\d*)-(\d*)-(\d*)/g;
		// var strDate = str.replace(regDate,"$2-$3-$1");
		var strDate = str.replace(/-/g,"/");
		return new Date(strDate);
	}
}

/**
 * 返回date1与date2相差的天数,格式为"yyyy-mm-dd"
 */
function dayBetweenDate(date1,date2){
	if (date1.trim() == "" || date2.trim() == "")
		return 0;

	var dat1 = parseStrToDate(date1);
	var dat2 = parseStrToDate(date2);


	return Math.floor((dat2.getTime() - dat1.getTime()) / 86400000);
}

/**
 * 去左空格 半角，全角
 */
	function ltrim(s){
		return s.replace( /^[" "|"　"]*/, "");
	}
	/**
	 * 去右空格 半角，全角
	 */
	function rtrim(s){
		return s.replace( /[" "|"　"]*$/, "");
	}

	/**
	 * 去左右空格 半角，全角
	 */
	function trim(s){
		return rtrim(ltrim(s));
	}

// 绑定事件
MyObj.Event={
  bind:function(_obj,_event,_fun,_flag){
    _flag=_flag||false;

    var _browserType=MyObj.detect();

    if(_browserType.browser.ie){
      _obj.attachEvent("on"+_event,_fun);
    }else {
      _obj.addEventListener(_event,_fun,_flag);
    }
  },
  // 解绑事件
  unbind:function(_obj,_event,_fun,_flag){
    _flag=_flag||false;
    var _browserType=MyObj.detect();
    if(_browserType.browser.ie){
      _obj.detachEvent("on"+_event,_fun);
    }else {
      _obj.removeEventListener(_event,_fun,_flag);
    }
  }
};

function submitToTarget(url,targetid){
		  if(window.frames[targetid]!=''&&window.frames[targetid]!=null){
		    window.frames[targetid].location.href=url;
		  }else{
		  if(window.parent.frames[targetid]==null){
		      var newWin=window.open(url, targetid, "resizable=yes,menubar=yes,toolbar=yes,location=yes,scrollbars=yes,height=600,width=795,top=0,left=0",true);
		      newWin.name=targetid;
		      newWin.focus();
		  }
		  else
		    window.parent.frames[targetid].location.href=url;
		  }
}

var coos = function(){this.version = "0.2";};

/**
 * * 根据id快速获取dom对象的方法 *
 * 
 * @param id
 *            字符串类型 *
 * @return DOM element
 */
coos.$id = function(id){  return document.getElementById(id);};

/**
 * * 在不确定传入id还是obj类型时快速获取dom对象的方法 *
 * 
 * @param el
 *            id或obj *
 * @return DOM element
 */

coos.$obj = function(el){
var obj = el;
if(typeof(el) == "string")
obj = document.getElementById(el);
 return obj;};

 /** * iframe的处理函数 * 提供批量和单独iframe自适应高度功能 */

 coos.iframe = {    autoHeights : function(els)    {
  for (var i = 0; i < arguments.length; i++)         {
   coos.iframe.autoHeight(arguments[i]);        }    },
    autoHeight : function(el)    {
     var obj = coos.$obj(el);
      var id = obj.id;
      var subWeb = document.frames ? document.frames[id].document : obj.contentDocument;
       if(obj != null && subWeb != null)        {
       	    var currentHeight=parseInt(subWeb.documentElement.scrollHeight);
      	 		obj.height = parseInt(subWeb.documentElement.scrollHeight) + "px";
      	 }
       }};
       
     function EncodeUtf8(s1) 
  { 
      var s = escape(s1); 
      var sa = s.split("%"); 
      var retV =""; 
      if(sa[0] != "") 
      { 
         retV = sa[0]; 
      } 
      for(var i = 1; i < sa.length; i ++) 
      { 
           if(sa[i].substring(0,1) == "u") 
           { 
               retV += Hex2Utf8(Str2Hex(sa[i].substring(1,5))); 
                 
           } 
           else retV += "%" + sa[i]; 
      } 
        
      return retV; 
  } 
  function Str2Hex(s) 
  { 
      var c = ""; 
      var n; 
      var ss = "0123456789ABCDEF"; 
      var digS = ""; 
      for(var i = 0; i < s.length; i ++) 
      { 
         c = s.charAt(i); 
         n = ss.indexOf(c); 
         digS += Dec2Dig(eval(n)); 
             
      } 
      return digS; 
  } 
  function Dec2Dig(n1) 
  { 
      var s = ""; 
      var n2 = 0; 
      for(var i = 0; i < 4; i++) 
      { 
         n2 = Math.pow(2,3 - i); 
         if(n1 >= n2) 
         { 
            s += '1'; 
            n1 = n1 - n2; 
          } 
         else
          s += '0'; 
            
      } 
      return s; 
        
  } 
  function Dig2Dec(s) 
  { 
      var retV = 0; 
      if(s.length == 4) 
      { 
          for(var i = 0; i < 4; i ++) 
          { 
              retV += eval(s.charAt(i)) * Math.pow(2, 3 - i); 
          } 
          return retV; 
      } 
      return -1; 
  }  
  function Hex2Utf8(s) 
  { 
     var retS = ""; 
     var tempS = ""; 
     var ss = ""; 
     if(s.length == 16) 
     { 
         tempS = "1110" + s.substring(0, 4); 
         tempS += "10" +  s.substring(4, 10);  
         tempS += "10" + s.substring(10,16);  
         var sss = "0123456789ABCDEF"; 
         for(var i = 0; i < 3; i ++) 
         { 
            retS += "%"; 
            ss = tempS.substring(i * 8, (eval(i)+1)*8); 
              
              
              
            retS += sss.charAt(Dig2Dec(ss.substring(0,4))); 
            retS += sss.charAt(Dig2Dec(ss.substring(4,8))); 
         } 
         return retS; 
     } 
     return ""; 
  }  
  var lockScreen = {
		lockOption: {
			css: {
				position: 'fixed',
				zIndex: '102',
				background: 'url(images/cmm/bg_white.png) repeat',
				color: '#2b6188',
				border: '#a5bade solid 2px',
				width: '110px',
				height: '20px',
				textAlign: 'center',
				padding: '10px 0px 10px 0px',
				margin: 'none',
				fontFamily: 'Arial,Helvetica,sans-serif',
				fontWeight: 'bold',
				fontSize: '12px',
				top: '50%',
				left: '50%',
				display: 'block'
			},
			onUnblock: function(opts){
				return false;
			},
			onLock: function(opts){
				return false;
			},
			win: window
			// message: '<img align="absmiddle" src="images/cmm/loading.gif"
			// />&nbsp;Loading...'
		},
		lockEL: function(options){
			jQuery.extend(this.lockOption, options || {});
			var el = this.lockOption.win.document.body, win = this.lockOption.win, $dl = jQuery("#div_lock_screen", el).first();
			if($dl && $dl.length>0){
				$dl.show();
				return this.lockOption.onLock(this.lockOption);
			}
			
			var $t  = jQuery(this.getTemplate()),$o = jQuery("#div_lock_overlay", $t);
			if(this.lockOption.message){
				jQuery("#div_lock_message", $t).css(this.lockOption.css).html(this.lockOption.message);
			}
			if(jQuery.browser.msie && '6.0'==jQuery.browser.version){
				var $win = jQuery(win), $w = $win.width(), $h = $win.height();
				$o.css({
					position: 'absolute',
					width: $w,
					height: $h	
				});
			}
			jQuery(el).append($t.html());
			return this.lockOption.onLock(this.lockOption);
		},
		unLockEl: function(rendWin){
			var el = this.lockOption.win.document.body, $dl = jQuery("#div_lock_screen", el).first();
			if($dl && $dl.length>0){
				$dl.hide();
				return this.lockOption.onUnblock(this.lockOption);
			}
		},
		getTemplate: function(){
			var template = "<div><div id='div_lock_screen'>"
						 + 		"<div id='div_lock_overlay'></div>"
						 + 		"<div id='div_lock_message' style='display:none;'></div>"
						 + "</div></div>";
			return template;
		}
	}
  var div_show = {
	getPosition: function($t){
		var $d = jQuery("div.aui_content:first", $t);
		var $w = $d.width(), $h = $d.height();
		var win = this.defaults.rendToWin, bo = win.document.body;
		
		var divLeft = bo.clientWidth / 2 - $w / 2;
       	var divTop = bo.clientHeight / 2 - $h / 2;
       	
    	var hh = win.screen.height / 2 - $h / 2 - (win.screenTop || 0);
       	return {left: divLeft, top: hh};
	 
	 	// if is IE6
       	/*
		 * if(jQuery.browser.msie && '6.0'==jQuery.browser.version){ $t.css("position", "absolute"); } var $d = jQuery("div.aui_content:first", $t), $w =
		 * $d.width(), bo = this.defaults.rendToWin.document.body; var divLeft = bo.clientWidth / 2 - $w / 2; return divLeft;
		 */
	},
	getView: function(url){
		var $t = jQuery(this.getTemplate());
		jQuery("iframe:first", $t).attr("src", url);
		jQuery("div.aui_content:first", $t).css({
			width: this.defaults.width,
			height: this.defaults.height
		});
		jQuery("iframe:first", $t).attr("scrolling", this.defaults.scrolling);
		
		// --最原始copy过来数据satart
		// var left = this.getPosition($t);
		// $t.css({"left": left, "top": "10%"});
		// --最原始copy过来数据end
		
		// $t.css({"left": pos.left, "top": pos.top});
		var pos = this.getPosition($t);
		if(this.defaults.left == undefined || this.defaults.left == "35%"){
			$t.css({"left": "35%", "top": "10%"}); //该页面此参数改为定值
		}else{
			$t.css({"left": this.defaults.left, "top": "10%"}); //该页面此参数改为定值
			this.defaults.left = "35%";
		}
		
		var $d = jQuery("div.aui_title:first", $t);
		jQuery("span:first", $d).html(this.defaults.title);
		
		var that = this;
		jQuery("a:first", $d).bind("click", function(){
			that.hide();
			try{
				parent.closeMyDiv();
			}catch(e){}
			
		});
		
		this.$t = $t;
		return $t;
	},
	hide: function(){
		this.defaults.isRemove ? this.remove() : this.$t.hide();
		lockScreen.unLockEl(this.defaults.rendToWin);
	},
	remove: function(){
		$("#div_lock_screen").remove();
		this.$t && this.$t.remove();
		this.$t = undefined;
	},
	show: function(config){
		jQuery.extend(this.defaults, config || {});
		this.defaults.isRemove && this.remove();
		var url = this.defaults.url;
		if(!url){
			return false;
		}
		
		var rendWin = this.defaults.rendToWin;
		lockScreen.lockEL({
			win: rendWin,
			message: this.defaults.message
		});
		
		if(this.$t){
			this.defaults.refreshEachTime && this.refreshIframe(url);
			this.$t.show();
			return false;
		}
		jQuery(rendWin.document.body).append(this.getView(url));
	},
	refreshIframe: function(url){
		jQuery("iframe", this.$t).attr("src", url);
		jQuery("span:first", this.$t).html(this.defaults.title);
	},
	defaults: {
		isRemove: true,
		width: '600px',
		height: '400px',
		rendToWin: window,
		title: '弹出框',
		url: '',
		refreshEachTime: true,
		scrolling: 'no',
		left : '35%'
	},
	getTemplate: function(){
		var template = '<div class="aui_inner" style="position:fixed;z-index:9999;background:#FFF;border:4px solid #CCCCCC;">'
					+	'<table class="aui_dialog" style="border:1px solid #ccc;">'
					+			'<tr>'
					+					'<td class="aui_header">'
					+						'<div class="aui_titleBar">'
					+							'<div class="aui_title">'
					+								'<span style="position:absolute;top:2px;">弹出层</span>'
					+								'<a class="aui_close" style="position:absolute;right:6px;top:2px;" href="javascript:void(0);">X</a>'
					+							'</div>'
					+						'</div>'
					+					'</td>'
					+			'</tr>'
					+			'<tr>'
					+				'<td class="aui_icon" style="display:none;">'
					+					'<div></div>'
					+				'</td>'
					+				'<td class="aui_main">'
					+					'<div class="aui_content" style="padding:0px;margin:0px;border:0px;">'
					+						'<iframe name="myDivName" id="myDivId" src="" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>'
					+					'</div>'
					+				'</td>'
					+			'</tr>'
					+			'<tr>'
					+				'<td colspan="2" class="aui_footer" style="display:none;">'
					+					'<div class="aui_buttons">'
					+						'<button class="aui_state_highlight">确定</button>'
					+						'<button>取消</button>'
					+					'</div>'
					+				'</td>'
					+			'</tr>'
					+	'</table>'
					+ '</div>';
		return template;
	}
};