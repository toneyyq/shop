<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>缘起后台  订单管理</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
	</head>
	<body>
		<div class="container">
			<div class="row" >
				<div class="page-header">
				  	<h1 class="col-md-8" style="font-family: '楷体';">缘起  后台管理系统 <small>&ensp;&ensp;订单管理</small></h1>
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
					<li role="presentation" class="active">
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
			<br />
			<div class="row" id="content">
				
				<div class="row" id="c-content">
					<div class="col-md-12">
						<h3><label for="stype"><b>订</b>单列表:</label></h3>
					</div>
					<div class="col-md-8">
						<form id="queryorder" action="${pageContext.request.contextPath}/qoderinfobyidandtatus.action" class="form-inline form-group" method="post">
							<label for="id">订单号:</label>
							<input type="text" class="form-control" id="orderid" name="id" value="" />
							<label for="status">订单状态:</label>
							<select id="tatus" name="status" class="form-control">
								<option value="null">请选择</option>
								<option value="1">未发货</option>
								<option value="0">已发货</option>
								<option value="-1">未付款</option>
							</select>
							<input type="button"class="form-control" value="搜索" onclick="qorder()" />
						</form>
					</div>
					<table class="table table-striped table-hover ">
					  	<tr class="info">
					  		<td>编号</td>
					  		<td>订单号</td>
					  		<td>订单商品</td>
					  		<td>商品数量</td>
					  		<td>总价</td>
					  		<td>订单状态</td>
					  		
					  	</tr>
					  	<tbody id="orderDetailMain">
					  		<c:forEach items="${pageInfo.list}" var="orderinfo" varStatus="s">
						  	<tr>
						  		<td>${s.count}</td>
						  		<!-- 订单号 -->
						  		<td>
						  		<a href="" data-toggle="modal" data-target="#orderinfo${orderinfo.orderID}" >${orderinfo.orderID}</a>
						  		<div class="modal fade" id="orderinfo${orderinfo.orderID}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
												<h4 class="modal-title" id="myModalLabel">订单详细信息</h4>
											</div>
											<div class="modal-body">
												<div class="row" id="c-content">
													<div class="col-md-6">
														<div class="row">
															<label class="col-md-6 text-right">订单时间：</label><span>${orderinfo.createDate}</span>
														</div>
														<div class="row">
															<label class="col-md-6 text-right">订单号：</label><span>${orderinfo.orderID}</span>
														</div>
														<div class="row">
															<label class="col-md-6 text-right">订单总计：</label><span>￥${orderinfo.orderAmount }</span>
														</div>
														<div class="row">
															<label class="col-md-6 text-right">付款方式：</label><span>${orderinfo.orderPay}</span>
														</div>
														
														<div id="address${orderinfo.orderID}" class="row">
															<label class="col-md-6 text-right">配送地址：</label>
															<!-- <span>Mary</span>
															 <span class="col-md-offset-6">江西省南昌市双港东路</span>
															<span class="col-md-offset-6">江西省 南昌市 昌北</span>
															<span class="col-md-offset-6">电话：3875211</span> -->
														</div>
													</div>
													<div class="col-md-6">
														<div class="row">
															<label class="col-md-6 text-right">收货方式：</label><span>${orderinfo.orderCarry}</span>
														</div>
														<div class="row">
															<label class="col-md-6 text-right">备注：</label><span>${orderinfo.orderRemark}</span>
														</div>
														<div class="row">
															<label class="col-md-6 text-right">数量：</label><span >${orderinfo.goodsCount}</span>
														</div>
														<div class="row">
															<label class="col-md-6 text-right">总计：</label><span>${orderinfo.orderAmount}</span>
														</div>
													</div>					
												</div>
											</div>
											<script type="text/javascript">
												$(function() {
													var id=${orderinfo.id}
													$.post('getaddressbyid.action',{
														id:id
													},function(data){
														$('#address${orderinfo.orderID}').append('<span class="col-md-6">'+data.memberName+'</span>'+
																				'<span class="col-md-offset-4 col-md-8">地址：'+data.provinceCode+data.cityCode+data.areaCode+'</span>'+
																				'<span class="col-md-offset-4 col-md-8">详细地址:'+data.memberAddress+'</span>'+
																				'<span class="col-md-offset-4 col-md-8">电话：'+data.memberTelephone+'</span>')			
													})
												})
											</script>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
											</div>
										</div>
									</div>
								</div>
						  		</td>
						  		<!-- 商品 -->
						  		<td><a href="${pageContext.request.contextPath}/togoodsinfo.action?id=${orderinfo.goodsID}">${orderinfo.goodsID}</a></td>
						  		<td>${orderinfo.goodsCount}</td>
						  		<td>${orderinfo.orderAmount}</td>
						  		<!-- 订单状态 -->
						  		<td>
						  			<span>
						  			<c:if test="${orderinfo.orderStatus == 1}">未发货&nbsp;&nbsp;
						  				<button id="upstatus" onclick="updateStatus(${orderinfo.orderID })">发货</button>
						  			</c:if>
						  			<c:if test="${orderinfo.orderStatus == 0}">已发货</c:if>
						  			<c:if test="${orderinfo.orderStatus == -1}">未付款</c:if>
						  			</span>
						  		</td>
						  	</tr>
						  	</c:forEach>
					  	</tbody>
					</table>
					
				</div>
				<div class="row" id="c-footer">
					<center>
						<ul class="pagination">
							<li><a href="<c:url value='/qorders.action?pn=1'/>" aria-label="Previous">首页</a></li>
							<li>
								<a href="<c:url value='/qorders.action?pn=${pageInfo.pageNum-1 }'/>">&laquo;</a>
							</li>
				            <!--处理页码-->
				            <c:forEach var="num"
				                       begin="${(pageInfo.pageNum-3>0?(pageInfo.pageNum-3):1)}"
				                       end="${(pageInfo.pageNum+3<=pageInfo.pages)?(pageInfo.pageNum+3):pageInfo.pages}">
				 
				                <li>
				                    <a href="<c:url value='/qorders.action?pn=${num}'/>">
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
								<a href="<c:url value='/qorders.action?pn=${pageInfo.pageNum+1 }'/>">&raquo;</a>
							</li>
							<li><a href="<c:url value='/qorders.action?pn=${pageInfo.pages}'/>" aria-label="Next">尾页</a></li>
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
		
		<script type="text/javascript">
		function qorder() {
			var orderid=$('#orderid').val()
			var status=$('#tatus').val()
			if (orderid == '' || orderid == null || orderid == undefined) {
				$('#orderid').val(0)
			}
			if (status == '' || status == null || status == undefined) {
				status=$('#tatus').val(null)
			}
			$('#queryorder').submit()
			
		}
		function updateStatus(id) {
			var status= 0
			var url="updateorderinfostatus.action"
			var args={
				id : id,
				status : status
			}
			$.post(url,args,function(data) {
				if(data>0){
					window.location.reload()
				}else{
					alert('发货失败')
				}
			})
		}


		
		</script>
	</body>
</html>
