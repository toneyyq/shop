<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>我的订单</title>

		<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="${pageContext.request.contextPath}/css/personal.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/orstyle.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/addstyle.css" rel="stylesheet" type="text/css">

		<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/amazeui.js"></script>

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
						<a href="#">首页</a>
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
					<div class="user-order">

						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">订单管理</strong> / <small>Order</small></div>
						</div>
						<hr/>

						<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

							<ul class="am-avg-sm-5 am-tabs-nav am-nav am-nav-tabs">
								<li class="am-active">
									<a href="#tab1">所有订单</a>
								</li>
								<li>
									<a href="#tab2">待付款</a>
								</li>
								<li>
									<a href="#tab3">待发货</a>
								</li>
								<li>
									<a href="#tab4">待收货</a>
								</li>

							</ul>
							
							<div class="am-tabs-bd">
								<!-- tab1 全部订单 -->
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-price">
											<td class="td-inner">单价</td>
										</div>
										<div class="th th-number">
											<td class="td-inner">数量</td>
										</div>
										<div class="th th-operation">
											<td class="td-inner">|</td>
										</div>
										<div class="th th-amount">
											<td class="td-inner">合计</td>
										</div>
										<div class="th th-status">
											<td class="td-inner">交易状态</td>
										</div>
										<div class="th th-change">
											<td class="td-inner">交易操作</td>
										</div>
									</div>

									<div class="order-main">
										<div class="order-list">

											<!--交易成功-->
											<c:forEach items="${ordersMap }" var="order">
											<div class="order-status5">
												<div class="order-title">
													<div class="dd-num">订单编号：
														<span>${order.key.orderID }</span>
													</div>
													<span>订单创建时间：<fmt:formatDate value="${order.key.createDate}" type="date" /></span>
													<!--    <em>店铺：小桔灯</em>-->
												</div>
												<div class="order-content">
													<div class="order-left">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="${pageContext.request.contextPath}/tointroduction.action?id=${order.value.goodsID}" class="J_MakePoint">
																		<img src="${pageContext.request.contextPath}${order.value.goodsPicture}" class="itempic J_ItemImg">
																	</a>
																</div>
																<div class="item-info">
																	<div class="item-basic-info">
																		<a href="${pageContext.request.contextPath}/tointroduction.action?id=${order.value.goodsID}">
																			<span>${order.value.goodsName}</span>
																		</a>
																	</div>
																</div>
															</li>
															<li class="td td-price">
																<div class="item-price">
																	￥${order.value.goodsMemberPrice }
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span>${order.key.goodsCount }
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">

																</div>
															</li>
														</ul>
													</div>
													
													<div class="order-right">
														<li class="td td-amount">
															<div class="item-amount">
																合计：￥${order.key.orderAmount}
																
															</div>
														</li>
														<c:if test="${order.key.orderStatus==0}">
															<div class="move-right">
																<li class="td td-status">
																	<div class="item-status">
																		<p class="Mystatus">已发货/已到达</p>
																	</div>
																</li>
																<li class="td td-change">
																	<a href="${pageContext.request.contextPath}/delorder.do?orderID=${order.key.orderID}" >
																	<div class="am-btn am-btn-danger anniu">
																		删除订单</div>
																	</a>
																</li>
															</div>
														</c:if>
														<c:if test="${order.key.orderStatus==1}">
															<div class="move-right">
																<li class="td td-status">
																	<div class="item-status">
																		<p class="Mystatus">未发货</p>
																	</div>
																</li>
																<li class="td td-change">
																	<a  onclick="remind()">
																	<div class="am-btn am-btn-danger anniu">
																		提醒发货</div>
																	</a>
																</li>
															</div>
														</c:if>
														<c:if test="${order.key.orderStatus==-1}">
															<div class="move-right">
																<li class="td td-status">
																	<div class="item-status">
																		<p class="Mystatus">待付款</p>
																	</div>
																</li>
																<li class="td td-change">
																	<a href="${pageContext.request.contextPath}/topay.do?orderID=${order.key.orderID}">
																	<div class="am-btn am-btn-danger anniu">
																		去支付</div>
																	</a>
																	
																</li>
															</div>
														</c:if>
													</div>
													
												</div>
											</div>
											</c:forEach>
										</div>
									</div>
								<!-- tab1 -->
								</div>
								<!-- tab2 待付款订单 -->
								<div class="am-tab-panel am-fade" id="tab2">

									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-price">
											<td class="td-inner">单价</td>
										</div>
										<div class="th th-number">
											<td class="td-inner">数量</td>
										</div>
										<div class="th th-operation">
											<td class="td-inner">|</td>
										</div>
										<div class="th th-amount">
											<td class="td-inner">合计</td>
										</div>
										<div class="th th-status">
											<td class="td-inner">交易状态</td>
										</div>
										<div class="th th-change">
											<td class="td-inner">交易操作</td>
										</div>
									</div>

									<div class="order-main">
										<div class="order-list">
											<c:forEach items="${ordersMap }" var="order">
											<c:if test="${order.key.orderStatus==-1}">
												<div class="order-status1">
													<div class="order-title">
														<div class="dd-num">订单编号：
															<a href="javascript:;">${order.key.orderID }</a>
														</div>
														<span>订单创建时间：<fmt:formatDate value="${order.key.createDate}" type="date" /></span>
														<!--    <em>店铺：小桔灯</em>-->
													</div>
													<div class="order-content">
														<div class="order-left">
															<ul class="item-list">
																<li class="td td-item">
																	<div class="item-pic">
																		<a href="#" class="J_MakePoint">
																			<img src="${pageContext.request.contextPath}${order.value.goodsPicture}" class="itempic J_ItemImg">
																		</a>
																	</div>
																	<div class="item-info">
																		<div class="item-basic-info">
																			<a href="#">
																				<span>${order.value.goodsName}</span>
																			</a>
																		</div>
																	</div>
																</li>
																<li class="td td-price">
																	<div class="item-price">
																		￥${order.value.goodsMemberPrice}
																	</div>
																</li>
																<li class="td td-number">
																	<div class="item-number">
																		<span>×</span>${order.key.goodsCount }
																	</div>
																</li>
																<li class="td td-operation">
																	<div class="item-operation">
	
																	</div>
																</li>
															</ul>
	
															
														</div>
														<div class="order-right">
															<li class="td td-amount">
																<div class="item-amount">
																	合计：￥${order.key.orderAmount}
																	
																</div>
															</li>
															<div class="move-right">
																<li class="td td-status">
																	<div class="item-status">
																		<p class="Mystatus">待付款</p>
																	</div>
																</li>
																<li class="td td-change">
																	<a href="${pageContext.request.contextPath}/topay.do?orderID=${order.key.orderID}">
																	<div class="am-btn am-btn-danger anniu">
																		去支付</div>
																	</a>
																	
																</li>
															</div>
														</div>
													</div>
												</div>
											</c:if>
											</c:forEach>
										</div>
									</div>
								<!-- tab2 -->
								</div>
								<!-- tab3 待发货 -->
								<div class="am-tab-panel am-fade" id="tab3">
									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-price">
											<td class="td-inner">单价</td>
										</div>
										<div class="th th-number">
											<td class="td-inner">数量</td>
										</div>
										<div class="th th-operation">
											<td class="td-inner">|</td>
										</div>
										<div class="th th-amount">
											<td class="td-inner">合计</td>
										</div>
										<div class="th th-status">
											<td class="td-inner">交易状态</td>
										</div>
										<div class="th th-change">
											<td class="td-inner">交易操作</td>
										</div>
									</div>

									<div class="order-main">
										<div class="order-list">
											<c:forEach items="${ordersMap }" var="order">
											<c:if test="${order.key.orderStatus==1}">
											<div class="order-status2">
												<div class="order-title">
													<div class="dd-num">订单编号：
														<a href="javascript:;">${order.key.orderID }</a>
													</div>
													<span>订单创建时间：<fmt:formatDate value="${order.key.createDate}" type="date" /></span>
													<!--    <em>店铺：小桔灯</em>-->
												</div>
												<div class="order-content">
													<div class="order-left">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="#" class="J_MakePoint">
																		<img src="${pageContext.request.contextPath}${order.value.goodsPicture}" class="itempic J_ItemImg">
																	</a>
																</div>
																<div class="item-info">
																	<div class="item-basic-info">
																		<a href="#">
																			<span>${order.value.goodsName}</span>
																		</a>
																	</div>
																</div>
															</li>
															<li class="td td-price">
																<div class="item-price">
																	￥${order.value.goodsMemberPrice}
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span>${order.key.goodsCount }
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">
																	
																</div>
															</li>
														</ul>
													</div>
													<div class="order-right">
														<li class="td td-amount">
															<div class="item-amount">
																合计：￥${order.key.orderAmount}
																
															</div>
														</li>
														<div class="move-right">
															<li class="td td-status">
																<div class="item-status">
																	<p class="Mystatus">未发货</p>
																</div>
															</li>
															<li class="td td-change">
																<a  onclick="remind()">
																<div class="am-btn am-btn-danger anniu">
																	提醒发货</div>
																</a>
															</li>
														</div>
													</div>
												</div>
											</div>
											</c:if>
											</c:forEach>
										</div>
									</div>
								<!-- tab3 -->
								</div>
								<!-- tab4 已发货 -->
								<div class="am-tab-panel am-fade" id="tab4">
									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-price">
											<td class="td-inner">单价</td>
										</div>
										<div class="th th-number">
											<td class="td-inner">数量</td>
										</div>
										<div class="th th-operation">
											<td class="td-inner">|</td>
										</div>
										<div class="th th-amount">
											<td class="td-inner">合计</td>
										</div>
										<div class="th th-status">
											<td class="td-inner">交易状态</td>
										</div>
										<div class="th th-change">
											<td class="td-inner">交易操作</td>
										</div>
									</div>

									<div class="order-main">
										<div class="order-list">
										<c:forEach items="${ordersMap }" var="order">
										<c:if test="${order.key.orderStatus==0}">
											<div class="order-status3">
												<div class="order-title">
													<div class="dd-num">订单编号：
														<a href="javascript:;">${order.key.orderID }</a>
													</div>
													<span>订单创建时间：<fmt:formatDate value="${order.key.createDate}" type="date" /></span>
													<!--    <em>店铺：小桔灯</em>-->
												</div>
												<div class="order-content">
													<div class="order-left">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="#" class="J_MakePoint">
																		<img src="${pageContext.request.contextPath}${order.value.goodsPicture}" class="itempic J_ItemImg">
																	</a>
																</div>
																<div class="item-info">
																	<div class="item-basic-info">
																		<a href="#">
																			<span>${order.value.goodsName}</span>
																		</a>
																	</div>
																</div>
															</li>
															<li class="td td-price">
																<div class="item-price">
																	￥${order.value.goodsMemberPrice}
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span>${order.key.goodsCount }
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">
																	
																</div>
															</li>
														</ul>
													</div>
													<div class="order-right">
														<li class="td td-amount">
															<div class="item-amount">
																合计：￥${order.key.orderAmount}
																
															</div>
														</li>
														<div class="move-right">
															<li class="td td-status">
																<div class="item-status">
																	<p class="Mystatus">已发货/已到达</p>
																</div>
															</li>
															<li class="td td-change">
																<a href="${pageContext.request.contextPath}/delorder.do?orderID=${order.key.orderID}" >
																<div class="am-btn am-btn-danger anniu">
																	删除订单</div>
																</a>
															</li>
														</div>
													</div>
												</div>
											</div>
											</c:if>
											</c:forEach>
										</div>
									</div>
								<!-- tab4 -->
								</div>
								
							</div>

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
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/home/nav-logandreg.js"></script>
		<script src="${pageContext.request.contextPath}/js/home/order.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>