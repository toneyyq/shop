/**
 * 修改会员状态
 * @param name
 * @param status
 * @returns
 */
function status(id,status) {
	var url=getBasePath()+"/updatemstatus.action";
	var args={
		memberID:id,
		memberStatus:status
	}
	$.post(url,args,function (data) {
		if(data=="error"){
			alert("小喵开小差了，会员状态修改失败！");
		}else{
			window.location.reload();
		}
	},"json")
}

/**
 * 获取真实路径
 */
function getBasePath() {
	var localObj = window.location
	var protocol = location.protocol
	var host = localObj.host
	var contextPath = localObj.pathname.split("/")[1]
	var basePath = protocol + "//" + host + "/" + contextPath;
	return basePath;
}