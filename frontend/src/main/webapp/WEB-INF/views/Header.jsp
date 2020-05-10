<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1 height=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
body{
background-image: url("http://www.geckomassage.com/wp-content/uploads/2015/01/plain-light-color-for-guest-background.jpg");
background-size:100%;
}
</style>
<body>
<div class="container">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Online Food</a>
			</div>
			<c:if test="${!sessionScope.loggedIn }">
			<ul class="nav navbar-nav">
				<li><a href="#"> Home</a>
				<li><a href="aboutus"> About Us</a></li>
				<li><a href="contactus"> Contact Us</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="register"> Register</a></li>
				<li><a href="login"> Login</a></li>
			</ul>
			</c:if>
			<c:if test="${sessionScope.loggedIn }">
				<c:if test="${sessionScope.role=='ROLE_ADMIN' }">
					<ul class="nav navbar-nav">
						<li><a href="#"> Home</a>
						<li><a href="category">Manage Category</a></li>
						<li><a href="supplier">Manage Supplier</a></li>
						<li><a href="product">Manage Product</a></li>
					</ul>
				</c:if>
				<c:if test="${sessionScope.role=='ROLE_USER' }">
					<ul class="nav navbar-nav">
						<li><a href="#"> Home</a>
						<li><a href="<c:url value="/productCatalog"/>"> Product Catalog</a></li>
						<li><a href="<c:url value="/cart"/>"> Cart</li>
						
					</ul>
				</c:if>
			</c:if>
			
			<div class="nav navbar-nav navbar-right">
				<c:if test="${sessionScope.loggedIn }">
					<font color="grey" >${sessionScope.username }</font><br>
					<a href="perform_logout" class="glyphicon glyphicon-log-out"> Logout</a>
				</c:if>
			</div>
</div>
</nav>
</div>
</body>