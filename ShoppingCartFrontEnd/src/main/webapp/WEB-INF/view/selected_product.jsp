<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<img src="<c:url value="resources/images/${product.image_name}"></c:url>"  height="70px" width="70px"/>
	<%-- <img alt="no image" src="${selectedProductImage}"> --%>
	<br> ${selectedProduct.product_Id}
	<img alt="" src="resources/images/${selectedProduct.product_Id}.PNG">
	product name: ${selectedProduct.product_name}
	<br> price : ${selectedProduct.price}
	<br> Description : ${selectedProduct.product_description}
	<br>
	<a href="cart/add/${selectedProduct.product_Id}">Add to Cart</a>

	<c:forEach items="${products}" var="product">
		${product.product_name}
		${product.product_description}
		${product.price}
		<img alt="" src="resources/images/${product.product_Id}.PNG">
	</c:forEach>
</body>
</html>