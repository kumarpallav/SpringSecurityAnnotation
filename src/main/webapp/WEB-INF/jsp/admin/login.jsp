<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Waverin Innovatives</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
	<!--script src="js/less-1.3.3.min.js"></script-->
	<!--append #!watch to the browser URL, then refresh the page. -->
	
	<link href="assets/css/bootstrap.min.css" rel="stylesheet">
	<link href="assets/css/style.css" rel="stylesheet">
	<link href="assets/css/main.css" rel="stylesheet">
	<link href="assets/css/font-awesome.min.css" rel="stylesheet">
	
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="img/favicon.png">
  
	<script type="text/javascript" src="assets/js/jquery.min.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/js/scripts.js"></script>
	
</head>

<body>
<div class="container login  ">
	<div class="row clearfix">
		<div class="col-md-12 column " align="center">
			<h1 ><i class="glyphicon glyphicon-user blue"></i></h1>
		
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form class="form-horizontal" action="login/authenticate" method="POST">
				<div class="form-group">
					 <label for="username" class="col-sm-2 control-label">Email </label>
					<div class="col-sm-10">
						<input type="text" name="username" class="form-control" id="username">
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input type="password" name="password" class="form-control" id="inputPassword3">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							 <label><input type="checkbox"> Remember me</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-success">Sign in</button>
						 <button type="reset" class="btn btn-default">Clear</button>
						 
					</div>
				</div>
			</form>
			<div class="row clearfix alerts">
				<div class="col-md-12 column">
					<div class="alert alert-success alert-dismissable">
						 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
						<h4>
							Alert!
						</h4> <strong>Warning!</strong> ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-12 column " align="center">
					<h5>
						Sign in using
					</h5>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column" align="center">
					<h4><i class="fa fa-facebook blue "></i>
					<i class="fa fa-twitter blue "></i>
					<i class="fa fa-google-plus red "></i>
					</h4>
					
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
