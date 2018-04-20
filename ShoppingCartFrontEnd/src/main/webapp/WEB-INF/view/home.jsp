<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home page</title>
</head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home page</title>
</head>
<body>
	<center>
		<img src="resources/image/homeImage.png" style="width: 900px; height: 200px;">		
		<!-- <h2>Welcome to shopping cart</h2> -->
		${logoutMessage}
	</center>

	<br>

	<%-- <jsp:include page="loginHeader.jsp"></jsp:include> --%>

	<hr color="blue" size="5">
 
	<jsp:include page="new_product_menu.jsp"></jsp:include>
	
	<%@ include file="adminLink.jsp" %>

	<c:if test="${isUserSelectedProduct==true}">

		<jsp:include page="selected_product.jsp"></jsp:include>
	</c:if>

	<c:if test="${isAdmin==true}">
		<jsp:include page="admin/adminHome.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedMyCart==true}">
		<jsp:include page="cart.jsp"></jsp:include>
	</c:if>

	${welcomeMessage} ${errorMessage} ${successMessage}



	<c:if test="${isUserClickedLogin==true}">
		<jsp:include page="login.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedRegister==true}">
		<jsp:include page="registration.jsp"></jsp:include>
	</c:if>
		
		<div class=container>
		<div class="container">
			<div class="row mar-bot-30">
				<div class="col-md-12">
					<!-- <div class="product-sec-tittle">
						<h2 style="text-align: center;" class="section-heading">
							<span>Feature</span> Product
						</h2>
					</div> -->
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