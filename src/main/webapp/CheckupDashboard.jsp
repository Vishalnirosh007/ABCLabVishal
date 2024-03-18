<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ABC Lab - Checkup Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Store</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Search-Checkup-Details.jsp">Search Specific & Update</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Add-Checkup-Details.jsp">Add</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="AdminHomePage.jsp">Dashboard</a>
        </li>
    </ul>
    <br/>
    <p>${message}</p>
    <br/>
    <div class="container">
        <table class="table table-striped">
            <thead>
                <tr class="table-dark">
                    <th>Checkup ID</th>
                    <th>Checkup Name</th>
                    <th>Cost [LKR]</th>
                    <th>Description</th>
                    <th>Remove from Store</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="checkup" items="${checkupList}">
                    <tr>
                        <td>${checkup.checkupID}</td>
                        <td>${checkup.checkupName}</td>
                        <td>${checkup.checkupCost}</td>
                        <td>${checkup.checkupDescription}</td>
                        <td>
                            <form method="post" action="checkupController">
                                <input type="hidden" name="checkupID" value="${checkup.checkupID}"/>
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
