<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin page</title>
</head>
<body>

	<%@include file="../new_product_menu.jsp"%>
	<center>
		<h2>	
			<a href="${pageContext.request.contextPath}/admin/manageCategories"> Manage Categories</a>  
			<a href="${pageContext.request.contextPath}/admin/manageSuppliers"> Manage Suppliers</a>
			<a href="${pageContext.request.contextPath}/admin/manageProducts"> Manage Products</a>
			<a href="${pageContext.request.contextPath}/admin/manageUsers"> Manage Users</a>
		</h2>
	</center> 
	<br>
		<c:if test="${isAdminClickedManageCategories==true }">
			<jsp:include page="category.jsp"></jsp:include>
		</c:if>
		<c:if test="${isAdminClickedManageSuppliers==true }">
			<jsp:include page="supplier.jsp"></jsp:include>
		</c:if>
		<c:if test="${isAdminClickedManageProducts==true }">
			<%@ include file="product.jsp" %>
		</c:if>
		
		<c:if test="${isAdminClickedUsers==true }">
			<jsp:include page="updateUser.jsp"></jsp:include>
		</c:if>
		
		<%@ include file="../footer.jsp" %> 
</body>
</html>