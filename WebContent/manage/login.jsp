<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>缘起 后台系统登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
	</head>

	<body>
		<div class="container">
			<div class="row" id="head">
				<div class="col-md-4 btn-group-lg">
					<a href="${pageContext.request.contextPath}/index.jsp" class="active col-md-12"><img src="${pageContext.request.contextPath}/img/logo-1.png" class="img-responsive " /></a>
				</div>

			</div>
			<div class="row" id="content">
				<div class="jumbotron col-md-8 " id="left">
					<h1 class="font-white">缘起</h1>
					<h1>后台管理系统</h1>
					<h2>欢迎您！</h2>

				</div>
				<div class="col-md-4 " id="right">
					<img src="${pageContext.request.contextPath}/img/logo.png" /> <span class="h2">登录后台系统</span> <br />
					<br />
					<!--表单登录-->
					<form action="${pageContext.request.contextPath}/user/ulogin.action" method="post">
					<div class="input-group input-group-lg">
						<span class="input-group-addon glyphicon glyphicon-user" id="sizing-addon1"></span> <input type="text" class="form-control" id="username" name="username" placeholder="请输入账号" aria-describedby="sizing-addon1">
					</div>
					<br />
					<div class="input-group input-group-lg">
						<span class="input-group-addon glyphicon glyphicon-lock" id="sizing-addon1"></span> <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" aria-describedby="sizing-addon1">
					</div>
					<br /> <span><font id="message"></font></span> <input id="bt" type="submit" class="form-control btn btn-danger" value="登录" />

					<!--  -->
					</form>
					<br />

					<div class="col-xs-offset-3 col-xs-4">
						<a href="###" style="color: darkgray;">忘记密码</a>
					</div>
					<div class="col-xs-5">
						<a href="###" style="color: darkgray;">忘记会员名</a>
					</div>

				</div>
			</div>
			<div class="row" id="footer">
				<div class="col-xs-12 ">
					<a href="##" class="col-xs-1 " style="color: darkgray;">关于缘起</a>
					<a href="##" class="col-xs-1 " style="color: darkgray;">帮助中心</a>
					<a href="##" class="col-xs-1 " style="color: darkgray;">开放平台</a>
					<a href="##" class="col-xs-1 " style="color: darkgray;">诚聘英才</a>
					<a href="##" class="col-xs-1 " style="color: darkgray;">联系我们</a>
					<a href="##" class="col-xs-1 " style="color: darkgray;">网站合作</a>
					<a href="##" class="col-xs-1 " style="color: darkgray;">法律声明</a>
					<a href="##" class="col-xs-1 " style="color: darkgray;">隐私政策</a>
					<a href="##" class="col-xs-1 " style="color: darkgray;">知识产权</a>
					<a href="##" class="col-xs-1 " style="color: darkgray;">廉正举报</a>
					<a href="##" class="col-xs-1 " style="color: darkgray;">缘起公益</a>
					<a href="##" class="col-xs-1 " style="color: darkgray;">English</a>
				</div>

				<div class="col-md-12">
					<small class="text-center col-xs-12">缘起购物网络科技有限公司</small> <small class="text-center col-xs-12">CopyRight © 2003-2020
					YQ98.XYZ 版权所有</small> <small class="text-center col-xs-12">缘起购物商城客户服务热线：010-8888888，77777777
					传真：010-66666666</small>
				</div>

			</div>
		</div>
	</body>

</html>