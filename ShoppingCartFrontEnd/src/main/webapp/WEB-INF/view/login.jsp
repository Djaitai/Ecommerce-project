<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login page</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- 
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->

<style type="text/css">
body {
	padding-top: 50px;
}

.jumbotron {
	height: 100%;
	background-color: ;
}

.form-group {
	padding-left: 60px;
	width: 90%;
}
</style>


<script type="text/javascript">
function emailFunction() 
{
    var x = document.getElementById("Email").pattern;
    document.getElementById("demo").innerHTML = x;
}
function passFunction() 
{
    var x = document.getElementById("passInput");
    if (x.type == "password") 
    {
        x.type = "text";
    } 
    else 
    {
        x.type = "password";
    }
}


</script>

</head>
<body>
	<jsp:include page="new_product_menu.jsp"></jsp:include>
	<br> ${message}	 
	<div class="container">
	<form name='loginForm' action='<c:url value="/login"></c:url>' method='POST'>	
		<div class="jumbotron">
			<div class="container">
				<br>
				<div class="form-group">
					<label for="email">Email:</label> <input type="email" id="Email"
						name="username" class="form-control" placeholder="Enter your Email"
						pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required />
				</div>
				<div class="form-group">
					<label for="pwd">Password:</label> <input type="password"
						class="form-control" id="passInput" placeholder="Enter password"
						name="password" required>
				</div>
				<div class="checkbox form-group">
					<label><input type="checkbox" onclick="passFunction()">Show
						Password</label>
				</div>
				<div class="form-group">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button class="btn btn-lg btn-primary" type="submit">Login</button>
                <button style="text-align:right;"  class="btn btn-lg btn-primary" type="reset">Cancel</button>                
                </div>
				<div class="form-group">
					<h4>
						<bold> If you have no account then <a href="register">
							Click me</a></bold>
					</h4>
				</div>
			</div>
		</div>	
	</form> 
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>