<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<style>
    body {
        background-image: url('img/tech.jpg');
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat; 
        height: 100vh; 
    }
    .logo {
        border-radius: 50%;
        width: 70px;
        height: 70px;
        margin: 0 10px 0 50px;
    }
    .navbar {
        background-color: #ffffff;
        box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        margin-bottom: 0;
    }
    .navbar-nav .nav-link {
        color: black;
        font-size: 1rem;
        font-weight: 400;
        margin: 0;
        padding: 0.5rem 1rem;
    }
    .navbar-nav .nav-link.active {
        color: black;
    }
    .navbar-toggler {
        margin-right: 30px;
    }
    .container-fluid {
        padding-left: 50px;
        padding-right: 50px;
    }
    .well {
        padding: 0 0 0 50px;
    }
    .container {
        margin-top: 5rem;
    }
    h2 {
        font-size: 2.5rem;
        font-weight: bold;
        color: white;
        margin-bottom: 2rem;
        text-align: center; /* Centering the text */
    }
    .form-group {
        margin-top: 2rem;
        text-align: center; /* Centering the form elements */
    }
    label {
        font-weight: bold;
        color: white;
    }
    .btn-secondary {
        background-color: red;
        border: none;
        border-radius: 10px;
        padding: 0.5rem 2rem;
        font-weight: bold;
        display: block;
        margin: 0 auto; /* Centering the button */
    }
    #errorMessage {
        display: none;
        color: red;
        margin-top: 1rem;
    }
</style>
  
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light" >
  <div class="container-fluid" >
    <img class="logo" alt="" src="img/abc.jpeg">
    <p class="fw-bold fs-4 mt-3" style="color: black;">ABC Lab</p>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav ms-auto">
        <a class="nav-link mx-0 mx-md-3 fs-6" href="HospitlHome.jsp">Home</a>
        <a class="nav-link mx-0 mx-md-3 fs-6" href="DoctorLogin.jsp">Doctor</a>
        <a class="nav-link mx-0 mx-md-3 fs-6" href="AdminLogin.jsp">Admin</a>
        <a class="nav-link active mx-0 mx-md-3 fs-6" aria-current="page" href="LabWorkerLodgin.jsp">Lab Worker</a>
      </div>
    </div>
  </div>
</nav>

<div class="row g-0 position-relative container mt-5">
  <div class="col-md-7 well" style="padding: 0 0 0 50px;">
    <div class="container mt-5">
      <h2>Technician Login</h2>
      <form id="loginForm" action="labWorkerLoginController" method="post">
        <div class="form-group mt-4">
          <label for="username">Username:</label><br>
          <input type="text" id="username" name="username" class="form-control" style="width: 50%; margin-left: 25%;" required><br>
        </div>
        <div class="form-group mt-4">
          <label for="password">Password:</label><br>
          <input type="password" id="password"  class="form-control" style="width: 50%; margin-left: 25%;" name="password" required><br>
        </div>
        
        <button type="submit" class="btn btn-secondary mb-5 mt-4">Login</button>
      </form>
      <div id="errorMessage" style="display: none; color: red;"></div>
    </div>
  </div>
</div>

</body>
</html>
