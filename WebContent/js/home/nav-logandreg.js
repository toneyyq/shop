$(
	function() {
		var member = $("#hiddenBtn").val();
		if(!member) {
			$("#logandreg").show()
			$("#nameandexit").hide()
		} else {
			$("#logandreg").hide()
			$("#nameandexit").show()
			//购物车
			$.post('cartcount.do',{},function(data){
				$('#J_MiniCartNum').text(data)
				$('#count').text(data)
			})
			
		}
		
		
		
	}
)