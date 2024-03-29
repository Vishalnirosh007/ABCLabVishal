<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Checkup</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
                <a class="link-secondary nav-link " href="Search-Checkup-Details.jsp">Search Specific & Update</a>
            </li>
            <li class="nav-item">
                <a class="text-white nav-link" href="Add-Checkup-Details.jsp">Add</a>
            </li>
        </ul>
        <br/>
        <br/>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="form-container">
                        <h3 class="text-center mb-4">Register Checkup</h3>
                        <form method="post" action="checkupController">
                            <div class="mb-3">
                                <label for="checkupName" class="form-label">Checkup Name:</label>
                                <input type="text" class="form-control" id="checkupName" name="checkupName"/>
                            </div>
                            <div class="mb-3">
                                <label for="checkupCost" class="form-label">Cost [LKR]:</label>
                                <input type="number" class="form-control" id="checkupCost" name="checkupCost"/>
                            </div>
                            <div class="mb-3">
                                <label for="checkupDescription" class="form-label">Description:</label>
                                <textarea class="form-control" id="checkupDescription" name="checkupDescription"></textarea>
                            </div>
                            <input type="hidden" name="type" value="add"/>
                            <div class="mb-3">
                                <button type="submit" class="btn btn-primary btn-register">Register</button>
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
