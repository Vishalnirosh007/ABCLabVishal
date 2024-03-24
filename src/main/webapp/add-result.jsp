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
<style>
body {
            background-color: #f8f9fa;
        }
        .container-fluid {
            padding-top: 20px;
        }
        .nav-link {
            color: #ffffff;
        }
        .nav-link:hover {
            color: #ffc107;
        }
        .form-label {
            font-weight: bold;
        }
        .btn-register {
            width: 100%;
        }
        .form-container {
            background-color: #fff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        </style>
<div class="container-fluid">
    <ul class="nav justify-content-center bg-dark py-2">
        <li class="nav-item">
            <a class="link-warning nav-link px-5 mx-5" aria-current="page" href="AdminHomePage.jsp"> << Go to Home</a>
        </li>
        <li class="nav-item">
            <a class="link-secondary  nav-link " aria-current="page" href="TestResult">Home</a>
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
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h3 class="card-title text-center mb-4">Add Result</h3>
                        <form method="post" action="testResultController">
                            <div class="mb-3">
                                <label for="appointmentID" class="form-label">Appointment ID:</label>
                                <input type="text" class="form-control" id="appointmentID" name="appointmentID"/>
                            </div>
                            <div class="mb-3">
                                <label for="result" class="form-label">Result:</label>
                                <input type="text" class="form-control" id="result" name="result"/>
                            </div>
                            <div class="mb-3">
                                <label for="report" class="form-label">Report:</label>
                                <input type="file" class="form-control" id="report" name="report"/>
                            </div>
                            <input type="hidden" name="type" value="add"/>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Register</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
