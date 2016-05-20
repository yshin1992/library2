<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="library/tags" prefix="library"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title></title>

<link rel="stylesheet" href="css/menu.css"> 
</head>

<body id="bg">
	<library:menu imgUrl="images/left/select_xl01.png"/>
<!-- 
	<div class="container">

		<div class="leftsidebar_box">
			<div class="line"></div>
			<dl class="source">
				<dt>
					书籍管理<img src="images/left/select_xl01.png">
				</dt>
				<dd class="first_dd">
					<a href="manager/booktype.do" target="main">图书类别管理</a>
				</dd>
				<dd>
					<a href="manager/bookinfo.do" target="main">图书信息管理</a>
				</dd>
			</dl>
			
			<dl class="syetem_management">
				<dt>
					系统管理<img src="images/left/select_xl01.png">
				</dt>
				<dd>
					<a href="manager/managerinfo.do" target="main">用户基本信息</a>
				</dd>
				<dd>
					<a href="manager/updateMgrInfo.do" target="main">修改用户信息</a>
				</dd>
				<dd>
					<a href="#" target="main">修改用户密码</a>
				</dd>
				<dd class="first_dd">
					<a href="#">后台用户管理</a>
				</dd>
				<dd>
					<a href="#">角色管理</a>
				</dd>
				<dd>
					<a href="#">客户类型管理</a>
				</dd>
				<dd>
					<a href="#">栏目管理</a>
				</dd>
				<dd>
					<a href="#">微官网模板组管理</a>
				</dd>
				<dd>
					<a href="#">商城模板管理</a>
				</dd>
				<dd>
					<a href="#">微功能管理</a>
				</dd>
			</dl>
			
			<dl class="system_log">
				<dt onClick="changeImage()">
					购书记录<img src="images/left/select_xl01.png">
				</dt>
				<dd class="first_dd">
					<a href="#">充值记录</a>
				</dd>
				<dd>
					<a href="#">短信充值记录</a>
				</dd>
				<dd>
					<a href="#">消费记录</a>
				</dd>
				<dd>
					<a href="#">操作记录</a>
				</dd>
			</dl>

			<dl class="custom">
				<dt onClick="changeImage()">
					客户管理<img src="images/left/select_xl01.png">
				</dt>
				<dd class="first_dd">
					<a href="#">客户管理</a>
				</dd>
				<dd>
					<a href="#">试用/成交客户管理</a>
				</dd>
				<dd>
					<a href="#">未成交客户管理</a>
				</dd>
				<dd>
					<a href="#">即将到期客户管理</a>
				</dd>
			</dl>

			<dl class="channel">
				<dt>
					渠道管理<img src="images/left/select_xl01.png">
				</dt>
				<dd class="first_dd">
					<a href="#">渠道主页</a>
				</dd>
				<dd>
					<a href="#">渠道标准管理</a>
				</dd>
				<dd>
					<a href="#">系统通知</a>
				</dd>
				<dd>
					<a href="#">渠道商管理</a>
				</dd>
				<dd>
					<a href="#">渠道商链接</a>
				</dd>
			</dl>

			<dl class="app">
				<dt onClick="changeImage()">
					APP管理<img src="images/left/select_xl01.png">
				</dt>
				<dd class="first_dd">
					<a href="#">App运营商管理</a>
				</dd>
				<dd>
					<a href="#">开放接口管理</a>
				</dd>
				<dd>
					<a href="#">接口类型管理</a>
				</dd>
			</dl>

			<dl class="cloud">
				<dt>
					大数据云平台<img src="images/left/select_xl01.png">
				</dt>
				<dd class="first_dd">
					<a href="#">平台运营商管理</a>
				</dd>
			</dl>

			<dl class="statistics">
				<dt>
					统计分析<img src="images/left/select_xl01.png">
				</dt>
				<dd class="first_dd">
					<a href="#">客户统计</a>
				</dd>
			</dl>

		</div>

	</div>
 -->
	<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
	<script type="text/javascript">
		$(".leftsidebar_box dt").css({
			"background-color" : "#3992d0"
		});
		$(".leftsidebar_box dt img").attr("src", "images/left/select_xl01.png");
		$(function() {
			$(".leftsidebar_box dd").hide();
			$(".leftsidebar_box dt").click(
					function() {
						$(".leftsidebar_box dt").css({
							"background-color" : "#3992d0"
						});
						$(this).css({
							"background-color" : "#317eb4"
						});
						$(this).parent().find('dd').removeClass("menu_chioce");
						$(".leftsidebar_box dt img").attr("src",
								"images/left/select_xl01.png");
						$(this).parent().find('img').attr("src",
								"images/left/select_xl.png");
						$(".menu_chioce").slideUp();
						$(this).parent().find('dd').slideToggle();
						$(this).parent().find('dd').addClass("menu_chioce");
					});
		});
	</script>

	<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
	</div>
</body>
</html>
