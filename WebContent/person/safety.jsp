<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>安全设置</title>

		<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="${pageContext.request.contextPath}/css/personal.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/infstyle.css" rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/amazeui.js" type="text/javascript"></script>
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

					<!--标题 -->
					<div class="user-safety">
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">账户安全</strong> / <small>Set&nbsp;up&nbsp;Safety</small></div>
						</div>
						<hr/>

						<div class="check">
							<ul>
								<li>
									<i class="i-safety-lock"></i>
									<div class="m-left">
										<div class="fore1">登录密码</div>
										<div class="fore2"><small>为保证您购物安全，建议您定期更改密码以保护账户安全。</small></div>
									</div>
									<div class="fore3">
										<a href="${pageContext.request.contextPath}/topwd.do">
											<div class="am-btn am-btn-secondary">修改</div>
										</a>
									</div>
								</li>
							</ul>
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
	</body>

</html>