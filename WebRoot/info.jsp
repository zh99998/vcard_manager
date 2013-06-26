<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>card_manager.html</title>

		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="this is my page">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">

		<link rel="stylesheet" type="text/css" href="../css/styles.css">
		<link rel="stylesheet" type="text/css"
			href="../css/bootstrap-responsive.min.css">
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">

		<script src="../js/jquery-1.8.3.min.js">
</script>
		<script src="../js/bootstrap.min.js">
</script>
		<script src="../js/jquery.editable.min.js">
</script>
	</head>

	<body>

		<div class="container">
			<div class="btn-group">
				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"
					style="width: 65px; height: 20px;"> <i class="icon-hand-up"></i>
				</a>
			</div>

			<div class="btn-group">
				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"
					style="width: 65px;" data-toggle="modal"> <i class="icon-user"></i><i
					class="icon-plus-sign"></i><span style="margin: 3px 10px;"></span>
					<span class="caret"></span> </a>
				<ul class="dropdown-menu">
					<li>
						<input>
						<i class="icon-search"></i>
						</input>
					</li>
					<li class="divider"></li>
					<li>
						<input type="checkbox" style="margin: 3px 10px;">
						通讯录
						</input>
					</li>
					<li class="divider"></li>
					<li>
						<a tabindex="-1" href="#">新建</a>
					</li>
				</ul>
				<script>
$('.dropdown-menu').click(function(e) {
	e.stopPropagation();
});
</script>
			</div>

			<div class="btn-group">
				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"
					style="width: 65px;"> <span style="margin: 3px 10px;">更多</span>
					<span class="caret"></span> </a>
				<ul class="dropdown-menu">
					<li>
						<a tabindex="-1" href="#">删除联系人</a>
					</li>
					<li>
						<a tabindex="-1" href="#">合并联系人</a>
					</li>
					<li class="divider"></li>
					<li>
						<a tabindex="-1" href="#">导入...</a>
					</li>
					<li>
						<a tabindex="-1" href="#">导出...</a>
					</li>
					<li>
						<a tabindex="-1" href="#">查找并合并重复项</a>
					</li>
					<li>
						<a tabindex="-1" href="#">还原通讯录</a>
					</li>
					</li>
					<li class="divider"></li>
					<li>
						<a tabindex="-1" href="#">名字</a>
					</li>
					<li>
						<a tabindex="-1" href="#">姓氏</a>
					</li>
				</ul>
			</div>

			<div class="btn-group" style="float: right;">
				<input type="button" style="width: 75px; height: 30px;" value="已保存" />
			</div>

		</div>

		<hr />
		<div>
			<c:forEach var="info" items="${infoesList}">
				<div class="row">
					<div class="span3">
						<c:choose>
							<c:when test="${info.property=='FN'}">
								<span>姓名</span>
							</c:when>
							<c:when test="${info.property=='EMAIL'}">
								<span>电子邮箱</span>
							</c:when>
							<c:when test="${info.property=='ORG'}">
								<span>组织</span>
							</c:when>
							<c:when test="${info.property=='TEL'}">
								<span>电话</span>
							</c:when>
							<c:when test="${info.type=='WORK'}">
								<span>工作</span>
							</c:when>
							<c:when test="${info.type=='HOME'}">
								<span>家庭</span>
							</c:when>
							<c:otherwise>
								<span>${info.type}</span>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="span7">
						<c:choose>
							<c:when test="${info.property == 'PHOTO'}">
									<div><img src="data:image/png;base64,${info.value}" /></div>
							</c:when>
							<c:otherwise>
								<div style="width: 200px; height: 20px; float: left;" class="edit" id="div_1">
									${info.value}
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="span2">
						<a href="#"> <i class="icon-remove-circle" style="width:20px;"></i></a>
					</div>
				</div>
			</c:forEach>
		</div>
		<br />
		<hr />

		<div class="vcard">
			<img class="photo"
				src="http://www.gravatar.com/avatar/09fb7a14e5b9fbb9cd82ffaa1df37634&size=120"
				align="left" />
			<h1 class="fn">
				Forrest Gump
			</h1>
			<div class="email">
				<span class="type">Internet</span> Email (
				<span class="type">pref</span>erred):
				<a class="value" href="mailto:forrestgump@example.com">forrestgump@example.com</a>
			</div>
			<div class="n">
				First Name:
				<span class="given-name">Forrest</span>
				<br />
				Last Name:
				<span class="family-name">Gump</span>
			</div>

			<div class="label" style="display: none">
				<span class="type">home</span> 42 Plantation St.
				<br />
				Baytown, LA 30314
				<br />
				United States of America
			</div>
			<div class="adr">
				<span class="type">Home</span> Address:
				<br />
				<span class="street-address">42 Plantation St.</span>
				<br />
				<span class="locality">Baytown</span>,
				<span class="region">LA</span>
				<span class="postal-code">30314</span>
				<br />
				<span class="country-name">United States of America</span>
			</div>
			<div class="tel">
				<abbr class="type" title="voice"></abbr>
				<span class="type">Home</span> Phone:
				<span class="value">+1-111-555-1212</span>
			</div>

			<div>
				Organization:
				<span class="org">Bubba Gump Shrimp Co.</span>
				<br />
				Title:
				<span class="title">Shrimp Man</span>
			</div>

			<div class="label" style="display: none">
				<span class="type">work</span> 100 Waters Edge
				<br />
				Baytown, LA 30314
				<br />
				United States of America
			</div>
			<div class="adr">
				<span class="type">Work</span> Address:
				<br />
				<span class="street-address">100 Waters Edge</span>
				<br />
				<span class="locality">Baytown</span>,
				<span class="region">LA</span>
				<span class="postal-code">30314</span>
				<br />
				<span class="country-name">United States of America</span>
			</div>
			<div class="tel">
				<abbr class="type" title="voice"></abbr>
				<span class="type">Work</span> Phone:
				<span class="value">+1-404-555-1212</span>
			</div>

			<em>vCard last updated:</em>
			<time class="rev" datetime="2008-04-24T19:52:43Z">
			April 24, 2008 at 7:52 PM GMT
			</time>

		</div>
		<script>
$(document).ready(function() {
	//$('.edit').editable();
		$('.edit').editable(
				'${pageContext.request.contextPath }/servlet/InfoServlet', {});
	});
</script>

	</body>
</html>
