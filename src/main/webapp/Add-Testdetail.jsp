<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Test Detail</title>
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
            <a class="link-secondary nav-link" href="TestDetailDashboard">Test Detail</a>
        </li>
        <li class="nav-item">
            <a class="text-white nav-link" href="Add-Testdetail.jsp">Add</a>
        </li>
    </ul>
    <br/>
    <br/>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h3 class="card-title text-center mb-4">Register Test Detail</h3>
                        <form method="post" action="testDetailController">
                            <div class="mb-3">
                                <label for="appointmentID" class="form-label">Appointment ID:</label>
                                <input type="number" class="form-control" id="appointmentID" name="appointmentID"/>
                            </div>
                            <div class="mb-3">
                                <label for="technicianName" class="form-label">Technician Name:</label>
                                <select class="form-control" id="technicianName" name="technicianName">
                                    <option value="mike">Mike</option>
                                    <option value="jake">Jake</option>
                                    <option value="noor">Noor</option>
                                    <option value="jim">jim</option>
                                    <!-- Add more options here -->
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="doctorName" class="form-label">Doctor Name:</label>
                                <select class="form-control" id="doctorName" name="doctorName">
                                <option value="Dr.Dissanayaka">Dr.Dissanayaka</option>
                                    <option value="Dr.RATNAPALA">Dr.RATNAPALA</option>
                                    <option value="Dr.PERERA">Dr.PERERA</option>
                                    <option value="Dr.Vishal">Dr.Vishal</option>
                                    <option value="Dr.Alwis">Dr.Alwis</option>
                                    <!-- Add more options here -->
                                </select>
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
