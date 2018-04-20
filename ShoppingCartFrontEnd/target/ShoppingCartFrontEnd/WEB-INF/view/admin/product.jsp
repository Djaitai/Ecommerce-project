<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>product</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"
	type="text/javascript"></script>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>
<link rel='stylesheet prefetch'
	href='http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css'>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<style type="text/css">
	sup
	{
		color: red;
		font-size: 15px;
	}
</style>

</head>
<body>

<%-- <%@include file="../new_product_menu.jsp"%> --%>

<hr size="5" color=" blue">
	<div class="container">
		${ProductSuccessMessage} ${ProductErrorMessage}
		${UploadedImage} ${UsucUploadedImage}
		
		<form class="well form-horizontal" action="${pageContext.request.contextPath}/admin/product/save" method="POST" enctype="multipart/form-data" >
			<fieldset>
				<legend>
					<center>
						<h2>
							<b>Product Form</b>
						</h2>
					</center>
				</legend>
				<br>
				
				<!-- Text input-->
				
				
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">  Product ID<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-star"></i></span>
							<input type="text" name="product_Id" value="${selectedProduct.product_Id}"  class="form-control" placeholder="Product ID">
						</div>
						
					</div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">Brand<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-star"></i></span>
							<input type="text" name="brand" value="${selectedProduct.brand}"  class="form-control" placeholder="Brand">
						</div>
						
					</div>
				</div>
				
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">Category ID<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<!-- <span class="input-group-addon"><i class="glyphicon glyphicon-star"></i></span> -->
							<%-- <input type="text" name="category_Id" value="${selectedProduct.category_Id}"  class="form-control" placeholder="Category ID"> --%>
							<select name = "category_Id" style="height: 30px; width: 120px">
								<!-- <option>Select category id -->
								<c:forEach var="category" items="${categories}">
								<option value="${category.category_Id}"> ${category.category_name} </option>
								</c:forEach>
							</select>
						</div>
						
					</div>
				</div>
				
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">Image<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<!-- <span class="input-group-addon"><i class="glyphicon glyphicon-star"></i></span> -->
							<%-- <input type="text" name="image_name" value="${selectedProduct.image_name}"  class="form-control" placeholder="Image"> --%>
							<input type="file" name="file" accept="images/*"/>
						</div>
						
					</div>
				</div> 
				
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">Price<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-star"></i></span>
							<input type="text" name="price" value="${selectedProduct.price}"  class="form-control" placeholder="Price">
						</div>
						
					</div>
				</div>
				
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">Product description<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-pencil"></i></span> 
								<input type="text" name="product_description" value="${selectedProduct.product_description}"  class="form-control" placeholder="Product description">
						</div>
					</div>
				</div>
				

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">Product name<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-pencil"></i></span> 
								<input type="text" name="product_name" value="${selectedProduct.product_name}"  class="form-control" placeholder="Product name">
						</div>
					</div>
				</div>
				
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">Stock<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-star"></i></span>
							<input type="text" name="stock" value="${selectedProduct.stock}"  class="form-control" placeholder="Stock">
						</div>						
					</div>
				</div>
				
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">Supplier ID<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<%-- <span class="input-group-addon"><i class="glyphicon glyphicon-star"></i></span>
							<input type="text" name="supplier_Id" value="${selectedProduct.supplier_Id}"  class="form-control" placeholder="SupplierID"> --%>
							<select name = "supplier_Id" style="height: 30px; width: 120px">
								<!-- <option>Select supplier id -->
								<c:forEach var="supplier" items="${suppliers}">
									<option value="${supplier.supplier_Id}"> ${supplier.supplier_name} </option>
								</c:forEach>
							</select>
						</div>
						
					</div>
				</div>


				<!-- Button -->
				<div class="form-group" align="center">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-12">
						<button type="submit" class="btn btn-warning">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Create product<span
								class="glyphicon glyphicon-send"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</button>
					</div>
				</div>
				
			</fieldset>
		</form>
	</div>

		<br><br>
		<hr style="height: 10px; color: #8B0000;">
		<!-- Display all Product -->

		<div class="container-fluid">
			<%-- ${categories}Work fine --%>

			<table class="table table-dark">
				<!-- Apply color to your table  -->
				<thead>
				<tr>
					<th scope="col">Product ID</th>
					<th scope="col">Brand</th>
					<th scope="col">Category ID</th>
					 <th scope="col">Image name</th> 
					<th scope="col">Price</th>
					<th scope="col">Product description</th>
					<th scope="col">Product name</th>
					<th scope="col">Stock</th>
					<th scope="col">Supplier ID</th>
					<th scope="col">Action</th>
				</tr>
				</thead>
				<c:url  value="/resources/image" var="image"></c:url>
				<c:forEach var="product" items="${products}">
				<tbody>
					<tr>
						<td>${product.product_Id}</td>
						<td>${product.brand}</td>
						<td>${product.category.category_Id}</td>
				 <td><img src="<c:url value="../resources/image/${product.image_name}"></c:url>"  height="70px" width="70px"/></td>
						<td>${product.price}</td>
						<td>${product.product_description}</td>
						<td>${product.product_name}</td>
						<td>${product.stock}</td>
						<td>${product.supplier.supplier_Id}</td>
						<td>
							<a href="product/delete/?product_Id=${product.product_Id}">DELETE</a> | 
							<a href="product/edit/?product_Id=${product.product_Id}">EDIT</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	
	<%@ include file="../footer.jsp" %>
</body>
</html>