/**
 * 删除公告
 * @param id
 * @returns
 */
function delPlacard(id) {
	var url = "delplacard.action";
	var args = {
		placardID: id
	}
	$.post(url, args,function(data) {
		if(data <=0) {
			//失败
			alert('小喵开小差了，删除失败，请重试！')
		} else {
			//成功
			window.location.reload();
		}
	},'json')
}