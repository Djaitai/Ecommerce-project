<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category page</title>
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
	font-size: 20px;
}
img
{
	 width: 50px;
	 height: 50px;
}

</style>

</head>
<body>
	<div class="container">
		<form class="well form-horizontal" action="${pageContext.request.contextPath}/admin/category/save" method="post" id="contact_form">
			<fieldset>

				<!-- Form Name -->
				<legend>
					<center>
						<h2>
							<b>Category Form</b>
						</h2>
					</center>
				</legend>
				<br>
				
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">  Category ID<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span> 
							<input type="text" name="category_Id" placeholder="E-Mail Address" class="form-control" 
								value="${selectedCategory.category_Id}"/>
                      </div>
						
					</div>
				</div>
				
				
				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Category name</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-earphone"></i></span> <input type="text"
								name="category_name" placeholder="Category name" class="form-control"
								value="${selectedCategory.category_name}"/>
						</div>
					</div>
				</div>
				

				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Category description<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input  type="text" name="category_description"
								placeholder="Category description" class="form-control" 
								value="${selectedCategory.category_description}"/>
						</div>
					</div>
				</div>
				<!-- Button -->

				<div class="form-group" align="center">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-12">
						<button type="submit" class="btn btn-warning">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Create category <span
								class="glyphicon glyphicon-send"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</button>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	</div>
	
	<!--  display all the categories -->
	<div class="container-fluid">
		<table class="table table-dark">
		<thead>
			<tr>
				<td>CATEGORY ID</td>
				<td>CATEGORY NAME</td>
				<td>CATEGORY DESCRIPTION</td>
				<td align="center">Action</td>
			</tr>
			</thead>
			<c:forEach var="category" items="${categories}">
				<tr>
					<td scope="col">${category.category_Id}</td>
					<td scope="col">${category.category_name}</td>
					<td scope="col">${category.category_description}</td>			
					<td scope="col"><a href="category/delete/?category_Id=${category.category_Id}"><img style="width: 50px; height: 40px;" src="../resources/image/delete.png" alt="no image"></a></td>
					<td scope="col"><a href="category/edit/?category_Id=${category.category_Id}"><img style="width: 50px; height: 40px;" style="width: 70px; height: 70px;" src="../resources/image/edit.png" alt="no image"></a></td>	
				</tr>
			</c:forEach>
		</table>
	</div>	
	
	<br><br>
	<%@ include file="../footer.jsp" %>
</body>
</html>