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
      background-image: url('img/recep.jpg');
      background-size: cover; /* Ensure the image covers the entire background */
      background-position: center; /* Center the background image */
      background-repeat: no-repeat; /* Prevent the background image from repeating */
      height: 100vh; /* Set the height to 100% of the viewport height */
    }
  </style>
  
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light" >
  <div class="container-fluid" >
    <img style="border-radius:50%;width: 70px;height: 70px; margin:0 10px 0 50px " alt="" src="img/logo.jpg">
    <p class="fw-bold fs-4 mt-3" style="color: red;">Logo name</p>
    <button style="margin:0 30px;" class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup" style="margin:0 50px;">
      <div class="navbar-nav" style="#ffff">
        
        
        <a class="nav-link mx-0 mx-md-3 fs-6" href="HospitlHome.jsp">Home</a>
        <a class="nav-link mx-0 mx-md-3 fs-6" href="DoctorLogin.jsp">Doctor</a>
        <a class="nav-link active mx-0 mx-md-3 fs-6" aria-current="page" href="AdminLogin.jsp">Receptionist</a>
         <a class="nav-link mx-0 mx-md-3 fs-6" href="LabWorkerLodgin.jsp">Technician</a>
        
      </div>
    </div>
  </div>
</nav>


<div class="row g-0  position-relative container mt-5">
  <div class="col-md-7    well" style="padding:0 0 0 50px ;">
  
  <div class="container mt-5 ">
  <h2>Technician Login</h2>
  <form id="loginForm" action="adminLoginController" method="post">
    <div class="form-group mt-4">
        <label for="username">Username:</label><br>
       <input type="text" id="username" name="username" class="form-control" required><br>
    </div>
    <div class="form-group mt-4">
        <label for="password">Password:</label><br>
      <input type="password" id="password"  class="form-control" name="password" required><br>
    </div>
    
    <button type="submit" class="btn btn-secondary mb-5 mt-4">Login</button>
    </form>
    
        <div id="errorMessage" style="display: none; color: red;"></div>
    
    
  
</div>
   
  </div>
  
</div>
</body>
</html>







