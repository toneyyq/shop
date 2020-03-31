<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>结算页面</title>

		<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />

		<link href="${pageContext.request.contextPath}/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/cartstyle.css" rel="stylesheet" type="text/css" />

		<link href="${pageContext.request.contextPath}/css/jsstyle.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/address.js"></script>

	</head>

	<body>

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
		<div class="concent">
			<!--地址 -->
			<div class="paycont">
				<div class="address">
					<h3>确认收货地址 </h3>
					<div class="control">
						<div class="tc-btn createAddr theme-login am-btn am-btn-danger">使用新地址</div>
					</div>
					<div class="clear"></div>
					<ul id="addresscheck">
						<div class="per-border"></div>
						<li class="user-addresslist defaultAddr">
							<input type="hidden" id="id" value="${defaddress.id}"/>
							<div class="address-left">
								<div class="user DefaultAddr">

									<span class="buy-address-detail">   
	                   					<span class="buy-user">${defaddress.memberName} </span>
										<span class="buy-phone">${defaddress.memberTelephone}</span>
									</span>
								</div>
								<div class="default-address DefaultAddr">
									<span class="buy-line-title buy-line-title-type">收货地址：</span>
									<span class="buy--address-detail">
									    <span class="province">${defaddress.provinceCode }</span>
										<span class="city">${defaddress.cityCode }</span>
										<span class="dist">${defaddress.areaCode }</span>
										<span class="street">${defaddress.memberAddress }</span>
									</span>

								</div>
								<ins class="deftip">默认地址</ins>
							</div>
							<div class="address-right">
								<!-- 小界面显示 进入个人地址管理界面 -->
								<a href="${pageContext.request.contextPath}/person/address.html">
									<span class="am-icon-angle-right am-icon-lg"></span></a>
							</div>
							<div class="clear"></div>

							<div class="new-addr-btn">
								<a href="#" class="hidden">设为默认</a>
								<span class="new-addr-bar hidden">|</span>
								<a class="hidden" href="javascript:void(0);" onclick="delClick(this);">删除</a>
							</div>

						</li>
						<div class="per-border"></div>
						<c:forEach items="${addressBooks}" var="address">
						<li class="user-addresslist">
							<input type="hidden" id="id" value="${address.id }" />
							<div class="address-left">
								<div class="user DefaultAddr">

									<span class="buy-address-detail">   
                  					<span class="buy-user">${address.memberName } </span>
									<span class="buy-phone">${address.memberTelephone }</span>
									</span>
								</div>
								<div class="default-address DefaultAddr">
									<span class="buy-line-title buy-line-title-type">收货地址：</span>
									<span class="buy--address-detail">
								   <span class="province">${address.provinceCode }</span>
									<span class="city">${address.cityCode }</span>
									<span class="dist">${address.areaCode }</span>
									<span class="street">${address.memberAddress }</span>
									</span>

								</div>
								<ins class="deftip hidden">默认地址</ins>
							</div>
							<div class="address-right">
								<span class="am-icon-angle-right am-icon-lg"></span>
							</div>
							<div class="clear"></div>

							<div class="new-addr-btn">
								<a href="javascript:setAddressStatus(${address.id})" >设为默认</a>
								<span class="new-addr-bar">|</span>
								<a href="javascript:delAdress(${address.id})" >删除</a>
							</div>

						</li>
						</c:forEach>
					</ul>

					<div class="clear"></div>
				</div>
				<!--物流 -->
				<!-- <div class="logistics">
					<h3>选择物流方式</h3>
					<ul class="op_express_delivery_hot">
						<li data-value="yuantong" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -468px"></i>圆通<span></span></li>
						<li data-value="shentong" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -1008px"></i>申通<span></span></li>
						<li data-value="yunda" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -576px"></i>韵达<span></span></li>
						<li data-value="zhongtong" class="OP_LOG_BTN op_express_delivery_hot_last "><i class="c-gap-right" style="background-position:0px -324px"></i>中通<span></span></li>
						<li data-value="shunfeng" class="OP_LOG_BTN  op_express_delivery_hot_bottom"><i class="c-gap-right" style="background-position:0px -180px"></i>顺丰<span></span></li>
					</ul>
				</div>
				<div class="clear"></div> -->

				<!--支付方式-->
				<%-- <div class="logistics">
					<h3>选择支付方式</h3>
					<ul class="pay-list">
						<li class="pay card"><img src="${pageContext.request.contextPath}/images/wangyin.jpg" />银联<span></span></li>
						<li class="pay qq"><img src="${pageContext.request.contextPath}/images/weizhifu.jpg" />微信<span></span></li>
						<li class="pay taobao"><img src="${pageContext.request.contextPath}/images/zhifubao.jpg" />支付宝<span></span></li>
					</ul>
				</div>
				<div class="clear"></div> --%>

				<!--订单 -->
				<form id="orderform" action="${pageContext.request.contextPath}/updateorder.do" method="post">
				<div class="concent">
					<div id="payTable">
						<h3>确认订单信息</h3>
						<div class="cart-table-th">
							<div class="wp">

								<div class="th th-item">
									<div class="td-inner">商品信息</div>
								</div>
								<div class="th th-price">
									<div class="td-inner">单价</div>
								</div>
								<div class="th th-amount">
									<div class="td-inner">数量</div>
								</div>
								<div class="th th-sum">
									<div class="td-inner">金额</div>
								</div>
								

							</div>
						</div>
						<div class="clear"></div>

						<tr class="item-list">
							<div class="bundle  bundle-last">

								<div class="bundle-main">
									<ul class="item-content clearfix">
										<div class="pay-phone">
											<li class="td td-item">
												<div class="item-pic">
													<a href="#" class="J_MakePoint">
														<img src="${pageContext.request.contextPath}${goods.goodsPicture}" class="itempic J_ItemImg" width="80px" height="80px"></a>
												</div>
												<div class="item-info">
													<div class="item-basic-info">
														<a href="#" class="item-title J_MakePoint" data-point="tbcart.8.11">${goods.goodsName}</a>
													</div>
												</div>
											</li>
											
											<li class="td td-price">
												<div class="item-price price-promo-promo">
													<div class="price-content">
														<input type="hidden" id="goodsprice" value="${goods.goodsMemberPrice }" />
														<em class="J_Price price-now">${goods.goodsMemberPrice }</em>
													</div>
												</div>
											</li>
										</div>
										<li class="td td-amount">
											<div class="amount-wrapper ">
												<div class="item-amount ">
													<span class="phone-title">购买数量</span>
													<div class="sl">
														<input type="hidden" id="number" value="${goods.goodsNumber }"/>
														<input class="min am-btn" name="" type="button" value="-" onclick="changecount(-1)"  />
														<input class="text_box" id="goodsCount" name="goodsCount" type="text" value="${orderInfo.goodsCount }" style="width:30px;" />
														<input class="add am-btn" name="" type="button" value="+" onclick="changecount(1)"/>
													</div>
												</div>
											</div>
										</li>
										<li class="td td-sum">
											<div class="td-inner">
												<em tabindex="0" id="amount" class="J_ItemSum number">${orderInfo.orderAmount }</em>
											</div>
										</li>
										

									</ul>
									<div class="clear"></div>

								</div>
							</div>
						</tr>
						<div class="clear"></div>
					</div>
				</div>
				<div class="clear"></div>
				<div class="pay-total">
				<!--留言-->
					<div class="order-extra">
						<div class="order-user-info">
							<div id="holyshit257" class="memo">
								<label>买家留言：</label>
								<input type="text" name="orderRemark" title="选填,对本次交易的说明（建议填写已经和卖家达成一致的说明）" placeholder="选填,建议填写和卖家达成一致的说明" class="memo-input J_MakePoint c2c-text-default memo-close">
								<div class="msg hidden J-msg">
									<p class="error">最多输入500个字符</p>
								</div>
							</div>
						</div>
				
					</div>
				</div>
				<!--信息 -->
				<div class="order-go clearfix">
					<div class="pay-confirm clearfix">
						<div class="box">
							<div tabindex="0" id="holyshit267" class="realPay"><em class="t">实付款：</em>
								<span class="price g_price ">
                                    <span>¥</span> <em class="style-large-bold-red " id="J_ActualFee">${orderInfo.orderAmount }</em>
								</span>
							</div>

							<div id="holyshit268" class="pay-address">
								<p class="buy-footer-address">
									<span class="buy-line-title buy-line-title-type">寄送至：</span>
									<span class="buy--address-detail">
								   	<span id="cprovince" class="province">${defaddress.provinceCode }</span>
									<span id="ccity" class="city">${defaddress.cityCode }</span>
									<span id="carea" class="dist">${defaddress.areaCode }</span>
									<span id="caddress" class="street">${defaddress.memberAddress }</span>
									</span>

								</p>
								<p class="buy-footer-address">
									<span class="buy-line-title">收货人：</span>
									<span class="buy-address-detail">   
                                         <span id="cmname" class="buy-user">${defaddress.memberName } </span>
									<span id="ctel" class="buy-phone">${defaddress.memberTelephone }</span>
									</span>
								</p>
							</div>
						</div>

						<div id="holyshit269" class="submitOrder">
							<div class="go-btn-wrap">
								<input type="hidden" id="orderID" name="orderID" value="${orderInfo.orderID }"/>
								<input type="hidden" id="addressid" name="id" value="${orderInfo.id }"/>
								<input type="hidden" id="orderAomunt" name="orderAmount" value="${orderInfo.orderAmount }"/>
								
								<input type="hidden" id="orderStatus" name="orderStatus" value="${orderInfo.orderStatus }"/>
								
								<a  id="J_Go" class="btn-go am-align-right" tabindex="0" data-am-modal="{target:'#my-pay'}"  >提交订单</a>
								<div class="am-modal am-modal-comfirm" tabindex="-1" id="my-pay">
									<div class="am-modal-dialog">
										<div class="am-modal-bd">
											<label for="pwd">支付密码：</label>
											<input type="password" id="pwd" placeholder="请输入密码进行支付"/>
										</div>	
										<div class="am-modal-footer">
											<span class="am-modal-btn" data-am-modal-cancel>取消</span>
											<span class="am-modal-btn" data-am-modal-confirm onclick="pay()">确认</span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				</form>
			</div>

			<div class="clear"></div>
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

		<div class="theme-popover-mask"></div>
		<div class="theme-popover">

			<!--标题 -->
			<div class="am-cf am-padding">
				<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add address</small></div>
			</div>
			<hr/>

			<div class="am-u-md-12">
				<div class="am-form am-form-horizontal">

					<div class="am-form-group">
						<label for="membername" class="am-form-label">收货人</label>
						<div class="am-form-content">
							<input type="hidden" id="mid" value="${sessionScope.member.memberID }"/>
							<input type="text" id="membername" name="memberName" placeholder="收货人" />
						</div>
					</div>

					<div class="am-form-group">
						<label for="memberphone" class="am-form-label">手机号码</label>
						<div class="am-form-content">
							<input id="memberphone" name="memberTelephone" placeholder="手机号必填" type="tel" />
						</div>
					</div>

					<div class="am-form-group">
						<label for="user-phone" class="am-form-label">所在地</label>
						<div class="am-form-content address">
							<select id="province" name="provinceCode" >
								<option value="0">请选择</option>
							</select>
							<select id="city" name="cityCode" >
								<option value="0">请选择</option>
							</select>
							<select id="area" name="areaCode" >
								<option value="0">请选择</option>
							</select>
						</div>
					</div>

					<div class="am-form-group">
						<label for="memberAddress" class="am-form-label">详细地址</label>
						<div class="am-form-content">
							<textarea class="" rows="3" id="memberAddress" name="memberAddress" placeholder="输入详细地址"></textarea>
							<small>100字以内写出你的详细地址...</small>
						</div>
					</div>

					<div class="am-form-group theme-poptit">
						<div class="am-u-sm-9 am-u-sm-push-3">
							<button class="am-btn am-btn-danger " onclick="addAddress()">保存</button>  
							<div class="am-btn am-btn-danger close">取消</div>
						</div>
					</div>
				</div>
			</div>

		</div>

		<div class="clear"></div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/home/nav-logandreg.js"></script>
		<script src="${pageContext.request.contextPath}/js/home/pay.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>