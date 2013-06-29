<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8"/>
	<title>用户管理</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<meta name="description" content=""/>
			<meta name="author" content=""/>

				<!-- Le styles -->
				<link href="assets/css/bootstrap.css" rel="stylesheet"/>
					<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
					<link href="assets/css/bootstrap-responsive.css" rel="stylesheet"/>

						

						<link rel="apple-touch-icon-precomposed" sizes="144x144"
							href="assets/ico/apple-touch-icon-144-precomposed.png"/>
							<link rel="apple-touch-icon-precomposed" sizes="114x114"
								href="assets/ico/apple-touch-icon-114-precomposed.png"/>
								<link rel="apple-touch-icon-precomposed" sizes="72x72"
									href="assets/ico/apple-touch-icon-72-precomposed.png"/>
									<link rel="apple-touch-icon-precomposed"
										href="assets/ico/apple-touch-icon-57-precomposed.png"/>
										<link rel="shortcut icon" href="assets/ico/favicon.png"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style type="text/css">
td {
	width: 60px;
}
</style>
<style>
/*.fieldtitle {
	width: 100px;
}*/
</style>
<script type="text/javascript">
	function chickAll() {
		// 全选方法
		var chickobj = document.getElementsByName("num");
		for ( var i = 0; i < chickobj.length; i++) {

			chickobj[i].checked = "checked";
		}

	}
	function Nochick() {
		// 反选方法   
		var chickobj = document.getElementsByName("num");
		for ( var i = 0; i < chickobj.length; i++) {

			chickobj[i].checked = !chickobj[i].checked;
		}

	}
</script>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<body>
	<jsp:include page="public/head.jsp"></jsp:include>


	<div id="main">
		<form name="form1" action="UserManagerServlet"	method="post"/>
			<table border="1" align="center" style="border-collapse:collapse;">
				<tr align="center">
					<td colspan="12">用户信息列表</td>
				</tr>
				
				<tr align="center">
					<td></td>
					<td>用户名</td>
					<td>密码</td>


					<td colspan="2">操作</td>
				</tr>

				<c:forEach var="user" items="${list}">

					<tr align="center">
						<td><input type="checkbox" value='${user.id}' name="num" /></td>
						<td><a href="ServletViewUser?userId=${user.id}">${user.name}</a></td>

						<td>${user.password}</td>

						<td><a href="${pageContext.request.contextPath}/UserDeleteServlet?uid=${user.id}">删除</a></td>
						<td><a href="UpdateUserServlet?uid=${user.id}">修改</a></td>
					</tr>
				</c:forEach>
			</table>
			<table align="center">
				<tr>
					<td><input type="button" value="全选" name="checkall"
						id="checkall" onclick="chickAll()" /></td>
					<td><input type="button" value="反选" name="nocheck"
						id="nocheck" onclick="Nochick()" /></td>
					<td><input type="submit" value="批量删除" /></td>

				</tr>
			</table>
	</div>
  </form>
  <form action ="AddUserServlet" method="post">
	<div class="container">
	
                <fieldset>

				<div class="control-group">

					<!-- Text input-->
					<label class="control-label" for="input01">用户名</label>
					<div class="controls">
						<input name="name" type="text"  class="input-xlarge"/>
							<p class="help-block"></p>
					</div>
				</div>

				<div class="control-group">

					<!-- Text input-->
					<label class="control-label" for="input01">密码</label>
					<div class="controls">
						<input name = "password" type="text"  class="input-xlarge"/>
							<p class="help-block"></p>
					</div>
				</div>



				<div class="control-group">
					<label class="control-label"></label>

					<!-- Button -->
					<div class="controls">
						<button class="btn btn-default">新建用户</button>
						${failed}
					</div>
				</div>

			</fieldset>
	</div>
	<!-- /container -->
	</form>
</body>
</html>
