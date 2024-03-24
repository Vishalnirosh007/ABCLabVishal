<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <ul class="nav justify-content-center bg-dark py-2">
    <li class="nav-item">
    <a class="link-warning nav-link px-5 mx-5" aria-current="page" href="AdminHomePage.jsp"> << Go to Home</a>
  </li>
  <li class="nav-item">
    <a class="text-white  nav-link " aria-current="page" href="PatientDashboard">Store</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary nav-link " href="Search-Patient-Details.jsp">Search Specific & Update</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary nav-link" href="Add-Patient-Details.jsp">Add</a>
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
