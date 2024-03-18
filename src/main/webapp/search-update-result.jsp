<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Search and Update Test Result</title>
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
    <a class="text-white nav-link " href="search-update-result.jsp">Search Specific & Update</a>
  </li>
  <li class="nav-item">
    <a class="link-secondary nav-link" href="add-result.jsp">Add</a>
  </li>
  
</ul>
        <br/>
        <br/>
       <div class="container">
            <h3>Search Test Result</h3>
            <br/>
            <form method="get" action="testResultController">
                Enter Result ID: <input type="text" name="resultID">
                <input type="hidden" name="type" value="specific">
                <button type="submit" class="btn btn-info">Search</button>            
            </form>
                        
            <br/>
            <p>${searchResult}</p>
            <br/>
            <h3>Edit Test Result</h3>
            <br/>
            <form method="post" action="testResultController">
                <label for="resultID">Result ID:</label>
                <input type="text" readonly class="form-control" id="resultID" name="resultID" value="${not empty testResult ? testResult.resultID : ''}"/>
                <br/>
                <label for="appointmentID">Appointment ID:</label>
                <input type="text" class="form-control" id="appointmentID" name="appointmentID"  value="${not empty testResult ? testResult.appointmentID : ''}"/>
                <br/>
                <label for="result">Result:</label>
                <input type="text" class="form-control" id="result" name="result"  value="${not empty testResult ? testResult.result : ''}"/>
                <input type="hidden" name="type" value="update"/>
                
            </form>         
        </div>      
    </div>
</body>
</html>
