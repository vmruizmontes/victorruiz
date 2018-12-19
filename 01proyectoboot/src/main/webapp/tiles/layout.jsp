<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="app.name" /></title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/sticky-footer-navbar.css" rel="stylesheet">
<link href="../css/signin.css" rel="stylesheet">
<link href="../css/starter-template.css" rel="stylesheet">

<!-- jQuery and vendor libraries -->
<script src="../js/jquery-3.2.1.js"></script>
<script src="../js/vendor/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

<!-- Lo mio -->
<link href="https://fonts.googleapis.com/css?family=Lobster"
	rel="stylesheet">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/nuevo.css">
</head>
<body>
	<tiles:insertAttribute name="header" />
	<main role="main" class="container">
	<div class="text-center">
		<tiles:insertAttribute name="body" />
	</div>
	</main>
	<!-- /.container -->
	<tiles:insertAttribute name="footer" />

</body>
</html>