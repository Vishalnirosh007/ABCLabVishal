<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Payment</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container-fluid {
            padding-top: 20px;
        }
        .nav-link {
            color: #ffffff;
        }
        .nav-link:hover {
            color: #ffc107;
        }
        .form-label {
            font-weight: bold;
        }
        .btn-register {
            width: 100%;
        }
        .form-container {
            background-color: #fff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <ul class="nav justify-content-center bg-dark py-2">
        <li class="nav-item">
            <a class="link-warning nav-link px-5 mx-5" aria-current="page" href="AdminHomePage.jsp"> << Go to Home</a>
        </li>
        <li class="nav-item">
            <a class="link-secondary  nav-link " aria-current="page" href="PaymentDashboard">Home</a>
        </li>
        <li class="nav-item">
            <a class="link-secondary nav-link " href="Search-Payment.jsp">Search Specific & Update</a>
        </li>
        <li class="nav-item">
            <a class="text-white nav-link" href="Add-payment.jsp">Add</a>
        </li>
    </ul>
    <br/>
    <br/>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="form-container">
                    <h3 class="text-center mb-4">Register Payment</h3>
                    <form method="post" action="paymentController">
                        <div class="mb-3">
                            <label for="price" class="form-label">Amount [LKR]:</label>
                            <input type="number" class="form-control" id="price" name="price"/>
                        </div>
                        <div class="mb-3">
                            <label for="paymentDate" class="form-label">Payment Date:</label>
                            <input type="date" class="form-control" id="paymentDate" name="paymentDate"/>
                        </div>
                        <div class="mb-3">
                            <label for="cardNumber" class="form-label">Card Number:</label>
                            <input type="text" class="form-control" id="cardNumber" name="cardNumber"/>
                        </div>
                        <div class="row mb-3">
                            <div class="col">
                                <label for="expiryDate" class="form-label">Expiry Date:</label>
                                <input type="text" class="form-control" id="expiryDate" name="expiryDate"/>
                            </div>
                            <div class="col">
                                <label for="cvcNumber" class="form-label">CVC Number:</label>
                                <input type="number" class="form-control" id="cvcNumber" name="cvcNumber"/>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="cardholderName" class="form-label">Cardholder Name:</label>
                            <input type="text" class="form-control" id="cardholderName" name="cardholderName"/>
                        </div>
                        <div class="mb-3">
                            <label for="patientId" class="form-label">Patient ID:</label>
                            <input type="number" class="form-control" id="patientId" name="patientId"/>
                        </div>
                        <input type="hidden" name="type" value="add"/>
                        <div class="mb-3">
                            <button type="submit" class="btn btn-primary btn-register">Pay</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
