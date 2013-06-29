<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="css/bootstrap.css" rel="stylesheet">
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
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="assets/ico/favicon.png">
								   
								   
								   
								   <meta http-equiv="Content-type" content="text/html; charset=utf-8">

	<link href="captcha/captcha.css" rel="stylesheet" type="text/css" />
	<style type="text/css" media="screen">
		body { background-color: silver; }
	</style>
		
	
	
  </head>

  <body>

    <div class="container">

      <form id="loginform" action="${pageContext.request.contextPath }/LoginServlet" method="post" class="form-signin">
      <input type="hidden" name="token" value="${token}" />
        <h2 class="form-signin-heading">请登录・・・・</h2>
        <h3>${failed}</h3>
        <input name="name" type="text" class="input-block-level" placeholder="用户名">
        <input name="password" type="password" class="input-block-level" placeholder="密码">
		<div class="ajax-fc-container">You must enable javascript to see captcha here!</div>
		
        <label class="checkbox"><br>
          <input type="checkbox" value="remember-me"> 记住我<br>
        </label>
        <button class="btn btn-large btn-primary" type="submit">登 录</button>
      </form>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="captcha/jquery.captcha.js"></script>
	<script type="text/javascript" charset="utf-8">
		$(function() {
			$(".ajax-fc-container").captcha({
				borderColor: "silver",
				text: "验证码：<br />请把 <span>heart</span> 拖拽到圆圈内."
			});
		});
	</script>
  </body>
</html>
