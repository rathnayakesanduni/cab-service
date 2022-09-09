<html>
<head>
<title>Admin page</title>
<% //In case, if Admin session is not set, redirect to Login page
if((request.getSession(false).getAttribute("Admin")== null) )
{
%>
<jsp:forward page="Admin.jsp"></jsp:forward>
<%} %>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>
</head>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <div style="text-align: right "><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-blue w3-animate-left"  style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container w3-row">
    <div class="w3-col s4">
      <img src="images/images20.jpg" class="w3-circle w3-margin-right" style="width:46px">
    </div>
    <div class="w3-col s8 w3-bar">
      <span>Welcome, <strong>Admin</strong></span><br>
      
    </div>
  </div>
  <hr>
  
  <div class="w3-bar-block">
    <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
    <a href="add-driver.jsp" class="w3-bar-item w3-button w3-padding ">Add Drivers</a>
    <a href="ViewDriverServlet?action=all" class="w3-bar-item w3-button w3-padding">View Drivers</a>
    <a href="update-Driver.jsp" class="w3-bar-item w3-button w3-padding">Update Driver</a>
    <a href="ViewVehicaleServlet?action=all" class="w3-bar-item w3-button w3-padding">View Vehicle</a>
    <a href="add-vehicale.jsp" class="w3-bar-item w3-button w3-padding">Add Vehicle</a>
    <a href="update-vehicale.jsp" class="w3-bar-item w3-button w3-padding">Update Vehicle</a>
    <a href="CustomerBookServlet?action=all" class="w3-bar-item w3-button w3-padding">View Booking Details</a>
    
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  

  

  <div class="signin-image" >
	<figure>
		<img src="images/cab1.jpg" alt="sing up image" width=1400 height=700>
	</figure>
						
  </div>
</div>

</body>
</html>
