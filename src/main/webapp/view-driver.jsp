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
		  <a class="nav-link active"aria-current="page" href="#">View Driver</a>
		
		<li class="nav-item">
		   <a class="nav-link" href="Admin.jsp">back to Admin page</a>
		</li>
		
	</ul>

  <br> 
<div class="container">
  <table class="table table-hover">
      <thead>
         <tr>
            <th>Driver Id</th>
            <th>Driver Name</th>
            <th>Branch Name</th>
            
            
         </tr>
      </thead>
      
        <tbody>
          <tag:forEach var="driver" items="${driverList}">
             <tr>
                <td>${driver.getDriverID()}</td>
                <td>${driver.getDriverName()}</td>
                <td>${driver.getBranchName()}</td>
                
                
                
                <td>
                     <form action="DeleteDriverServlet" method="post">
                         <input type="hidden" name="action" value="delete"/>
                         <input type="hidden" name="driverID" value="${driver.getDriverID()}"/>
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