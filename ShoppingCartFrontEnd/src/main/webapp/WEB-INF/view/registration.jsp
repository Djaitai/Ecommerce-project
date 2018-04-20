<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<style type="text/css">

sup
{
	color: red;
	font-size: 20px;
}


</style>

</head>
<body>


	<%@include file="new_product_menu.jsp"%>
	 <div>
	<div class="container">
		<form:form class="well form-horizontal" modelAttribute="user" action="${pageContext.request.contextPath}/saveRegister" method="post" id="contact_form">
			<fieldset>

				<!-- Form Name -->
				<legend>
					<center>
						<h2>
							<b>Registration Form</b>
						</h2>
					</center>
				</legend>
				<br>
				
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">  E-Mail<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span> <form:input path="emailID"
								placeholder="E-Mail Address" class="form-control" type="text" />
                      <form:errors path="emailID"></form:errors></div>
						
					</div>
				</div>
				
				
				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Contact No.</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-earphone"></i></span> <form:input
								path="mobile" placeholder="(639)" class="form-control"
								type="text"/>
						</div>
					</div>
				</div>
				

				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Full name<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <form:input path="name"
								placeholder="Full Name" class="form-control" type="text"/>
						</div>
					</div>
				</div>

				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Password<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <form:input
								path="password" placeholder="Password" class="form-control"
								type="password"/>
						</div>
					</div>
				</div>
				<!-- Text input-->

				<%-- <div class="form-group">
					<label class="col-md-4 control-label">Role</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <form:input path="role"
								placeholder="Role" class="form-control" type="text"/>
						</div>
					</div>
				</div> --%>
				
				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Address<sup>*</sup></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-home"></i></span> <form:input path="address"
								placeholder="Address" class="form-control" type="text"/>
						</div>
					</div>
				</div>


				<!-- Button -->

				<div class="form-group" align="center">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-12">
						<button type="submit" class="btn btn-warning">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Register <span
								class="glyphicon glyphicon-send"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</button>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
	</div>
</body>

</html>