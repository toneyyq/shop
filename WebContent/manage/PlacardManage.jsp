<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>缘起后台  公告管理</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
	</head>
	<body>
		<div class="container">
			<div class="row" >
				<div class="page-header">
				  	<h1 class="col-md-8" style="font-family: '楷体';">缘起  后台管理系统 <small>&ensp;&ensp;公告管理</small></h1>
				  	<img src="${pageContext.request.contextPath}/img/logo-1.png" class="col-md-2 col-md-offset-2"/>
				</div>
			</div>
			<div class="row" id="nav">
				<ul class="nav nav-tabs">
					<li role="presentation">
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
					<li role="presentation" class="active">
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
						<h3><label for="stype"><b>公</b>告列表:</label></h3>
					</div>
					<div class="col-md-3 col-md-offset-1">
						<h3><a href="${pageContext.request.contextPath}/toaddplacard.action"><span class="glyphicon glyphicon-plus"></span>添加公告信息</a></h3>
					</div>
					
				</div>
				<div class="row" id="c-content">
					<table class="table table-striped table-hover col-md-12">
					  	<tr class="info">
					  		<td>编号</td>
					  		<td>公告标题</td>
					  		<td>发布时间</td>
					  		<td>失效时间</td>
					  		<td>修改</td>
					  		<td>删除</td>
					  	</tr>
					  	<tbody>
					  		<c:forEach items="${pageInfo.list}" var="placard" varStatus="s">
						  	<tr>
						  		<td>${s.count}</td>
						  		<td>${placard.placardTitle}</td>
						  		<td><fmt:formatDate value="${placard.issueDate}" type="date" /></td>
						  		<td><fmt:formatDate value="${placard.expireDate}" type="date" /></td>
						  		<!-- 修改 -->
						  		<td><a href="${pageContext.request.contextPath}/toupdateplacard.action?id=${placard.placardID}"><span class="glyphicon glyphicon-pencil"></span></a></td>
						  		<!-- 删除 -->
						  		<td>
						  			<a data-toggle="modal" data-target="#delplacard${placard.placardID}"><span class="glyphicon glyphicon-trash"></span></a>
						  			<div class="modal fade" id="delplacard${placard.placardID}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
													<h4 class="modal-title " id="myModalLabel">删除公告</h4>
												</div>
												<div class="modal-body">
													<h5>公告标题：${placard.placardTitle}</h5>
													<br />
													<span>是否确定删除该公告？</span>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
													<button type="button" onclick="delPlacard(${placard.placardID})" class="btn btn-primary" data-dismiss="modal">确定</button>
												</div>
											</div>
										</div>
									</div>
						  		</td>
						  	</tr>
						  	</c:forEach>
					  	</tbody>
					</table>
					
				</div>
				<div class="row" id="c-footer">
					<center>
						<ul class="pagination">
							<li><a href="<c:url value='/qplacards.action?pn=1'/>" aria-label="Previous">首页</a></li>
							<li>
								<a href="<c:url value='/qplacards.action?pn=${pageInfo.pageNum-1 }'/>">&laquo;</a>
							</li>
				            <!--处理页码-->
				            <c:forEach var="num"
				                       begin="${(pageInfo.pageNum-3>0?(pageInfo.pageNum-3):1)}"
				                       end="${(pageInfo.pageNum+3<=pageInfo.pages)?(pageInfo.pageNum+3):pageInfo.pages}">
				 
				                <li>
				                    <a href="<c:url value='/qplacards.action?pn=${num}'/>">
				                        <!--  判断：主要是为了给当前页显示红色 -->
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
								<a href="<c:url value='/qplacards.action?pn=${pageInfo.pageNum+1 }'/>">&raquo;</a>
							</li>
							<li><a href="<c:url value='/qplacards.action?pn=${pageInfo.pages}'/>" aria-label="Next">尾页</a></li>
						</ul>
					</center>
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
		<!-- 删除公告 -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/PlacardManage.js" ></script>
	</body>
</html>
