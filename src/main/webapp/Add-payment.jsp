<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Add Payment</title>
</head>
<body>
<div class="container-fluid">
		<ul class="nav nav-tabs">
			<li class="nav-item">
				<a class="nav-link" href="PaymentDashboard">Store</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="Search-Payment.jsp">Search Specific & Update</a>
			</li>
			<li class="nav-item">
				<a class="nav-link active" aria-current="page" href="#">Add</a>
			</li>
		</ul>
		<br/>
		<br/>
		<div class="container">
			<h3>Register Payment</h3>
			<br/>
			<p>${message}</p>
			<br/>
			<form method="post" action="paymentController">
				<br/>
            
            <label for="price">Amount [LKR]:</label>
            <input type="number" class="form-control" id="price" name="price"/>
            <br/>
            <label for="paymentDate">Payment Date:</label>
            <input type="date" class="form-control" id="paymentDate" name="paymentDate"/>
            <br/>
            <label for="cardNumber">Card Number:</label>
            <input type="text" class="form-control" id="cardNumber" name="cardNumber"/>
            <br/>
            <label for="expiryDate">Expiry Date:</label>
            <input type="text" class="form-control" id="expiryDate" name="expiryDate"/>
            <br/>
            <label for="cvcNumber">CVC Number:</label>
            <input type="number" class="form-control" id="cvcNumber" name="cvcNumber"/>
            
            <br/>
            <label for="cardholderName">Cardholder Name:</label>
            <input type="text" class="form-control" id="cardholderName" name="cardholderName"/>
            <br/>
            <label for="patientId">Patient ID:</label>
            <input type="number" class="form-control" id="patientId" name="patientId"/>
            <input type="hidden" name="type" value="add"/>
            <br/>
            <br/>
				<button type="submit" class="btn btn-primary">Register</button>			
			</form>		
		</div>		
	</div>
</body>
</html>
