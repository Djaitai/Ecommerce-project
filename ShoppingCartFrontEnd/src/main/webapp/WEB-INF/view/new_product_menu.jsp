<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>menu</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style type="text/css">
@import url(http://fonts.googleapis.com/css?family=Open+Sans:400,700);

body {
	font-family: 'Open Sans', 'sans-serif';
}

.mega-dropdown {
	position: static !important;
}

.mega-dropdown-menu {
	padding: 20px 0px;
	width: 100%;
	box-shadow: none;
	-webkit-box-shadow: none;
}

.mega-dropdown-menu>li>ul {
	padding: 0;
	margin: 0;
}

.mega-dropdown-menu>li>ul>li {
	list-style: none;
}

.mega-dropdown-menu>li>ul>li>a {
	display: block;
	color: #222;
	padding: 3px 5px;
}

.mega-dropdown-menu>li ul>li>a:hover, .mega-dropdown-menu>li ul>li>a:focus
	{
	text-decoration: none;
}

.mega-dropdown-menu .dropdown-header {
	font-size: 18px;
	color: #ff3546;
	padding: 5px 60px 5px 5px;
	line-height: 30px;
}

.carousel-control {
	width: 30px;
	height: 30px;
	top: -35px;
}

.left.carousel-control {
	right: 30px;
	left: inherit;
}

.carousel-control .glyphicon-chevron-left, .carousel-control .glyphicon-chevron-right
	{
	font-size: 12px;
	background-color: #fff;
	line-height: 30px;
	text-shadow: none;
	color: #333;
	border: 1px solid #ddd;
}

#hoverColor a:hover {
	color: red;
}
</style>

<script type="text/javascript">
	$(document).ready(
			function() {
				$(".dropdown").hover(
						function() {
							$('.dropdown-menu', this).not('.in .dropdown-menu')
									.stop(true, true).slideDown("400");
							$(this).toggleClass('open');
						},
						function() {
							$('.dropdown-menu', this).not('.in .dropdown-menu')
									.stop(true, true).slideUp("400");
							$(this).toggleClass('open');
						});
			});
</script>
</head>
<body>

	<div style="background-color: #ffcccc;">
		<!-- <div class="container"> -->
		<nav class="navbar">
		<div class="navbar-header">
			<button class="navbar-toggle" type="button" data-toggle="collapse"
				data-target=".js-navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a style="color: #000000;"  class="navbar-brand"
				href="${pageContext.request.contextPath}/home">My Store</a>
		</div>
		<div class="collapse navbar-collapse js-navbar-collapse">
			<ul class="nav navbar-nav">
				<c:forEach items="${categories}" var="category">

					<li class="dropdown mega-dropdown"><a style="color: #000000;"
						href="${pageContext.request.contextPath}/productCustList/${category.category_Id}"
						class="dropdown-toggle">${category.category_name}<span
							class="caret"></span></a>
						<ul class="dropdown-menu mega-dropdown-menu">
							<li class="col-sm-3">
								<ul>
									<c:forEach items="${category.products}" var="product">
										<li><a
											href="${pageContext.request.contextPath}/productDescription/${product.product_Id}">${product.product_name}</a></li>
									</c:forEach>
								</ul>
							</li>
						</ul> <!-- <li><a href="#">Store locator</a></li> --></li>
				</c:forEach>
			</ul>

			<ul class="nav navbar-nav navbar-right">

				<c:if test="${pageContext.request.userPrincipal.name!=null}">
					<li class="dropdown"><h4 style="color: #ffffff">${pageContext.request.userPrincipal.name}</h4></li>
				</c:if>
				<li class="dropdown"><a style="color: #000000;" href="#"
					class="dropdown-toggle" data-toggle="dropdown" role="button"
					aria-expanded="false">My account <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<c:if test="${pageContext.request.userPrincipal.name== null}">
							<li class="active"><a href="login"><span
									class="glyphicon glyphicon-log-in"></span> Login</a></li>
						</c:if>
						<%-- <li><a href="${pageContext.request.contextPath}/login">Login</a></li> --%>


						<li><a href="register"><span
								class="glyphicon glyphicon-user"></span> Sign Up</a></li>


						<c:if test="${pageContext.request.userPrincipal.name!= null}">
							<li><a href="${pageContext.request.contextPath}/logout"><span
									class="glyphicon glyphicon-log-out"></span> Logout</a></li>
						</c:if>
						<%-- <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li> --%>
						<!-- 						<li class="divider"></li> -->
						<!-- <li><a href="#">Separated link</a></li> -->
					</ul></li>

				<c:if test="${pageContext.request.userPrincipal.name!= null}">
					<li><a href="${pageContext.request.contextPath}/showCart"><span
							class="glyphicon glyphicon-shopping-cart"></span> MyCart(${size})</a></li>
				</c:if>
				<%-- <li>
					 
				<a href="${pageContext.request.contextPath}/showCart">My
						cart (0) items</a> 
				</li> --%>
				<form class="navbar-form navbar-left" action="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search"
							name="searchString">
					</div>
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</form>
			</ul>
		</div>

		<!-- /.nav-collapse --> </nav>
	</div>
	<hr color="blue" width="100">
	${category.products}
</body>
</html>