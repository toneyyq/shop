$(
	function() {
		//失焦
		$("#name").blur(function() {
			//判断会员名是否存在
			var mname = $(this).val();
			var url = getBasePath()+"/checkmname.action";
			var args = {
				name: $(this).val()
			};
			$.post(url, args, function(data) {
				if(data == "false") {
					//关闭注册按钮
					$("#regbtn").attr("disabled", true)
				} else {
					//打开注册按钮
					$("#regbtn").attr("disabled", false)
				}
			})

		})
	}
)
/**
 * 获取真实路径
 * @returns	basePath 项目真实路径
 */
function getBasePath() {
	var localObj = window.location
	var protocol = location.protocol
	var host = localObj.host
	var contextPath = localObj.pathname.split("/")[1]
	var basePath = protocol + "//" + host + "/" + contextPath;
	return basePath;
}