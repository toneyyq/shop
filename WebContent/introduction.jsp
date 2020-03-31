<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>商品页面</title>

		<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link type="text/css" href="css/optstyle.css" rel="stylesheet" />
		<link type="text/css" href="css/style.css" rel="stylesheet" />

		<script type="text/javascript" src="basic/js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="basic/js/quick_links.js"></script>

		<script type="text/javascript" src="AmazeUI-2.4.2/assets/js/amazeui.js"></script>
		<script type="text/javascript" src="js/jquery.imagezoom.min.js"></script>
		<script type="text/javascript" src="js/jquery.flexslider.js"></script>
		<script type="text/javascript" src="js/list.js"></script>

	</head>

	<body>

		<div id="header">
		<div class="hmtop">
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

		<b class="line"></b>
		<div class="listMain">

			<!--分类-->
			<div class="nav-table">
				<div class="nav-cont">
					<ul>
						<li class="index">
							<a href="toindex.action">首页</a>
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
		</div>
			
			<script type="text/javascript">
				$(function() {});
				$(window).load(function() {
					$('.flexslider').flexslider({
						animation: "slide",
						start: function(slider) {
							$('body').removeClass('loading');
						}
					});
				});
			</script>
			<div class="scoll">
				<section class="slider">
					<div class="flexslider">
						<ul class="slides">
							<li>
								<img src="${pageContext.request.contextPath}${goodsInfo.goodsPicture}" title="${goodsInfo.goodsName}" />
							</li>
							
						</ul>
					</div>
				</section>
			</div>

			<!--放大镜-->

			<div class="item-inform">
				<div class="clearfixLeft" id="clearcontent">

					<div class="box">
						<script type="text/javascript">
							$(document).ready(function() {
								$(".jqzoom").imagezoom();
								$("#thumblist li a").click(function() {
									$(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
									$(".jqzoom").attr('src', $(this).find("img").attr("mid"));
									$(".jqzoom").attr('rel', $(this).find("img").attr("big"));
								});
							});
						</script>

						<div class="tb-booth tb-pic tb-s310">
							<a href="${pageContext.request.contextPath}${goodsInfo.goodsPicture}"><img src="${pageContext.request.contextPath}${goodsInfo.goodsPicture}" alt="细节展示放大镜特效" rel="${pageContext.request.contextPath}${goodsInfo.goodsPicture}" class="jqzoom"  /></a>
						</div>
						<ul class="tb-thumb" id="thumblist">
							<li class="tb-selected">
								<div class="tb-pic tb-s40">
									<a href="#"><img src="${pageContext.request.contextPath}${goodsInfo.goodsPicture}" mid="${pageContext.request.contextPath}${goodsInfo.goodsPicture}" big="${pageContext.request.contextPath}${goodsInfo.goodsPicture}"></a>
								</div>
							</li>
							
						</ul>
					</div>

					<div class="clear"></div>
					<!-- //放大镜 -->
				</div>

				<div class="clearfixRight">

					<!--规格属性-->
					<!--名称-->
					<div class="tb-detail-hd">
						<h1>
							${goodsInfo.goodsName}
						</h1>
					</div>
					<div class="tb-detail-list">
						<!--价格-->
						<div class="tb-detail-price">
							<li class="price iteminfo_price">
								<dt>促销价</dt>
								<dd><em>¥</em><b class="sys_item_price">${goodsInfo.goodsMemberPrice}</b> </dd>
							</li>
							<li class="price iteminfo_mktprice">
								<dt>原价</dt>
								<dd><em>¥</em><b class="sys_item_mktprice">${goodsInfo.goodsNormalPrice}</b></dd>
							</li>
							<div class="clear"></div>
						</div>

						<!--销量-->
						<!-- <ul class="tm-ind-panel">

							<li class="tm-ind-item tm-ind-sumCount canClick">
								<div class="tm-indcon"><span class="tm-label">累计销量</span><span class="tm-count">6015</span></div>
							</li>
							<li class="tm-ind-item tm-ind-reviewCount canClick tm-line3">
								<div class="tm-indcon"><span class="tm-label">累计评价</span><span class="tm-count">640</span></div>
							</li>
						</ul>
						<div class="clear"></div> -->

						<!--各种规格-->
						<dl class="iteminfo_parameter sys_item_specpara">
							
							<dt class="theme-login">
								<!-- 小屏显示 -->
								<div class="cart-title">可选规格<span class="am-icon-angle-right"></span></div>
							</dt>
							<dd>
								<!--操作页面-->

								<div class="theme-popover-mask"></div>

								<div class="theme-popover">
									<div class="theme-span"></div>
									<div class="theme-poptit">
										<a href="javascript:;" title="关闭" class="close">×</a>
									</div>
									<div class="theme-popbod dform">
										<form class="theme-signin" name="loginform"  >

											<div class="theme-signin-left">

												<div class="theme-options">
													
													<dd>
														
														<span id="Stock" class="tb-hidden">库存<span class="stock">${goodsInfo.goodsNumber }</span>件</span>
													</dd>

												</div>
												<div class="clear"></div>

												<div class="btn-op">
													<div class="btn am-btn am-btn-warning">确认</div>
													<div class="btn close am-btn am-btn-warning">取消</div>
												</div>
											</div>
											<div class="theme-signin-right">
												<div class="img-info">
													<img src="${pageContext.request.contextPath}${goodsInfo.goodsPicture}" />
												</div>
												<div class="text-info">
													<span class="J_Price price-now">¥${goodsInfo.goodsMemberPrice}</span>
													<span class="tb-hidden">库存<span class="stock">${goodsInfo.goodsNumber }</span>件</span>
												</div>
											</div>
										</form>
									</div>
								</div>
							</dd>
						</dl>
						<div class="clear"></div>
					</div>

					<ul class="pay">
					
						<li >
							<div class="clearfix tb-btn tb-btn-basket theme-login">
								<a id="collect" title="收藏商品" onclick="addanddelfavorite(${goodsInfo.goodsID})">
									收藏
								</a>
							</div>
						</li>
						<li>
							<div class="clearfix tb-btn tb-btn-buy theme-login">
								<a  id="LikBuy" title="点此按钮到下一步确认购买信息"  href="${pageContext.request.contextPath}/toaddorder.do?goodsID=${goodsInfo.goodsID}">立即购买</a>
							</div>
						</li>
						<li>
							<div class="clearfix tb-btn tb-btn-basket theme-login">
								<a id="LikBasket" title="加入购物车" onclick="addcart(${goodsInfo.goodsID})">加入购物车</a>
							</div>
						</li>
						
					</ul>
					
				</div>
				<div class="clear"></div>
			</div>

			<!-- introduce-->

			<div class="introduce">
				<div class="browse">
					<div class="mc">
						<ul>
							<li class="mt">
								<h2>猜你喜欢</h2>
							</li>
							<c:forEach items="${goods}" var="good">
							<li class="first">
								<div class="p-img">
									<a href="${pageContext.request.contextPath}/tointroduction.action?id=${good.goodsID}"> <img class="" src="${pageContext.request.contextPath}${good.goodsPicture}" height="177px"> </a>
								</div>
								<div class="p-name">
									<a href="${pageContext.request.contextPath}/tointroduction.action?id=${good.goodsID}">
										${good.goodsName }
									</a>
								</div>
								<div class="p-price"><strong>￥${good.goodsMemberPrice }</strong></div>
							</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="introduceMain">
					<div class="am-tabs" data-am-tabs>
						<ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">
							<li class="am-active">
								<a href="#">
									<span class="index-needs-dt-txt">宝贝详情</span>
								</a>
							</li>
							
							<li>
								<a href="#">
									<span class="index-needs-dt-txt">看了又看</span>
								</a>
							</li>
						</ul>

						<div class="am-tabs-bd">

							<div class="am-tab-panel am-fade am-in am-active">
								<!-- 商品细节 -->
								<div class="details">
									<div class="twlistNews" style="height: 300px">
										${goodsInfo.goodsIntroduce }
									</div>
								</div>
								<div class="clear"></div>
							</div>

							<div class="am-tab-panel am-fade">
								<!-- 看了又看 -->
								<div class="like">
									<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
										<c:forEach items="${pageInfo.list }" var="goods">
										<li>
											<div class="i-pic limit">
												<a href="${pageContext.request.contextPath}/tointroduction.action?id=${goods.goodsID}">
												<img src="${pageContext.request.contextPath}${goods.goodsPicture}" height="230px" width="230px" />
												<p>${goods.goodsName }</p>
												</a>
												<p class="price fl">
													<b>¥</b>
													<strong>${goods.goodsMemberPrice }</strong>
												</p>
											</div>
										</li>
										</c:forEach>
									</ul>
								</div>
								<div class="clear"></div>

								<!--分页 -->
								<ul class="am-pagination am-pagination-right">
									<li class="am-disabled">
										<a href="<c:url value='/tointroduction.action?pn=${pageInfo.pageNum-1 }&id=${goodsInfo.goodsID }'/>">&laquo;</a>
									</li>
									 <!--处理页码-->
						            <c:forEach var="num"
						                       begin="${(pageInfo.pageNum-3>0?(pageInfo.pageNum-3):1)}"
						                       end="${(pageInfo.pageNum+3<=pageInfo.pages)?(pageInfo.pageNum+3):pageInfo.pages}">
						 
						                <li>
						                    <a href="<c:url value='/tointroduction.action?pn=${num}&id=${goodsInfo.goodsID }'/>">
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
										<a href="<c:url value='/tointroduction.action?pn=${pageInfo.pageNum+1 }&id=${goodsInfo.goodsID }'/>">&raquo;</a>
									</li>
								</ul>
								<div class="clear"></div>

							</div>

						</div>

					</div>

					<div class="clear"></div>

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
				
			</div>
		</div>
		<!--菜单 -->
		<div class="tip">
			<div id="sidebar">
				<div id="wrap">
					
					<div id="shopCart " class="item ">
						<a href="${pageContext.request.contextPath}/cart.do">
							<span class="message "></span>
						</a>
						<a href="${pageContext.request.contextPath}/cart.do"><p id="count" class="cart_num ">0</p></a>
					</div>
					<div id="brand " class="item ">
						<a href="${pageContext.request.contextPath}/mycollect.do">
							<span class="wdsc "><img src="images/wdsc.png " /></span>
						</a>
						<div class="mp_tooltip ">
							我的收藏
							<i class="icon_arrow_right_black "></i>
						</div>
					</div>
					<div id="broadcast " class="item ">
						<!-- 充值 -->
						<a href="# ">
							<span class="chongzhi "><img src="images/chongzhi.png " /></span>
						</a>
						<div class="mp_tooltip ">
							余额：￥${member.memberAmount}
							<i class="icon_arrow_right_black "></i>
						</div>
					</div>

					<div class="quick_toggle ">
						<ul>
							<li class="qtitem ">
								<a href="# "><span class="kfzx "></span></a>
								<div class="mp_tooltip ">客服中心<i class="icon_arrow_right_black "></i></div>
							</li>
							<!--二维码 -->
							<li class="qtitem ">
								<a href="#none "><span class="mpbtn_qrcode "></span></a>
								<div class="mp_qrcode " style="display:none; "><img src="images/weixin_code_145.png " /><i class="icon_arrow_white "></i></div>
							</li>
							<!--回到顶部 -->
							<li class="qtitem ">
								<a href="#top " class="return_top "><span class="top "></span></a>
							</li>
						</ul>
					</div>

					
					<div id="quick_links_pop " class="quick_links_pop hide "></div>

				</div>

			</div>

		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/home/nav-logandreg.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/home/introduction.js"></script>
		<script type="text/javascript">
			//进入页面判断是否已经收藏该商品
			$(function () {
				var member='${sessionScope.member.memberName}'
				if (!member || member== null || member == undefined ||member == '') {
					
				}else {
					var goodsid=${goodsInfo.goodsID}
					
					$.post('checkfavorite.do',{
						goodsID:goodsid
						
					},function(data){
						if (data>0) {
							$('#collect').text("已收藏")
						}else {
							
						}
					})
				}
				
			})
			
		</script>
	</body>

</html>