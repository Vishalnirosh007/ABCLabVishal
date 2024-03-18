<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Patients</a>
        </li>
                    <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="Search-Patient-Details.jsp">Search Specific & Update</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Add-Patient-Details.jsp">Add</a>
            </li>
     
    </ul>
    <br/>
    <p>${message}</p>
    <br/>
    <div class="container">
        <table class="table table-striped">
            <thead>
                <tr class="table-dark">
                    <th>Patient ID</th>
                    <th>Patient Full Name</th>
                    <th>Patient Phone Number</th>
                    <th>Date of Birth</th>
                    <th>Patient Address</th>
                    <th>Gender</th>
                    <th>Patient Email</th>
                    <th>Patient Username</th>
                    <th>Patient Password</th>
                    <th>Remove from Records</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="patient" items="${patientList}">
                    <tr>
                        <td>${patient.patientID}</td>
                        <td>${patient.patientFullName}</td>
                        <td>${patient.patientPhoneNumber}</td>
                        <td>${patient.dateOfBirth}</td>
                        <td>${patient.patientAddress}</td>
                        <td>${patient.gender}</td>
                        <td>${patient.patientEmail}</td>
                        <td>${patient.patientUsername}</td>
                        <td>${patient.patientPassword}</td>
                        <td>
                            <form method="post" action="patientController">
                                <input type="hidden" name="patientID" value="${patient.patientID}"/>
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
