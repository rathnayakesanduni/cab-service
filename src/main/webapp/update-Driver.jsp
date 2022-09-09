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
		  <a class="nav-link active"aria-current="page" href="#">Update driver</a>
		
		<li class="nav-item">
		   <a class="nav-link" href="Admin.jsp">back to Admin page</a>
		</li>
		
	</ul>
    <br><div class="container">
        <h2>Search a Vehicle:</h2>
        <br>
        <form action="ViewDriverServlet" >
           <label for="driverID">Driver Id:</label>
           <input type="number" id="driverID" name="driverID" class="form-control"/>
           <br>
           <input type="hidden" name="action" value="single"/>
           <button type="submit" class="btn btn-info">Search</button>
        </form>
    </div>
    <br>
    <div class="container">
        <form action="UpdateDriverServlet" method="post">
         <label for="driverID">Driver Id:</label>
         <input type="number"  readonly="readonly" id="driverID" name="driverID" class="form-control" value="${driver.getDriverID()}"/>
            
        <label for="driverName">Driver  Name:</label>
        <input type="text" id="driverName" name="driverName" class="form-control" value="${driver.getDriverName()}">
        <br>
        
        
        <label for="branchName ">Branch Name:</label>
        <input type="text" id="branchName" name="branchName" class="form-control" value="${driver.getBranchName()}">
        <br>
       
       
        <br>
        <input type="hidden" name="action" value="updateDriver"/>
           <button type="submit" class="btn btn-warning">Update Information</button>
        </form>
    </div>
</body>
</html>