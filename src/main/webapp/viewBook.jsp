<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" />
<title>TechMart</title>
</head>
<body>
 <p>${message}</p>
   <p>${deleteMessage}</p>
  <br> 
 
 <ul class="nav nav-tabs">
		<li class="nav-item">
		  <a class="nav-link active"aria-current="page" href="#">View Booking</a>
		
		
		
		<li class="nav-item">
		   <a class="nav-link" href="Admin.jsp">back to admin Home page</a>
		</li>
		
		<li class="nav-item">
		   <a class="nav-link" href="Driver.jsp">back to driver Home page</a>
		</li>
		
	</ul>

  <br> 
<div class="container">
  <table class="table table-hover">
      <thead>
         <tr>
           
           
            <th>Booking Id</th>
            <th>Customer Name</th>
            <th>PickUp Location </th>
            <th>DropUp Location</th>
            <th>Vehicle Type </th>
           
            
            
         </tr>
      </thead>
      
        <tbody>
          <tag:forEach var="customerBooking1" items="${customerBookList}">
             <tr>
             
                <td>${customerBooking1.getBookingID()}</td>
                <td>${customerBooking1.getCustomerName()}</td>
                <td>${customerBooking1.getPickUpLocation()}</td>
                <td>${customerBooking1.getDropUpLocation()}</td>
                <td>${customerBooking1.getVehicleType()}</td>
                
                
                
              </tr>  
          </tag:forEach>
      </tbody>
  </table>	
	
 </div>
</body>
</html>