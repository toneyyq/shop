<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>搜索页面</title>

		<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />

		<link href="basic/css/demo.css" rel="stylesheet" type="text/css" />

		<link href="css/seastyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="basic/js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="js/script.js"></script>
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
			
			<div id= "content">
			<div class="am-g am-g-fixed">
				<div class="am-u-sm-12 am-u-md-12">
                 	<div class="theme-popover">														
					
					<ul class="select">
						
						<li class="select-list">
							<dl id="select2">
								<dt class="am-badge am-round">种类</dt>
								<div class="dd-conent">
									<dd class="select-all selected"><a href="qgoodsbynameortype.action">全部</a></dd>
									<c:forEach items="${types}" var="type">
									<dd><a href="qgoodsbynameortype.action?type=${type.typeName}">${type.typeName}</a></dd>
									</c:forEach>
								</div>
							</dl>
						</li>
						
			        
					</ul>
					<div class="clear"></div>
                      </div>
					<div class="search-content">
						
						<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
							<c:forEach items="${pageInfo.list}" var="goods">
							<li>
							
								<div class="i-pic limit">
									<a href="${pageContext.request.contextPath}/tointroduction.action?id=${goods.goodsID}">
									<img src="${pageContext.request.contextPath}${goods.goodsPicture}" height="220px" width="220px" />											
									<p class="title fl">${goods.goodsName}</p>
									<p class="price fl">
										<b>¥</b>
										<strong>${goods.goodsMemberPrice }</strong>
									</p>
									<p class="number fl">
										商品数量：<span>${goods.goodsNumber }</span>
									</p>
									</a>
								</div>
							</li>
							</c:forEach>
						</ul>
						
					</div>
					
					<div class="clear"></div>
					<ul class="am-pagination am-pagination-right">
						<li class="am-disabled"><a href="<c:url value='/qgoodsbynameortype.action?pn=${pageInfo.pageNum-1 }&goodsName=${goodsName }&type=${type }'/>">&laquo;</a></li>
						<c:forEach var="num"
			                       begin="${(pageInfo.pageNum-3>0?(pageInfo.pageNum-3):1)}"
			                       end="${(pageInfo.pageNum+3<=pageInfo.pages)?(pageInfo.pageNum+3):pageInfo.pages}">
			 
			                <li>
			                    <a href="<c:url value='/qgoodsbynameortype.action?pn=${num}&goodsName=${goodsName }&type=${type }'/>">
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
						<li><a href="<c:url value='/qgoodsbynameortype.action?pn=${pageInfo.pageNum+1 }&goodsName=${goodsName }&type=${type }'/>">&raquo;</a></li>
					</ul>
			

				</div>
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
		</div>

	</div>

		<!--引导 -->
		<ul class="navCir">
			<li class="active">
				<a href="${pageContext.request.contextPath}/toindex.action"><i class="am-icon-home "></i>首页</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/qgoodsbynameortype.action"><i class="am-icon-list"></i>搜索</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/cart.do"><i class="am-icon-shopping-basket"></i>购物车</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/myindex.do"><i class="am-icon-user"></i>我的</a>
			</li>
		</ul>

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

		<script>
			window.jQuery || document.write('<script src="basic/js/jquery-1.9.min.js"><\/script>');
		</script>
		<script type="text/javascript" src="basic/js/quick_links.js"></script>
		<script type="text/javascript" src="js/home/nav-logandreg.js"></script>
		<div class="theme-popover-mask"></div>

	</body>

</html>