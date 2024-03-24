<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Add Appointment</title>
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
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
        .form-group {
            background-color: #ffffff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-group label {
            font-weight: bold;
        }
        .form-control {
            border: 1px solid #ced4da;
            border-radius: 5px;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            font-weight: bold;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
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
            <a class="link-secondary  nav-link " aria-current="page" href="AppointmentDashboard">Store</a>
        </li>
        <li class="nav-item">
            <a class="link-secondary nav-link " href="Search-Appointment.jsp">Search Specific & Update</a>
        </li>
        <li class="nav-item">
            <a class="text-white nav-link" href="Add-Appointment.jsp">Add</a>
        </li>
    </ul>
    <br/>
    <br/>
    <div class="container">
        <div class="form-group p-5 mx-5 mb-4">
            <h3>Register Appointment</h3>
            <form method="post" action="appointmentController">
                <br/>
                <label for="patientID">Patient ID:</label>
                <input type="number" class="form-control mt-2" id="patientID" name="patientID"/>
                <br/>
                <label for="appointmentDate">Appointment Date:</label>
                <input type="date" class="form-control mt-2" id="appointmentDate" name="appointmentDate"/>
                <br/>
                <label for="checkupName">Checkup Name:</label>
                <input type="text" class="form-control mt-2" id="checkupName" name="checkupName"/>
                <br/>
                <label for="doctorName">Doctor Name:</label>
                <input type="text" class="form-control mt-2" id="doctorName" name="doctorName"/>
                <br/>
                <label for="appointmentStatus">Appointment Status:</label>
                <input type="text" class="form-control mt-2" id="appointmentStatus" name="appointmentStatus"/>
                <input type="hidden" name="type" value="add"/>
                <br/>
                <button type="submit" class="btn btn-primary">Schedule</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
