<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>地址管理</title>

		<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<link href="${pageContext.request.contextPath}/css/personal.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/addstyle.css" rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>

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
				</div>
			</article>
		</header>

		<div class="nav-table">
			<div class="nav-cont">
				<ul>
					<li class="index">
						<a href="${pageContext.request.contextPath}/toindex.action">首页</a>
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

					<div class="user-address">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">地址管理</strong> / <small>Address&nbsp;list</small></div>
						</div>
						<hr/>
						<!--地址-->
						
						<ul class="am-avg-sm-1 am-avg-md-3 am-thumbnails">
							<!-- 默认地址 -->
							<li id="daddress" class="user-addresslist ">
								<span class="new-option-r"><i class="am-icon-check-circle"></i>默认地址</span>
								<span class="new-txt" >${defaddress.memberName }</span>
								<span class="new-txt-rd2" >${defaddress.memberTelephone }</span>
								
								<div class="new-mu_l2a new-p-re">
									<p class="new-mu_l2cw">
										<span class="title">地址：</span>
										<span class="province"  >${defaddress.provinceCode }</span>
										<span class="city" >${defaddress.cityCode }</span>
										<span class="dist" >${defaddress.areaCode }</span>
										<span class="street" >${defaddress.memberAddress }</span>
									</p>
								</div>
								<div class="new-addr-btn">
									
								</div>
							</li>
							<c:forEach items="${address}" var="address">
								<li class="user-addresslist ">
									<a href="javascript:setAddressStatus(${address.id })"><span class="new-option-r"><i class="am-icon-check-circle"></i>设为默认</span></a>
									<span class="new-txt" >${address.memberName }</span>
									<span class="new-txt-rd2" >${address.memberTelephone }</span>
									
									<div class="new-mu_l2a new-p-re">
										<p class="new-mu_l2cw">
											<span class="title">地址：</span>
											<span class="province"  >${address.provinceCode }</span>
											<span class="city" >${address.cityCode }</span>
											<span class="dist" >${address.areaCode }</span>
											<span class="street" >${address.memberAddress }</span>
										</p>
									</div>
									<div class="new-addr-btn">
										<span class="new-addr-bar">|</span>
										<!-- ajax -->
										<a href="#" onclick="delAdress(${address.id });"><i class="am-icon-trash"></i>删除</a>
									</div>
								</li>
							</c:forEach>
						</ul>
						
						<div class="clear"></div>
						<!-- 添加地址模态框 -->
						<button type="button" class="am-btn am-btn-default " data-toggle="modal" data-target="#insertaddress">添加新地址</button>
						<!--例子-->
						<div class="modal fade" id="insertaddress" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="myModalLabel"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add&nbsp;address</small></h4>
									</div>
									<form action="${pageContext.request.contextPath}/insertaddress.do" class="am-form am-form-horizontal" method="post">
									<div class="modal-body">
										<input type="hidden" name="memberID" value="${sessionScope.member.memberID }" />
										<!-- 地址状态 非默认0 -->
										<input type="hidden" name="tatus" value="0" />
										<div class="am-form-group">
											<label for="user-name" class="  am-form-label">收货人</label>
											<div class="am-form-content">
												<input type="text" id="user-name" name="memberName" placeholder="收货人">
											</div>
										</div>

										<div class="am-form-group">
											<label for="user-phone" class="  am-form-label">手机号码</label>
											<div class="am-form-content">
												<input id="user-phone"  name="memberTelephone" placeholder="手机号必填" type="tel">
											</div>
										</div>
										<div class="am-form-group">
											<label for="user-address" class="am-form-label">所在地</label>
											<!--省市区-->
											<div class="am-form-content address">
												<select id="province" name="provinceCode" >
													<option value="0">请选择</option>
													
												</select>
												<select id="city"  name="cityCode" >
													<option value="0">请选择</option>
												</select>
												<select id="area" name="areaCode" >
													<option value="0">请选择</option>
												</select>
											</div>
										</div>

										<div class="am-form-group">
											<label for="user-intro" class="am-form-label">详细地址</label>
											<div class="am-form-content">
												<textarea  rows="3" id="user-intro" name="memberAddress" placeholder="输入详细地址"></textarea>
												<small>100字以内写出你的详细地址...</small>
											</div>
										</div>
										
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
										<button type="submit"  class="btn btn-primary" >保存</button>
									</div>
									</form>
								</div>
							</div>
						</div>
						

					</div>

					<script type="text/javascript">
						$(document).ready(function() {
							$(".new-option-r").click(function() {
								$(this).parent('.user-addresslist').addClass("defaultAddr").siblings().removeClass("defaultAddr");
							});

							var $ww = $(window).width();
							if($ww > 640) {
								$("#doc-modal-1").removeClass("am-modal am-modal-no-btn")
							}

						})
					</script>

					<div class="clear"></div>

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
		<script src="${pageContext.request.contextPath}/js/home/address.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function() {
				var defaddress='${defaddress}'
				if (!defaddress) {
					$('#daddress').css('display','none')
				}
			})
		
		</script>
	</body>

</html>