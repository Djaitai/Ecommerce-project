<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Product Page Desig</title>
<link rel="stylesheet" type="text/css" href="../resources/test.css">
<link rZZzzel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style type="text/css">
	#images
	{
		width: 300px;
		height: 300px;
		border: none;
	}
	#price
	{
		color: red;
	}
	#detail
	{
		color: #000099;
	}
</style>
</head>
<body>

	<%@ include file="new_product_menu.jsp"%>
	<div class=container>
		<div class="container">
			<div class="row mar-bot-30">
				<div class="col-md-12">
					<div class="product-sec-tittle">
						<h2 style="text-align: center;" class="section-heading">
							<span>Feature</span> Product
						</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<c:if test="${empty productlist}">
					<center>
						<h3 style="color: red;">No Products</h3>
					</center>
				</c:if>
				<c:forEach items="${productlist}" var="p">

					<div class="featured-product">
						<div class="col-md-4">

							<div class="product-box hover-circle text-center" style="box-shadow: none; height: 460px;">

								<div class="product-item">
									<figure>
										<img id="images" src="${pageContext.request.contextPath}/resources/image/${p.image_name}"
											alt="product" />
									</figure>
									<p class="product-drisc">${p.product_description}</p>

									<h4 id="price" class="product-price">Price :${p.price}</h4>
									<a id="detail" href="${pageContext.request.contextPath}/productDescription/${p.product_Id}"
										class="btn btn-default buy-now">View details</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<br><br>
	
	<%@ include file="footer.jsp"%>
</body>
</html>