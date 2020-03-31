<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.yq.po.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>缘起后台 商品管理</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="page-header">
				<h1 class="col-md-8" style="font-family: '楷体';">
					缘起 后台管理系统 <small>&ensp;&ensp;商品管理</small>
				</h1>
				<img src="${pageContext.request.contextPath}/img/logo-1.png" class="col-md-2 col-md-offset-2" />
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
				<div class="col-md-8">
					<form action="${pageContext.request.contextPath}/sgbytypeandname.action" class="form-inline" method="post">
						<label for="stype" style="font-size: 30px">商品类别:</label> <select
							id="stype" name="stype" class="form-control">
							<option value="0" selected>请选择</option>
						</select> <label></label> <select id="smtype" name="typeCode"
							class="form-control">
							<option value="null" selected>请选择</option>
						</select> <input name="goodsName" id="tq" type="text" class="form-control" /> <input
							type="submit" class="form-control" value="搜索"  />
					</form>
				</div>
				<div class="col-md-2 col-md-offset-2">
					<h3>
						<a href="${pageContext.request.contextPath}/toaddgoods.action"><span class="glyphicon glyphicon-plus"></span>添加商品信息</a>
					</h3>
				</div>

			</div>
			<div class="row" id="c-content">
				<span><font id="message"></font></span>
				<table class="table table-striped table-hover col-md-12">
					<tr class="info">
						<td class="col-md-1">编号</td>
						<td class="col-md-4"><center>商品</center></td>
						<td class="col-md-1">所属类型</td>
						<td class="col-md-1">价格</td>
						<td class="col-md-1">商品数量</td>
						<td class="col-md-1">特价</td>
						<td class="col-md-1">补货</td>
						<td class="col-md-1">修改</td>
						<td class="col-md-1">有效/失效</td>
					</tr>
					<tbody id="tbody">
						
						<c:forEach items="${pageInfo.list}" var="goods" varStatus="s">
							<tr>
								<td>${s.count}<input type="hidden" id="goodsID" value="${goods.goodsID }"/></td>
								<td><a href="${pageContext.request.contextPath}/togoodsinfo.action?id=${goods.goodsID}"><img
										src="${pageContext.request.contextPath}${goods.goodsPicture}" class="col-md-6" height="130px" width="185px"/>${goods.goodsName}</a></td>
								<td>${goods.typeCode}</td>
								<td>${goods.goodsNormalPrice}</td>
								<td id="goodsNumber${goods.goodsID }">${goods.goodsNumber}</td>
								<!-- 特价 -->
								<td id="isSale${goods.goodsID }">
									<c:if test="${goods.isSale==1}">
									<a onclick="sale(${goods.goodsID},0)"><span class="glyphicon glyphicon-ok"></span></a>
									</c:if>
									<c:if test="${goods.isSale==0}">
									<a onclick="sale(${goods.goodsID},1)"><span class="glyphicon glyphicon-remove"></span></a>
									</c:if>
								</td>
								<!--补货 -->
								<td>
									<a class="btn" data-toggle="modal" data-target="#addNumber${goods.goodsID }"><span class="glyphicon glyphicon-plus"></span></a>
									<div class="modal fade" id="addNumber${goods.goodsID }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
													<h4 class="modal-title" id="myModalLabel">添加的商品数量</h4>
												</div>
												<div class="modal-body">
													<input id="reNumber${goods.goodsID }" type="text" class="form-control" value="" />
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
													<button type="button" onclick="addNumber(${goods.goodsID})" class="btn btn-primary" data-dismiss="modal">保存</button>
												</div>
											</div>
										</div>
									</div>
								</td>
								<!-- 修改 -->
								<td><a href="toeditgoods.action?id=${goods.goodsID}"><span class="glyphicon glyphicon-pencil"></span></a>
								</td>
								<!-- 有效/失效 -->
								<td >
									<c:if test="${goods.isValid==0}">
									<a onclick="valid(${goods.goodsID},1)"><span class="glyphicon glyphicon-eye-close"></span></a>
									</c:if>
									<c:if test="${goods.isValid==1}">
									<a onclick="valid(${goods.goodsID},0)"><span class="glyphicon glyphicon-eye-open"></span></a>
									</c:if>
								</td>
							</tr>
							
						</c:forEach>
					</tbody>
				</table>

			</div>
			<div class="row" id="c-footer">
				<center>
					<ul class="pagination">
						<li><a href="<c:url value='/queryAllGoods.action?pn=1'/>" aria-label="Previous">首页</a></li>
						<li>
							<a href="<c:url value='/queryAllGoods.action?pn=${pageInfo.pageNum-1 }'/>">&laquo;</a>
						</li>
			            <!--处理页码-->
			            <c:forEach var="num"
			                       begin="${(pageInfo.pageNum-3>0?(pageInfo.pageNum-3):1)}"
			                       end="${(pageInfo.pageNum+3<=pageInfo.pages)?(pageInfo.pageNum+3):pageInfo.pages}">
			 
			                <li>
			                    <a href="<c:url value='/queryAllGoods.action?pn=${num}'/>">
			                            <%--判断：主要是为了给当前页显示红色--%>
			                        <c:choose>
			                            <c:when test="${num==pageInfo.pageNum}">
			                                <span style="color: red">${num}</span>
			                            </c:when>
			                            <c:otherwise>${num}</c:otherwise>
			                        </c:choose>
			 
			                    </a>
			                </li>
			 
			            </c:forEach>
						<li>
							<a href="<c:url value='/queryAllGoods.action?pn=${pageInfo.pageNum+1 }'/>">&raquo;</a>
						</li>
						<li><a href="<c:url value='/queryAllGoods.action?pn=${pageInfo.pages}'/>" aria-label="Next">尾页</a></li>
					</ul>
				</center>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/GoodsManage.js"></script>

</body>
</html>
