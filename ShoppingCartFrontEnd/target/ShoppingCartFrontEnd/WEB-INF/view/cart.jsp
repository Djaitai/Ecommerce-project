<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>cart</title>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link
href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
rel="stylesheet">
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	
	<%@ include file="loginHeader.jsp" %>
	<%@ include file="new_product_menu.jsp" %>

	<div class="container">

		<h4>
			<img alt="no image" src="${pageContext.request.contextPath}/resources/block-cart-icon.png">
			&nbsp; YOUR CART
		</h4>
		<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Image</th>
					<th>Total</th>
					<th>Action</th>
				</tr>
			</thead>


			<tbody>
				<c:if test="${empty cartInfo}">
					<tr>
						<td colspan="9" align="center">No Record Exists</td>
					</tr>
				</c:if>
				<c:forEach var="cart" varStatus="st" items="${cartInfo}">
					<tr>

						<td><c:out value="${cart.product_name}"></c:out></td>
						<td><c:out value="${cart.quantity}"></c:out></td>
						<td><c:out value="${cart.price}"></c:out></td>
						<td><img src="${pageContext.request.contextPath}/resources/image/<c:out value='${cart.cart_image}'></c:out>"
							height="50px" width="50px" /></td>

						<td><c:out value="${cart.quantity * cart.price}"></c:out></td>
						<td><a
							href="${pageContext.request.contextPath}/deletePCart/${cart.cart_Id}"
							class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></a></td>

					</tr>
				</c:forEach>


			</tbody>
			<tfoot>
				<tr>
					<td><a href="${pageContext.request.contextPath}/allProductList/" class="btn btn-warning"><i class="fa fa-angle-left"></i>
							Continue Shopping</a></td>
					<c:if test="${not empty cartInfo}">
						<td><a href="${pageContext.request.contextPath}/checkout" class="btn btn-success btn-block">Checkout <i
								class="fa fa-angle-right"></i>
						</a></td>
					</c:if>
				</tr>
			</tfoot>
		</table>
		<jsp:include page="footer.jsp"></jsp:include>
		<div>
			<br />
			<br />
			<br />
		</div>
	</div>

</body>
</html>