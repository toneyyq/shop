<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>个人中心</title>

		<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/basic/css/demo.css" rel="stylesheet" type="text/css" />
		
		<link href="${pageContext.request.contextPath}/css/personal.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/systyle.css" rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
	</head>

	<body>
		<!--头 -->
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
		<div class="nav-table">
			<div class="nav-cont">
				<ul>
					<li class="index">
						<a href="${pageContext.request.contextPath}/toindex.action">首页</a>
					</li>
					<li class="qc">
						<a href="#">闪购</a>
					</li>
					<li class="qc">
						<a href="#">限时抢</a>
					</li>
					<li class="qc">
						<a href="#">团购</a>
					</li>
				</ul>

			</div>
		</div>
		<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">
					<div class="wrap-left">
						<div class="wrap-list">
							<div class="m-user">
								<!--个人信息 -->
								<div class="m-bg"></div>
								<div class="m-userinfo">
									<div class="m-baseinfo">
										<a href="${pageContext.request.contextPath}/tomyinfo.do">
											<!--改图片-->
											<img src="${pageContext.request.contextPath}/images/getAvatar.do.jpg">
										</a>
										<div class="s-prestige am-btn am-round">
											
											<em class="s-name">昵称：${sessionScope.member.memberName}</em>
										</div>
									</div>

								</div>
								
								<!--九宫格(小屏幕显示)-->
								<div class="user-patternIcon">
									<div class="s-bar">
										<i class="s-icon"></i>我的常用
									</div>
									<ul>

										<a href="${pageContext.request.contextPath}/cart.do">
											<li class="am-u-sm-4"><i class="am-icon-shopping-basket am-icon-md"></i><img src="${pageContext.request.contextPath}/images/iconbig.png" />
												<p>购物车</p>
											</li>
										</a>
										<a href="${pageContext.request.contextPath}/mycollect.do">
											<li class="am-u-sm-4"><i class="am-icon-heart am-icon-md"></i><img src="${pageContext.request.contextPath}/images/iconsmall1.png" />
												<p>我的收藏</p>
											</li>
										</a>
									</ul>
								</div>
								<!--收藏夹 -->
								<div class="you-like">
									<div class="s-bar">我的收藏
										<c:if test="${favorit.pageNum+1 <= favorit.pages }">
										<a class="i-load-more-item-shadow" href="<c:url value='/myindex.do?pn=${favorit.pageNum+1 }'/>"><i class="am-icon-refres	h am-icon-fw"></i>换一组</a>
										</c:if>
										<c:if test="${favorit.pageNum+1 > favorit.pages }">
										<a class="i-load-more-item-shadow" href="<c:url value='/myindex.do?pn=1'/>"><i class="am-icon-refres	h am-icon-fw"></i>换一组</a>
										</c:if>
									</div>
									<div class="s-content">
										<!-- 收藏的商品 -->
										<c:forEach items="${favorit.list}" var="goods">
										<div class="s-item-wrap">
											<div class="s-item">

												<div class="s-pic">
													<a href="${pageContext.request.contextPath}/tointroduction.action?id=${goods.goodsID}" class="s-pic-link">
														<img src="${pageContext.request.contextPath}${goods.goodsPicture}" 
																alt="${goods.goodsName}"
																height="200px"
																class="s-pic-img s-guess-item-img" />
													</a>
												</div>
												<div class="s-price-box">
													<span class="s-price"><em class="s-price-sign">¥</em><em class="s-value">${goods.goodsMemberPrice}</em></span>
													<span class="s-history-price"><em class="s-price-sign">¥</em><em class="s-value">${goods.goodsNormalPrice}</em></span>

												</div>
												<div class="s-title">
													<a href="${pageContext.request.contextPath}/tointroduction.action?id=${goods.goodsID}" title="${goods.goodsName}" >${goods.goodsName}</a>
												</div>
												
											</div>
										</div>
										</c:forEach>
									</div>

									

								</div>

							</div>
						</div>
					</div>
					<div class="wrap-right">

						<!-- 日历-->
						<div class="day-list">
							<div class="s-bar">
								<a class="i-history-trigger s-icon" href="#"></a>我的日历
							</div>
							<div class="s-care s-care-noweather">
								<div class="s-date">
									<em	class="date"></em>
									<span class="weekday"></span>
									<span class="yearandmonth"></span>
								</div>
							</div>
						</div>
						<!--新品 -->
						<div class="new-goods">
							<div class="s-bar">
								<i class="s-icon"></i>今日新品
								<a class="i-load-more-item-shadow">2款新品</a>
							</div>
							<c:forEach items="${newGoods}" var="goods">
							<div class="new-goods-info">
								<a class="shop-info" href="${pageContext.request.contextPath}/tointroduction.action?id=${goods.goodsID}" target="_blank">
									<div>
										<img src="${pageContext.request.contextPath}${goods.goodsPicture}" alt="" height="180px">
									</div>
									<span class="one-hot-goods">￥${goods.goodsMemberPrice }</span>
								</a>
							</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<!--底部-->
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

			<aside class="menu">
				<ul>
					<li class="person active">
						<a href="${pageContext.request.contextPath}/myindex.do">个人中心</a>
					</li>
					<li class="person">
						<a href="" disabled>个人资料</a>
						<ul>
							<li>
								<a href="${pageContext.request.contextPath}/tomyinfo.do">个人信息</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/tosafety.do">安全设置</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/myaddress.do">收货地址</a>
							</li>
						</ul>
					</li>
					<li class="person">
						<a href=""	disabled>我的交易</a>
						<ul>
							<li>
								<a href="${pageContext.request.contextPath}/myorders.do">订单管理</a>
							</li>

						</ul>
					</li>

					<li class="person">
						<a href=""	disabled>我的小窝</a>
						<ul>
							<li>
								<a href="${pageContext.request.contextPath}/mycollect.do">收藏</a>
							</li>
						</ul>
					</li>

				</ul>

			</aside>
		</div>
		<!--引导(小屏幕显示) -->
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
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/home/nav-logandreg.js"></script>
		<script type="text/javascript">
			/* 日历 */
			$(function () {
				var dt=new Date()
				var year= dt.getFullYear()
				var month=dt.getMonth()+1
				var date= dt.getDate()
				var weekNum=dt.getDay()
				var weekDay=["星期日","星期一","星期二","星期三","星期四","星期五","星期六"]
				date=extra(date)
				month=extra(month)
				$(".yearandmonth").text(year +"年"+month+"月")
				$(".weekday").text(weekDay[weekNum])
				$(".date").text(date)
				
			})
			/* 显示两位数 */
			function extra(x){
				if (x<10) {
					return "0"+x;
				} else{
					return x;
				}
			}
		</script>
	</body>

</html>