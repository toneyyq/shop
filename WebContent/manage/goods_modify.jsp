<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>缘起后台  商品修改</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
	</head>
	<body>
		<div class="container">
			<div class="row" >
				<div class="page-header">
				  	<h1 class="col-md-8" style="font-family: '楷体';">缘起  后台管理系统 <small>&ensp;&ensp;商品管理  商品修改</small></h1>
				  	<img src="${pageContext.request.contextPath}/img/logo-1.png" class="col-md-2 col-md-offset-2"/>
				</div>
			</div>
			<div class="row" id="nav">
				<ul class="nav nav-tabs">
					<li role="presentation" class="active">
						<a href="${pageContext.request.contextPath}/queryAllGoods.action"><img src="${pageContext.request.contextPath}/img/商品管理.png" />商品管理</a>
					</li>
					<li role="presentation">
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
					<div class="col-md-6">
						<div class="page-header">
						  	<h2 style="font-family: '楷体';">商品信息修改<span class="glyphicon glyphicon-plus"></span></h2> 
						</div>
					</div>
					<div class="col-md-6">
						<nav aria-label="...">
					  		<ul class="pager">
					    		<li class="next"><a href="${pageContext.request.contextPath}/queryAllGoods.action">返回<span aria-hidden="true">&rarr;</span></a></li>
					  		</ul>
						</nav>
					</div>
				</div>
				<div class="row" id="c-content">
					<form action="${pageContext.request.contextPath}/updateGoods.action" class="form-horizontal" method="post"	enctype="multipart/form-data">
						<!-- 商品id -->
						<input type="hidden" id="goodsID" name="goodsID" value="${goods.goodsID}">
						<div class="form-group col-md-12 ">
						    <label for="good_name" class="col-md-3 control-label">商品名称</label>
						    <div class="col-md-9">
						    	<input type="text" class="form-control " id="good_name" name="goodsName" value="${goods.goodsName}" />
						    </div>
						</div>
						<div class="form-group col-md-12 ">
						    <label for="good_img" class="col-md-3 control-label">商品图片</label>
						    <div class="col-md-9">
						    	<input type="file" id="goodPic" value="${pageContext.request.contextPath}${goods.goodsPicture}"   />
						    	<br />
						    	<img alt="" src="${pageContext.request.contextPath}${goods.goodsPicture}" id="goodspic" width="150px" height="150px">
						    </div>
						</div>
						<div class="form-group col-md-12 ">
						    <label for="good_info" class="col-md-3 control-label">商品简介</label>
						    <div class="col-md-9">
						    	<textarea name="goodsIntroduce" id="goodsIntroduce" class="form-control" >${goods.goodsIntroduce}</textarea>
						    </div>
						</div>
						<div class="form-group col-md-6">
						    <label for="lgtype" class="col-md-6 control-label ">所属商品大类别</label>
						    <div class="col-md-6 ">
						    	<select name="superType" id="stype" class="form-control">
						      		<option value="0">请选择</option>
						    	</select>
						    </div>
						</div>
						<div class="form-group col-md-6">
						    <label for="smtype" class="col-md-6 control-label ">所属商品小类别</label>
						    <div class="col-md-6 ">
						    	<select name="typeCode" id="smtype" class="form-control">
						      		<option value="${goods.typeCode }">请选择</option>
						    	</select>
						    </div>
						</div>
						
						<div class="form-group col-md-6">
						    <label for="good1_price" class="col-md-6 control-label ">商品市场价格</label>
						    <div class="col-md-6 ">
						    	<input type="text" class="form-control" id="goodsNormalPrice" name="goodsNormalPrice" value="${goods.goodsNormalPrice}" placeholder="￥" />
						    </div>
						</div>
						<div class="form-group col-md-6">
						    <label for="good2_price" class="col-md-6 control-label ">商城价格</label>
						    <div class="col-md-6 ">
						    	<input type="text" class="form-control" id="goodsMemberPrice" name="goodsMemberPrice" value="${goods.goodsMemberPrice}" placeholder="￥" />
						    </div>
						</div>
						<div class="form-group col-md-6">
						    <label for="discount" class="col-md-6 control-label ">商品数量</label>
						    <div class="col-md-6 ">
						    	<input type="text" class="form-control" id="goodsNumber" name="goodsNumber" value="${goods.goodsNumber}"/>
						    </div>
						</div>
						<div class="form-group col-md-6">
						    <label for="choose_discount" class="col-md-6 control-label ">是否特价(特价为商城价格)</label>
						    <div class="col-md-6 ">
						    	<c:if test="${goods.isSale>0}">
							    	<div class="col-md-6">
							    		<input type="radio" name="isSale" id="isSale" value="1" checked="checked" />是
							    	</div>
							    	<div class="col-md-6">
							    		<input type="radio"  name="isSale" id="noSale" value="0"  />否
							    	</div>
						    	</c:if>
						    	<c:if test="${goods.isSale<=0}">
							    	<div class="col-md-6">
							    		<input type="radio" name="isSale" id="isSale" value="1" />是
							    	</div>
							    	<div class="col-md-6">
							    		<input type="radio"  name="isSale" id="noSale" value="0" checked="checked" />否
							    	</div>
						    	</c:if>
						    </div>
						</div>
						<div class="form-group col-md-12">
								<input type="submit" class="btn btn-success col-md-3 col-md-offset-3" value="保存并返回"   >
								<input type="reset" class="btn btn-danger col-md-3 col-md-offset-3" />
						</div>
						
					</form>
										
				</div>
				<div class="row" id="c-footer">
					
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
					<small class="text-center col-xs-12">缘起购物网络科技有限公司</small>
					<small class="text-center col-xs-12">CopyRight © 2003-2020 YQ98.XYZ 版权所有</small>
					<small class="text-center col-xs-12">缘起购物商城客户服务热线：010-8888888，77777777 传真：010-66666666</small>	 
				</div>
					
			</div>
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/goods_modify.js" ></script>
	</body>
</html>
