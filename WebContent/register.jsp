<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>注册</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.min.css" />
		<link href="${pageContext.request.contextPath}/css/dlstyle.css" rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

	</head>

	<body>

		<div class="login-boxtitle">
			<a href="index.html">
				<img alt="" src="${pageContext.request.contextPath}/images/logo-2.png" />
				<img alt="" src="${pageContext.request.contextPath}/images/logo-1.png" />
			</a>
		</div>

		<div class="res-banner">
			<div class="res-main">
				<div class="login-banner-bg"><span></span><img src="${pageContext.request.contextPath}/images/big.jpg" /></div>
				<div class="login-box">

					<div class="am-tabs">
						<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
							<li >
								<a href="#" disabled="disabled">邮箱注册</a>
							</li>
						</ul>

						<div class="am-tabs-bd">
							<div class="am-tab-panel am-active">
								<form action="${pageContext.request.contextPath}/mregist.action" method="post">
									<div class="user-name">
										<label for="name"><i class="am-icon-user"></i></label>
										<input type="text" name="memberName" id="name" placeholder="请输入用户名">
									</div>
									<div class="user-email">
										<label for="email"><i class="am-icon-envelope-o"></i></label>
										<input type="email" name="memberEmail" id="email" placeholder="请输入邮箱账号">
									</div>
									<div class="user-pass">
										<label for="password"><i class="am-icon-lock"></i></label>
										<input type="password" name="memberPassword" id="password" placeholder="设置密码">
									</div>
									<div class="user-pass">
										<label for="passwordRepeat"><i class="am-icon-lock"></i></label>
										<input type="password" name="repassword" id="passwordRepeat" placeholder="确认密码">
									</div>
									<div class="am-cf">
									<input type="submit" id="regbtn" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
									</div>
								</form>	
								<div class="login-links">
									<label for="reader-me">
											<input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》
										</label>
								</div>
								
								
							</div>
						</div>
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
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/home/regist.js"></script>
	</body>

</html>