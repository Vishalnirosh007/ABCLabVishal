<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Search and Update Checkup</title>
</head>
<body>
    <div class="container-fluid">
         <div class="container-fluid">
        <ul class="nav justify-content-center bg-dark py-2">
        <li class="nav-item">
    <a class="link-warning nav-link px-5 mx-5" aria-current="page" href="AdminHomePage.jsp"> << Go to Home</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary  nav-link " aria-current="page" href="CheckupDashboard">Store</a>
  </li>
  <li class="nav-item">
    <a class="text-white nav-link " href="Search-Checkup-Details.jsp">Search Specific & Update</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary nav-link" href="Add-Checkup-Details.jsp">Add</a>
  </li>
  
</ul>
        <br/>
        <br/>
        <div class="container">
            <h3>Search Checkup-----------------</h3>
            <br/>
            <form method="get" action="checkupController">
                Enter Checkup ID: <input type="text" name="checkupID">
                <input type="hidden" name="type" value="specific">
                <button type="submit" class="btn btn-info">Search</button>            
            </form>
                        
            <br/>
            <p>${searchResult}</p>
            <br/>
            <h3>Edit Checkup-----------------</h3>
            <br/>
            <form method="post" action="checkupController">
                <label for="checkupID">Checkup ID:</label>
                <input type="text" readonly class="form-control" id="checkupID" name="checkupID" value="${not empty checkup ? checkup.checkupID : ''}"/>
                <br/>
                <label for="checkupName">Checkup Name:</label>
                <input type="text" class="form-control" id="checkupName" name="checkupName"  value="${not empty checkup ? checkup.checkupName : ''}"/>
                <br/>
                <label for="checkupCost">Cost:</label>
                <input type="number" class="form-control" id="checkupCost" name="checkupCost"  value="${not empty checkup ? checkup.checkupCost : ''}"/>
                <br/>
                <label for="checkupDescription">Description:</label>
                <input type="text" class="form-control" id="checkupDescription" name="checkupDescription"  value="${not empty checkup ? checkup.checkupDescription : ''}"/>
                <input type="hidden" name="type" value="update"/>
                <br/>
                <button type="submit" class="btn btn-warning">Update</button>            
            </form>     
        </div>      
    </div>
</body>
</html>
