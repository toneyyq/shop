<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<title>付款结束提示</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" />
		<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/basic/css/demo.css" rel="stylesheet" type="text/css" />

		<link href="${pageContext.request.contextPath}/css/sustyle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/basic/js/jquery-1.7.min.js"></script>

	</head>

	<body>

		<div id="header">
		<div class="hmtop">
			<!--顶部导航条 -->
			<div class="am-container header">
				<ul class="message-l">
					<li class="topMessage">
						<!-- 隐藏 -->
						<input id="hiddenBtn" type="hidden" value="${sessionScope.member}" />
						
						<div id="logandreg" class="menu-hd">
							<a href="${pageContext.request.contextPath}/login.jsp" target="_top" class="h">亲，请登录</a>
							<a href="${pageContext.request.contextPath}/register.jsp" target="_top">免费注册</a>
						</div>
						<div id="nameandexit" class="menu-hd" >
							<a href="${pageContext.request.contextPath}/myindex.do" target="_top" class="h">${sessionScope.member.memberName},欢迎您！</a>
							&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath}/mexit.do" target="_top">注销</a>
						</div>
					</li>
				</ul>
				<ul class="message-r">
					<li class="topMessage home">
						<div class="menu-hd">
							<a href="${pageContext.request.contextPath}/toindex.action" target="_top" class="h">商城首页</a>
						</div>
					</li>
					<li class="topMessage my-shangcheng">
						<div class="menu-hd MyShangcheng">
							<a href="${pageContext.request.contextPath}/myindex.do" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
						</div>
					</li>
					<li class="topMessage mini-cart">
						<div class="menu-hd">
							<a id="mc-menu-hd" href="${pageContext.request.contextPath}/cart.do" target="_top">
								<i class="am-icon-shopping-cart  am-icon-fw"></i>
								<span>购物车</span>
								<strong id="J_MiniCartNum" class="h">0</strong>
							</a>
						</div>
					</li>
					<li class="topMessage favorite">
						<div class="menu-hd">
							<a href="${pageContext.request.contextPath}/user/tologin.action" target="_top"><span>后台</span></a>
						</div>
					</li>
				</ul>
			</div>

			<!--悬浮搜索框-->
			<div class="nav white">
				<div class="logo"><img src="images/logo-1.png" /></div>
				<ul class="logoBig">
					
					<li><img src="images/logo-2.png" width="100px" height="90px" /></li>
					<li><img src="images/logo-1.png" width="100px" height="90px" /></li>
				</ul>

				<div class="search-bar pr">
					<form action="qgoodsbynameortype.action">
						<input id="searchInput" name="goodsName" type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
					</form>
				</div>
			</div>

			<div class="clear"></div>
		</div>
		<div id="success" class="take-delivery">
			<div class="status">
				<h2>您已成功付款</h2>
				<div class="successInfo">
					<ul>
						<li>付款金额<em>¥${order.orderAmount }</em></li>
						<div class="user-info">
							<p>收货人：${addressBook.memberName }</p>
							<p>联系电话：${addressBook.memberTelephone }</p>
							<p>收货地址：${addressBook.provinceCode} ${addressBook.cityCode} ${addressBook.areaCode} ${addressBook.memberAddress}</p>
						</div>
						请认真核对您的收货信息，如有错误请联系客服

					</ul>
					<div class="option">
						<span class="info">您可以</span>
						查看<a href="${pageContext.request.contextPath}/tointroduction.action?id=${goodsID}" class="J_MakePoint"><span>已买到的宝贝</span></a>
						查看<a href="${pageContext.request.contextPath}/myorders.do" class="J_MakePoint"><span>交易详情</span></a>
					</div>
				</div>
			</div>
			
		</div>
		<!-- 付款失败 -->
		<div id="flunk" style="display:none;" class="take-delivery">
			<div class="status">
				<h2>付款失败！可前往
					<a href="${pageContext.request.contextPath}/myorders.do">我的订单 </a>
					 重新付款
				</h2>
				<div class="successInfo">
					<ul>
						<li>待付款金额<em>¥${order.orderAmount }</em></li>
						<div class="user-info">
							<p>收货人：${addressBook.memberName }</p>
							<p>联系电话：${addressBook.memberTelephone }</p>
							<p>收货地址：${addressBook.provinceCode} ${addressBook.cityCode} ${addressBook.areaCode} ${addressBook.memberAddress}</p>
						</div>
						

					</ul>
					<div class="option">
						<span class="info">您可以</span>
						查看<a href="${pageContext.request.contextPath}/tointroduction.action?id=${goodsID}" class="J_MakePoint"><span>宝贝信息</span></a>
						查看<a href="${pageContext.request.contextPath}/myorders.do" class="J_MakePoint"><span>我的订单 </span></a>
					</div>
				</div>
			</div>
			
		</div>

		<div class="footer ">
			<div class="footer-hd ">
				<p>
					<a href="# ">缘起</a>
					<b>|</b>
					<a href="# ">商城首页</a>
					<b>|</b>
					<a href="# ">支付宝</a>
					<b>|</b>
					<a href="# ">物流</a>
				</p>
			</div>
			<div class="footer-bd ">
				<p>
					<a href="# ">关于缘起</a>
					<a href="# ">合作伙伴</a>
					<a href="# ">联系我们</a>
					<a href="# ">网站地图</a>
					<em>© 2015-2025 YuanQi.com 版权所有</em>
				</p>
			</div>
		</div>
		
		<script type="text/javascript">
			$(function() {
				var tatus=${order.orderStatus}
				if (tatus < 0) {
					$('#success').css('display','none')
					$('#flunk').css('display','block')
				}
			})
		</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/home/nav-logandreg.js"></script>
	</body>

</html>