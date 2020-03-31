$(function() {
	$('#oldpwd').focus();
	//原密码确认
	$('#oldpwd').blur(function() {
		var pwd = $('#oldpwd').val()
		var name = $('#membername').val()
		$.post("comparepwd.do", {
				name: name,
				pwd: pwd
			},
			function(data) {
				if (data > 0) {
					$('#btn').attr("disabled", false)
					$('#msg1').css('display','block')
					$('#msg1').css('color','green')
					$('#msg2').css('display','none')
					
				} else {
					$('#msg2').css('display','block')
					$('#msg2').css('color','red')
					$('#msg1').css('display','none')
					$('#btn').attr("disabled", true)
					$('#oldpwd').focus();

				}
			})

	})
})

function upPassword(id) {
	var newpwd = $('#newpwd').val();
	var renewpwd = $('#renewpwd').val();
	if (renewpwd != newpwd) {
		alert("两次输入新密码不一致！请重新填写")
		$('#newpwd').focus();
	} else {
		//修改密码
		$.post("updatmpwd.do", {
				id: id,
				newpwd: newpwd
			},
			function(data) {
				
				if (data > 0) {
					//进度条前进
					$('.u-progress-bar-inner').css('width', '100%')
					$('.step-2 .u-stage-icon-inner .bg').css('opacity', '1')
					
					//显示修改成功
					$('#form').hide();
					$('#msg').css('display','block')
					//跳转页面
				

				} else {
					alert("小喵开小差了，修改密码失败，请重试！")
				}
			})
	}

}


//获取真实路径
function getBasePath() {
	var localObj = window.location
	var protocol = location.protocol
	var host = localObj.host
	var contextPath = localObj.pathname.split("/")[1]
	var basePath = protocol + "//" + host + "/" + contextPath;
	return basePath;
}
