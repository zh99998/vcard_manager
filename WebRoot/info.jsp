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
		<link rel="stylesheet" type="text/css" href="../css/bootstrap-combobox.css">

		<script src="../js/jquery-1.8.3.min.js">
</script>
		<script src="../js/bootstrap.min.js">
</script>
		<script src="../js/jquery.editable.min.js">
</script>
<script src="../js/bootstrap-combobox.js">
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
		<div id="infoes">
			<c:forEach var="info" items="${infoesList}">
				<div id="info${info.id}" class="row">
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
								<div>
									<img src="data:image/png;base64,${info.value}" />
								</div>
							</c:when>
							<c:otherwise>
								<div style="width: 200px; height: 20px; float: left;"
									class="edit" id="infodiv_${info.id}">
									${info.value}
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="span2">
						<a href="#" onclick="deleteRow(${info.id})"> <i
							class="icon-remove-circle" style="width: 20px;"></i> </a>
					</div>
				</div>
			</c:forEach>
		</div>
		<br />
		<div>
			<div class="span4">
				<select class="combobox">
					<option value="ADD">添加</option>
					<option value="FN">姓名</option>
					<option value="EMAIL">邮箱</option>
					<option value="TEL">电话</option>
					<option value="ORG">公司</option>
				</select>
			</div>
			<script>
				$('.combobox').change(function(ev){
					$('<div />', {'class':'row'}).append([
						$('<div />', {'class': 'span3'}).append($('<span/>', {'text': this.value})),
						$('<div />', {'class': 'span7'}).append($('<div/>', {'id': 'create_'+this.value, 'class': 'edit', 'text': '点击编辑'})),
						$('<div />', {'class': 'span2'}),
						
						]).appendTo('#infoes')
						$('.edit').editable(
				'${pageContext.request.contextPath }/servlet/InfoServlet?card_id=${card.id}', {});
					this.value = 'ADD';
				})
			</script>
			<%--<div class="span8">
				<input type="text" class="edit" id="create_${info.id}" style="height:30px;" />
			</div>
		--%></div>
		<hr />
		${card.id}
		<div>
			<div class="span6">
				<c:choose>
					<c:when test="${card.imgFront!=null}">
						<img src="${card.imgFront}" />
						<a href="#" onclick="deleteImg(${card.id},'imgFront'); return false;"> <i
							class="icon-remove-circle" style="width: 20px;"></i> </a>
					</c:when>
					<c:otherwise>
						<p>正面图</p>
						<input id="imgFrontUpload" class="img_upload" type="file" />
						<div id="imgFront"></div>
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="span6">
				<c:choose>
					<c:when test="${card.imgBack!=null}">
						<img src="${card.imgBack}" />
						<a href="#" onclick="deleteImg(${card.id},'imgBack'); return false;"> <i
							class="icon-remove-circle" style="width: 20px;"></i> </a>
					</c:when>
					<c:otherwise>
						<p>背面图</p>
						<input id="imgBackUpload" class="img_upload" type="file" />
						<div id="imgBack"></div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	<script>
$(document).ready(function() {
	//$('.edit').editable();
		$('.edit').editable(
				'${pageContext.request.contextPath }/servlet/InfoServlet', {});
	});
</script>

		<script type="text/javascript">

function _ajax_request(url, data, callback, type, method) {
	if (jQuery.isFunction(data)) {
		callback = data;
		data = {};
	}
	return jQuery.ajax( {
		type : method,
		url : url,
		data : data,
		success : callback,
		dataType : type
	});
}

jQuery.extend( {
	put : function(url, data, callback, type) {
		return _ajax_request(url, data, callback, type, 'PUT');
	},
	delete_ : function(url, data, callback, type) {
		return _ajax_request(url, data, callback, type, 'DELETE');
	}
});

function deleteRow(info_id) {
	$.post('InfoServlet', {
		id : info_id,
		_method : "delete"
	}, function() {
		$('#info' + info_id).remove()
	});
};

function deleteImg(card_id,img) {
	$.post('CardServlet', {
		id : card_id,
		_method : "delete",
		img : img
	}, function() {
		location.reload()
	});
};

</script>
<%--<script>
$(document).ready(function() {
	$('.combobox').combobox();
});
</script>
	--%>
	<script>
 $('#imgFrontUpload').change(function(evt){
$('#imgFrontUpload').attr("disabled",true);   
 	var f = evt.target.files[0];
 	var reader = new FileReader();

     // Closure to capture the file information.
     reader.onload = (function(theFile) {
       return function(e) {
         // Render thumbnail.
         console.log(e.target.result);
         $.post('${pageContext.request.contextPath}/servlet/CardServlet', {field: 'imgFront', id: ${card.id}, img: e.target.result}, function(){location.reload()});
         document.getElementById('imgFront').innerHTML =  ['<img class="thumb" src="', e.target.result,
                           '" title="', escape(theFile.name), '"/>'].join('');
       };
     })(f);

     // Read in the image file as a data URL.
     reader.readAsDataURL(f);
 })
 
 
 $('#imgBackUpload').change(function(evt){
$('#imgBackUpload').attr("disabled",true);   
 	var f = evt.target.files[0];
 	var reader = new FileReader();

     // Closure to capture the file information.
     reader.onload = (function(theFile) {
       return function(e) {
         // Render thumbnail.
         console.log(e.target.result);
         $.post('${pageContext.request.contextPath}/servlet/CardServlet', {field: 'imgBack', id: ${card.id}, img: e.target.result}, function(){location.reload()});
         var span = document.createElement('span');
         document.getElementById('imgBack').innerHTML =  ['<img class="thumb" src="', e.target.result,
                           '" title="', escape(theFile.name), '"/>'].join('');
       };
     })(f);

     // Read in the image file as a data URL.
     reader.readAsDataURL(f);
 })
 
 </script>
	</body>
	
</html>
