<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ABC LAB</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
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
    <a class="text-white  nav-link " aria-current="page" href="AppointmentDashboard.jsp">Home</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary nav-link " href="Search-Appointment.jsp">Search Specific & Update</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary nav-link" href="Add-Appointment.jsp">Add</a>
  </li>
  
</ul>
    <br/>
    <p>${message}</p>
    <br/>
    <div class="container">
        <table class="table table-striped">
            <thead>
                <tr class="table-dark">
                    <th>Appointment ID</th>
                    <th>Patient ID</th>
                    <th>Appointment Date</th>
                    <th>Checkup Name</th>
                    <th>Doctor Name</th>
                    <th>Appointment Status</th>
                    <th>Remove Appointment</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="appointment" items="${appointmentList}">
                    <tr>
                        <td>${appointment.appointmentID}</td>
                        <td>${appointment.patientID}</td>
                        <td>${appointment.appointmentDate}</td>
                        <td>${appointment.checkupName}</td>
                        <td>${appointment.doctorName}</td>
                        <td>${appointment.appointmentStatus}</td>
                        <td>
                            <form method="post" action="appointmentController">
                                <input type="hidden" name="appointmentID" value="${appointment.appointmentID}"/>
                                <input type="hidden" name="type" value="delete"/>
                                <button type="submit" class="btn btn-danger">Remove</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<br/>
</body>
</html>
