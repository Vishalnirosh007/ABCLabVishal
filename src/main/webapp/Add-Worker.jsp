<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Add Lab Worker</title>
</head>
<body>
<div class="container-fluid">
		
		
		<ul class="nav justify-content-center bg-dark py-2">
		<li class="nav-item">
    <a class="link-warning nav-link px-5 mx-5" aria-current="page" href="AdminHomePage.jsp"> << Go to Home</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary  nav-link " aria-current="page" href="LabworkerDashboard">Store</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary nav-link " href="Search-Worker.jsp">Search Specific & Update</a>
  </li>
  <li class="nav-item">
    <a class="text-white nav-link" href="Add-Worker.jsp">Add</a>
  </li>
  
</ul>
		<br/>
		<br/>
		<div class="container">
			<h3>Register Lab Worker</h3>
			<br/>
			<p>${message}</p>
			<br/>
			<form method="post" action="labWorkerController">
				<br/>
				<label for="labWorkerName">Lab Worker Name:</label>
				<input type="text" class="form-control" id="labWorkerName" name="labWorkerName"/>
				<br/>
				<br/>
				<label for="description">Description:</label>
				<input type="text" class="form-control" id="description" name="description"/>
				<input type="hidden" name="type" value="add"/>
				<br/>
				<br/>
				<button type="submit" class="btn btn-primary">Register</button>			
			</form>		
		</div>		
	</div>
</body>
</html>
