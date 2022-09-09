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
		   <a class="nav-link" href="User.jsp">back to User Home page</a>
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
          <tag:forEach var="customerBooking" items="${customerBookingList}">
             <tr>
             
                <td>${customerBooking.getBookingID()}</td>
                <td>${customerBooking.getCustomerName()}</td>
                <td>${customerBooking.getPickUpLocation()}</td>
                <td>${customerBooking.getDropUpLocation()}</td>
                <td>${customerBooking.getVehicleType()}</td>
                
                
                  <td>
                     <form action="ViewCustomerBookingServlet" method="post">
                         <input type="hidden" name="action" value="delete"/>
                         <input type="hidden" name="bookingID" value="${customerBooking.getBookingID()}"/>
                         <button type="submit" class="btn btn-danger">Cancle booking</button>
                     </form>
                  </td>
                
              </tr>  
          </tag:forEach>
      </tbody>
  </table>	
	
 </div>
</body>
</html>