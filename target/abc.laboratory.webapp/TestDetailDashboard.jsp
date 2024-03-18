<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Detail Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Test Detail</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Add-Testdetail.jsp">Add</a>
        </li>
    </ul>
    <br/>
    <p>${message}</p>
    <br/>
    <div class="container">
        <table class="table table-striped">
            <thead>
                <tr class="table-dark">
                    <th>Test Detail ID</th>
                    <th>Appointment ID</th>
                    <th>Technician Name</th>
                    <th>Doctor Name</th>
                    <th>Remove from Store!</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="testDetail" items="${testDetailList}">
                    <tr>
                        <td>${testDetail.idTestDetail}</td>
                        <td>${testDetail.appointmentID}</td>
                        <td>${testDetail.technicianName}</td>
                        <td>${testDetail.doctorName}</td>
                        <td>
                            <form method="post" action="testDetailController">
                                <input type="hidden" name="testdetailid" value="${testDetail.idTestDetail}"/>
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
