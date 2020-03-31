<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>缘起后台  公告添加</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datepicker3.min.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datepicker.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datepicker.zh-CN.min.js"></script>
		<!--日期控件jQuery-->
		<script type="text/javascript">
			$(function() {
				$("#sDate").datepicker({
					language: "zh-CN",
					clearBtn: true, //清除
					autoclose: true,
					todayHighlight: true,
					format: 'yyyy-mm-dd',
					todayBtn: true, //今日按钮
					startDate: '2020-01-01', 
					endDate: '2030-12-31'
				});
				$("#eDate").datepicker({
					language: "zh-CN",
					clearBtn: true, //清除
					autoclose: true,
					todayHighlight: true,
					format: 'yyyy-mm-dd',
					todayBtn: true, //今日按钮
					startDate: '2020-01-01', 
					endDate: '2030-12-31'
				});
			})	
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row" >
				<div class="page-header">
				  	<h1 class="col-md-8" style="font-family: '楷体';">缘起  后台管理系统 <small>&ensp;&ensp;公告管理  添加公告</small></h1>
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
					<div class="col-md-6">
						<div class="page-header">
						  	<h2 style="font-family: '楷体';">添加公告信息<span class="glyphicon glyphicon-plus"></span></h2> 
						</div>
					</div>
					<div class="col-md-6">
						<nav aria-label="...">
					  		<ul class="pager">
					    		<li class="next"><a href="javascript:history.go(-1)">返回<span aria-hidden="true">&rarr;</span></a></li>
					  		</ul>
						</nav>
					</div>
				</div>
				<div class="row" id="c-content">
					<form action="${pageContext.request.contextPath}/addplacard.action" class="form-horizontal" method="post">
						<div class="form-group col-md-12 ">
						    <label for="placard_tittle" class="col-md-2 control-label">公告标题:</label>
						    <div class="col-md-9">
						    	<input type="text" class="form-control " name="placardTitle" id="placard_tittle"  />
						    </div>
						</div>
						<div class="form-group col-md-12 ">
						    <label for="placard_content" class="col-md-2 control-label">公告内容:</label>
						    <div class="col-md-9">
						    	<textarea name="placardContent" class="form-group-lg form-control" style="height: 180px;" ></textarea>
						    </div>
						</div>
						<div class="form-group col-md-12 form-inline">
						    <label for="placard_stime" class="col-md-2 control-label">发布时间:</label>
						    <div class="col-md-3">
					    	<input type="text" name="issueDate" id="sDate" class="laydate-icon col-md-12 form-group-lg form-control"  />
					    	</div>
						    <label for="placard_etime" class="col-md-2 control-label">失效时间:</label>
						    <div class="col-md-3">
					    	<input type="text" name="expireDate" id="eDate" class="col-md-12 form-group-lg form-control"  />
							</div>
						</div>
						<div class="form-group col-md-12">
							<input type="submit" class="btn btn-success col-md-3 col-md-offset-2" value="保存并返回"  />
							<input type="reset" class="btn btn-danger col-md-3 col-md-offset-2" />
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
		
	</body>
</html>
