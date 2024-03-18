<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Search and Update Payment</title>
</head>
<body>
    <div class="container-fluid">
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link" href="PaymentDashboard">Store</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Search Specific & Update</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Add-payment.jsp">Add</a>
            </li>
        </ul>
        <br/>
        <br/>
        <div class="container">
            <h3>Search Payment-----------------</h3>
            <br/>
            <form method="get" action="paymentController">
                Enter Payment ID: <input type="text" name="paymentid">
                <input type="hidden" name="type" value="specific">
                <button type="submit" class="btn btn-info">Search</button>            
            </form>
                        
            <br/>
            <p>${searchResult}</p>
            <br/>
            <h3>Edit Payment-----------------</h3>
            <br/>
            <form method="post" action="paymentController">
             <label for="paymentId">Payment ID:</label>
                <input type="text" readonly class="form-control" id="paymentId" name="paymentId" value="${not empty payment ? payment.paymentId : ''}"/>
                <br/>
                <label for="price">Amount [LKR]:</label>
            <input type="number" class="form-control" id="price" name="price" value="${not empty payment ? payment.price : ''}"/>
            <br/>
            <label for="paymentDate">Payment Date:</label>
            <input type="date" class="form-control" id="paymentDate" name="paymentDate" value="${not empty payment ? payment.paymentDate : ''}"/>
            <br/>
            <label for="cardNumber">Card Number:</label>
            <input type="text" class="form-control" id="cardNumber" name="cardNumber" value="${not empty payment ? payment.cardNumber : ''}"/>
            <br/>
            <label for="expiryDate">Expiry Date:</label>
            <input type="text" class="form-control" id="expiryDate" name="expiryDate" value="${not empty payment ? payment.expiryDate : ''}"/>
            <br/>
            <label for="cvcNumber">CVC Number:</label>
            <input type="number" class="form-control" id="cvcNumber" name="cvcNumber" value="${not empty payment ? payment.cvcNumber : ''}"/>
            
            <br/>
            <label for="cardholderName">Cardholder Name:</label>
            <input type="text" class="form-control" id="cardholderName" name="cardholderName" value="${not empty payment ? payment.cardholderName : ''}"/>
            <br/>
            <label for="patientId">Patient ID:</label>
            <input type="number" class="form-control" id="patientId" name="patientId" value="${not empty payment ? payment.patientId : ''}"/>
            <input type="hidden" name="type" value="add"/>
            <br/>
                <button type="submit" class="btn btn-warning">Update</button>            
            </form>     
        </div>      
    </div>
</body>
</html>
