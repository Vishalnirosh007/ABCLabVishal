<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<style>
    body {
        background-image: url('img/doc img.jpg');
        background-size: cover;
        background-position: center;
        background-attachment: fixed;
        min-height: 100vh;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    
    .container {
        background-color: rgba(255, 255, 255, 0.9);
        border-radius: 10px;
        padding: 40px;
        box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
    }
    
    .navbar {
        background-color: #ffffff;
        box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
    }
    
    .navbar-brand {
        font-weight: bold;
        color: #333;
        margin-right: 20px;
    }
    
    .navbar-toggler-icon {
        border: none;
    }
    
    .form-control {
        border-radius: 10px;
    }
    
    .btn-primary {
        border-radius: 10px;
    }
</style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="img/logo.jpg" alt="Logo" width="50" height="50" class="d-inline-block align-text-top rounded-circle">
            ABC LAB
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link" href="Dashboard.jsp">Home</a>
                <a class="nav-link active" href="PatientLogReg.jsp">Patient</a>
                <a class="nav-link" href="AvailableTest.jsp">Available Test</a>
            </div>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2 class="text-center mb-4">Register</h2>
            <form method="post" action="registerPatientController">
                <div class="mb-3">
                    <label for="patientFullName" class="form-label">Full Name:</label>
                    <input type="text" class="form-control" id="patientFullName" name="patientFullName">
                </div>
                <div class="mb-3">
                    <label for="patientPhoneNumber" class="form-label">Phone Number:</label>
                    <input type="text" class="form-control" id="patientPhoneNumber" name="patientPhoneNumber">
                </div>
                <div class="mb-3">
                    <label for="dateOfBirth" class="form-label">Date of Birth:</label>
                    <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth">
                </div>
                <div class="mb-3">
                    <label for="patientAddress" class="form-label">Address:</label>
                    <input type="text" class="form-control" id="patientAddress" name="patientAddress">
                </div>
                <div class="mb-3">
                    <label for="gender" class="form-label">Gender:</label>
                    <input type="text" class="form-control" id="gender" name="gender">
                </div>
                <div class="mb-3">
                    <label for="patientEmail" class="form-label">Email:</label>
                    <input type="text" class="form-control" id="patientEmail" name="patientEmail">
                </div>
                <div class="mb-3">
                    <label for="patientUsername" class="form-label">Username:</label>
                    <input type="text" class="form-control" id="patientUsername" name="patientUsername">
                </div>
                <div class="mb-3">
                    <label for="patientPassword" class="form-label">Password:</label>
                    <input type="password" class="form-control" id="patientPassword" name="patientPassword">
                </div>
                <input type="hidden" name="type" value="add">
                <button type="submit" class="btn btn-primary w-100">Register</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
