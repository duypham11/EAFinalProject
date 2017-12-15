<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:insertAttribute name="title" /></title>
	<link href="<spring:url value='/bootstrap/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
	<link href="<spring:url value='/bootstrap/vendor/metisMenu/metisMenu.min.css'/>" rel="stylesheet">
	<link href="<spring:url value='/bootstrap/dist/css/sb-admin-2.css'/>" rel="stylesheet">
	<link href="<spring:url value='/bootstrap/front/vendor/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css">
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<script src="<spring:url value='/bootstrap/vendor/jquery/jquery.min.js'/>"></script>
	<script src="<spring:url value='/bootstrap/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
	<script src="<spring:url value='/bootstrap/vendor/metisMenu/metisMenu.min.js'/>"></script>
	<script src="<spring:url value='/bootstrap/dist/js/sb-admin-2.js'/>"></script>
</head>
<body>
	<tiles:insertAttribute name="body" />
</body>
</html>