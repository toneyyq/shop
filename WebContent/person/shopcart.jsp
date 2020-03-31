<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>购物车页面</title>

		<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/cartstyle.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/optstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/amazeui.js" type="text/javascript"></script>

	</head>

	<body>

		<header>
			<article>
				<div class="mt-logo">
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

			</article>
		</header>
		<!--购物车 -->
		<div class="concent">
			<div id="cartTable">
				<div class="cart-table-th">
					<div class="wp">
						<div class="th th-chk">
							<div id="J_SelectAll1" class="select-all J_SelectAll">

							</div>
						</div>
						<div class="th th-item">
							<div class="td-inner">商品信息</div>
						</div>
						<div class="th th-price">
							<div class="td-inner">单价</div>
						</div>
						<div class="th th-amount">
							<div class="td-inner">数量</div>
						</div>
						<div class="th th-sum">
							<div class="td-inner"> &nbsp;</div>
						</div>
						<div class="th th-op">
							<div class="td-inner">操作</div>
						</div>
					</div>
				</div>
				<div class="clear"></div>
				<tr class="item-list">
					<div class="bundle  bundle-last ">
						<div class="bundle-main">
						<!-- 购物车商品显示 -->
						
							<c:forEach	items="${ cartmap}" var="cart" >
							<form id="addorder" action="${pageContext.request.contextPath}/toaddorder.do" method="post">
							<ul class="item-content clearfix">
								<li class="td td-item">
									<div class="item-pic">
										<a href="${pageContext.request.contextPath}/tointroduction.action?id=${cart.value.goodsID}" target="_blank" class="J_MakePoint" data-point="tbcart.8.12">
											<img src="${pageContext.request.contextPath}${cart.value.goodsPicture}" class="itempic J_ItemImg" height="80px" width="80px"></a>
									</div>
									<div class="item-info">
										<div class="item-basic-info">
											<a href="${pageContext.request.contextPath}/tointroduction.action?id=${cart.value.goodsID}" target="_blank" title="${cart.value.goodsName }" class="item-title J_MakePoint" data-point="tbcart.8.11">${cart.value.goodsName }</a>
										</div>
									</div>
								</li>
								<li class="td td-info">
									<div class="item-props ">

									</div>
								</li>
								<li class="td td-price">
									<div class="item-price price-promo-promo">
										<div class="price-content">
											<div class="price-line">
												<em class="price-original">${cart.value.goodsNormalPrice }</em>
											</div>
											<div class="price-line">
												<em class="J_Price price-now" tabindex="0">${cart.value.goodsMemberPrice }</em>
											</div>
										</div>
									</div>
								</li>
								<li class="td td-amount">
									<div class="amount-wrapper ">
										<div class="item-amount ">
											<div class="sl">
												<input type="hidden" name="goodsID" value="${cart.value.goodsID }"/>
												<input class="min am-btn" name="" type="button" value="-" onclick="setcount(1)" />
												<input id="goodsCount${cart.key.cartID }" class="text_box" name="goodsCount" type="text" value="${cart.key.goodsCount}" style="width:30px;" />
												<input class="add am-btn" name="" type="button" value="+" onclick="setcount(-1)" />
											
											</div>
										</div>
									</div>
								</li>
								<li class="td td-sum">
									<div class="td-inner">
									</div>
								</li>
								<li class="td td-op">
									<div class="td-inner">
										<center>
										<button title="去支付" class="btn-fav am-btn-lg am-btn-danger" type="submit">去支付</button>
										
										<a href="javascript:delcart(${cart.key.cartID });"  class="delete">
											删除</a>
										</center>
									</div>
								</li>
							</ul>
							</form>
							
							</c:forEach>
						</div>
					</div>
				</tr>
				
				
				<div class="clear"></div>

			</div>
			<div class="clear"></div>

			

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

		</div>
		<!--引导 -->
		<ul class="navCir">
			<li class="active">
				<a href="${pageContext.request.contextPath}/toindex.action"><i class="am-icon-home "></i>首页</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/qgoodsbynameortype.action"><i class="am-icon-list"></i>搜索</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/cart.do"><i class="am-icon-shopping-basket"></i>购物车</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/myindex.do"><i class="am-icon-user"></i>我的</a>
			</li>
		</ul>
		<!-- 顶部导航栏判断是否已经登陆 -->
		<script type="text/javascript" src="js/home/nav-logandreg.js"></script>
		<script type="text/javascript">
			function delcart(cartID) {
				$.post('delcart.do',{
					cartID:cartID
				},function(data){
					window.location.reload()
				})
			}
			
			
		</script>
	</body>

</html>