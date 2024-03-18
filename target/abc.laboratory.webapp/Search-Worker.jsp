<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Search and Update Lab Worker</title>
</head>
<body>
    <div class="container-fluid">
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link" href="LabworkerDashboard">Store</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Search Specific & Update</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Add-Worker.jsp">Add</a>
            </li>
        </ul>
        <br/>
        <br/>
        <div class="container">
            <h3>Search Lab Worker-----------------</h3>
            <br/>
            <form method="get" action="labWorkerController">
                Enter Lab Worker ID: <input type="text" name="labWorkerID">
                <input type="hidden" name="type" value="specific">
                <button type="submit" class="btn btn-info">Search</button>            
            </form>
                        
            <br/>
            <p>${searchResult}</p>
            <br/>
            <h3>Edit Lab Worker-----------------</h3>
            <br/>
            <form method="post" action="labWorkerController">
                <label for="labWorkerID">Lab Worker ID:</label>
                <input type="text" readonly class="form-control" id="labWorkerID" name="labWorkerID" value="${not empty labWorker ? labWorker.labWorkerID : ''}"/>
                <br/>
                <label for="labWorkerName">Lab Worker Name:</label>
                <input type="text" class="form-control" id="labWorkerName" name="labWorkerName"  value="${not empty labWorker ? labWorker.labWorkerName : ''}"/>
                <br/>
                <label for="description">Description:</label>
                <input type="text" class="form-control" id="description" name="description"  value="${not empty labWorker ? labWorker.description : ''}"/>
                <input type="hidden" name="type" value="update"/>
                <br/>
                <button type="submit" class="btn btn-warning">Update</button>            
            </form>     
        </div>      
    </div>
</body>
</html>
