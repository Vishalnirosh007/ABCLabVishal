<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Add Doctor</title>
</head>
<body>
<div class="container-fluid">
		<ul class="nav nav-tabs">
			<li class="nav-item">
				<a class="nav-link" href="DoctorDashboard">Store</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="Search-Doctor-Details.jsp">Search Specific & Update</a>
			</li>
			<li class="nav-item">
				<a class="nav-link active" aria-current="page" href="#">Add</a>
			</li>
		</ul>
		<br/>
		<br/>
		<div class="container">
			<h3>Register Doctor</h3>
			<br/>
			<p>${message}</p>
			<br/>
			<form method="post" action="doctorController">
				<br/>
				<label for="firstName">First Name:</label>
				<input type="text" class="form-control" id="firstName" name="firstName"/>
				<br/>
				<br/>
				<label for="lastName">Last Name:</label>
				<input type="text" class="form-control" id="lastName" name="lastName"/>
				<br/>
				<br/>
				<label for="specialization">Specialization:</label>
				<input type="text" class="form-control" id="specialization" name="specialization"/>
				<br/>
				<br/>
				<label for="email">Email:</label>
				<input type="email" class="form-control" id="email" name="email"/>
				<br/>
				<input type="hidden" name="type" value="add"/>
				<br/>
				<br/>
				<button type="submit" class="btn btn-primary">Register</button>			
			</form>		
		</div>		
	</div>
</body>
</html>
