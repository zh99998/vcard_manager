<%@page import="edu.sdkd.domain.*" contentType="text/html charset=utf-8"%>
<form name="myform" action="servlet/UpdateUserServlet" method="post">
	<table border="1" align="center" style="border-collapse:collapse;">
		<tr>
			<td colspan="2">用户信息修改<input type="hidden" name="userId"
				value="${userId}" /></td>
		</tr>
		<tr>
			<td>用户名</td>
			<td class="tdstyle2"><input type="text" name="userName" /></td>
		</tr>
		<tr>
			<td>密 码</td>
			<td><input type="text" name="userPassword" /></td>
		</tr>




		<td colspan="2"><input type="submit" value="修改" /></td>
		</tr>
	</table>
</form>