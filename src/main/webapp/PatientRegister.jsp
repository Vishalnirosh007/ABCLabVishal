<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<style>
    body {
      
      
      background-image: url('img/doc img.jpg');
      background-size: cover;
      background-position: center;
      background-attachment: fixed;
      height: 100vh;
    }
  </style>
  
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light  " >
  <div class="container-fluid " >
    <img style="border-radius:50%;width: 70px;height: 70px; margin:0 10px 0 50px " alt="" src="img/logo.jpg">
    <p class="fw-bold fs-4 mt-3" style="color: red;">Logo name</p>
    <button style="margin:0 30px;" class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup" style="margin:0 50px;">
      <div class="navbar-nav" style="#ffff">
      	<a class="nav-link mx-0 mx-md-3  fs-6" href="Dashboard.jsp">Home</a>
        <a class="nav-link active mx-0 mx-md-3 fs-6" aria-current="page" href="PatientLogReg.jsp">Patient</a>
        <a class="nav-link mx-0 mx-md-3 fs-6" href="AvailableTest.jsp">Available Test</a>
      </div>
    </div>
  </div>
</nav>













<div class="row g-0  position-relative container mt-5">
  <div class="col-md-7    well" style="padding:0 0 0 50px ;">
  
  <div class="container mb-3">
  <h2>Register</h2>
  
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
  
</div>
</body>
</html>



