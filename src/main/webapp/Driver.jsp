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
	
  
			<ul class="navbar-nav ml-auto">
				
				<li class="nav-item"> <a href="CustomerBookServlet?action=all" class="w3-bar-item w3-button w3-padding">View Booking Details</a></li>
				
				<li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a></li>
				
				
				
				
			</ul>
				
				
		
<br>



<%@include file="/includes/footer.jsp"%>
</body>
</html>