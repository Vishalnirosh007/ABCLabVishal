<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Search and Update Patient</title>
</head>
<body>
    <div class="container-fluid">
        <ul class="nav justify-content-center bg-dark py-2">
        <li class="nav-item">
    <a class="link-warning nav-link px-5 mx-5" aria-current="page" href="AdminHomePage.jsp"> << Go to Home</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary  nav-link " aria-current="page" href="PatientDashboard">Store</a>
  </li>
  <li class="nav-item">
    <a class="text-white nav-link " href="Search-Patient-Details.jsp">Search Specific & Update</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary nav-link" href="Add-Patient-Details.jsp">Add</a>
  </li>
  
</ul>
        <br/>
        <br/>
        <div class="container">
            <h3>Search Patient-----------------</h3>
            <br/>
            <form method="get" action="patientController">
                Enter Patient ID: <input type="text" name="patientID">
                <input type="hidden" name="type" value="specific">
                <button type="submit" class="btn btn-info">Search</button>            
            </form>
                        
            <br/>
            <p>${searchResult}</p>
            <br/>
            <h3>Edit Patient-----------------</h3>
            <br/>
            <form method="post" action="patientController">
                <label for="patientID">Patient ID:</label>
                <input type="text" readonly class="form-control" id="patientID" name="patientID" value="${not empty patient ? patient.patientID : ''}"/>
                <br/>
                <label for="patientFullName">Patient Full Name:</label>
                <input type="text" class="form-control" id="patientFullName" name="patientFullName"  value="${not empty patient ? patient.patientFullName : ''}"/>
                <br/>
                <label for="patientPhoneNumber">Patient Phone Number:</label>
                <input type="text" class="form-control" id="patientPhoneNumber" name="patientPhoneNumber"  value="${not empty patient ? patient.patientPhoneNumber : ''}"/>
                <br/>
                <label for="dateOfBirth">Date of Birth:</label>
                <input type="Date" class="form-control" id="dateOfBirth" name="dateOfBirth"  value="${not empty patient ? patient.dateOfBirth : ''}"/>
                <br/>
                <label for="patientAddress">Patient Address:</label>
                <input type="text" class="form-control" id="patientAddress" name="patientAddress"  value="${not empty patient ? patient.patientAddress : ''}"/>
                <br/>
                <label for="gender">Gender:</label>
                <input type="text" class="form-control" id="gender" name="gender"  value="${not empty patient ? patient.gender : ''}"/>
                <br/>
                <label for="patientEmail">Patient Email:</label>
                <input type="text" class="form-control" id="patientEmail" name="patientEmail"  value="${not empty patient ? patient.patientEmail : ''}"/>
                <br/>
                <label for="patientUsername">Patient Username:</label>
                <input type="text" class="form-control" id="patientUsername" name="patientUsername"  value="${not empty patient ? patient.patientUsername : ''}"/>
                <br/>
                <label for="patientPassword">Patient Password:</label>
                <input type="text" class="form-control" id="patientPassword" name="patientPassword"  value="${not empty patient ? patient.patientPassword : ''}"/>
                <input type="hidden" name="type" value="update"/>
                <br/>
                <button type="submit" class="btn btn-warning">Update</button>            
            </form>     
        </div>      
    </div>
</body>
</html>
