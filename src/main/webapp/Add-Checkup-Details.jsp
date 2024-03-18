<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Add Checkup</title>
</head>
<body>
<div class="container-fluid">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link" href="CheckupDashboard">Store</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Search-Checkup-Details.jsp">Search Specific & Update</a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Add</a>
        </li>
    </ul>
    <br/>
    <br/>
    <div class="container">
        <h3>Register Checkup</h3>
        <br/>
        <p>${message}</p>
        <br/>
        <form method="post" action="checkupController">
            <br/>
            <label for="checkupName">Checkup Name:</label>
            <input type="text" class="form-control" id="checkupName" name="checkupName"/>
            <br/>
            <br/>
            <label for="checkupCost">Cost [LKR]:</label>
            <input type="number" class="form-control" id="checkupCost" name="checkupCost"/>
            <br/>
            <br/>
            <label for="checkupDescription">Description:</label>
            <textarea class="form-control" id="checkupDescription" name="checkupDescription"></textarea>
            <input type="hidden" name="type" value="add"/>
            <br/>
            <br/>
            <button type="submit" class="btn btn-primary">Register</button>
        </form>
    </div>
</div>
</body>
</html>
