$('#J_Go')
		.mousemove(
				function() {
					/**
					 * 选择地址响应
					 */
					var addressid = $('#addresscheck > .defaultAddr > #id')
							.val();
					var cprovince = $(
							'#addresscheck > .defaultAddr > .address-left > .default-address > .buy--address-detail > .province')
							.text()
					var ccity = $(
							'#addresscheck > .defaultAddr > .address-left > .default-address > .buy--address-detail  > .city')
							.text()
					var carea = $(
							'#addresscheck > .defaultAddr > .address-left > .default-address > .buy--address-detail  > .dist')
							.text()
					var caddress = $(
							'#addresscheck > .defaultAddr > .address-left > .default-address > .buy--address-detail  > .street')
							.text()
					var cmname = $(
							'#addresscheck > .defaultAddr > .address-left > .user > .buy-address-detail > .buy-user')
							.text()
					var ctel = $(
							'#addresscheck > .defaultAddr > .address-left > .user  > .buy-address-detail > .buy-phone')
							.text()
					$('#addressid').valueOf(addressid);
					$('#cprovince').text(cprovince)
					$('#ccity').text(ccity)
					$('#carea').text(carea)
					$('#caddress').text(caddress)
					$('#cmname').text(cmname)
					$('#ctel').text(ctel)

				})

/**
 * 商品数量改变响应 code 加减数
 */
function changecount(code) {
	var number = $('#number').val()
	var count = $('#goodsCount').val()
	if (code > 0) {
		count++
	} else {
		count--
	}
	if (count < 1) {
		count = 1;
	}
	if (count > number) {
		count = number
	}
	var price = $('#goodsprice').val()
	$('#orderAomunt').val(count * price)
	$('#amount').text(count * price)
	$('#J_ActualFee').text(count * price)
}

$('#goodsCount').blur(function() {
	var count = $('#goodsCount').val()
	var price = $('#goodsprice').val()
	$('#orderAomunt').val(count * price)
	$('#amount').text(count * price)
	$('#J_ActualFee').text(count * price)

})

/**
 * 支付
 * 
 * @returns
 */
function pay() {
	var pwd = $('#pwd').val()
	var amount = $('#J_ActualFee').text()
	$.post('pwdtopay.do', {
		pwd : pwd,
		amount : amount
	}, function(data) {
		if (data > 0) {
			//支付成功
			$('#orderStatus').val('1')
		}else if(data < 0){
			//余额不足
			alert("余额不足")
		}
		$('#orderform').submit()
			
	})

}

// 省级别下拉框
$.post("getprovinces.action", function(data) {
	$.each(data, function(index, obj) {
		$('#province').append(
				'<option value="' + obj.provinceCode + '">' + obj.province
						+ '</option>')
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
				provinceCode : provinceCode
			}, function(data) {
				$.each(data, function(index, obj) {
					$('#city').append(
							'<option value="' + obj.cityCode + '">' + obj.city
									+ '</option>')
				})
			}, "json")
		});

// 改变事件 地区
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
				cityCode : cityCode
			}, function(data) {
				$.each(data, function(index, obj) {
					$('#area').append(
							'<option value="' + obj.areaCode + '">' + obj.area
									+ '</option>')
				})
			}, "json")
		});

// 失焦事件 判断添加地址是否有空值
$('#membername,#memberphone,#memberAddress').blur(function() {
	// 不为空项
	var data = $(this).val().replace(/(^\s*)|(\s*$)/g, '');
	if (data == null || data == undefined || data == "") {

		$(this).focus();
	} else {

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
			// 修改订单地址
			setorderaddid(data)

		} else {
			alert("设为默认地址时出现问题!请重试")
		}
	})
}
//修改订单地址
function setorderaddid(id) {
	var orderID = $('#orderID').val()
	$.post('setorderaddressid.do', {
		orderID : orderID,
		id : id
	}, function(data) {
		if (data > 0) {
			window.location.href=getBasePath()+'/topay.do?orderID='+orderID
		} else {
			alert("修改订单出现问题")
		}
	})
}

/**
 * 添加地址
 */
function addAddress() {
	
	var memberID = $('#mid').val()
	var memberName = $('#membername').val()
	var memberAddress = $('#memberAddress').val()
	var provinceCode = $('#province').val()
	var cityCode = $('#city').val()
	var areaCode = $('#area').val()
	var memberTelephone = $('#memberphone').val()
	// 状态 0为普通地址 1为默认地址
	var tatus = 0
	$.post('addAddress.do', {
		memberID : memberID,
		memberName : memberName,
		memberAddress : memberAddress,
		provinceCode : provinceCode,
		cityCode : cityCode,
		areaCode : areaCode,
		memberTelephone : memberTelephone,
		tatus : tatus

	}, function(data) {
		if (data > 0) {
			// 添加地址成功
			reload()
		} else {
			
		}
	})
}
//刷新页面
function reload() {
	var orderID = $('#orderID').val()
	window.location.href=getBasePath()+'/topay.do?orderID='+orderID
}

/**
 * 删除地址
 * 
 * @param {Object}
 *            id
 */
function delAdress(id) {
	
	$.post("deladdress.do", {
		id : id
	}, function(data) {
		if (data > 0) {
			reload()
		} else {
			alert("小喵开小差了，删除失败，请刷新后重试！")
		}
	})
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


