<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>ABC Lab Appointments</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Appointments</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Search-Appointment.jsp">Search Specific & Update</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Add-Appointment.jsp">Schedule Appointment</a>
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
                    <th>Doctor Name</th>
                    <th>Checkup Name</th>
                    <th>Lab Worker Name</th>
                    <th>Patient ID</th>
                    <th>Checkup ID</th>
                    <th>Doctor ID</th>
                    <th>Lab Worker ID</th>
                    <th>Appointment Status</th>
                    <th>Make Payment</th>
                    <th>Cancel Appointment</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="appointment" items="${appointmentList}">
                    <tr>
                        <td>${appointment.appointmentID}</td>
                        <td>${appointment.doctorName}</td>
                        <td>${appointment.checkupName}</td>
                        <td>${appointment.labWorkerName}</td>
                        <td>${appointment.patientID}</td>
                        <td>${appointment.checkupID}</td>
                        <td>${appointment.doctorID}</td>
                        <td>${appointment.labWorkerID}</td>
                        <td>${appointment.appointmentStatus}</td>
                        <td>
                            <form method="post" action="appointmentController">
                                <input type="hidden" name="appointmentId" value="${appointment.appointmentID}"/>
                                <input type="hidden" name="type" value="delete"/>
                                <button type="submit" class="btn btn-danger">Cancel</button>
                            </form>
                        </td>
                        <td>
                        <form action="PaymentDashboard.jsp">
   					 	<input type="submit" value="Pay">
   					 	
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
