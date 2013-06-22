<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
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
			<button class="btn btn-primary" data-dismiss="modal"
				aria-hidden="true">确定</button>
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
						<li><a href="#import" role="button" class="btn"
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
						<li><a tabindex="-1" href="departview.jsp">公司部门视图</a></li>
						<li><a tabindex="-1" href="#">还原通讯录</a></li>
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
		</div>
	</div>


	<link rel="stylesheet"
		href="http://blueimp.github.io/Bootstrap-Image-Gallery/css/bootstrap-image-gallery.min.css">
	<link rel="stylesheet" href="css/jquery.fileupload-ui.css">
	<div id="import" class="modal hide fade">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h3>名片导入</h3>
		</div>
		<div class="modal-body">
			<form id="fileupload" action="//jquery-file-upload.appspot.com/"
				method="POST" enctype="multipart/form-data">
				<!-- Redirect browsers with JavaScript disabled to the origin page -->
				<noscript>
					<input type="hidden" name="redirect"
						value="http://blueimp.github.io/jQuery-File-Upload/">
				</noscript>
				<!-- The fileupload-buttonbar contains buttons to add/delete files and start/cancel the upload -->
				<div class="row fileupload-buttonbar">
					<div class="span7">
						<!-- The fileinput-button span is used to style the file input field as button -->
						<span class="btn btn-success fileinput-button"> <i
							class="icon-plus icon-white"></i> <span>添加文件</span> <input
							type="file" name="files[]" multiple>
						</span>
						<button type="button" class="btn btn-danger delete">
							<i class="icon-trash icon-white"></i> <span>删除文件</span>
						</button>
						<input type="checkbox" class="toggle">
						<!-- The loading indicator is shown during file processing -->
						<span class="fileupload-loading"></span>
					</div>
					<!-- The global progress information -->
					<div class="span5 fileupload-progress fade">
						<!-- The global progress bar -->
						<div class="progress progress-success progress-striped active"
							role="progressbar" aria-valuemin="0" aria-valuemax="100">
							<div class="bar" style="width:0%;"></div>
						</div>
						<!-- The extended global progress information -->
						<div class="progress-extended">&nbsp;</div>
					</div>
				</div>
				<!-- The table listing the files available for upload/download -->
				<table role="presentation" class="table table-striped">
					<tbody class="files" data-toggle="modal-gallery"
						data-target="#modal-gallery"></tbody>
				</table>
			</form>
		</div>
		<div class="modal-footer">
			<button type="reset" class="btn btn-warning cancel">
				<i class="icon-ban-circle icon-white"></i> <span>取消</span>
			</button>
			<button type="submit" class="btn btn-primary start">
				<i class="icon-upload icon-white"></i> <span>确定</span>
			</button>




			<a href="#" class="btn">Close</a> <a href="#" class="btn btn-primary">Save
				changes</a>
		</div>
	</div>


	<!-- modal-gallery is the modal dialog used for the image gallery -->
	<div id="modal-gallery" class="modal modal-gallery hide fade"
		data-filter=":odd" tabindex="-1">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">&times;</a>
			<h3 class="modal-title"></h3>
		</div>
		<div class="modal-body">
			<div class="modal-image"></div>
		</div>
		<div class="modal-footer">
			<a class="btn modal-download" target="_blank"> <i
				class="icon-download"></i> <span>Download</span>
			</a> <a class="btn btn-success modal-play modal-slideshow"
				data-slideshow="5000"> <i class="icon-play icon-white"></i> <span>Slideshow</span>
			</a> <a class="btn btn-info modal-prev"> <i
				class="icon-arrow-left icon-white"></i> <span>Previous</span>
			</a> <a class="btn btn-primary modal-next"> <span>Next</span> <i
				class="icon-arrow-right icon-white"></i>
			</a>
		</div>
	</div>
	<!-- The template to display files available for upload -->
	<script id="template-upload" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-upload fade">
        <td>
            <span class="preview"></span>
        </td>
        <td>
            <p class="name">{%=file.name%}</p>
            {% if (file.error) { %}
                <div><span class="label label-important">Error</span> {%=file.error%}</div>
            {% } %}
        </td>
        <td>
            <p class="size">{%=o.formatFileSize(file.size)%}</p>
            {% if (!o.files.error) { %}
                <div class="progress progress-success progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="bar" style="width:0%;"></div></div>
            {% } %}
        </td>
        <td>
            {% if (!o.files.error && !i && !o.options.autoUpload) { %}
                <button class="btn btn-primary start">
                    <i class="icon-upload icon-white"></i>
                    <span>Start</span>
                </button>
            {% } %}
            {% if (!i) { %}
                <button class="btn btn-warning cancel">
                    <i class="icon-ban-circle icon-white"></i>
                    <span>Cancel</span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>
	<!-- The template to display files available for download -->
	<script id="template-download" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-download fade">
        <td>
            <span class="preview">
                {% if (file.thumbnail_url) { %}
                    <a href="{%=file.url%}" title="{%=file.name%}" data-gallery="gallery" download="{%=file.name%}"><img src="{%=file.thumbnail_url%}"></a>
                {% } %}
            </span>
        </td>
        <td>
            <p class="name">
                <a href="{%=file.url%}" title="{%=file.name%}" data-gallery="{%=file.thumbnail_url&&'gallery'%}" download="{%=file.name%}">{%=file.name%}</a>
            </p>
            {% if (file.error) { %}
                <div><span class="label label-important">Error</span> {%=file.error%}</div>
            {% } %}
        </td>
        <td>
            <span class="size">{%=o.formatFileSize(file.size)%}</span>
        </td>
        <td>
            <button class="btn btn-danger delete" data-type="{%=file.delete_type%}" data-url="{%=file.delete_url%}"{% if (file.delete_with_credentials) { %} data-xhr-fields='{"withCredentials":true}'{% } %}>
                <i class="icon-trash icon-white"></i>
                <span>Delete</span>
            </button>
            <input type="checkbox" name="delete" value="1" class="toggle">
        </td>
    </tr>
{% } %}
</script>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
	<script src="js/vendor/jquery.ui.widget.js"></script>
	<!-- The Templates plugin is included to render the upload/download listings -->
	<script src="http://blueimp.github.io/JavaScript-Templates/tmpl.min.js"></script>
	<!-- The Load Image plugin is included for the preview images and image resizing functionality -->
	<script
		src="http://blueimp.github.io/JavaScript-Load-Image/load-image.min.js"></script>
	<!-- The Canvas to Blob plugin is included for image resizing functionality -->
	<script
		src="http://blueimp.github.io/JavaScript-Canvas-to-Blob/canvas-to-blob.min.js"></script>
	<!-- Bootstrap JS and Bootstrap Image Gallery are not required, but included for the demo -->
	<script src="http://blueimp.github.io/cdn/js/bootstrap.min.js"></script>
	<script
		src="http://blueimp.github.io/Bootstrap-Image-Gallery/js/bootstrap-image-gallery.min.js"></script>
	<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
	<script src="js/jquery.iframe-transport.js"></script>
	<!-- The basic File Upload plugin -->
	<script src="js/jquery.fileupload.js"></script>
	<!-- The File Upload processing plugin -->
	<script src="js/jquery.fileupload-process.js"></script>
	<!-- The File Upload image preview & resize plugin -->
	<script src="js/jquery.fileupload-image.js"></script>
	<!-- The File Upload audio preview plugin -->
	<script src="js/jquery.fileupload-audio.js"></script>
	<!-- The File Upload video preview plugin -->
	<script src="js/jquery.fileupload-video.js"></script>
	<!-- The File Upload validation plugin -->
	<script src="js/jquery.fileupload-validate.js"></script>
	<!-- The File Upload user interface plugin -->
	<script src="js/jquery.fileupload-ui.js"></script>
	<!-- The main application script -->
	<script src="js/main.js"></script>
	<!-- The XDomainRequest Transport is included for cross-domain file deletion for IE8+ -->
	<!--[if gte IE 8]><script src="js/cors/jquery.xdr-transport.js"></script><![endif]-->



</body>
</html>
