//添加收藏
function addanddelfavorite(goodsID) {
	var temp=$('#collect').text()
	if (temp=='已收藏') {
		$.post('delfavorite.do', {
			goodsID: goodsID
		}, function(data) {
			if (data > 0) {
				
				$('#collect').text("收藏")
			} else {
				alert("取消收藏失败，其稍后重试！")
			}
		})
	}else {
		$.post('addfavorite.do', {
			goodsID: goodsID
		}, function(data) {
			if (data > 0) {
				
				$('#collect').text("已收藏")
			} else {
				alert("添加收藏失败，其稍后重试！")
			}
		})
	}
	
}

//加入购物车
function addcart(goodsID){
	var count=1
	$.post('addcart.do',{
		goodsID:goodsID,
		goodsCount:count
	},function(data){
		if (data>0) {
			alert("添加商品到购物车成功!")
		} else{
			alert("小喵开小差了,宝贝不小心走丢了,请重新添加吧")
		}
	})
}
