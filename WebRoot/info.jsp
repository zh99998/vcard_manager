<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>card_manager.html</title>

		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="this is my page">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">

		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<link rel="stylesheet" type="text/css"
			href="css/bootstrap-responsive.min.css">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css"
			href="css/bootstrap-combobox.css">

		<script src="js/jquery-1.8.3.min.js">
</script>
		<script src="js/bootstrap.min.js">
</script>
		<script src="js/jquery.editable.min.js">
</script>
		<script src="js/bootstrap-combobox.js">
</script>
<style>
.row{border-bottom: 1px solid lightgray}
</style>
	</head>

	<body>
		<!-- header -->
		<jsp:include page="public/head.jsp"></jsp:include>


		<!-- body -->
		
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
					<li class="divider"></li>

					<c:forEach var="circle" items="${circleMap}">
						<li>
							<c:choose>
								<c:when test="${circle.value}">
									<input class="circlecheckbox" data-circleId="${circle.key.id}"
										type="checkbox" style="margin: 3px 10px;" checked />
								</c:when>
								<c:otherwise>
									<input class="circlecheckbox" data-circleId="${circle.key.id}"
										type="checkbox" style="margin: 3px 10px;" />
								</c:otherwise>
							</c:choose>
							${circle.key.name}
						</li>

					</c:forEach>

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
								<span>邮箱</span>
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
							<c:when test="$(info.property=='ORG')">
								<span>公司</span>
							</c:when>
							<c:when test="$(info.property=='NOTE')">
								<span>备注</span>
							</c:when>
							<c:when test="$(info.property=='ADR')">
								<span>地址</span>
							</c:when>
							<c:when test="$(info.property=='TITLE')">
								<span>职位</span>
							</c:when>
							<c:when test="$(info.property=='URL')">
								<span>网址</span>
							</c:when>
							<c:when test="$(info.property=='X-MSN')">
								<span>MSN</span>
							</c:when>
							<c:when test="$(info.property=='X-TWITTER')">
								<span>TWITTER</span>
							</c:when>
							<c:when test="${info.type!=null}">
								<span>${info.type}</span>
							</c:when>
							<c:otherwise>

								<span>${info.property}</span>
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
							<c:when test="${info.property == 'EMAIL'}">
								<div style="width: 200px; height: 20px; float: left;"
									class="edit" id="infodiv_${info.id}">
									${info.value}
								</div>
								<a href="mailto:${info.value}" <i class="icon-envelope"></i></a>
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
					<option value="ADD">
						添加
					</option>
					<option value="FN">
						姓名
					</option>
					<option value="EMAIL">
						邮箱
					</option>
					<option value="TEL">
						电话
					</option>
					<option value="ORG">
						公司
					</option>
					<option value="NOTE">
						备注
					</option>
					<option value="ADR">
						地址
					</option>
					<option value="NOTE">
						备注
					</option>
					<option value="TITLE">
						职位
					</option>
					<option value="URL">
						网址
					</option>
					<option value="X-MSN">
						MSN
					</option>
					<option value="X-TWITTER">
						TWITTER
					</option>
					<option value="X-CUSTOM">
						自定义
					</option>
				</select>
			</div>
			<script>
$('.combobox').change(function(ev) {
	if (this.value == 'X-CUSTOM') {
		var property = prompt('请输入字段名');
		$('<div />', {
			'class' : 'row'
		}).append( [ $('<div />', {
			'class' : 'span3'
		}).append($('<span/>', {
			'text' : property
		})), $('<div />', {
			'class' : 'span7'
		}).append($('<input/>', {
			'id' : 'create_' + property,
			'type' : 'text'
		})), $('<div />', {
			'class' : 'span2'
		}),

		]).appendTo('#infoes')
		$('#create_' + property).change(function() {
			$.post('InfoServlet?card_id=${card.id}', {
				id : this.id,
				value : this.value
			}, function() {
				location.reload();
			})
		})

		this.value = 'ADD';

	} else {
		switch (this.value) {
		case 'FN':
			var text = '姓名';
			break;
		case 'TEL':
			var text = '电话';
			break;
		case 'EMAIL':
			var text = '邮箱';
			break;
		case 'ORG':
			var text = '公司';
			break;
		case 'ADR':
			var text = '地址';
			break;
		case 'NOTE':
			var text = '备注';
			break
		case 'TITLE':
			var text = '职位';
			break;
		case 'URL':
			var text = '网址';
			break;
		case 'X-MSN':
			var text = 'MSN';
			break;
		case 'X-TWITTER':
			var text = 'TWITTER';
			break;
		}
		;
		$('<div />', {
			'class' : 'row'
		}).append( [ $('<div />', {
			'class' : 'span3'
		}).append($('<span/>', {
			'text' : text
		})), $('<div />', {
			'class' : 'span7'
		}).append($('<input/>', {
			'id' : 'create_' + this.value,
			'type' : this.value == 'EMAIL' ? 'email' : 'text'
		})), $('<div />', {
			'class' : 'span2'
		}),

		]).appendTo('#infoes')
		$('#create_' + this.value).change(function() {
			$.post('InfoServlet?card_id=${card.id}', {
				id : this.id,
				value : this.value
			}, function() {
				location.reload();
			})
		})

		this.value = 'ADD';
	}
})
</script>
			<%--<div class="span8">
				<input type="text" class="edit" id="create_${info.id}" style="height:30px;" />
			</div>
		--%>
		</div>
		<hr />
		${card.id}
		<div>
			<div class="span6">
				<c:choose>
					<c:when test="${card.imgFront!=null}">
						<img src="${card.imgFront}" />
						<a href="#"
							onclick="deleteImg(${card.id},'imgFront'); return false;"> <i
							class="icon-remove-circle" style="width: 20px;"></i> </a>
					</c:when>
					<c:otherwise>
						<p>
							正面图
						</p>
						<input id="imgFrontUpload" class="img_upload" type="file" />
						<div id="imgFront"></div>
					</c:otherwise>
				</c:choose>
			</div>

			<div class="span6">
				<c:choose>
					<c:when test="${card.imgBack!=null}">
						<img src="${card.imgBack}" />
						<a href="#"
							onclick="deleteImg(${card.id},'imgBack'); return false;"> <i
							class="icon-remove-circle" style="width: 20px;"></i> </a>
					</c:when>
					<c:otherwise>
						<p>
							背面图
						</p>
						<input id="imgBackUpload" class="img_upload" type="file" />
						<div id="imgBack"></div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<script>
$(document).ready(function() {
	//$('.edit').editable();
		$('.edit').editable('${pageContext.request.contextPath }/InfoServlet',
				{});
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

function deleteImg(card_id, img) {
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
         $.post('${pageContext.request.contextPath}/CardServlet', {field: 'imgFront', id: ${card.id}, img: e.target.result}, function(){location.reload()});
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
         $.post('${pageContext.request.contextPath}/CardServlet', {field: 'imgBack', id: ${card.id}, img: e.target.result}, function(){location.reload()});
         var span = document.createElement('span');
         document.getElementById('imgBack').innerHTML =  ['<img class="thumb" src="', e.target.result,
                           '" title="', escape(theFile.name), '"/>'].join('');
       };
     })(f);

     // Read in the image file as a data URL.
     reader.readAsDataURL(f);
 })
 
 </script>
		<script>

$('.circlecheckbox').change(function(e){
	 $.post('CardCircleServlet', {checked: e.target.checked, circle_id: $(e.target).attr('data-circleId'), card_id: ${card.id}})
 })
 </script>
	</body>

</html>
