<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <meta charset="ISO-8859-1">
    <title>Add Appointment</title>
</head>
<body>
    <div class="container-fluid">
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link" href="AppointmentDashboard">Store</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Search-Appointment.jsp">Search Specific & Update</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Add</a>
            </li>
        </ul>
        <br/>
        <br/>
        <div class="container">
            <h3>Register Appointment</h3>
            <br/>
            <p>${message}</p>
            <br/>
            <form method="post" action="appointmentController">
                <br/>
                <label for="appointmentDate">Appointment Date:</label>
                <input type="Date" class="form-control" id="appointmentDate" name="appointmentDate"/>
                <br/>
                <label for="doctorName">Doctor Name:</label>
                <input type="text" class="form-control" id="doctorName" name="doctorName"/>
                <br/>
                <label for="checkupName">Checkup Name:</label>
                <input type="text" class="form-control" id="checkupName" name="checkupName"/>
                <br/>
                <label for="labWorkerName">Lab Worker Name:</label>
                <input type="text" class="form-control" id="labWorkerName" name="labWorkerName"/>
                <br/>
                <label for="patientId">Patient ID:</label>
                <input type="number" class="form-control" id="patientId" name="patientId"/>
                <br/>
                <label for="checkupId">Checkup ID:</label>
                <input type="number" class="form-control" id="checkupId" name="checkupId"/>
                <br/>
                <label for="doctorId">Doctor ID:</label>
                <input type="number" class="form-control" id="doctorId" name="doctorId"/>
                <br/>
                <label for="labWorkerId">Lab Worker ID:</label>
                <input type="number" class="form-control" id="labWorkerId" name="labWorkerId"/>
                <br/>
                <label for="appointmentStatus">Appointment Status:</label>
                <input type="text" class="form-control" id="appointmentStatus" name="appointmentStatus"/>
                <input type="hidden" name="type" value="add"/>
                <br/>
                <br/>
                <button type="submit" class="btn btn-primary">Register</button>            
            </form>        
        </div>      
    </div>
</body>
</html>
