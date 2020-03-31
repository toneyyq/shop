//大类别下拉框
$.post("qtypesbypid.action", {
	"typeId": '0'
}, function(data) {
	$.each(data, function(index, obj) {
		$('#stype').append(
			'<option value="' + obj.typeID + '">' + obj.typeName +
			'</option>')
	})
}, "json")

// 改变事件
$('#stype').bind(
	'change',
	function() {
		var v_superid = $(this).val();
		$('#smtype').html('<option value="null">请选择</option>');

		// 如果v_superid=0表示用户选择的是请选择,中断程序执行,不会发送请求
		if(v_superid == 0) {
			return false;
		}
		$.post("qtypesbypid.action", {
			"typeId": v_superid
		}, function(data) {
			$.each(data, function(index, obj) {
				$('#smtype').append(
					'<option value="' + obj.typeName + '">' + obj.typeName +
					'</option>')
			})
		}, "json")
	});
/**
 * 补货
 */
function addNumber(goodsID) {
	var number = $('#reNumber'+ goodsID).val();
	var url = getBasePath() + "/addgNumber.action";
	var args = {
		goodsID: goodsID,
		addNumber: number
	}
	
	$.post(url, args, function(data) {
		if(data > 0) {
			$('#goodsNumber' + goodsID).text(data)
			$('#reNumber' + goodsID).text("")
		} else {
			alert("小喵开小差了，补货失败！请稍后重试")
		}
	})
}
/**
 * 商品改特价状态
 * @returns
 */
function sale(goodsID,isSale) {
	var url=getBasePath() + "/gsale.action";
	var args={
		goodsID:goodsID,
		isSale:isSale
	}
	$.post(url,args,function (data) {
		if(data<0){
			alert("小喵开小差了，特价修改失败！");
		}else{
			window.location.reload();
		}
	},"json")
}
/**
 * 改变商品状态
 * @param goodsID
 * @param isValid
 * @returns
 */
function valid(goodsID,isValid) {
	var url=getBasePath() + "/gvalid.action";
	var args={
		goodsID:goodsID,
		isValid:isValid
	}
	$.post(url,args,function (data) {
		if(data<0){
			alert("小喵开小差了，商品状态修改失败！")
		}else{
			window.location.reload()
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