<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>缘起后台 商品类别管理</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
	
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="page-header">
					<h1 class="col-md-8" style="font-family: '楷体';">
						缘起 后台管理系统 <small>&ensp;&ensp;商品类别管理</small>
					</h1>
					<img src="${pageContext.request.contextPath}/img/logo-1.png" class="col-md-2 col-md-offset-2" />
				</div>
			</div>
			<div class="row" id="nav">
				<ul class="nav nav-tabs">
					<li role="presentation">
						<a href="${pageContext.request.contextPath}/queryAllGoods.action"><img src="${pageContext.request.contextPath}/img/商品管理.png" />商品管理</a>
					</li>
					<li role="presentation" class="active">
						<a href="${pageContext.request.contextPath}/superTypes.action"><img src="${pageContext.request.contextPath}/img/商品类别管理.png" />商品类别管理</a>
					</li>
					<li role="presentation">
						<a href="${pageContext.request.contextPath}/qorders.action"><img src="${pageContext.request.contextPath}/img/订单管理.png" />订单管理</a>
					</li>
					<li role="presentation">
						<a href="${pageContext.request.contextPath}/qmembers.action"><img src="${pageContext.request.contextPath}/img/会员管理.png" />会员管理</a>
					</li>
					<li role="presentation">
						<a href="${pageContext.request.contextPath}/qplacards.action"><span class="glyphicon glyphicon-comment"></span>公告管理</a>
					</li>
					<li role="presentation" class="">
						<a href="${pageContext.request.contextPath}/user/exit.action"><span class="glyphicon glyphicon-remove-sign"></span>退出后台</a>
					</li>
				</ul>
			</div>
			<div class="row" id="content">
				<div class="row" id="c-head">
					<div class="col-md-8">
						<h3>
							<label for="stype"><b>大</b>分类信息列表:</label>
						</h3>
					</div>
					
	
				</div>
				<div class="row" id="c-content">
					<table class="table table-striped table-hover col-md-12">
						<tr class="info">
							<td>编号</td>
					  		<td>大分类信息名称</td>
					  		<td>描述</td>
					  		<td>子类管理</td>
	
						</tr>
						<tbody id=tbody>
							<c:forEach items="${pageInfo.list}" var="suptype" varStatus="s">
							<tr>
								<td>${s.count}</td>
								<td>${suptype.typeName}</td>
								<td>${suptype.typeDesc}</td>
								<td><a href="${pageContext.request.contextPath}/subtype.action?parentID=${suptype.typeID }"><span class="glyphicon glyphicon-pencil"></span></a></td>
							</tr>
							</c:forEach>
						</tbody>
	
					</table>
	
				</div>
				
			</div>
			<div class="row" id="footer">
				<div class="col-xs-12 ">
					<a href="##" class="col-xs-1 " style="color: darkgray;">关于缘起</a> <a
						href="##" class="col-xs-1 " style="color: darkgray;">帮助中心</a> <a
						href="##" class="col-xs-1 " style="color: darkgray;">开放平台</a> <a
						href="##" class="col-xs-1 " style="color: darkgray;">诚聘英才</a> <a
						href="##" class="col-xs-1 " style="color: darkgray;">联系我们</a> <a
						href="##" class="col-xs-1 " style="color: darkgray;">网站合作</a> <a
						href="##" class="col-xs-1 " style="color: darkgray;">法律声明</a> <a
						href="##" class="col-xs-1 " style="color: darkgray;">隐私政策</a> <a
						href="##" class="col-xs-1 " style="color: darkgray;">知识产权</a> <a
						href="##" class="col-xs-1 " style="color: darkgray;">廉正举报</a> <a
						href="##" class="col-xs-1 " style="color: darkgray;">缘起公益</a> <a
						href="##" class="col-xs-1 " style="color: darkgray;">English</a>
				</div>
	
				<div class="col-md-12">
					<small class="text-center col-xs-12">缘起购物网络科技有限公司</small> <small
						class="text-center col-xs-12">CopyRight © 2003-2020
						YQ98.XYZ 版权所有</small> <small class="text-center col-xs-12">缘起购物商城客户服务热线：010-8888888，77777777
						传真：010-66666666</small>
				</div>
	
			</div>
		</div>
<%-- 		<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/pm.js"></script>--%>
	</body>
</html>
