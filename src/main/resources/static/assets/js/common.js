alert("world");
function isWeixnOpen(){
    var ua = navigator.userAgent.toLowerCase();
    alert(ua);
    if(ua.match(/MicroMessenger/i)=="micromessenger") {
    	alert("true");
        return true;
    } else {
    	alert("false");
        return false;
    }
}

if(isWeixnOpen()){
	$("#pageHeader").hide();
}