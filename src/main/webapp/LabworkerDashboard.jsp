<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lab Worker Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <ul class="nav justify-content-center bg-dark py-2">
    <li class="nav-item">
    <a class="link-warning nav-link px-5 mx-5" aria-current="page" href="AdminHomePage.jsp"> << Go to Home</a>
  </li>
  <li class="nav-item">
    <a class="text-white  nav-link " aria-current="page" href="LabworkerDashboard">Store</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary nav-link " href="Search-Worker.jsp">Search Specific & Update</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary nav-link" href="Add-Worker.jsp">Add</a>
  </li>
  
</ul>
    <br/>
    <p>${message}</p>
    <br/>
    <div class="container">
        <table class="table table-striped">
            <thead>
                <tr class="table-dark">
                    <th>Lab Worker ID</th>
                    <th>Lab Worker Name</th>
                    <th>Description</th>
                    <th>Remove Lab Worker</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="labWorker" items="${labWorkerList}">
                    <tr>
                        <td>${labWorker.labWorkerID}</td>
                        <td>${labWorker.labWorkerName}</td>
                        <td>${labWorker.description}</td>
                        <td>
                            <form method="post" action="labWorkerController">
                                <input type="hidden" name="labWorkerID" value="${labWorker.labWorkerID}"/>
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
