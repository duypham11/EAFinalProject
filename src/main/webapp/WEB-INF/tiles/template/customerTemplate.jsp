<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title" /></title>

<link
	href="<spring:url value='/bootstrap/vendor/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet">
<!-- MetisMenu CSS -->
<link
	href="<spring:url value='/bootstrap/vendor/metisMenu/metisMenu.min.css'/>"
	rel="stylesheet">
<!-- Custom CSS -->
<link href="<spring:url value='/bootstrap/dist/css/sb-admin-2.css'/>"
	rel="stylesheet">
<!-- Custom Fonts -->
<link
	href="<spring:url value='/bootstrap/front/vendor/font-awesome/css/font-awesome.min.css'/>"
	rel="stylesheet" type="text/css">
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script
	src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

<!-- jQuery -->
<script
	src="<spring:url value='/bootstrap/vendor/jquery/jquery.min.js'/>"></script>
<!-- Bootstrap Core JavaScript -->
<script
	src="<spring:url value='/bootstrap/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
<!-- Metis Menu Plugin JavaScript -->
<script
	src="<spring:url value='/bootstrap/vendor/metisMenu/metisMenu.min.js'/>"></script>
<!-- Custom Theme JavaScript -->
<script src="<spring:url value='/bootstrap/dist/js/sb-admin-2.js'/>"></script>

</head>

<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<spring:url value='/' />">Welcome
					to FlashDelivery Tracking System</a>
			</div>
			<!-- /.navbar-header -->
			<!-- /.navbar-top-links -->
			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<form action="trackParcel" method="get">
								<div class="input-group custom-search-form">

									<input type="text" class="form-control"
										placeholder="Track No i.e 123 xxx xxx" name="tracknumber">
									<span class="input-group-btn">
										<button class="btn btn-default" type="submit">
<!--  											<button class="btn btn-primary" onclick="location.href='/FlashDelivery/trackParcel/87659'">-->
											<i class="fa fa-search"></i>
										</button>
									</span>
								</div>
							</form> <!-- /input-group -->
						</li>
						<li><a href="<spring:url value='/login' />"><i
								class="fa fa-sign-in fa-fw"></i> Login</a></li>
						<li><a href="<spring:url value='/storeSignup' />"><i
								class="fa fa-users fa-fw"></i> Become our Partner</a></li>
						<li><a href="<spring:url value='/rider/riderSignup' />"><i
								class="fa fa-car  fa-fw"></i> Become our Rider</a></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						<tiles:insertAttribute name="title" />
					</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<tiles:insertAttribute name="body" />
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

</body>
</html>
