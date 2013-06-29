<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="brand" href=".">名片管理系統</a>
			<div class="nav-collapse collapse">
				<p class="navbar-text pull-right">
					欢迎回来，
					<a href="changeinfo.jsp" class="navbar-link">${user.name}</a>
					| <a href="logout">退出</a>
				</p>

				<ul class="nav">
					<li class="active">
						<a href=".">首页</a>
					</li>

					<c:if test="${user.admin}">
						<li>
							<a href="UserManagerServlet">管理中心</a>
						</li>
					</c:if>

					<li>
						<a href="#about" data-toggle="modal">关于</a>
					</li>
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
			aria-hidden="true">
			×
		</button>
		<h3 id="myModalLabel">
			关于名片管理系统
		</h3>
	</div>
	<div class="modal-body">
		<p>
			名片管理系统
			<br />
			版权所有©2013 sdkd信息软件102开发小组
			<br />
			保留所有权利。
			<br />
			本系统有朱恒、张贺、王文波、孙中强参与开发。
			<br />
		</p>
	</div>
	<div class="modal-footer">
		<button class="btn btn-primary" data-dismiss="modal"
			aria-hidden="true">
			确定
		</button>
	</div>
	
</div>
