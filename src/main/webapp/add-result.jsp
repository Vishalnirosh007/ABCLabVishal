<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Result</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
   
    
    
    <ul class="nav justify-content-center bg-dark py-2">
    <li class="nav-item">
    <a class="link-warning nav-link px-5 mx-5" aria-current="page" href="AdminHomePage.jsp"> << Go to Home</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary  nav-link " aria-current="page" href="TestResult">Store</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary nav-link " href="search-update-result.jsp">Search Specific & Update</a>
  </li>
  <li class="nav-item">
    <a class="text-white nav-link" href="add-result.jsp">Add</a>
  </li>
  
</ul>



    <br/>
    <br/>
    <div class="container">
        <h3>Register Result</h3>
        <br/>
        <p>${message}</p>
        <br/>
        <form method="post" action="testResultController">
            <br/>
            <label for="appointmentID">Appointment ID:</label>
            <input type="text" class="form-control" id="appointmentID" name="appointmentID"/>
            <br/>
            <br/>
            <label for="result">Result:</label>
            <input type="text" class="form-control" id="result" name="result"/>
            <br/>
            <br/>
            <label for="report">Report:</label>
            <!-- Assuming the report is uploaded as a file -->
            <input type="file" class="form-control" id="report" name="report"/>
            <input type="hidden" name="type" value="add"/>
            <br/>
            <br/>
            <button type="submit" class="btn btn-primary">Register</button>
        </form>
    </div>
</div>
</body>
</html>