//省级别下拉框
$.post("getprovinces.action", function(data) {
	$.each(data, function(index, obj) {
		$('#province').append(
			'<option value="' + obj.provinceCode + '">' + obj.province +
			'</option>')
	})
}, "json")

// 改变事件 城市
$('#province').bind(
	'change',
	function() {
		var provinceCode = $(this).val();
		$('#city').html('<option value="0">请选择</option>');

		// 如果province=0表示用户选择的是请选择,中断程序执行,不会发送请求了
		if (provinceCode == 0) {
			return false;
		}
		$.post("getcities.action", {
			provinceCode: provinceCode
		}, function(data) {
			$.each(data, function(index, obj) {
				$('#city').append(
					'<option value="' + obj.cityCode + '">' + obj.city +
					'</option>')
			})
		}, "json")
	});

//改变事件 地区
$('#city').bind(
	'change',
	function() {
		var cityCode = $(this).val();
		$('#area').html('<option value="0">请选择</option>');

		// 如果city=0表示用户选择的是请选择,中断程序执行,不会发送请求了
		if (city == 0) {
			return false;
		}
		$.post("getareas.action", {
			cityCode: cityCode
		}, function(data) {
			$.each(data, function(index, obj) {
				$('#area').append(
					'<option value="' + obj.areaCode + '">' + obj.area +
					'</option>')
			})
		}, "json")
	});

// 失焦事件 判断添加地址是否有空值
$('#user-name,#user-phone,#user-intro').blur(function() {
	
	var data=$(this).val().replace(/(^\s*)|(\s*$)/g,'');
	if (data == null || data == undefined || data== "") {
		
		$(this).focus();
	}else {
		
	}
})

/**
 * 设置为默认地址
 * 
 * @param {Object}
 *            id
 */
function setAddressStatus(id) {
	$.post('setdefaddress.do', {
		id : id
	}, function(data) {
		if (data > 0) {
			// 刷新页面
			window.location.reload();

		} else {
			alert("设为默认地址时出现问题!请重试")
		}
	})
}

function delAdress(id) {
	$.post("deladdress.do",{
		id:id
	},function(data){
		if (data>0) {
			window.location.reload();
		}else {
			alert("小喵开小差了，删除失败，请刷新后重试！")
		}
	})
}

