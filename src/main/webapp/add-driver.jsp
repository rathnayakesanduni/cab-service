<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" />

<title>GoCheeta</title>
<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">

</head>
<body>


  <br>
     <p>${message}</p>
  <br>
	<ul class="nav nav-tabs">
		<li class="nav-item">
		  <a class="nav-link active"aria-current="page" href="#">Add New Driver</a>
		
		<li class="nav-item">
		   <a class="nav-link" href="Admin.jsp">back to Admin page</a>
		</li>
		
	</ul>

<br>

<div class="container">
     
     <form method="post" action="adddriver"  >
							<div class="form-group">
								<label for="driverName"><i
									class="zmdi zmdi-account material-icons-name"></i></label> 
									<input type="text" name="driverName" id="driverName" placeholder="Driver Name" />
							</div>
							<div class="form-group">
								<label for="address"><i class="zmdi zmdi-home"></i></label> 
								<input type="text" id="branchName" name="branchName" placeholder="Branch Name" />
							</div>
							
							
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Add" />
							</div>
							 <input type="hidden" name="action" value="add"/>
        <br>
						</form>
</div>

<%@include file="/includes/footer.jsp"%>
</body>
</html>