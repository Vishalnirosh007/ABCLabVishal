<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Search and Update Appointment</title>
    <style>
        body {
           .left-section {
            float: left;
            width: 50%;
        }
        .right-section {
            float: right;
            width: 50%;
        }
         body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            padding-top: 20px;
        }
        .nav-link {
            color: #ffffff;
        }
        .table th, .table td {
            vertical-align: middle;
        }
        .btn-remove {
            padding: 0.375rem 0.75rem;
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
    <a class="text-white  nav-link " aria-current="page" href="AdminAppointment">Home</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary nav-link " href="AdminSearch-Appointment.jsp">Search Specific & Update</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary nav-link" href="AdminAdd-Appointment.jsp">Add</a>
  </li>
  
</ul>
        <br/>
        <br/>
    <div class="container form-group p-5 mx-5 mb-4 bg-light">
        <div class="row">
            <div class="col-md-6">
                <h3>Search Appointment</h3>
                <form method="get" action="adminappointmentController">
                    <div class="form-group">
                        Enter Appointment ID: <input type="text" class="form-control" name="appointmentID">
                        <input type="hidden" name="type" value="specific">
                        <button type="submit" class="btn btn-info mt-2">Search</button>
                    </div>
                </form>
                <br/>
                <p>${searchResult}</p>
            </div>
            <div class="col-md-6">
                <h3>Edit Appointment</h3>
                <form method="post" action="adminappointmentController">
                    <label for="appointmentID">Appointment ID:</label>
                    <input type="text" readonly class="form-control" id="appointmentID" name="appointmentID" value="${not empty appointment ? appointment.appointmentID : ''}"/>
                    <br/>
                    <label for="patientID">Patient ID:</label>
                    <input type="text" class="form-control" id="patientID" name="patientID" value="${not empty appointment ? appointment.patientID : ''}"/>
                    <br/>
                    <label for="appointmentDate">Appointment Date:</label>
                    <input type="date" class="form-control" id="appointmentDate" name="appointmentDate" value="${not empty appointment ? appointment.appointmentDate : ''}"/>
                    <br/>
                    <label for="checkupName">Checkup Name:</label>
                    <input type="text" class="form-control" id="checkupName" name="checkupName" value="${not empty appointment ? appointment.checkupName : ''}"/>
                    <br/>
                    <label for="doctorName">Doctor Name:</label>
                    <input type="text" class="form-control" id="doctorName" name="doctorName" value="${not empty appointment ? appointment.doctorName : ''}"/>
                    <br/>
                    <label for="appointmentStatus">Appointment Status:</label>
                    <input type="text" class="form-control" id="appointmentStatus" name="appointmentStatus" value="${not empty appointment ? appointment.appointmentStatus : ''}"/>
                    <input type="hidden" name="type" value="update"/>
                    <br/>
                    <button type="submit" class="btn btn-warning">Update</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
