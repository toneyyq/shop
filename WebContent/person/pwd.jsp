<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>修改密码</title>

		<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="${pageContext.request.contextPath}/css/personal.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/stepstyle.css" rel="stylesheet" type="text/css">

		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
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

					<div class="am-cf am-padding">
						<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">修改密码</strong> / <small>Password</small></div>
					</div>
					<hr/>
					<!--进度条-->
					<div class="m-progress">
						<div class="m-progress-list">
							<span class="step-1 step">
                                <em class="u-progress-stage-bg"></em>
                                <i class="u-stage-icon-inner">1<em class="bg"></em></i>
                                <p class="stage-name">重置密码</p>
                            </span>
							<span class="step-2 step">
                                <em class="u-progress-stage-bg"></em>
                                <i class="u-stage-icon-inner" >2<em class="bg"></em></i>
                                <p class="stage-name">完成</p>
                            </span>
							<span class="u-progress-placeholder"></span>
						</div>
						<div class="u-progress-bar total-steps-2">
							<div class="u-progress-bar-inner " ></div>
						</div>
					</div>
					<div id="form" class="am-form am-form-horizontal" method="post">
						<input type="hidden" id="membername" name="name" value="${sessionScope.member.memberName }">
						<div class="am-form-group">
							<label for="user-old-password" class="am-form-label">
								原密码
								
								<span id="msg1" class="am-icon-check-circle am-icon-sm" style=" display: none" ></span>
								<span id="msg2" class="am-icon-close am-icon-sm" style=" display: none" ></span>
							</label>
							<div class="am-form-content">
								<input type="password" id="oldpwd" name="password" placeholder="请输入原始密码">
								
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-new-password" class="am-form-label">新密码</label>
							<div class="am-form-content">
								<input type="password" id="newpwd" placeholder="由数字、字母组合">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-confirm-password" class="am-form-label">确认密码</label>
							<div class="am-form-content">
								<input type="password" id="renewpwd" placeholder="请再次输入上面的密码">
							</div>
						</div>
						<div class="info-btn">
							<button id="btn" class="am-btn am-btn-danger" onclick="upPassword(${sessionScope.member.memberID})">保存修改</button>
						</div>

					</div>
					<center id="msg" style="display:none;" >
						<p >修改密码成功!<p>
						
						<a href="${pageContext.request.contextPath}/myindex.do">返回个人主页</a>
					</center>

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
		<script src="${pageContext.request.contextPath}/js/home/pwd.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>