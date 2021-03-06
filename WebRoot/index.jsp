<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		<style>
tr:hover {
	background-color: #F2F2F2;
}
</style>

		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/bootstrap-responsive.css" rel="stylesheet">
		<script src="js/jquery.js">
</script>
		<script src="js/bootstrap.js">
</script>
		<script type="text/javascript">
function deleteItem(id) {
	var b = window.confirm("确定删除？");
	if (b) {
		window.location.href = "";
	}
};

function toCards(id) {
	window.location.href = "${pageContext.request.contextPath }/cards?id=" + id;
}
</script>

	</head>

	<body>
		<!-- header -->
		<jsp:include page="public/head.jsp"></jsp:include>


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
							<li class="active">
								<a href="#">通讯录</a>
							</li>
							<c:forEach var="list" items="${circles}">
								<li>
									<a class="circle_${list.id}" href="circles?id=${list.id}"
										data-toggle="modal"
										onclick="$('#edit_circle_id_input').val(${list.id})">${list.name}
										<c:forEach var="length" items="${num}">
											<c:if test="${length.key == list.id}">
								(${length.value})
								</c:if>
										</c:forEach> </a>
								</li>
							</c:forEach>
							<!-- Button to trigger modal -->
							<li>
								<a href="#new_circle" role="button" class="btn"
									data-toggle="modal" style="width: 80px">新建群组</a>
							</li>
							<!-- Modal -->
							<div id="new_circle" class="modal hide fade" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">
										×
									</button>
									<h3 id="myModalLabel">
										输入新建群组名称
									</h3>
								</div>
								<form action="CircleServlet" method="POST">
									<div class="modal-body">

										<p>
											输入组名
											<input type="text" name="name" />
										</p>
									</div>
									<div class="modal-footer">
										<button class="btn" data-dismiss="modal" aria-hidden="true">
											关闭
										</button>
										<button class="btn btn-primary">
											保存
										</button>
									</div>
								</form>
							</div>
						</ul>
					</div>

					<!--/.well -->
				</div>
				<!--/span-->


				<div class="span9">
					<div class="btn-group">
						<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"
							style="width: 65px;"> <input type="checkbox"
								style="margin: 3px 10px;" /> <span class="caret"></span> </a>
						<ul class="dropdown-menu">
							<li>
								<a tabindex="-1" href="#"
									onclick="$('.cardentrycheckbox, #selectall').attr('checked', true);return false">全选</a>
							</li>
							<li>
								<a tabindex="-1" href="#"
									onclick="$('.cardentrycheckbox, #selectall').attr('checked', false);return false">全不选</a>
							</li>
							<li class="divider"></li>
						</ul>
					</div>

					<div class="btn-group">
						<a href="#new_card" class="btn dropdown-toggle"
							style="width: 65px;" data-toggle="modal"> <i
							class="icon-user"> <!-- --> </i><i class="icon-plus"> <!--  -->
						</i><span style="margin: 3px 10px;"></span> <span class="caret"></span>
						</a>

						<!-- Modal -->
						<div id="new_card" class="modal hide fade" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<form action="CardServlet" method="POST">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">
										×
									</button>
									<h3 id="myModalLabel">
										请输入姓名
									</h3>
								</div>
								<div class="modal-body">
									<input name="N" type="text"
										style="width: 525px; height: 55px;" />
									<input name="action" value="addcard" type="hidden" />
									<input name="circleId" value="${circleId}" type="hidden" />
								</div>
								<div class="modal-footer">
									<button class="btn" data-dismiss="modal" aria-hidden="true">
										关闭
									</button>
									<button class="btn btn-primary">
										保存
									</button>
								</div>
							</form>
						</div>
					</div>

					<div class="btn-group">
						<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"
							style="width: 65px;"> <span style="margin: 3px 10px;">更多</span>
							<span class="caret"></span> </a>
						<ul class="dropdown-menu">
							<c:if test="${circleId!=null}">
								<li>
									<a tabindex="-1"
										href="CircleServlet?id=${circleId}&_method=delete">删除组</a>
								</li>

								<li>
									<a tabindex="-1"
										href="#edit_circle" data-toggle="modal">修改组名称</a>
								</li>

							</c:if>

							<li>
								<a id="deleteCard" tabindex="-1" href="#">删除联系人</a>
							</li>
							<li>
								<a id="merge" tabindex="-1" href="#">合并联系人</a>
							</li>
							<li class="divider"></li>
							<!--<li>
								<a tabindex="-1" href="#">导入...</a>
							</li>-->
							<li>
								<a id="export" tabindex="-1" href="export">导出...</a>
							</li>
							<li>
								<a tabindex="-1" href="orgview">公司部门视图</a>
							</li>
						</ul>
					</div>

					<div class="btn-group" style="float: right;">
						<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"
							style="width: 20px; height: 20px;"> <i
							class="icon-chevron-left"> <!--  --> </i> </a>
						<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"
							style="width: 25px; height: 20px;"> <i
							class="icon-chevron-right"> <!--  --> </i> </a>
					</div>

					<div class="btn-group" style="float: right;">
						<div>
							<b>zhang</b> "-"
							<b>test</b>
						</div>
					</div>

					<div class="btn-group" style="float: right;">
						<li>
							<form action="search" id="searchForm" method="post">
								<input name="key" />
								<a href="#" onclick="$('#searchForm').submit(); return false">
								<i class="icon-search"></i>
								</a>
							</form>
						</li>
					</div>

					<div>
						<br />
						<table style="width: 100%">
							<th>
								<td>
									姓名
								</td>
								<td>
									邮箱
								</td>
								<td>
									电话
								</td>
								<td>
									公司
								</td>
							</th>
							<c:forEach var="cardEntry" items="${cardInfoesMap}">

								<tr style="cursor: pointer"
									onclick="toCards(${cardEntry.key.id})">
									<td>
										<input type="checkbox" class="cardentrycheckbox"
											data-cardid="${cardEntry.key.id}" style="cursor: default" />
									</td>
									<td>
										${cardEntry.value.FN}
									</td>
									<td>
										${cardEntry.value.EMAIL}
									</td>
									<td>
										${cardEntry.value.TEL}
									</td>
									<td>
										${cardEntry.value.ORG}
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>

				</div>
			</div>
		</div>
		<div id="edit_circle" class="modal hide fade" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">
					×
				</button>
				<h3 id="myModalLabel">
					修改群组名称
				</h3>
			</div>

			<form id="editCircleform" action="CircleServlet" method="POST">
				<div class="modal-body">

					<p>
						输入修改群组名
						<input type="text" name="name" />
						<input type="hidden" name="id" value=${circleId} />
						<input type="hidden" name="_method" value="put" />
					</p>
				</div>

				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">
						关闭
					</button>
					<button class="btn btn-primary">
						保存
					</button>
				</div>
			</form>

		</div>
		<script>
$('.cardentrycheckbox').click(function(event) {
	event.stopPropagation()
})

$('#deleteCard').click(function() {
	var checkboxes = $('.cardentrycheckbox')
	var result = new Array();
	for (i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			result.push($(checkboxes[i]).attr('data-cardid'))
		}
	}
	location.href = "CardServlet?delete=delete&id=" + result.join(',')
return false;
})

$('#export').click(function() {
	var checkboxes = $('.cardentrycheckbox')
	var result = new Array();
	for (i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			result.push($(checkboxes[i]).attr('data-cardid'))
		}
	}
	location.href = "export?id=" + result.join(',')
	return false;
})

$('#merge').click(function() {
	var checkboxes = $('.cardentrycheckbox')
	var result = new Array();
	for (i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			result.push($(checkboxes[i]).attr('data-cardid'))
		}
	}
	location.href = "merge?id=" + result.join(',')
	                      return false;
})
</script>
		<style>
.circle_${circleId}
{
background
:
 
lightblue
;
}
</style>
	</body>
</html>
