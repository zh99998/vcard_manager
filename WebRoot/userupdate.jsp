<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/bootstrap-responsive.css" rel="stylesheet">
		<script src="js/jquery.js">
</script>
		<script src="js/bootstrap.js">
</script>
	</head>
	<body>
		<jsp:include page="public/head.jsp"></jsp:include>
		<form style="margin-top:50px;" name="myform" action="UpdateUserServlet" method="post">
		<table border="1" align="center" style="border-collapse: collapse;">
			<tr>
				<td colspan="2">
					用户信息修改
					<input type="hidden" name="userId" value="${userId}" />
				</td>
			</tr>
			<tr>
				<td>
					用户名
				</td>
				<td class="tdstyle2">
					<input type="text" name="userName" />
				</td>
			</tr>
			<tr>
				<td>
					密 码
				</td>
				<td>
					<input type="text" name="userPassword" />
				</td>
			</tr>




			<td colspan="2">
				<input type="submit" value="修改" />
			</td>
			</tr>
		</table>
	</form>
	</body>
</html>


