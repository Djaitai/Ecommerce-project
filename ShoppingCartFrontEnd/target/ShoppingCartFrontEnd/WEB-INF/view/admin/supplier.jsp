<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration page</title>
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
<%@include file="../new_product_menu.jsp"%>
	<div class="container">
		${SupplierSuccessMessage} ${SupplierErrorMessage}
		<form class="well form-horizontal" action="${pageContext.request.contextPath}/supplier/save" method="POST" id="form">
			<fieldset>
				<legend>
					<center>
						<h2>
							<b>Supplier Form</b>
						</h2>
					</center>
				</legend>
				<br>
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">Supplier ID<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-pencil"></i></span> 
										<input type="text" name="supplier_Id" value="${selectedSupplier.supplier_Id}" 
										 class="form-control" placeholder="Supplier ID" required="required">
						</div>
					</div>
				</div>
				
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">Supplier name<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-pencil"></i></span> 
										<input type="text" name="supplier_name" value="${selectedSupplier.supplier_name}" 
										 class="form-control" placeholder="Supplier name" required="required">
						</div>
					</div>
				</div>
				
				
				
				<div class="form-group">
					<label class="col-md-4 control-label">Supplier mobile<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-pencil"></i></span> 
										<input type="text" name="supplier_mobile" value="${selectedSupplier.supplier_mobile}" 
										 class="form-control" placeholder="Supplier mobile" required="required">
						</div>
					</div>
				</div>
				

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">Supplier address<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-pencil"></i></span> 
										<input type="text" name="supplier_address" value="${selectedSupplier.supplier_address}" 
										 class="form-control" placeholder="Supplier address" required="required">
						</div>
					</div>
				</div>


				<!-- Button -->
				<div class="form-group" align="center">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-12">
						<button type="submit" class="btn btn-warning">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Create supplier<span
								class="glyphicon glyphicon-send"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</button>
					</div>
				</div>
				
			</fieldset>
		</form>
	</div>

		<br><br>
		<hr style="height: 10px; color: #8B0000;">
		<!-- Display all Supplier -->

		<div class="container-fluid">
			<%-- ${suppliers}Work fine --%>

			<table class="table table-dark">
				<!-- Apply color to your table  -->
				<thead>
				<tr>
					<th scope="col">Supplier ID</th>
					<th scope="col">Supplier name</th>
					<th scope="col">Supplier mobile</th>
					<th scope="col">Supplier address</th>
					<th scope="col">Action</th>
				</tr>
				</thead>
				<c:url  value="/resources/images" var="image"></c:url>
				<c:forEach var="supplier" items="${suppliers}">
				<tbody>
					<tr>
						<td>${supplier.supplier_Id}</td>
						<td>${supplier.supplier_name}</td>
						<td>${supplier.supplier_mobile}</td>
						<td>${supplier.supplier_address}</td>
						<td><a href="supplier/delete/?supplier_Id=${supplier.supplier_Id}">Delete</a>
							| <a href="supplier/edit/?supplier_Id=${supplier.supplier_Id}">Edit</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	
	<%@ include file="../footer.jsp" %>
</body>
</html>