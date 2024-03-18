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
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Payment</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Search-Payment.jsp">Search Specific & Update</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Add-payment.jsp">Add</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="ReceptionistDashboard.jsp">Dashboard</a>
        </li>
    </ul>
    <br/>
    <p>${message}</p>
    <br/>
    <div class="container">
        <table class="table table-striped">
            <thead>
                <tr class="table-dark">
                    <th>Payment ID</th>
                    <th>Cardholder Name</th>
                    <th>Card Number</th>
                    <th>Expiry Date</th>
                    <th>CVC Number</th>
                    <th>Payment Date</th>
                    <th>Patient ID</th>
                    <th>Remove Payment</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="payment" items="${paymentList}">
                    <tr>
                        <td>${payment.paymentId}</td>
                        <td>${payment.cardholderName}</td>
                        <td>${payment.cardNumber}</td>
                        <td>${payment.expiryDate}</td>
                        <td>${payment.cvcNumber}</td>
                        <td>${payment.paymentDate}</td>
                        <td>${payment.patientId}</td>
                        <td>
                            <form method="post" action="payment">
                                <input type="hidden" name="paymentId" value="${payment.paymentId}"/>
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
