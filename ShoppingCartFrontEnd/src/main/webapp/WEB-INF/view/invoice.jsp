<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>invoice page</title>
</head>
<body>
	<jsp:include page="new_product_menu.jsp"></jsp:include>

	<div class="container">
		<form class="form-horizontal" action="${pageContext.request.contextPath}/ackAction">
			<fieldset>
				<div class="form-group">
					<label class="col-md-4 control-label" for="username">Customer
						Name</label>
					<div class="col-md-4">
						<label class="col-md-4 control-label" for="username">${userDetails.name}</label>
					</div>
				</div>


				<div class="form-group">
					<label class="col-md-4 control-label" for="email">Customer
						Email Address</label>
					<div class="col-md-4">
						<label class="col-md-4 control-label" for="email">${userDetails.emailID}</label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="address">Shipping
						Address</label>
					<div class="col-md-4">
						<label class="col-md-4 control-label" for="address">${userDetails.address}</label>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="deliverydate">Date
						Of Delivery</label>
					<div class="col-md-4">
						<label class="col-md-4 control-label" for="deliverydate">Deliverd
							in 7 Working Days</label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-4">
						<button type="submit" name="invoiceClick" class="btn btn-primary">OK</button>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>