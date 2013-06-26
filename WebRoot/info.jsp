<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'info.jsp' starting page</title>
	</head>

	<body>
		<table style="width: 100%">
			<c:forEach var="info" items="${infoesList}">
				<tr>
					<td></td>
				</tr>
			</c:forEach>
		</table>
		This is my info.JSP page.
		<br>
	</body>
</html>
