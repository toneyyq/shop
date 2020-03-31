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
		$('#smtype').html('<option value="0">请选择</option>');

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

//图片显示
$('#goodPic').bind(
	'change',
	function() {
		var obj = $(this)[0].files[0];
		var wuc = window.URL.createObjectURL(obj);
		$('#goodspic').show();
		$('#goodspic').attr('src', wuc);
		

	}
)


