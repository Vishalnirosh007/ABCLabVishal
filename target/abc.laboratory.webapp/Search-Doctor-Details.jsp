<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Search and Update Doctor</title>
</head>
<body>
    <div class="container-fluid">
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link" href="DoctorDashboard">Doctors</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Search Specific & Update</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Add-Doctor-Details.jsp">Add</a>
            </li>
        </ul>
        <br/>
        <br/>
        <div class="container">
            <h3>Search Doctor-----------------</h3>
            <br/>
            <form method="get" action="doctorController">
                Enter Doctor ID: <input type="text" name="doctorId">
                <input type="hidden" name="type" value="specific">
                <button type="submit" class="btn btn-info">Search</button>            
            </form>
                        
            <br/>
            <p>${searchResult}</p>
            <br/>
            <h3>Edit Doctor-----------------</h3>
            <br/>
            <form method="post" action="doctorController">
                <label for="doctorId">Doctor ID:</label>
                <input type="text" readonly class="form-control" id="doctorId" name="doctorId" value="${not empty doctor ? doctor.doctorID : ''}"/>
                <br/>
                <label for="firstName">First Name:</label>
                <input type="text" class="form-control" id="firstName" name="firstName"  value="${not empty doctor ? doctor.firstName : ''}"/>
                <br/>
                <label for="lastName">Last Name:</label>
                <input type="text" class="form-control" id="lastName" name="lastName"  value="${not empty doctor ? doctor.lastName : ''}"/>
                <br/>
                <label for="specialization">Specialization:</label>
                <input type="text" class="form-control" id="specialization" name="specialization"  value="${not empty doctor ? doctor.specialization : ''}"/>
                <br/>
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email"  value="${not empty doctor ? doctor.email : ''}"/>
                <input type="hidden" name="type" value="update"/>
                <br/>
                <button type="submit" class="btn btn-warning">Update</button>            
            </form>     
        </div>      
    </div>
</body>
</html>
