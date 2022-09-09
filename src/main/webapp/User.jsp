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
	<%@include file="includes/navbar.jsp" %>

<br>

		<div class="container d-flex align-items-center flex-column">
			<!-- Masthead Avatar Image-->
			<img  src="images/cab6.jpg" alt="..." />
			
			<!-- Masthead Subheading-->
			<p >Online cab service</p>
		</div>
	
<br>
<br>
<div class="container">
     
     <form method="post" action="CustomerBookingServlet"  >
							<div class="form-group">
								<label for="customerName"><i
									class="zmdi zmdi-account material-icons-name"></i></label> 
									<input type="text" name="customerName" id="customerName" placeholder="Customer Name" />
							</div>
							<div class="form-group">
								<label for="pickUpLocation"><i class="zmdi zmdi-home"></i></label> 
								<input type="text" id="pickUpLocation" name="pickUpLocation" placeholder="PickUpLocation" />
							</div>
							
							<div class="form-group">
								<label for="dropUpLocation"><i class="zmdi zmdi-phone"></i></label> 
								<input type="text" id="dropUpLocation" name="dropUpLocation" placeholder="DropUpLocation " />
							</div>
							
							<div class="form-group">
								<select name="vehicleType" id="vehicleType" class="form-select" aria-label=".form-select-lg example" required="required">
                                    <option value="vehicleType">Select Vehicle Type</option>
                                    <option>Van</option>
                                    <option>Car</option>
                                    <option>ThreewiI</option>
                                    
                                    
                              </select>
							</div>
							
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Booking" />
							</div>
							 <input type="hidden" name="action" value="add"/>
        <br>
						</form>
</div>


<%@include file="/includes/footer.jsp"%>
</body>
</html>