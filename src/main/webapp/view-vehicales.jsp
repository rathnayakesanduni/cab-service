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
		  <a class="nav-link active"aria-current="page" href="#">View Vehicle</a>
		
		<li class="nav-item">
		   <a class="nav-link" href="Admin.jsp">back to Admin page</a>
		</li>
		
	</ul>

  <br> 
<div class="container">
  <table class="table table-hover">
      <thead>
         <tr>
            <th>Vehicle Id</th>
            <th>Vehicle Name</th>
            <th>Vehicle Number</th>
            <th>Branch Name</th>
            <th>Price </th>
            
         </tr>
      </thead>
      
        <tbody>
          <tag:forEach var="vehicale" items="${vehicaleList}">
             <tr>
                <td>${vehicale.getVehicleID()}</td>
                <td>${vehicale.getVehicleName()}</td>
                <td>${vehicale.getVehicaleNumber()}</td>
                <td>${vehicale.getBranchname()}</td>
                <td>${vehicale.getPrice()}</td>
                
                
                <td>
                     <form action="DeletVehicleServlet" method="post">
                         <input type="hidden" name="action" value="delete"/>
                         <input type="hidden" name="vehicleID" value="${vehicale.getVehicleID()}"/>
                         <button type="submit" class="btn btn-danger">Delete</button>
                     </form>
                </td>
              </tr>  
          </tag:forEach>
      </tbody>
  </table>	
	
 </div>
</body>
</html>