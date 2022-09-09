<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"><link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body><br>
     <p>${message}</p>
  <br><ul class="nav nav-tabs">
		<li class="nav-item">
		  <a class="nav-link active"aria-current="page" href="#">Update Vehicle</a>
		
		<li class="nav-item">
		   <a class="nav-link" href="Admin.jsp">back to Admin page</a>
		</li>
		
	</ul>
    <br><div class="container">
        <h2>Search a Vehicle:</h2>
        <br>
        <form action="ViewVehicaleServlet" >
           <label for="vehicleID">Vehicle Id:</label>
           <input type="number" id="vehicleID" name="vehicleID" class="form-control"/>
           <br>
           <input type="hidden" name="action" value="single"/>
           <button type="submit" class="btn btn-info">Search</button>
        </form>
    </div>
    <br>
    <div class="container">
        <form action="UpdateVehicaleServlet" method="post">
         <label for="vehicleID">Vehicle Id:</label>
         <input type="number"  readonly="readonly" id="vehicleID" name="vehicleID" class="form-control" value="${vehicale.getVehicleID()}"/>
            
        <label for="vehicleName">Vehicle  Name:</label>
        <input type="text" id="vehicleName" name="vehicleName" class="form-control" value="${vehicale.getVehicleName()}">
        <br>
        
        <label for="vehicaleNumber">Vehicle number:</label>
        <input type="text" id="vehicaleNumber" name="vehicaleNumber" class="form-control" value="${vehicale.getVehicaleNumber()}">
        <br>
        
        <label for="branchname ">Branch Name:</label>
        <input type="text" id="branchname" name="branchname" class="form-control" value="${vehicale.getBranchname()}">
        <br>
        
        <label for="price">Price :</label>
        <input type="text" id="price" name="price" class="form-control" value="${vehicale.getPrice()}">
        <br>
        
       
        <br>
        <input type="hidden" name="action" value="update"/>
           <button type="submit" class="btn btn-warning">Update Information</button>
        </form>
    </div>
</body>
</html>