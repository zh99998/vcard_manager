<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />	
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/bootstrap-responsive.css" rel="stylesheet">
	<script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
	
  </head>
  
  <body>
  	<!-- header -->
  	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="#">名片管理系統</a>
				<div class="nav-collapse collapse">
					<p class="navbar-text pull-right">
						Logged in as <a href="#" class="navbar-link">Username</a>
					</p>
					<ul class="nav">
						<li class="active"><a href="#">首页</a></li>
						<li><a href="#about" data-toggle="modal">关于</a></li>
						<!-- <li><a href="#contact">Contact</a></li> -->
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div id="about" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">关于名片管理系统</h3>
		</div>
		<div class="modal-body">
			<p>喵喵喵喵</p>
		</div>
		<div class="modal-footer">
			<button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">确定</button>
		</div>
	</div>
	
	
	<!-- body -->
	
	<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="active"><a href="#">通讯录</a></li>
						<li><a href="#">群组1</a></li>
						<li><a href="#">群组2</a></li>
						<!-- Button to trigger modal -->
						<li><a href="#new_circle" role="button" class="btn"
							data-toggle="modal" style="width:80px">新建群组</a></li>
						<li><a href="#myModal" role="button" class="btn"
							data-toggle="modal" style="width:80px">导入名片</a></li>
						<!-- Modal -->
						<div id="new_circle" class="modal hide fade" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h3 id="myModalLabel">Modal header</h3>
							</div>
							<div class="modal-body">
								<p>
									输入组名 <input type="text" name="fname" />
								</p>
							</div>
							<div class="modal-footer">
								<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
								<button class="btn btn-primary">保存</button>
							</div>
						</div>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->


			<div class="span9">
				<div class="btn-group">
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"
						style="width:65px;"> <input type="checkbox"
						style="margin:3px 10px;" /> <span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a tabindex="-1" href="#">全选</a></li>
						<li><a tabindex="-1" href="#">全不选</a></li>
						<li class="divider"></li>
					</ul>
				</div>

				<div class="btn-group">
					<a href="#new_card" class="btn dropdown-toggle" style="width:65px;"
						data-toggle="modal"> <i class="icon-user"> <!-- --></i><i
						class="icon-plus"> <!--  --></i><span style="margin:3px 10px;"></span>
						<span class="caret"></span>
					</a>

					<!-- Modal -->
					<div id="new_card" class="modal hide fade" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h3 id="myModalLabel">Modal header</h3>
						</div>
						<div class="modal-body">
							<input type="text" style="width:525px;height:55px;" />
						</div>
						<div class="modal-footer">
							<button class="btn" data-dismiss="modal" aria-hidden="true">
								关闭</button>
							<button class="btn btn-primary">保存</button>
						</div>
					</div>
				</div>

				<div class="btn-group">
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"
						style="width:65px;"> <span style="margin:3px 10px;">更多</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a tabindex="-1" href="#">删除联系人</a></li>
						<li><a tabindex="-1" href="#">合并联系人</a></li>
						<li class="divider"></li>
						<li><a tabindex="-1" href="#">导入...</a></li>
						<li><a tabindex="-1" href="#">导出...</a></li>
						<li><a tabindex="-1" href="#">查找并合并重复项</a></li>
						<li><a tabindex="-1" href="departview.jsp">公司部门视图</a></li>
						<li class="divider"></li>
						<li><a tabindex="-1" href="#">名字</a></li>
						<li><a tabindex="-1" href="#">姓氏</a></li>
					</ul>
				</div>

				<div class="btn-group" style="float:right;">
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"
						style="width:20px;height:20px;"> <i class="icon-chevron-left">
							<!--  -->
					</i>
					</a> <a class="btn dropdown-toggle" data-toggle="dropdown" href="#"
						style="width:25px;height:20px;"> <i class="icon-chevron-right">
							<!--  -->
					</i>
					</a>
				</div>

				<div class="btn-group" style="float:right;">
					<div>
						<b>zhang</b> "-" <b>test</b>
					</div>
				</div>
			</div>
			<div>
			//公司部门视图
			</div>
		</div>
	</div>
  </body>
</html>
