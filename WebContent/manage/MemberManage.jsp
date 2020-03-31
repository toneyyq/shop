<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>缘起后台  会员管理</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
	</head>
	<body>
		<div class="container">
			<div class="row" >
				<div class="page-header">
				  	<h1 class="col-md-8" style="font-family: '楷体';">缘起  后台管理系统 <small>&ensp;&ensp;会员管理</small></h1>
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
					<li role="presentation" class="active">
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
						<h3><label for="stype"><b>会</b>员列表:</label></h3>
					</div>
					<div class="col-md-8">
						<form action="qmemberbyname.action" class="form-inline form-group" method="get">
							<label for="memberName">会员名:</label>
							<input type="text" class="form-control" name="memberName"/>
							<input type="submit"class="form-control" value="搜索"  />
						</form>
					</div>
					<table class="table table-striped table-hover ">
					  	<tr class="info">
					  		<td>编号</td>
					  		<td>会员名</td>
					  		<td>Email</td>
					  		<td>创建时间</td>
					  		<td>解冻/冻结</td>
					  	</tr>
					  	<tbody>
					  		<c:forEach items="${pageInfo.list}" var="member" varStatus="s">
						  	<tr>
						  		<td>${s.count}</td>
						  		<td>
						  			<a data-toggle="modal" data-target="#memberDetial${member.memberID}">${member.memberName}</a>
						  			<div class="modal fade" id="memberDetial${member.memberID}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
													<h4 class="modal-title" id="myModalLabel">会员详情</h4>
												</div>
												<div class="modal-body">
													<div class="row">
														<label class="col-md-6 text-right">用 户 名：</label><span>${member.memberName}</span>
													</div>
													
													<div class="row">
														<label class="col-md-6 text-right">E-mail：</label><span>${member.memberEmail}</span>
													</div>
													<div class="row">
														<label class="col-md-6 text-right">余额：</label><span>￥${member.memberAmount}</span>
													</div>
													
													<div class="row">
														<label class="col-md-6 text-right">用户状态：</label>
														<span>
															<c:if test="${member.memberStatus>0 }">
												  				有效
												  			</c:if>
												  			<c:if test="${member.memberStatus==0 }">
												  				已冻结
												  			</c:if>
														</span>
													</div>
													<div class="row">
														<label class="col-md-6 text-right"> 创建时间：</label><span><fmt:formatDate value="${member.createDate}" type="date" /></span>
													</div>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
												</div>
											</div>
										</div>
									</div>
						  		</td>
						  		<td>${member.memberEmail}</td>
						  		<td><fmt:formatDate value="${member.createDate}" type="date" /></td>
						  		<td>
						  			<c:if test="${member.memberStatus>0 }">
						  				<a onclick="status('${member.memberID}',0)"><span class="glyphicon glyphicon-ok"></span></a>
						  			</c:if>
						  			<c:if test="${member.memberStatus==0 }">
						  				<a onclick="status('${member.memberID}',1)"><span class="glyphicon glyphicon-remove"></span></a>
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
							<li><a href="<c:url value='/qmembers.action?pn=1'/>" aria-label="Previous">首页</a></li>
							<li>
								<a href="<c:url value='/qmembers.action?pn=${pageInfo.pageNum-1 }'/>">&laquo;</a>
							</li>
				            <!--处理页码-->
				            <c:forEach var="num"
				                       begin="${(pageInfo.pageNum-3>0?(pageInfo.pageNum-3):1)}"
				                       end="${(pageInfo.pageNum+3<=pageInfo.pages)?(pageInfo.pageNum+3):pageInfo.pages}">
				 
				                <li>
				                    <a href="<c:url value='/qmembers.action?pn=${num}'/>">
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
								<a href="<c:url value='/qmembers.action?pn=${pageInfo.pageNum+1 }'/>">&raquo;</a>
							</li>
							<li><a href="<c:url value='/qmembers.action?pn=${pageInfo.pages}'/>" aria-label="Next">尾页</a></li>
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
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/MemberManage.js" ></script>
	</body>
</html>
