<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Add Patient</title>
</head>
<body>
<div class="container-fluid">
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link" href="PatientRegister"></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Login-Patient.jsp">Login</a>
            </li>
            
        </ul>
        <br/>
        <br/>
        <div class="container">
            <h3>Register Patient</h3>
            <br/>
            <p>${message}</p>
            <br/>
            <form method="post" action="registerPatientController">
                <br/>
                <label for="patientFullName">Full Name:</label>
                <input type="text" class="form-control" id="patientFullName" name="patientFullName"/>
                <br/>
                <br/>
                <label for="patientPhoneNumber">Phone Number:</label>
                <input type="text" class="form-control" id="patientPhoneNumber" name="patientPhoneNumber"/>
                <br/>
                <br/>
                <label for="dateOfBirth">Date of Birth:</label>
                <input type="Date" class="form-control" id="dateOfBirth" name="dateOfBirth"/>
                <br/>
                <br/>
                <label for="patientAddress">Address:</label>
                <input type="text" class="form-control" id="patientAddress" name="patientAddress"/>
                <br/>
                <br/>
                <label for="gender">Gender:</label>
                <input type="text" class="form-control" id="gender" name="gender"/>
                <br/>
                <br/>
                <label for="patientEmail">Email:</label>
                <input type="text" class="form-control" id="patientEmail" name="patientEmail"/>
                <br/>
                <br/>
                <label for="patientUsername">Username:</label>
                <input type="text" class="form-control" id="patientUsername" name="patientUsername"/>
                <br/>
                <br/>
                <label for="patientPassword">Password:</label>
                <input type="text" class="form-control" id="patientPassword" name="patientPassword"/>
                <input type="hidden" name="type" value="add"/>
                <br/>
                <br/>
                <button type="submit" class="btn btn-primary">Register</button>            
            </form>     
        </div>      
    </div>
</body>
</html>
