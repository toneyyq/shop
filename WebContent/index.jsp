<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
	<!-- xmlns="http://www.w3.org/1999/xhtml" -->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>首页-缘起商城</title>

		<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="css/hmstyle.css" rel="stylesheet" type="text/css" />
		<link href="css/skin.css" rel="stylesheet" type="text/css" />
		<link href="css/personal.css" rel="stylesheet" type="text/css">
		<link href="css/systyle.css" rel="stylesheet" type="text/css">
		<script src="AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
		
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

		<div class="banner">
			<!--轮播 -->
			<div class="am-slider am-slider-default scoll" data-am-flexslider id="demo-slider-0">
				<ul class="am-slides">
					<li class="banner1">
						<a href="introduction.html"><img src="images/ad1.jpg" /></a>
					</li>
					<li class="banner2">
						<a><img src="images/ad2.jpg" /></a>
					</li>
					<li class="banner3">
						<a><img src="images/ad3.jpg" /></a>
					</li>
					<li class="banner4">
						<a><img src="images/ad4.jpg" /></a>
					</li>

				</ul>
			</div>
			<div class="clear"></div>
		</div>

		<!--商品导航栏-->
		<div class="shopNav">
			<div class="slideall">

				<div class="long-title"><span class="all-goods">全部分类</span></div>
				<div class="nav-cont">
					<ul>
						<li class="index">
							<a href="toindex.action">首页</a>
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

				<!--侧边导航 -->
				<div id="nav" class="navfull">
					<div class="area clearfix">
						<div class="category-content" id="guide_2">

							<div class="category">
								<c:forEach items="${typeMap}" var="stype">
								<!--十个-->
								<ul class="category-list" id="js_climit_li">
									<li class="appliance js_toggle relative first">
										<div class="category-info">
											<h3 class="category-name b-category-name"><a class="ml-22" title="${stype.key}">${stype.key}</a></h3>
											<em>&gt;</em></div>
										<div class="menu-item menu-in top">
											<div class="area-in">
												<div class="area-bg">
													<div class="menu-srot">
														<!-- 小类别 -->
														<div class="sort-side">
															<c:forEach items="${stype.value}" var="smtype">
															<dl class="dl-sort">
																<dt><a href="qgoodsbynameortype.action?type=${smtype.typeName}"><span title="蛋糕">${smtype.typeName}</span></a></dt>
																
															</dl>
															</c:forEach>

														</div>
														<div class="brand-side">
															<dl class="dl-sort"><dt><span>实力商家</span></dt>
																<dd>
																	<a rel="nofollow" title="呵官方旗舰店" target="_blank" href="#"><span class="red">呵官方旗舰店</span></a>
																</dd>
																<dd>
																	<a rel="nofollow" title="格瑞旗舰店" target="_blank" href="#"><span>格瑞旗舰店</span></a>
																</dd>
																<dd>
																	<a rel="nofollow" title="飞彦大厂直供" target="_blank" href="#"><span class="red">飞彦大厂直供</span></a>
																</dd>
																<dd>
																	<a rel="nofollow" title="红e·艾菲妮" target="_blank" href="#"><span>红e·艾菲妮</span></a>
																</dd>
																<dd>
																	<a rel="nofollow" title="本真旗舰店" target="_blank" href="#"><span class="red">本真旗舰店</span></a>
																</dd>
																<dd>
																	<a rel="nofollow" title="杭派女装批发网" target="_blank" href="#"><span class="red">杭派女装批发网</span></a>
																</dd>
															</dl>
														</div>
													</div>
												</div>
											</div>
										</div>
										<b class="arrow"></b>
										
									</li>
									
								</ul>
								</c:forEach>
							</div>
						</div>

					</div>
				</div>
				
				<!--轮播-->

				<script type="text/javascript">
					(function() {
						$('.am-slider').flexslider();
					});
					$(document).ready(function() {
						$("li").hover(function() {
							$(".category-content .category-list li.first .menu-in").css("display", "none");
							$(".category-content .category-list li.first").removeClass("hover");
							$(this).addClass("hover");
							$(this).children("div.menu-in").css("display", "block")
						}, function() {
							$(this).removeClass("hover")
							$(this).children("div.menu-in").css("display", "none")
						});
					})
				</script>

				

				<!--走马灯 -->

				<div class="marqueen">
					<span class="marqueen-title">商城头条</span>
					<div class="demo">
						<ul>
							
							<c:forEach items="${placards}" var="placard">
							<li id="prof">
							<a target="_blank" href="${pageContext.request.contextPath}/qgoodsbynameortype.action"   >
								<span id="my-popover${placard.placardID}">${placard.placardTitle}</span>
								
							</a>
							
							</li>
							<script type="text/javascript">
								$(function() {
									$('#my-popover${placard.placardID}').popover({
										theme:'warning lg',
										content: '<p>内容：${placard.placardContent}</p><p>活动时间：<fmt:formatDate value="${placard.issueDate}" type="date" />~<fmt:formatDate value="${placard.expireDate}" type="date" />',
										trigger:'hover focus'
									})
								})
							</script>
							</c:forEach>
							

						</ul>
						<div class="advTip"><img src="images/advTip.jpg" /></div>
					</div>
				</div>

				<div class="clear"></div>
			</div>
		</div>
		</div>
		<!--响应-->
		<script type="text/javascript">
			if($(window).width() < 640) {
				function autoScroll(obj) {
					$(obj).find("ul").animate({
						marginTop: "-39px"
					}, 500, function() {
						$(this).css({
							marginTop: "0px"
						}).find("li:first").appendTo(this);
					})
				}
				$(function() {
					setInterval('autoScroll(".demo")', 3000);
				})
			}
		</script>
		<div id="content">
		
			<!-- 商品展示 -->
			<div class="am-container">
				<div class="col-md-10 col-offset-1">
				<div class="s-content" >
				<c:forEach items="${pageInfo.list}" var="goods">
				 
				  	<div class="s-item-wrap">
						<div class="s-item">
							<a href="${pageContext.request.contextPath}/tointroduction.action?id=${goods.goodsID}">
							<div class="s-pic">
								<div  class="s-pic-link">
									<img src="${pageContext.request.contextPath}${goods.goodsPicture}" 
											alt="${goods.goodsName}"
											title="${goods.goodsName}" 
											class="s-pic-img s-guess-item-img" height="300px"  />
								</div>
							</div>
							<div class="s-price-box">
								<span class="s-price"><em class="s-price-sign">¥</em><em class="s-value">${goods.goodsMemberPrice }</em></span>
								<span class="s-history-price"><em class="s-price-sign">¥</em><em class="s-value">${goods.goodsNormalPrice}</em></span>

							</div>
							<div class="s-title">
								<p  title="${goods.goodsName}">${goods.goodsName}</p>
							</div>
							</a>
						</div>
					</div>
				
				</c:forEach>
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
			<!--shopMainbg-->
		</div>

		<!--引导 (小界面响应)-->
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

		<!--菜单 -->
		<div class="tip">
			<div id="sidebar">
				<div id="wrap">
					
					<div id="shopCart " class="item ">
						<a href="${pageContext.request.contextPath}/cart.do">
							<span class="message "></span>
						</a>
						<a href="${pageContext.request.contextPath}/cart.do"><p id="count" class="cart_num ">0</p></a>
					</div>
					<div id="brand " class="item ">
						<a href="${pageContext.request.contextPath}/mycollect.do">
							<span class="wdsc "><img src="images/wdsc.png " /></span>
						</a>
						<div class="mp_tooltip ">
							我的收藏
							<i class="icon_arrow_right_black "></i>
						</div>
					</div>
					<div id="broadcast " class="item ">
						<!-- 充值 -->
						<a href="">
							<span class="chongzhi "><img src="images/chongzhi.png " /></span>
						</a>
						
						<div class="mp_tooltip ">
							余额：￥${member.memberAmount}
							<i class="icon_arrow_right_black "></i>
						</div>
					</div>

					<div class="quick_toggle ">
						<ul>
							<li class="qtitem ">
								<a href="# "><span class="kfzx "></span></a>
								<div class="mp_tooltip ">客服中心<i class="icon_arrow_right_black "></i></div>
							</li>
							<!--二维码 -->
							<li class="qtitem ">
								<a href="#none "><span class="mpbtn_qrcode "></span></a>
								<div class="mp_qrcode " style="display:none; "><img src="images/weixin_code_145.png " /><i class="icon_arrow_white "></i></div>
							</li>
							<!--回到顶部 -->
							<li class="qtitem ">
								<a href="#top " class="return_top "><span class="top "></span></a>
							</li>
						</ul>
					</div>

					
					<div id="quick_links_pop " class="quick_links_pop hide "></div>

				</div>

			</div>

		</div>
		<script>
			window.jQuery || document.write('<script src="basic/js/jquery.min.js "><\/script>');
		</script>
		<script type="text/javascript">
			 $(function() {
				url=location.href;
				if(url!="http://localhost:8080/shop/toindex.action"){
					url="${pageContext.request.contextPath}/toindex.action";
					self.location.replace(url);
				}
			})
		</script>
		<script type="text/javascript " src="basic/js/quick_links.js "></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/home/nav-logandreg.js"></script>
	</body>

</html>