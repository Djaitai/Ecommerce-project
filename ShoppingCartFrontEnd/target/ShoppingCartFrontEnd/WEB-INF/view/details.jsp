<%@ taglib prefix="j" uri="http://java.sun.com/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Detail</title>
</head>
<body>
	<script>
		$(document).ready(function() {
			//-- Click on detail
			$("ul.menu-items > li").on("click", function() {
				$("ul.menu-items > li").removeClass("active");
				$(this).addClass("active");
			})
			$(".attr,.attr2").on("click", function() {
				var clase = $(this).attr("class");
				$("." + clase).removeClass("active");
				$(this).addClass("active");
			})
			//-- Click on QUANTITY
			$(".btn-minus").on("click", function() {
				var now = $(".section > div > input").val();
				if ($.isNumeric(now)) {
					if (parseInt(now) - 1 > 0) {
						now--;
					}
					$(".section > div > input").val(now);
				} else {
					$(".section > div > input").val("1");
				}
			})
			$(".btn-plus").on("click", function() {
				var now = $(".section > div > input").val();
				if ($.isNumeric(now)) {
					$(".section > div > input").val(parseInt(now) + 1);
				} else {
					$(".section > div > input").val("1");
				}
			})
		})
	</script>
	<div class="container">
		
		<%@ include file="loginHeader.jsp" %>
		<%@ include file="new_product_menu.jsp" %>
	
		<div class="row">
			<div class="col-xs-4 item-photo">
				<img style="max-width: 100%; margin-top: 30px;"
					src="${pageContext.request.contextPath}/resources/image/${product.image_name}" />
			</div>
			<div class="col-xs-5" style="border: 0px solid gray">
				<!-- Datos del vendedor y titulo del producto -->
				<h3>${product.product_name}</h3>

				<h4>Price - ${product.price} Rs.</h4>
				<h5>Supplier - ${product.supplier.supplier_name}</h5>



				<div class="section" style="padding-bottom: 20px;">

					<form action="${pageContext.request.contextPath}/addToCart"
						method="post">
						<input type="hidden" value="${product.product_Id}" name="product_Id" /> <input
							type="hidden" value="${product.price}" name="price" /> <input
							type="hidden" value="${product.product_name}" name="product_name" /> <input
							type="hidden" value="${product.image_name}" name="image_name" /> <input
							type="number" class="form-control" name="quant" required /><br>
						<input class="btn btn-primary btn-lg" type="submit"
							value="add to cart">
					</form>
					<h6>
						<span class="glyphicon glyphicon-heart-empty"
							style="cursor: pointer;"></span> Add Product
					</h6>
				</div>
			</div>

			<div class="col-xs-9">
				<ul class="menu-items">
					<li class="active">Details of product</li>

				</ul>
				<div style="width: 100%; border-top: 1px solid black">
					<p style="padding: 15px;">
					<h4>${product.product_description}</h4>
					</p>
					<small>
						
					</small> 
				</div>
			</div>
		</div>
	</div>
	<br>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>