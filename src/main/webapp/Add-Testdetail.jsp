<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Test Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">

    <ul class="nav justify-content-center bg-dark py-2">
    <li class="nav-item">
    <a class="link-warning nav-link px-5 mx-5" aria-current="page" href="AdminHomePage.jsp"> << Go to Home</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary nav-link " href="TestDetailDashboard">Test Detail</a>
  </li>
  <li class="nav-item">
    <a class="text-white nav-link" href="Add-Testdetail.jsp">Add</a>
  </li>
  
</ul>
    <br/>
    <br/>
    <div class="container">
        <h3>Register Test Detail</h3>
        <br/>
        <p>${message}</p>
        <br/>
        <form method="post" action="testDetailController">
            <br/>
            <label for="appointmentID">Appointment ID:</label>
            <input type="number" class="form-control" id="appointmentID" name="appointmentID"/>
            <br/>
            <br/>
            <label for="technicianName">Technician Name:</label>
            <select class="form-control" id="technicianName" name="technicianName">
                <option value="mike">Mike</option>
                <option value="jake">Jake</option>
                <option value="noor">Noor</option>
                <option value="gym">Gym</option>
                <!-- Add more options here -->
            </select>
            <br/>
            <br/>
            <label for="doctorName">Doctor Name:</label>
            <select class="form-control" id="doctorName" name="doctorName">
                <option value="RATNAPALA">RATNAPALA</option>
                <option value="PERERA">PERERA</option>
                <option value="Vishal">Vishal</option>
                <option value="Alwis">Alwis</option>
                <!-- Add more options here -->
            </select>
            <input type="hidden" name="type" value="add"/>
            <br/>
            <br/>
            <button type="submit" class="btn btn-primary">Register</button>
        </form>
    </div>
</div>
</body>
</html>
